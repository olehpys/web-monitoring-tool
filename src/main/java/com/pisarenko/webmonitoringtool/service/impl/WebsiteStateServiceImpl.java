package com.pisarenko.webmonitoringtool.service.impl;

import com.pisarenko.webmonitoringtool.model.StateStatus;
import com.pisarenko.webmonitoringtool.model.Website;
import com.pisarenko.webmonitoringtool.model.WebsiteState;
import com.pisarenko.webmonitoringtool.model.WebsiteStatus;
import com.pisarenko.webmonitoringtool.repository.WebsiteStateRepository;
import com.pisarenko.webmonitoringtool.service.WebsiteStateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebsiteStateServiceImpl implements WebsiteStateService {

    private final WebsiteStateRepository websiteStateRepository;
    private final RestTemplate restTemplate;


    @Override
    public WebsiteState getState(Website website) {
        ResponseEntity<String> res = getUrlResponse(website);

        WebsiteState websiteState = WebsiteState.builder()
                .id(website.getId())
                .url(website.getUrl())
                .contentLength(getContentLength(res))
                .responseCode(getResponseCode(res))
                .responseTime(getResponseTime(website))
                .build();
        if (getResponseTime(website) < website.getExpectedResponseTime()) {
            websiteState.setState(StateStatus.OK);
        } else
            websiteState.setState(StateStatus.WARNING);
        if (getContentLength(res) < 0 || getContentLength(res) > website.getExpectedMaxResponseValue() || !getResponseCode(res).equals(website.getExpectedResponseCode())) {
            websiteState.setState(StateStatus.CRITICAL);
        }
        return websiteStateRepository.save(websiteState);
    }

    @Override
    public List<WebsiteState> getStates(List<Website> websites) {
        List<WebsiteState> websiteStates = new ArrayList<>();
        for (Website website : websites) {
            WebsiteState state = getState(website);
            websiteStates.add(state);
        }
        return websiteStates;
    }

    @Override
    public ResponseEntity<String> getUrlResponse(Website website) {
        return restTemplate.getForEntity(website.getUrl(), String.class);
    }

    @Override
    public long getContentLength(ResponseEntity<String> response) {
        log.debug("Response content length is [{}]", response.getHeaders().getContentLength());
        return response.getHeaders().getContentLength();
    }

    @Override
    public String getResponseCode(ResponseEntity<String> response) {
        log.debug("Response code is [{}]", response.getStatusCode().toString());
        return response.getStatusCode().toString();
    }

    @Override
    public double getResponseTime(Website website) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        restTemplate.getForEntity(website.getUrl(), String.class);
        stopWatch.stop();
        log.debug("Response time is [{}]", stopWatch.getTotalTimeSeconds());
        return stopWatch.getTotalTimeSeconds();
    }

    @Override
    public WebsiteState getStateById(String id) {
        return websiteStateRepository.findWebsiteStateById(id);
    }

    @Override
    public boolean isWebsiteActive(Website website) {
        Date date = new Date();
        if (!website.getDateFrom().after(date) && !website.getDateTo().before(date)) {
            return true;
        } else {
            website.setWebsiteStatus(WebsiteStatus.INACTIVE);
        }
        return false;
    }
}

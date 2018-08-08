package com.pisarenko.providesupport.service.impl;

import com.pisarenko.providesupport.model.StateStatus;
import com.pisarenko.providesupport.model.Website;
import com.pisarenko.providesupport.model.WebsiteState;
import com.pisarenko.providesupport.repository.WebsiteStateRepository;
import com.pisarenko.providesupport.service.WebsiteStateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebsiteStateServiceImpl implements WebsiteStateService {

    private final WebsiteStateRepository websiteStateRepository;
    private final RestTemplate restTemplate;


    @Override
    public WebsiteState getStatus(Website website) {
        ResponseEntity<String> res = getUrlResponse(website);
        WebsiteState websiteState = WebsiteState.builder()
                .id(website.getId())
                .contentLength(getContentLength(res))
                .responseCode(getResponseCode(res))
                .responseTime(getResponseTime(website))
                .state(website.getExpectedStateStatus())
                .build();
        if (getContentLength(res) > website.getExpectedMaxResponseValue() || !getResponseCode(res).equals(website.getExpectedResponseCode())) {
            websiteState.setState(StateStatus.CRITICAL);
        }
        return websiteStateRepository.save(websiteState);
    }

    @Override
    public List<WebsiteState> getStatuses(List<Website> websites) {
        List<WebsiteState> websiteStateList = new ArrayList<>();
        for (Website website : websites) {
            WebsiteState saved = getStatus(website);
            websiteStateList.add(saved);
        }
        return websiteStateList;
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
}

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

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebsiteStateServiceImpl implements WebsiteStateService {

    private final WebsiteStateRepository websiteStateRepository;
    private final RestTemplate restTemplate;


    @Override
    public WebsiteState getStatus(Website website) {

        WebsiteState websiteState = WebsiteState.builder()
                .id(website.getId())
                .contentLength(getContentLength(website))
                .responseCode(getResponseCode(website))
                .responseTime(getResponseTime(website))
                .state(website.getExpectedStateStatus())
                .build();

        if (getContentLength(website) > website.getExpectedMaxResponseValue() || !getResponseCode(website).equals(website.getExpectedResponseCode())) {

            websiteState.setState(StateStatus.CRITICAL);
        }
        return websiteStateRepository.save(websiteState);
    }

    @Override
    public List<WebsiteState> getStatuses(List<Website> websites) {
        for (Website website : websites) {
            getStatus(website);
        }
        return websiteStateRepository.findAll();
    }

    @Override
    public long getContentLength(Website website) {
        ResponseEntity<String> response = restTemplate.getForEntity(website.getUrl(), String.class);
        log.debug("Response content length is [{}]", response.getHeaders().getContentLength());
        return response.getHeaders().getContentLength();
    }

    @Override
    public String getResponseCode(Website website) {
        ResponseEntity<String> response = restTemplate.getForEntity(website.getUrl(), String.class);
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

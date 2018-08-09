package com.pisarenko.providesupport.service;

import com.pisarenko.providesupport.model.Website;
import com.pisarenko.providesupport.model.WebsiteState;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WebsiteStateService {

    WebsiteState getState(Website website);

    List<WebsiteState> getStates(List<Website> websites);

    ResponseEntity<String> getUrlResponse(Website website);

    long getContentLength(ResponseEntity<String> response);

    String getResponseCode(ResponseEntity<String> response);

    double getResponseTime(Website website);

    WebsiteState getStateById(String id);

}

package com.pisarenko.providesupport.service;

import com.pisarenko.providesupport.model.Website;
import com.pisarenko.providesupport.model.WebsiteState;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface WebsiteStateService {

    WebsiteState getStatus(Website website);

    List<WebsiteState> getStatuses(List<Website> websites);

    long getContentLength(Website website);

    HttpStatus getResponseCode(Website website);

    long getResponseTime(Website website);

}

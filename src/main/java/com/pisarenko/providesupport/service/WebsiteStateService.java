package com.pisarenko.providesupport.service;

import com.pisarenko.providesupport.model.Website;
import com.pisarenko.providesupport.model.WebsiteState;

import java.util.List;

public interface WebsiteStateService {

    WebsiteState getStatus(Website website);

    List<WebsiteState> getStatuses(List<Website> websites);

    long getContentLength(Website website);

    String getResponseCode(Website website);

    double getResponseTime(Website website);

}

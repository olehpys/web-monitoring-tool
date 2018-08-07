package com.pisarenko.providesupport.service;

import com.pisarenko.providesupport.model.Website;

import java.util.List;

public interface WebsiteService {

    Website createWebsite(Website website);

    void updateWebsite(String id);

    void deleteWebsite(String id);

    Website getWebsiteById(String id);

    List<Website> getAllWebsites();

}

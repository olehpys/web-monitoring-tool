package com.pisarenko.webmonitoringtool.service.impl;

import com.pisarenko.webmonitoringtool.model.Website;
import com.pisarenko.webmonitoringtool.repository.WebsiteRepository;
import com.pisarenko.webmonitoringtool.service.WebsiteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebsiteServiceImpl implements WebsiteService {

    private final WebsiteRepository websiteRepository;

    @Override
    public Website createWebsite(Website website) {
        Website created = websiteRepository.save(website);
        log.debug("Website: [{}] created", created.getId());
        return created;
    }

    @Override
    public void updateWebsite(Website website) {
        Website updated = websiteRepository.save(website);
        log.debug("Website: [{}] updated", updated.getId());
    }

    @Override
    public void deleteWebsite(String id) {
        websiteRepository.delete(getWebsiteById(id));
        log.debug("Website: [{}] deleted", id);
    }

    @Override
    public Website getWebsiteById(String id) {
        return websiteRepository.findWebsiteById(id);
    }

    @Override
    public List<Website> getAllWebsites() {
        return websiteRepository.findAll();
    }

    @Override
    public List<Website> getActiveWebsites() {
        return websiteRepository.findActiveWebsites();
    }
}

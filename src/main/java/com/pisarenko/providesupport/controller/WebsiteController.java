package com.pisarenko.providesupport.controller;

import com.pisarenko.providesupport.model.Website;
import com.pisarenko.providesupport.model.WebsiteState;
import com.pisarenko.providesupport.service.WebsiteService;
import com.pisarenko.providesupport.service.WebsiteStateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/websites")
public class WebsiteController {

    private final WebsiteService websiteService;
    private final WebsiteStateService websiteStateService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ResponseEntity<Website> addWebsite(@RequestBody Website website) {
        Website createdWebsite = websiteService.createWebsite(website);
        return ResponseEntity.ok(createdWebsite);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    ResponseEntity<Void> editWebsiteConfig(@PathVariable String id) {
        websiteService.updateWebsite(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    ResponseEntity<Void> deleteWebsite(@PathVariable String id) {
        websiteService.deleteWebsite(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    ResponseEntity<List<Website>> websites() {
        List<Website> websites = websiteService.getAllWebsites();
        return ResponseEntity.ok(websites);
    }

    @RequestMapping(value = "/allChecked", method = RequestMethod.GET)
    ResponseEntity<List<WebsiteState>> websiteStates() {
        List<WebsiteState> websitesStates = websiteStateService.getStates(websiteService.getAllWebsites());
        return ResponseEntity.ok(websitesStates);
    }
}

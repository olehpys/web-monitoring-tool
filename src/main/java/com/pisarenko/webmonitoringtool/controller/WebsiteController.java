package com.pisarenko.webmonitoringtool.controller;

import com.pisarenko.webmonitoringtool.model.Website;
import com.pisarenko.webmonitoringtool.model.WebsiteState;
import com.pisarenko.webmonitoringtool.service.WebsiteService;
import com.pisarenko.webmonitoringtool.service.WebsiteStateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebsiteController {

    private final WebsiteService websiteService;
    private final WebsiteStateService websiteStateService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView websiteStates() {
        List<WebsiteState> websitesStates = websiteStateService.getStates(websiteService.getActiveWebsites());
        ModelAndView states = new ModelAndView("index");
        states.addObject("websitesStates", websitesStates);
        return states;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    ModelAndView allWebsites() {
        List<Website> websites = websiteService.getAllWebsites();
        ModelAndView allWebsites = new ModelAndView("all");
        allWebsites.addObject("websites", websites);
        return allWebsites;
    }

    @RequestMapping(value = "/website/add", method = RequestMethod.POST)
    ResponseEntity<Website> addWebsite(Website website) {
        Website createdWebsite = websiteService.createWebsite(website);
        return ResponseEntity.ok(createdWebsite);
    }

    @RequestMapping(value = "/website/edit", method = RequestMethod.POST)
    ResponseEntity<Void> editWebsiteConfig(Website website) {
        websiteService.updateWebsite(website);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/website/delete", method = RequestMethod.POST)
    ResponseEntity<Void> deleteWebsite(String id) {
        websiteService.deleteWebsite(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/website/edit/{id}", method = RequestMethod.GET)
    ModelAndView editWebsite(@PathVariable String id) {
        Website websiteToUpdate = websiteService.getWebsiteById(id);
        ModelAndView website = new ModelAndView("edit");
        website.addObject("website", websiteToUpdate);
        return website;
    }

    @RequestMapping(value = "/website/{id}", method = RequestMethod.GET)
    ModelAndView getWebsiteState(@PathVariable String id) {
        Website currentWebsite = websiteService.getWebsiteById(id);
        WebsiteState currentWebsiteState = websiteStateService.getStateById(id);
        Map<String, Object> model = new HashMap<>();
        model.put("expectedWebsite", currentWebsite);
        model.put("websiteState", currentWebsiteState);

        return new ModelAndView("website", "model", model);
    }

}

package com.pisarenko.webmonitoringtool.service;

import com.pisarenko.webmonitoringtool.model.Website;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebsiteStateServiceTest {

    @Autowired
    WebsiteStateService restTemplateService;
    @Autowired
    WebsiteService websiteService;

    private Website website;

    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        website = Website.builder()
                .id("1")
                .url("https://telegram.org/")
                .expectedResponseTime(5)
                .expectedResponseCode("200")
                .expectedMinResponseValue(1)
                .expectedMaxResponseValue(125)
                .build();
    }


    @Test
    public void addWebsiteTest() {
        Website created = websiteService.createWebsite(website);
        System.out.println(created);
    }

    @Test
    public void getResponseTimeTest() {

        double time = restTemplateService.getResponseTime(website);

        Assert.assertEquals(2, time, DELTA);
    }
}

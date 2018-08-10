package com.pisarenko.providesupport.service;

import com.pisarenko.providesupport.model.Website;
import com.pisarenko.providesupport.repository.WebsiteRepository;
import com.pisarenko.providesupport.service.impl.WebsiteServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
public class WebsiteServiceTest {

    @Mock
    private WebsiteRepository websiteRepository;

    @InjectMocks
    private WebsiteServiceImpl websiteService;

    private Website website;

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
    public void getAllWebsitesTest() {

        Mockito.when(websiteRepository.findAll()).thenReturn(Collections.singletonList(website));

        List<Website> websiteList = websiteService.getAllWebsites();

        Assert.assertEquals(Collections.singletonList(website).get(0), websiteList.get(0));


    }
}

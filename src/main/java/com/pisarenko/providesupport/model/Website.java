package com.pisarenko.providesupport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "websites")
public class Website {

    @Id
    @Column(name = "website_id")
    private String id;

    @Column(name = "url")
    private String url;

    @Column(name = "response_time")
    private double expectedResponseTime;

    @Column(name = "response_code")
    private String expectedResponseCode;

    @Column(name = "website_status")
    @Enumerated(EnumType.STRING)
    private WebsiteStatus websiteStatus;

    @Column(name = "min_res_value")
    private long expectedMinResponseValue;

    @Column(name = "max_res_value")
    private long expectedMaxResponseValue;

    @Column(name = "date_from")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Column(name = "date_to")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateTo;

}

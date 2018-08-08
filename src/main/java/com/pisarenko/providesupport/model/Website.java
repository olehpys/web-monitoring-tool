package com.pisarenko.providesupport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private StateStatus expectedStateStatus;

    @Column(name = "response_code")
    private String expectedResponseCode;

    @Column(name = "min_res_value")
    private long expectedMinResponseValue;

    @Column(name = "max_res_value")
    private long expectedMaxResponseValue;

}

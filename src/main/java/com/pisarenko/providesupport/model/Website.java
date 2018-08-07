package com.pisarenko.providesupport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private ResponseTime responseTime;

    @Column(name = "response_code")
    private String responseCode;

    @Column(name = "min_res_value")
    private byte minResponseValue;

    @Column(name = "max_res_value")
    private byte maxResponseValue;

}

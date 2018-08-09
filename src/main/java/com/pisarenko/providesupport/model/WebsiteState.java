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
@Table(name = "websites_states")
public class WebsiteState {

    @Id
    @Column(name = "website_id")
    private String id;

    @Column(name = "website_url")
    private String url;

    @Column(name = "website_state")
    private StateStatus state;

    @Column(name = "content_length")
    private long contentLength;

    @Column(name = "response_code")
    private String responseCode;

    @Column(name = "response_time")
    private double responseTime;

}

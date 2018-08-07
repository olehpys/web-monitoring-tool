package com.pisarenko.providesupport.model;

import lombok.Getter;

@Getter
public enum ResponseTime {
    OK(0, 5), WARNING(6, 10), CRITICAL(10, 15);

    private int minTime;
    private int maxTime;

    ResponseTime(int minTime, int maxTime) {
        this.minTime = minTime;
        this.maxTime = maxTime;
    }
}

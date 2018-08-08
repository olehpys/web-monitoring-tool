package com.pisarenko.providesupport.model;

import lombok.Getter;

@Getter
public enum StateStatus {
    OK(0, 5), WARNING(6, 10), CRITICAL(10, 15);

    private int minTime;
    private int maxTime;

    StateStatus(int minTime, int maxTime) {
        this.minTime = minTime;
        this.maxTime = maxTime;
    }
}

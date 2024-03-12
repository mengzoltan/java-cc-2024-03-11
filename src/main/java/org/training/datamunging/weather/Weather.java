package org.training.datamunging.weather;

import lombok.Builder;

public record Weather(int day, int max, int min) {
    @Builder public Weather{}

    public int getDifference() {
        return max - min;
    }
}

package org.training.samples.structures.common;

import lombok.Builder;

import java.time.LocalDate;
import java.util.Objects;

public record Interval(LocalDate start, LocalDate end) {
    public Interval {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);
    }

    public int getDaysBetween() {
        return start.datesUntil(end).toList().size();
    }
}

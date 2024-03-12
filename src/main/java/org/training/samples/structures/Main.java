package org.training.samples.structures;

import org.training.samples.structures.common.Interval;
import org.training.samples.structures.course.Course;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Interval interval = new Interval(LocalDate.of(2024, 3, 10), LocalDate.now());
        Course course = Course.builder()
                .title("Clean Code")
                .description("valami")
                .interval(interval)
                .build();
//        int daysBetweenDates = getDaysBetweenDates(course.getStartDate(), course.getEndDate());
        System.out.println(course.getInterval().getDaysBetween());

    }

    private static int getDaysBetweenDates(LocalDate from, LocalDate to) {
        return from.datesUntil(to).toList().size();
    }
}

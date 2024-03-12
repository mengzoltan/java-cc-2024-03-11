package org.training.samples.structures.course;

import lombok.Builder;
import lombok.Data;
import org.training.samples.structures.common.Interval;

@Data
@Builder
public class Course {
    private String title;
    private String description;
    private Interval interval;
}

package org.training.samples.structures.contract;

import lombok.Builder;
import lombok.Data;
import org.training.samples.structures.common.Interval;

import java.time.LocalDate;

@Data
@Builder
public class Contract {
    private String title;
    private Interval interval;
}

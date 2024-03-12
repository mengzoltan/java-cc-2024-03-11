package org.training.datamunging;

import java.nio.file.Path;

public class DataMungingApp {

    public static void main(String[] args) {
        int dayWithMinimumDiff = new WeatherFileProcessor(new WeatherFileFormat(2))
                .getDayWithMinimumDiff(Path.of("src/main/resources/weather.dat"));
        System.out.println(dayWithMinimumDiff);
    }

}

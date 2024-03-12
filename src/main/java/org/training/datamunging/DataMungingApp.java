package org.training.datamunging;

import org.training.datamunging.football.FootballClub;
import org.training.datamunging.football.FootballFileFormat;
import org.training.datamunging.weather.Weather;
import org.training.datamunging.weather.WeatherFileFormat;

import java.nio.file.Path;

public class DataMungingApp {

    public static void main(String[] args) {
        Weather weather = new DatFileProcessor<>(new WeatherFileFormat(2))
                .getInstanceWithMinimumDiff(Path.of("src/main/resources/weather.dat"));
        System.out.println(weather.day());

        FootballClub footballClub = new DatFileProcessor<>(new FootballFileFormat(1))
                .getInstanceWithMinimumDiff(Path.of("src/main/resources/football.dat"));
        System.out.println(footballClub.name());
    }

}

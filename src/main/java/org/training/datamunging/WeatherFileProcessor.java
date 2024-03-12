package org.training.datamunging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public class WeatherFileProcessor {

    private WeatherFileFormat weatherFileFormat;

    @SneakyThrows
    public int getDayWithMinimumDiff(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath)) {

            Optional<Weather> min = lines
                    .skip(weatherFileFormat.getHeaderLines())
                    .filter(weatherFileFormat::isProcessableRow)
                    .map(weatherFileFormat::createWeather)
                    .min(Comparator.comparing(Weather::getDifference));

            return min.orElseThrow(IllegalArgumentException::new).day();
        }

    }

}

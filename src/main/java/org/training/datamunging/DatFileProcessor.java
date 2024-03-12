package org.training.datamunging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public class DatFileProcessor <T> {

    private DatFileFormat<T> datFileFormat;

    @SneakyThrows
    public T getInstanceWithMinimumDiff(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath)) {

            Optional<T> min = lines
                    .skip(datFileFormat.getSkippingLines())
                    .filter(datFileFormat::isProcessableRow)
                    .map(datFileFormat::createWeather)
                    .min(datFileFormat::getComperator);

            return min.orElseThrow(IllegalArgumentException::new);
        }

    }

}

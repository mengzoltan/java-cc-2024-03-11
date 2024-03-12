package org.training.datamunging;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
public class WeatherFileFormat {
    private int headerLines;


    public boolean isProcessableRow(String line) {
        return !line.trim().startsWith("m") && !line.trim().isEmpty();
    }

    public Weather createWeather(String line) {
        line = replaceSpaces(line);
        String[] parts = line.trim().split(" ");
        int day = Integer.parseInt(getNumbers(parts[0]));
        int max = Integer.parseInt(getNumbers(parts[1]));
        int min = Integer.parseInt(getNumbers(parts[2]));

        return Weather.builder().day(day).max(max).min(min).build();
    }

    private String replaceSpaces(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }

    private String getNumbers(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString();
    }
}

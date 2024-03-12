package org.training.datamunging.football;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.training.datamunging.DatFileFormat;

@Data
@AllArgsConstructor
public class FootballFileFormat implements DatFileFormat<FootballClub> {

    private int headerLines;

    public boolean isProcessableRow(String line) {
        return !line.trim().startsWith("-") && !line.trim().isEmpty();
    }

    public FootballClub createWeather(String line) {
        line = replaceSpaces(line);
        String[] parts = line.trim().split(" ");
        String name = parts[1];
        int fGoals = Integer.parseInt(parts[6]);
        int aGoals = Integer.parseInt(parts[8]);

        return FootballClub.builder().name(name).fGoals(fGoals).aGoals(aGoals).build();
    }

    @Override
    public int getSkippingLines() {
        return headerLines;
    }

    @Override
    public int getComperator(FootballClub club, FootballClub t1) {
        return club.getDifference() - t1.getDifference();
    }

    private String replaceSpaces(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }

}

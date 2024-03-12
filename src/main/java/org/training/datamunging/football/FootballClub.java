package org.training.datamunging.football;

import lombok.Builder;

public record FootballClub(String name, int fGoals, int aGoals) {
    @Builder public FootballClub {}

    public int getDifference() {
        return Math.abs(fGoals - aGoals);
    }
}

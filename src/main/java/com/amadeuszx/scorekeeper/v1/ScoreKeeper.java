package com.amadeuszx.scorekeeper.v1;

/**
 * https://kata-log.rocks/score-keeper-kata
 */
public class ScoreKeeper {
    private int teamA = 0;
    private int teamB = 0;

    public String getScore() {
        final int tmpA = Math.min(teamA, 999);
        final int tmpB = Math.min(teamB, 999);
        return String.format("%03d:%03d", tmpA, tmpB);
    }

    public void scoreTeamA1() {
        teamA++;
    }

    public void scoreTeamA2() {
        teamA += 2;
    }

    public void scoreTeamA3() {
        teamA += 3;
    }

    public void scoreTeamB1() {
        teamB++;
    }

    public void scoreTeamB2() {
        teamB += 2;
    }

    public void scoreTeamB3() {
        teamB += 3;
    }
}

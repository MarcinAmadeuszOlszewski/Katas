package com.amadeuszx.scorekeeper.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreKeeperTest {

    private static ScoreKeeper scoreKeeper;

    @BeforeEach
    void setUp() {
        scoreKeeper = new ScoreKeeper();
    }

    @Test
    void getScoreOnBeginningReturnZeros() {
        final String result = scoreKeeper.getScore();
        assertEquals("000:000", result);
    }

    @ParameterizedTest
    @MethodSource("examples")
    void getScoreAfterScoreTeamA1ReturnOnePointForA(Score score, String expected) {
        score.score();
        final String result = scoreKeeper.getScore();
        assertEquals(expected, result);
    }

    @Test
    void getScoreDigitLimit() {
        for (int i = 0; i < 334; i++) {
            scoreKeeper.scoreTeamA3();
            scoreKeeper.scoreTeamB3();
        }
        final String result = scoreKeeper.getScore();
        assertEquals("999:999", result);
    }

    private static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of((Score) () -> scoreKeeper.scoreTeamA1(), "001:000"),
                Arguments.of((Score) () -> scoreKeeper.scoreTeamA2(), "002:000"),
                Arguments.of((Score) () -> scoreKeeper.scoreTeamA3(), "003:000"),
                Arguments.of((Score) () -> scoreKeeper.scoreTeamB1(), "000:001"),
                Arguments.of((Score) () -> scoreKeeper.scoreTeamB2(), "000:002"),
                Arguments.of((Score) () -> scoreKeeper.scoreTeamB3(), "000:003"),
                Arguments.of((Score) () -> {
                    scoreKeeper.scoreTeamA1();
                    scoreKeeper.scoreTeamA2();
                    scoreKeeper.scoreTeamA3();
                    scoreKeeper.scoreTeamB1();
                    scoreKeeper.scoreTeamB2();
                    scoreKeeper.scoreTeamB3();
                }, "006:006"),
                Arguments.of((Score) () -> {
                    scoreKeeper.scoreTeamA1();
                    scoreKeeper.scoreTeamA2();
                    scoreKeeper.scoreTeamA3();
                }, "006:000"),
                Arguments.of((Score) () -> {
                    scoreKeeper.scoreTeamB1();
                    scoreKeeper.scoreTeamB2();
                    scoreKeeper.scoreTeamB3();
                }, "000:006")
        );
    }
}
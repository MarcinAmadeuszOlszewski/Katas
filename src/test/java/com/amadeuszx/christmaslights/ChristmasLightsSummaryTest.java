package com.amadeuszx.christmaslights;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChristmasLightsSummaryTest {

    private final ChristmasLights christmasLights = new ChristmasLights();

    @Test
    void summary() {
//        turn on 887,9 through 959,629
        christmasLights.turnOn(new Point(887, 9), new Point(959, 629));
//        turn on 454,398 through 844,448
        christmasLights.turnOn(new Point(454, 398), new Point(454, 398));
//        turn off 539,243 through 559,965
        christmasLights.turnOff(new Point(539, 243), new Point(559, 965));
//        turn off 370,819 through 676,868
        christmasLights.turnOff(new Point(370, 819), new Point(676, 868));
//        turn off 145,40 through 370,997
        christmasLights.turnOff(new Point(145, 40), new Point(370, 997));
//        turn off 301,3 through 808,453
        christmasLights.turnOff(new Point(301, 3), new Point(808, 453));
//        turn on 351,678 through 951,908
        christmasLights.turnOn(new Point(351, 678), new Point(897, 994));
//        toggle 720,196 through 897,994
        christmasLights.toggle(new Point(720, 196), new Point(897, 994));
//        toggle 831,394 through 904,860
        christmasLights.toggle(new Point(831, 394), new Point(904, 860));

        assertEquals(236944, christmasLights.count());
    }
}

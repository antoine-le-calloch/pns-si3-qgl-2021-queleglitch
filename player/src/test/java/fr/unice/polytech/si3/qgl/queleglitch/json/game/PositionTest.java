package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position position0_0;
    Position position100_0;
    Position position0_100;
    Position position100_100;
    Position positionShipForRunnerTest;

    @BeforeEach
    void setUp() {
        position0_0 = new Position(0,0,0);
        position100_0 = new Position(100,0,0);
        position0_100 = new Position(0,100,0);
        position100_100 = new Position(100,100,0);
    }

    //////////////////////////////////////    Test de getAngleToAPlace()     //////////////////////////////////////

    @Test
    void getAngleToAPlaceIn_100_0(){
        assertEquals(0, position0_0.getAngleToAPlace(new Position(100, 0, 0)));
    }

    @Test
    void getAngleToAPlaceIn_100_100(){
        assertEquals(Math.PI/4, position0_0.getAngleToAPlace(new Position(100, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_0_100(){
        assertEquals(Math.PI/2, position0_0.getAngleToAPlace(new Position(0, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_100(){
        assertEquals(3*Math.PI/4, position0_0.getAngleToAPlace(new Position(-100, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_0(){
        assertEquals(Math.PI, position0_0.getAngleToAPlace(new Position(-100, 0, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_Minus100(){
        assertEquals(-3*Math.PI/4, position0_0.getAngleToAPlace(new Position(-100, -100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_0_Minus100(){
        assertEquals(-Math.PI/2, position0_0.getAngleToAPlace(new Position(0, -100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_100_Minus100(){
        assertEquals(-Math.PI/4, position0_0.getAngleToAPlace(new Position(100, -100, 0)));
    }

    /////position 100_0

    @Test
    void getAngleToAPlaceIn_100_0_PositionIn100_0(){
        assertEquals(0, position100_0.getAngleToAPlace(new Position(200, 0, 0)));
    }

    @Test
    void getAngleToAPlaceIn_100_100_PositionIn100_0(){
        assertEquals(Math.PI/4, position100_0.getAngleToAPlace(new Position(200, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_0_100_PositionIn100_0(){
        assertEquals(Math.PI/2, position100_0.getAngleToAPlace(new Position(100, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_100_PositionIn100_0(){
        assertEquals(3*Math.PI/4, position100_0.getAngleToAPlace(new Position(0, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_0_PositionIn100_0(){
        assertEquals(Math.PI, position100_0.getAngleToAPlace(new Position(0, 0, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_Minus100_PositionIn100_0(){
        assertEquals(-3*Math.PI/4, position100_0.getAngleToAPlace(new Position(0, -100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_0_Minus100_PositionIn100_0(){
        assertEquals(-Math.PI/2, position100_0.getAngleToAPlace(new Position(100, -100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_100_Minus100_PositionIn100_0(){
        assertEquals(-Math.PI/4, position100_0.getAngleToAPlace(new Position(200, -100, 0)));
    }

    //////////////////////////////////////    Test de getNorm()     //////////////////////////////////////

    @Test
    void getNormToAPlaceIn_100_0(){
        assertEquals(100, position0_0.getNorm(new Position(100, 0, 0)));
    }

    @Test
    void getNormToAPlaceIn_100_100(){
        assertEquals(Math.sqrt(20000), position0_0.getNorm(new Position(100, 100, 0)));
    }

    @Test
    void getNormToAPlaceIn_0_100(){
        assertEquals(100, position0_0.getNorm(new Position(0, 100, 0)));
    }

    @Test
    void getNormToAPlaceIn_Minus100_100(){
        assertEquals(Math.sqrt(20000), position0_0.getNorm(new Position(-100, 100, 0)));
    }

    @Test
    void getNormToAPlaceIn_Minus100_0(){
        assertEquals(100, position0_0.getNorm(new Position(-100, 0, 0)));
    }

    @Test
    void getNormToAPlaceIn_Minus100_Minus100(){
        assertEquals(Math.sqrt(20000), position0_0.getNorm(new Position(-100, -100, 0)));
    }

    @Test
    void getNormToAPlaceIn_0_Minus100(){
        assertEquals(100, position0_0.getNorm(new Position(0, -100, 0)));
    }

    @Test
    void getNormToAPlaceIn_100_Minus100(){
        assertEquals(Math.sqrt(20000), position0_0.getNorm(new Position(100, -100, 0)));
    }

    //////////////////////////////////////    Test de resolveNewPosition()     //////////////////////////////////////

    @Test
    void nextPosition_angle0_speed0() {
        Position nextPosition = position0_0.calculateNewPosition(0,0);
        assertEquals(new Position(0,0,0),nextPosition);
    }

    @Test
    void nextPosition_angle0_speed100() {
        Position nextPosition = position0_0.calculateNewPosition(0,100);
        assertEquals(new Position(100,0,0),nextPosition);
    }

    @Test
    void nextPosition_angle1_speed100() {
        Position nextPosition = position0_0.calculateNewPosition(1,100);
        assertEquals(new Position(100,0,1),nextPosition);
    }

    ////////////////// Runner test

    @Test
    void rudderTestStep0() {
        positionShipForRunnerTest = new Position(2852.173913043478, 1978.827361563518, -1.0297442586766543);
        Position nextPosition = positionShipForRunnerTest.calculateNewPosition(0.0930508042072854/100,(165 + 50.0*Math.cos(-1.0297442586766543))/100);
        assertEquals(new Position(2853.1563579763833,1977.1922986191448,-1.0288137506345814),nextPosition);
    }

    @Test
    void rudderTestStep1() {
        positionShipForRunnerTest = new Position(2853.1563579763833,1977.1922986191448,-1.0288137506345814);
        Position nextPosition = positionShipForRunnerTest.calculateNewPosition(0.0930508042072854/100,(165 + 50.0*Math.cos(1.0288137506345814))/100);
        assertEquals(new Position(2854.140529580881, 1975.5578090034594, -1.0278832425925084), nextPosition);
    }
}
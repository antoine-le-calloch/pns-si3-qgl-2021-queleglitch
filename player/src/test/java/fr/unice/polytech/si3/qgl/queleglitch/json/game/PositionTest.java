package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position position1;
    Position position2;
    Position positionRunnerTest;

    @BeforeEach
    void setUp() {
        position1 = new Position(0,0,0);
        position2 = new Position(0,0,0);
    }

    //////////////////////////////////////    Test de resolveNewPosition()     //////////////////////////////////////

    @Test
    void nextPosition_angle0_speed0() {
        assertEquals(position1,position1.getNextPosition(0,0));
    }

    @Test
    void nextPosition_angle0_speed100() {
        assertEquals(new Position(100,0,0),position1.getNextPosition(0,100));
    }

    @Test
    void nextPosition_angle1_speed100() {
        assertEquals(new Position(84.3762461008662,45.54865083873183,1.0000000000000007),position1.getNextPosition(1,100));
    }

    ////////////////// Runner test

    @Test
    void rudderTestRound0() {
        positionRunnerTest = new Position(2852.173913043478, 1978.827361563518, -1.0297442586766543);
        assertEquals(new Position(2950.418406334009, 1815.3210671261977, -0.9366934544693667),positionRunnerTest.getNextPosition(0.0930508042072854,165 + 50.0*Math.cos(1.0297442586766543)));
    }

    @Test
    void rudderTestRound1() {
        positionRunnerTest = new Position(2958.9016642451215, 1818.4806682445735, -0.9366934544693667);
        assertEquals(new Position(3074.2068908993306,1661.6918931870753,-0.9366934544693667),positionRunnerTest.getNextPosition(0,165.0 + 50.0*Math.cos(-0.9366934544693667)));
    }
}
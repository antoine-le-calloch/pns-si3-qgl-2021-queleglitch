package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    Circle circle;

    @BeforeEach
    void setUp() {
        circle = new Circle(100);
    }

    @Test
    void firstRealPoints_rad100_on_0_0() {
        assertEquals(new Point(110,0), circle.getRealPoints(new Position(0,0,0))[0]);
    }

    @Test
    void firstRealPoints_rad100_on_0_100() {
        assertEquals(new Point(110,100), circle.getRealPoints(new Position(0,100,0))[0]);
    }

    @Test
    void allRealPoints_rad100_on_0_0() {
        assertTrue(Arrays.stream(circle.getRealPoints(new Position(0,0,0))).allMatch(point -> Math.round(point.getNorm(new Point(0,0))) == 110));
    }

    @Test
    void allRealPoints_rad100_on_548_497() {
        assertTrue(Arrays.stream(circle.getRealPoints(new Position(548,497,0))).allMatch(point -> Math.round(point.getNorm(new Point(548,497))) == 110));
    }

    @Test
    void allRealPoints_rad100_on_548_497_NormWith0_0() {
        assertFalse(Arrays.stream(circle.getRealPoints(new Position(548,497,0))).allMatch(point -> Math.round(point.getNorm(new Point(0,0))) == 110));
    }
}
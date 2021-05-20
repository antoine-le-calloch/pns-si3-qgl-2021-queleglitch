package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingTest {

    Moving movingtest;

    @BeforeEach
    void setUp(){
        movingtest = new Moving(1,2,3);
    }

    @Test
    void getTrueXdistance() {
        assertEquals(1,movingtest.getXdistance());
    }

    @Test
    void getFalseXdistanceTest() {
        assertNotEquals(4,movingtest.getXdistance());
    }

    @Test
    void getTrueYdistance() {
        assertEquals(2,movingtest.getYdistance());
    }

    @Test
    void getFalseYdistance() {
        assertNotEquals(6,movingtest.getYdistance());
    }

    @Test
    void getTrueType() {
        assertEquals("MOVING",movingtest.getType());
    }

    @Test
    void getFalseType() {
        assertNotEquals("ROW",movingtest.getType());
    }

    @Test
    void setXdistanceTest() {
        movingtest.setXdistance(4);
        assertEquals(4,movingtest.getXdistance());
        assertNotEquals(6,movingtest.getXdistance());
    }

    @Test
    void setYdistanceTest() {
        movingtest.setYdistance(5);
        assertEquals(5,movingtest.getYdistance());
        assertNotEquals(6,movingtest.getYdistance());
    }
}
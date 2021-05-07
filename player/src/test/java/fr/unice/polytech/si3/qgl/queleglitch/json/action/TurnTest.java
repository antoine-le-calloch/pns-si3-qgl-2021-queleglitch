package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {

    Turn turnTest;

    @BeforeEach
    void setUp(){
        turnTest = new Turn(Math.PI/4,3);
    }

    @Test
    void getGoodRotation() {
        assertEquals(Math.PI/4,turnTest.getRotation());
    }

    @Test
    void getFalseRotation() {
        assertNotEquals(Math.PI/3,turnTest.getRotation());
    }

    @Test
    void getTrueType() {
        assertEquals("TURN",turnTest.getType());
    }

    @Test
    void setRotation() {
        turnTest.setRotation(Math.PI/6);
        assertEquals(Math.PI/6,turnTest.getRotation());
        assertNotEquals(Math.PI/3,turnTest.getRotation());
    }
}
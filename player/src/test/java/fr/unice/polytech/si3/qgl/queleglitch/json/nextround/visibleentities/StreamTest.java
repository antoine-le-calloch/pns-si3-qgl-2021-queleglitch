package fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamTest {

    Stream streamTest = new Stream();

    @Test
    void get_Good_Type() {
        assertEquals("stream",streamTest.getType());
    }

    @Test
    void get_Bad_Type() {
        assertNotEquals("reef",streamTest.getType());
    }

    @Test
    void getStrengthTest() {
        streamTest.setStrength(180);
        assertEquals(180,streamTest.getStrength());
    }

    @Test
    void setStrengthTest() {
        assertEquals(0,streamTest.getStrength());
        streamTest.setStrength(145);
        assertEquals(145,streamTest.getStrength());
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.json.nextround;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WindTest {

    Wind windTest;

    @BeforeEach
    void setUp(){
        windTest = new Wind(140,0);
    }

    @Test
    void get_And_Set_Strenght_Test(){
        assertEquals(140,windTest.getStrength());
        windTest.setStrength(320);
        assertEquals(320,windTest.getStrength());
        assertNotEquals(140,windTest.getStrength());
    }

    @Test
    void get_And_Set_Orientation_Test(){
        assertEquals(0,windTest.getOrientation());
        windTest.setOrientation(Math.PI);
        assertEquals(Math.PI,windTest.getOrientation());
        assertNotEquals(0,windTest.getOrientation());
    }

}
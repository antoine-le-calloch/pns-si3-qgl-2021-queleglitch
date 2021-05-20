package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntitiesTest {

    Oar oar;
    private static final int EXPECTED = 0;
    private static final int NOT_EXPECTED = 0;

    @BeforeEach
    void setUp(){
        oar = new Oar(1,1);

    }

    @Test
    void wellSetPosition(){
        oar.setX(0);
        oar.setY(0);
        assertEquals(EXPECTED,oar.getX());
        assertEquals(EXPECTED,oar.getY());
    }

    @Test
    void positionNotSet(){
        assertNotEquals(EXPECTED, oar.getX());
        assertNotEquals(EXPECTED, oar.getY());
    }

}
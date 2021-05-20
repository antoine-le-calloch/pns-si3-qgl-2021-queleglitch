package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SailTest {

    Sail sailClosed;

    @BeforeEach
    void setUp(){
        sailClosed = new Sail(0,0,false);
    }

    @Test
    void setSailOpen(){
        sailClosed.setOpenned(true);
        assertEquals(true, sailClosed.isOpenned());
    }

}
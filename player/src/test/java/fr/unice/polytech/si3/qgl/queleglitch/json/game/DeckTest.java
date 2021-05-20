package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deckTest;

    @BeforeEach
    void setUp(){
        deckTest = new Deck(340,270);
    }

    @Test
    void getTrueWidth() {
        assertEquals(340,deckTest.getWidth());
    }

    @Test
    void getFalseWidth() {
        assertNotEquals(300,deckTest.getWidth());
    }

    @Test
    void getTrueLength() {
        assertEquals(270,deckTest.getLength());
    }

    @Test
    void getFalseLength() {
        assertNotEquals(300,deckTest.getLength());
    }

    @Test
    void setWidth() {
        deckTest.setWidth(180);
        assertEquals(180,deckTest.getWidth());
        assertNotEquals(340,deckTest.getWidth());
    }

    @Test
    void setLength() {
        deckTest.setLength(290);
        assertEquals(290,deckTest.getLength());
        assertNotEquals(270,deckTest.getLength());
    }
}
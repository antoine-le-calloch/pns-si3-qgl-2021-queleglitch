package fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReefTest {

    Reef reefTest;

    @BeforeEach
    void setUp(){
        reefTest = new Reef(new Position(-500,0,0), new Rectangle(430,420,0));
    }


    @Test
    void get_Good_Type() {
        assertEquals("reef",reefTest.getType());
    }

    @Test
    void get_Bad_Type() {
        assertNotEquals("stream",reefTest.getType());
    }

    @Test
    void equalityTest(){
        Reef reefTest2 = new Reef(new Position(-500,0,0), new Rectangle(430,420,0));
        Reef reefTest3 = new Reef(new Position(-300,200,0), new Rectangle(230,120,0));
        assertEquals(reefTest,reefTest2);
        assertNotEquals(reefTest,reefTest3);
    }
}
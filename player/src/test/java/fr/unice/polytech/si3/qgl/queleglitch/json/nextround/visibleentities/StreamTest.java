package fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
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

    @Test
    void equalityTest(){
        Stream streamTest2 = new Stream(new Position(0,0,0),new Circle(2));
        Stream streamTest3 = new Stream(new Position(0,0,0),new Circle(2));
        Stream streamTest4 = new Stream(new Position(3,3,0),new Circle(1));
        assertEquals(streamTest2,streamTest3);
        assertNotEquals(streamTest2,streamTest4);
    }
}
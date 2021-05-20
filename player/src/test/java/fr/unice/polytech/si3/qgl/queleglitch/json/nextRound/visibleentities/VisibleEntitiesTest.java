package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisibleEntitiesTest {

    VisibleEntities visibleEntitiesTest = new VisibleEntities(new Position(0,10,0),new Rectangle(5,5,0));

    @Test
    void get_Good_Position() {
        Position goodPosition = new Position(0,10,0);
        assertEquals(goodPosition,visibleEntitiesTest.getPosition());
    }

    @Test
    void get_Bad_Position() {
        Position badPosition = new Position(0,40,0);
        assertNotEquals(badPosition,visibleEntitiesTest.getPosition());
    }

    @Test
    void get_Good_Shape() {
        Shape goodShape = new Rectangle(5,5,0);
        assertEquals(goodShape,visibleEntitiesTest.getShape());
    }

    @Test
    void get_Bad_Shape() {
        Shape badShape = new Rectangle(3,3,0);
        Shape badShape2 = new Circle(2);
        assertNotEquals(badShape,visibleEntitiesTest.getShape());
        assertNotEquals(badShape2,visibleEntitiesTest.getShape());
    }

    @Test
    void setPositionTest() {
        Position originPosition = new Position(0,10,0);
        assertEquals(originPosition,visibleEntitiesTest.getPosition());
        visibleEntitiesTest.setPosition(new Position(18,12,0));
        Position expectedPosition = new Position(18,12,0);
        assertEquals(expectedPosition,visibleEntitiesTest.getPosition());
    }

    @Test
    void setShapeTest() {
        Shape originShape = new Rectangle(5,5,0);
        assertEquals(originShape,visibleEntitiesTest.getShape());
        visibleEntitiesTest.setShape(new Circle(6));
        Shape expectedShape = new Circle(6);
        assertEquals(expectedShape,visibleEntitiesTest.getShape());
    }

    @Test
    void EqualityTest() {
        VisibleEntities visibleEntitiesTest2 = new VisibleEntities(new Position(0,10,0),new Rectangle(5,5,0));
        VisibleEntities visibleEntitiesTest3 = new VisibleEntities(new Position(7,7,0),new Rectangle(5,5,0));
        assertEquals(visibleEntitiesTest,visibleEntitiesTest2);
        assertNotEquals(visibleEntitiesTest,visibleEntitiesTest3);
    }
}
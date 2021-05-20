package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void EqualityTest() {
        Circle circle = new Circle(6);
        Circle circle2 = new Circle(6);
        Circle circle3 = new Circle(3);
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Rectangle rectangle2 = new Rectangle(3,5,0);
        assertEquals(circle,circle2);
        assertNotEquals(circle,circle3);
        assertNotEquals(rectangle1,rectangle2);
    }
}
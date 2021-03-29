package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    Rectangle rectangle;

    @BeforeEach
    void setUp() {
    }

    ////////////////////getReelPoints()

    @Test
    void reelPoints_W2_H4_ort0_mid0_0(){
        rectangle = new Rectangle(2,4,0);
        Point[] reelPoints = new Point[]{new Point(2,1),new Point(-2,1), new Point(-2,-1),new Point(2,-1)};
        assertArrayEquals(reelPoints,rectangle.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reelPoints_W2_H4_ortPIOn2_mid0_0(){
        rectangle = new Rectangle(2,4,Math.PI/2);
        Point[] reelPoints = new Point[]{new Point(-0.9999999999999999,2),new Point(-1.0000000000000002,-2),new Point(0.9999999999999999,-2),new Point(1.0000000000000002,2)};
        assertArrayEquals(reelPoints,rectangle.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reelPoints_W2_H4_ortMinusPIOn2_mid0_0(){
        rectangle = new Rectangle(2,4,-Math.PI/2);
        Point[] reelPoints = new Point[]{new Point(1.0000000000000002,-2),new Point(0.9999999999999999,2),new Point(-1.0000000000000002,2),new Point(-0.9999999999999999,-2)};
        assertArrayEquals(reelPoints,rectangle.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reelPoints_W2_H4_ort0_midMinus1_Minus1(){
        rectangle = new Rectangle(2,4,0);
        Point[] reelPoints = new Point[]{new Point(1,0),new Point(-3,0),new Point(-3,-2),new Point(1,-2)};
        assertArrayEquals(reelPoints,rectangle.getReelPoints(new Position(-1,-1,0)));
    }
}
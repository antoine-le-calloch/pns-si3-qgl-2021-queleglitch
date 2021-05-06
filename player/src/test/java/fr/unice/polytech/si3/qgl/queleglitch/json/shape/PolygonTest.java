package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    Polygon polygon;
    Point[] actual4Points;
    Point[] actual5Points;

    @BeforeEach
    void setUp() {
        actual4Points = new Point[]{new Point(2,1),new Point(-2,1), new Point(-2,-1),new Point(2,-1)};
        actual5Points = new Point[]{new Point(3,0),new Point(2,1),new Point(-2,1), new Point(-2,-1),new Point(2,-1)};
    }

    ////////////////////equals()

    @Test
    void polygonEquals(){
        Polygon polygon1 = new Polygon(0.268, actual5Points);
        Polygon polygon2 = new Polygon(0.268, actual5Points);

        assertEquals(polygon1,polygon2);
    }

    @Test
    void polygonNotEqualsOnVertices(){
        Polygon polygon1 = new Polygon(0.268, actual5Points);
        Polygon polygon2 = new Polygon(0.268, actual4Points);

        assertNotEquals(polygon1,polygon2);
    }

    @Test
    void polygonNotEqualsOnOrientation(){
        Polygon polygon1 = new Polygon(0.268, actual5Points);
        Polygon polygon2 = new Polygon(0.56, actual5Points);

        assertNotEquals(polygon1,polygon2);
    }

    ////////////////////getReelPoints()

    @Test
    void reel4Points_W2_H4_ort0_mid0_0(){
        polygon = new Polygon(0, actual4Points);

        assertArrayEquals(actual4Points,polygon.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void reel4Points_W2_H4_ortPIOn2_mid0_0(){
        polygon = new Polygon(Math.PI/2, actual4Points);

        Point[] reelPoints = new Point[]{new Point(-0.9999999999999999,2),new Point(-1.0000000000000002,-2),new Point(0.9999999999999999,-2),new Point(1.0000000000000002,2)};
        assertArrayEquals(reelPoints,polygon.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void reel4Points_W2_H4_ortMinusPIOn2_mid0_0(){
        polygon = new Polygon(-Math.PI/2, actual4Points);

        Point[] reelPoints = new Point[]{new Point(1.0000000000000002,-2),new Point(0.9999999999999999,2),new Point(-1.0000000000000002,2),new Point(-0.9999999999999999,-2)};
        assertArrayEquals(reelPoints,polygon.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void reel4Points_W2_H4_ort0_midMinus1_Minus1(){
        polygon = new Polygon(0, actual4Points);

        Point[] reelPoints = new Point[]{new Point(1,0),new Point(-3,0),new Point(-3,-2),new Point(1,-2)};
        assertArrayEquals(reelPoints,polygon.getRealPoints(new Position(-1,-1,0)));
    }

    @Test
    void reel5Points_ort0_mid0_0(){
        polygon = new Polygon(0, actual5Points);

        assertArrayEquals(actual5Points,polygon.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void reel5Points_ortPIOn2_mid0_0(){
        polygon = new Polygon(Math.PI/2, actual5Points);

        Point[] reelPoints = new Point[]{new Point(1.8369701987210297E-16,3),new Point(-0.9999999999999999,2),new Point(-1.0000000000000002,-2),new Point(0.9999999999999999,-2),new Point(1.0000000000000002,2)};
        assertArrayEquals(reelPoints,polygon.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void reel5Points_ortMinusPIOn2_mid0_0(){
        polygon = new Polygon(-Math.PI/2, actual5Points);

        Point[] reelPoints = new Point[]{new Point(1.8369701987210297E-16,-3),new Point(1.0000000000000002,-2),new Point(0.9999999999999999,2),new Point(-1.0000000000000002,2),new Point(-0.9999999999999999,-2)};
        assertArrayEquals(reelPoints,polygon.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void reel5Points_ort0_midMinus1_Minus1(){
        polygon = new Polygon(0, actual5Points);

        Point[] reelPoints = new Point[]{new Point(2,-1),new Point(1,0),new Point(-3,0),new Point(-3,-2),new Point(1,-2)};
        assertArrayEquals(reelPoints,polygon.getRealPoints(new Position(-1,-1,0)));
    }

    /*@Test
    void reel5Points_ort0_In1172_1548(){
        Point[] points = new Point[]{new Point(28.0,-748.0),new Point(568.0,-48.0),
                new Point(68.0,712.0),new Point(-252.0,332.0),new Point(-412.0,-248.0)};
        polygon = new Polygon(0, points);

        Point[] points = new Point[]{new Point(28.0,-748.0),new Point(568.0,-48.0),
                new Point(68.0,712.0),new Point(-252.0,332.0),new Point(-412.0,-248.0)};
        assertArrayEquals(reelPoints,polygon.getRealPoints(new Position(1172.0,1548.0,0.0)));
    }*/
}
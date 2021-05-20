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

    @Test
    void get_And_Set_Orientation_Test(){
        polygon = new Polygon(0, actual5Points);
        assertEquals(0,polygon.getOrientation());
        polygon.setOrientation(3);
        assertEquals(3,polygon.getOrientation());
        assertNotEquals(5,polygon.getOrientation());
    }

    @Test
    void get_And_Set_Vertices_Test(){
        Point[] vertices = new Point[]{new Point(2,1),new Point(-2,1), new Point(-2,-1),new Point(2,-1)};
        Polygon polygonTest = new Polygon(0,vertices);
        assertEquals(vertices,polygonTest.getVertices());
        Point[] newVertices = new Point[]{new Point(3,1),new Point(-4,1), new Point(-2,-7),new Point(6,-5)};
        polygonTest.setVertices(newVertices);
        assertEquals(newVertices,polygonTest.getVertices());
    }

    @Test
    void see_Polygon_Informations(){
        polygon = new Polygon(0, actual5Points);
        assertEquals("Orientation : 0.0 | Vertices : [Point{x=3.0, y=0.0}, Point{x=2.0, y=1.0}, Point{x=-2.0, y=1.0}, Point{x=-2.0, y=-1.0}, Point{x=2.0, y=-1.0}]",polygon.toString());
    }

}
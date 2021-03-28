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

    ////////////////////getReelPoints()

    @Test
    void reel4Points_W2_H4_ort0_mid0_0(){
        polygon = new Polygon(0, actual4Points);

        assertArrayEquals(actual4Points,polygon.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reel4Points_W2_H4_ortPIOn2_mid0_0(){
        polygon = new Polygon(Math.PI/2, actual4Points);

        Point[] reelPoints = new Point[]{new Point(-0.9999999999999999,2),new Point(-1.0000000000000002,-2),new Point(0.9999999999999999,-2),new Point(1.0000000000000002,2)};
        assertArrayEquals(reelPoints,polygon.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reel4Points_W2_H4_ortMinusPIOn2_mid0_0(){
        polygon = new Polygon(-Math.PI/2, actual4Points);

        Point[] reelPoints = new Point[]{new Point(1.0000000000000002,-2),new Point(0.9999999999999999,2),new Point(-1.0000000000000002,2),new Point(-0.9999999999999999,-2)};
        assertArrayEquals(reelPoints,polygon.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reel4Points_W2_H4_ort0_midMinus1_Minus1(){
        polygon = new Polygon(0, actual4Points);

        Point[] reelPoints = new Point[]{new Point(1,0),new Point(-3,0),new Point(-3,-2),new Point(1,-2)};
        assertArrayEquals(reelPoints,polygon.getReelPoints(new Position(-1,-1,0)));
    }

    @Test
    void reel5Points_W2_H4_ort0_mid0_0(){
        polygon = new Polygon(0, actual5Points);

        assertArrayEquals(actual5Points,polygon.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reel5Points_W2_H4_ortPIOn2_mid0_0(){
        polygon = new Polygon(Math.PI/2, actual5Points);

        Point[] reelPoints = new Point[]{new Point(1.8369701987210297E-16,3),new Point(-0.9999999999999999,2),new Point(-1.0000000000000002,-2),new Point(0.9999999999999999,-2),new Point(1.0000000000000002,2)};
        assertArrayEquals(reelPoints,polygon.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reel5Points_W2_H4_ortMinusPIOn2_mid0_0(){
        polygon = new Polygon(-Math.PI/2, actual5Points);

        Point[] reelPoints = new Point[]{new Point(1.8369701987210297E-16,-3),new Point(1.0000000000000002,-2),new Point(0.9999999999999999,2),new Point(-1.0000000000000002,2),new Point(-0.9999999999999999,-2)};
        assertArrayEquals(reelPoints,polygon.getReelPoints(new Position(0,0,0)));
    }

    @Test
    void reel5Points_W2_H4_ort0_midMinus1_Minus1(){
        polygon = new Polygon(0, actual5Points);

        Point[] reelPoints = new Point[]{new Point(2,-1),new Point(1,0),new Point(-3,0),new Point(-3,-2),new Point(1,-2)};
        assertArrayEquals(reelPoints,polygon.getReelPoints(new Position(-1,-1,0)));
    }
}
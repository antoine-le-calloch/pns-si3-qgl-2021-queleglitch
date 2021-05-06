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
    void realPoints_W2_H4_ort0_mid0_0(){
        rectangle = new Rectangle(2,4,0);
        Point[] realPoints = new Point[]{new Point(2,1),new Point(-2,1), new Point(-2,-1),new Point(2,-1)};
        assertArrayEquals(realPoints,rectangle.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void realPoints_W2_H4_ortPIOn2_mid0_0(){
        rectangle = new Rectangle(2,4,Math.PI/2);
        Point[] realPoints = new Point[]{new Point(-0.9999999999999999,2),new Point(-1.0000000000000002,-2),new Point(0.9999999999999999,-2),new Point(1.0000000000000002,2)};
        assertArrayEquals(realPoints,rectangle.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void realPoints_W2_H4_ortMinusPIOn2_mid0_0(){
        rectangle = new Rectangle(2,4,-Math.PI/2);
        Point[] realPoints = new Point[]{new Point(1.0000000000000002,-2),new Point(0.9999999999999999,2),new Point(-1.0000000000000002,2),new Point(-0.9999999999999999,-2)};
        assertArrayEquals(realPoints,rectangle.getRealPoints(new Position(0,0,0)));
    }

    @Test
    void realPoints_W2_H4_ort0_midMinus1_Minus1(){
        rectangle = new Rectangle(2,4,0);
        Point[] realPoints = new Point[]{new Point(1,0),new Point(-3,0),new Point(-3,-2),new Point(1,-2)};
        assertArrayEquals(realPoints,rectangle.getRealPoints(new Position(-1,-1,0)));
    }

    @Test
    void realPoints_W250_H1200_ort0Point7_mid5416_211(){
        rectangle = new Rectangle(250,1200,0);
        Point[] realPoints = new Point[]{new Point(5795.69389589501,692.4711955261215),new Point(4876.440564152237,-78.87393609772568),
                                         new Point(5037.137466573871,-270.3850468774702),new Point(5956.390798316645,500.960084746377)};
        assertArrayEquals(realPoints,rectangle.getRealPoints(new Position(5416.415681234441,211.04307432432563,0.6981317007977318)));

    }

    @Test
    void realPoints_W250_H2500_ort0Point9_mid0_0(){
        rectangle = new Rectangle(250,2500,0.9250245035569946);
        Point[] realPoints = new Point[]{new Point(652.4393401841488,1073.521265453122),new Point(-852.098217695972,-923.0675096651099),
                new Point(-652.4393401841488,-1073.521265453122),new Point(852.098217695972,923.0675096651099)};
        assertArrayEquals(realPoints,rectangle.getRealPoints(new Position(0,0,0)));
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Polygon;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SpottingTest {

    Spotting spotting;
    Point point0_0;
    Point point100_0;
    Point point100_100;

    @BeforeEach
    void setUp() {
        spotting = new Spotting(null);
        point0_0 = new Point(0,0);
        point100_0 = new Point(100,0);
        point100_100 = new Point(100,100);
    }

    ///////////////////////////////////////////   isThisReefBetween2Points()  ///////////////////////////////////////////

    @Test
    void rectangleReef_CheckpointIn100_0_And_200_0_ReefIn150_0() {
        Point point200_0 = new Point(200,0);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(150,0,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point100_0, point200_0));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_200_0_ReefIn50_0() {
        Point point200_0 = new Point(200,0);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,0,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point200_0));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_200_0_ReefIn250_0() {
        Point point200_0 = new Point(200,0);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(250,0,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point200_0));
    }

    ///

    @Test
    void rectangleReef_CheckpointIn100_0_And_200_100_ReefIn150_0() {
        Point point200_100 = new Point(200,100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(150,50,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point100_0, point200_100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_200_100_ReefIn50_Minus50() {
        Point point200_100 = new Point(200,100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point200_100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_200_100_ReefIn250_150() {
        Point point200_100 = new Point(200,100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(250,150,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point200_100));
    }

    ///

    @Test
    void rectangleReef_CheckpointIn100_0_And_100_100_ReefIn100_50() {
    Point point100_100 = new Point(100,100);
    Rectangle rectangle = new Rectangle(2,4,0);
    Reef reef = new Reef(new Position(100,50,0),rectangle);
    assertTrue(spotting.isThisReefBetween2Points(reef, point100_0, point100_100));
}

    @Test
    void rectangleReef_CheckpointIn100_0_And_100_100_ReefIn100_Minus50() {
        Point point100_100 = new Point(100,100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(100,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point100_100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_100_100_ReefIn100_150() {
        Point point100_100 = new Point(100,100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(100,150,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point100_100));
    }

    ///

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_100_ReefIn50_50() {
        Point point0_100 = new Point(0,100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,50,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point100_0, point0_100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_100_ReefInMinus50_150() {
        Point point0_100 = new Point(0,100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(-50,150,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point0_100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_100_ReefIn150_Minus50() {
        Point point0_100 = new Point(0,100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(150,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point0_100));
    }

    ///

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_0_ReefIn50_0() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,0,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point100_0, point0_0));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_0_ReefInMinus50_0() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(-50,0,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point0_0));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_0_ReefIn150_0() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(150,0,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point0_0));
    }

    ///

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_Minus100_ReefIn50_0() {
        Point point0_Minus100 = new Point(0,-100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,-50,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point100_0, point0_Minus100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_Minus100_ReefInMinus50_0() {
        Point point0_Minus100 = new Point(0,-100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(-50,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point0_Minus100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_0_Minus100_ReefIn150_0() {
        Point point0_Minus100 = new Point(0,-100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(150,50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point0_Minus100));
    }

    ///

    @Test
    void rectangleReef_CheckpointIn100_0_And_100_Minus100_ReefIn50_0() {
        Point point100_Minus100 = new Point(100,-100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(100,-50,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point100_0, point100_Minus100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_100_Minus100_ReefInMinus50_0() {
        Point point100_Minus100 = new Point(100,-100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(100,-150,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point100_Minus100));
    }

    @Test
    void rectangleReef_CheckpointIn100_0_And_100_Minus100_ReefIn150_0() {
        Point point100_Minus100 = new Point(100,-100);
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(100,50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point100_0, point100_Minus100));
    }

    ///

    @Test
    void rectangleReef_Ort0_W2_H4_InMinus50_0() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(-50,0,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_InMinus50_50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(-50,50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_InMinus50_Minus50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(-50,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In0_50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(-50,50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In50_Minus50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In50_50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In0_Minus50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(0,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In50_0() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,0,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_100_50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(100,50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_100_Minus50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(100,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In150_50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(150,50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In150_Minus50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(150,-50,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In150_0() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(150,0,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In50_2() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,2,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In50_1() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,1,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In50_Minus1() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,-1,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_Ort0_W2_H4_In50_Minus2() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,-2,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_OrtPIOn2_W2_H4_In50_2() {
        Rectangle rectangle = new Rectangle(2,4,Math.PI/2);
        Reef reef = new Reef(new Position(50,2,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_OrtMinusPIOn2_W2_H4_In50_2() {
        Rectangle rectangle = new Rectangle(2,4,-Math.PI/2);
        Reef reef = new Reef(new Position(50,2,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_OrtPIOn4_W2_H4_In50_2() {
        Rectangle rectangle = new Rectangle(2,4,Math.PI/4);
        Reef reef = new Reef(new Position(50,2,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void rectangleReef_OrtPIOn8_W2_H4_In50_2() {
        Rectangle rectangle = new Rectangle(2,4,Math.PI/8);
        Reef reef = new Reef(new Position(50,2,0),rectangle);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void diagonal_rectangleReef_OrtP0_W2_H4_In50_50() {
        Rectangle rectangle = new Rectangle(2,4,0);
        Reef reef = new Reef(new Position(50,50,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_100));
    }

    @Test
    void diagonal_rectangleReef_OrtPIOn2_W2_H4_In50_50() {
        Rectangle rectangle = new Rectangle(2,4,Math.PI/2);
        Reef reef = new Reef(new Position(50,50,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_100));
    }

    @Test
    void diagonal_rectangleReef_OrtPI_W2_H4_In50_50() {
        Rectangle rectangle = new Rectangle(2,4,Math.PI);
        Reef reef = new Reef(new Position(50,50,0),rectangle);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_100));
    }

    @Test
    void polygonReef_In50_50() {
        Polygon polygon = new Polygon(0,new Point[]{new Point(1,0),new Point(-1,0.5),new Point(-1,-0.5)});
        Reef reef = new Reef(new Position(50,50,0),polygon);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_100));
    }

    @Test
    void polygonReef_In50_52() {
        Polygon polygon = new Polygon(0,new Point[]{new Point(1,0),new Point(-1,0.5),new Point(-1,-0.5)});
        Reef reef = new Reef(new Position(50,52,0),polygon);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_100));
    }

    @Test
    void polygonReef_In0_0() {
        Polygon polygon = new Polygon(0,new Point[]{new Point(1,0),new Point(-1,0.5),new Point(-1,-0.5)});
        Reef reef = new Reef(new Position(0,0,0),polygon);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void polygonReef_In0_1() {
        Polygon polygon = new Polygon(0,new Point[]{new Point(1,0),new Point(-1,0.5),new Point(-1,-0.5)});
        Reef reef = new Reef(new Position(0,1,0),polygon);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void polygonReef_In2_1() {
        Polygon polygon = new Polygon(0,new Point[]{new Point(1,0),new Point(-1,1),new Point(-1,-1)});
        Reef reef = new Reef(new Position(2,1,0),polygon);
        assertTrue(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    @Test
    void polygonReef_In2_2() {
        Polygon polygon = new Polygon(0,new Point[]{new Point(1,0),new Point(-1,1),new Point(-1,-1)});
        Reef reef = new Reef(new Position(2,2,0),polygon);
        assertFalse(spotting.isThisReefBetween2Points(reef, point0_0, point100_0));
    }

    ///////////////////////////////////////////   isReefsBetween2Points()  ///////////////////////////////////////////

    @Test
    void manyReef_50_2_And_50_Minus2() {
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Rectangle rectangle2 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,2,0),rectangle1),new Reef(new Position(50,-2,0),rectangle2)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertFalse(spotting.isReefsBetween2Points(point0_0, point100_0));
    }

    @Test
    void manyReef_50_1_And_50_Minus2() {
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Rectangle rectangle2 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,1,0),rectangle1),new Reef(new Position(50,-2,0),rectangle2)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertTrue(spotting.isReefsBetween2Points(point0_0, point100_0));
    }

    @Test
    void manyReef_50_2_And_50_Minus1() {
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,2,0),rectangle1),new Reef(new Position(50,-1,0),rectangle1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertTrue(spotting.isReefsBetween2Points(point0_0, point100_0));
    }

    @Test
    void manyReef_rectangle_50_1_And_50_Minus1() {
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,1,0),rectangle1),new Reef(new Position(50,-1,0),rectangle1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertTrue(spotting.isReefsBetween2Points(point0_0, point100_0));
    }

    @Test
    void manyReef_polygon_50_52_And_52_50() {
        Polygon polygon1 = new Polygon(Math.PI/8,new Point[]{new Point(1,0),new Point(-1,0.5),new Point(0,-1)});
        Reef[] reef = new Reef[]{new Reef(new Position(50,52,0),polygon1),new Reef(new Position(52,50,0),polygon1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertFalse(spotting.isReefsBetween2Points(point0_0, point100_100));
    }

    @Test
    void manyReef_polygon_50_51_And_52_50() {
        Polygon polygon1 = new Polygon(Math.PI/8,new Point[]{new Point(1,0),new Point(-0,0.5),new Point(0,-1)});
        Reef[] reef = new Reef[]{new Reef(new Position(50,51,0),polygon1),new Reef(new Position(52,50,0),polygon1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertTrue(spotting.isReefsBetween2Points(point0_0, point100_100));
    }

    @Test
    void manyReef_polygonAndRectangle_50_52_And_52_50_And_50_50() {
        Polygon polygon1 = new Polygon(Math.PI/8,new Point[]{new Point(1,0),new Point(-0,0.5),new Point(0,-1)});
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,52,0),polygon1),new Reef(new Position(52,50,0),polygon1),new Reef(new Position(50,50,0),rectangle1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertTrue(spotting.isReefsBetween2Points(point0_0, point100_100));
    }

    @Test
    void manyReef_polygonAndRectangle_50_52_And_51_50_And_52_50() {
        Polygon polygon1 = new Polygon(Math.PI/8,new Point[]{new Point(1,0),new Point(-0,0.5),new Point(0,-1)});
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,52,0),polygon1),new Reef(new Position(51,50,0),polygon1),new Reef(new Position(52,50,0),rectangle1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertTrue(spotting.isReefsBetween2Points(point0_0, point100_100));
    }

    @Test
    void manyReef_polygonAndRectangle_50_51_And_52_50_And_52_50() {
        Polygon polygon1 = new Polygon(Math.PI/8,new Point[]{new Point(1,0),new Point(-0,0.5),new Point(0,-1)});
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,51,0),polygon1),new Reef(new Position(52,50,0),polygon1),new Reef(new Position(52,50,0),rectangle1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertTrue(spotting.isReefsBetween2Points(point0_0, point100_100));
    }

    @Test
    void manyReef_polygonAndRectangle_50_51_And_51_50_And_51_50() {
        Polygon polygon1 = new Polygon(Math.PI/8,new Point[]{new Point(1,0),new Point(-0,0.5),new Point(0,-1)});
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,51,0),polygon1),new Reef(new Position(51,50,0),polygon1),new Reef(new Position(51,50,0),rectangle1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertTrue(spotting.isReefsBetween2Points(point0_0, point100_100));
    }

    @Test
    void manyReef_polygonAndRectangle_50_52_And_52_50_And_48_50() {
        Polygon polygon1 = new Polygon(Math.PI/8,new Point[]{new Point(1,0),new Point(-0,0.5),new Point(0,-1)});
        Rectangle rectangle1 = new Rectangle(2,4,0);
        Reef[] reef = new Reef[]{new Reef(new Position(50,52,0),polygon1),new Reef(new Position(52,50,0),polygon1),new Reef(new Position(46,50,0),rectangle1)};
        spotting = new Spotting(Arrays.asList(reef.clone()));
        assertFalse(spotting.isReefsBetween2Points(point0_0, point100_100));
    }

    ///////////////////////////////////////////   findLineIntersection()  ///////////////////////////////////////////

    @Test
    void LineIntersection_0_0__7_0_And_5_5__5_Minus5() {
        assertEquals(new Point(5,0),spotting.findLineIntersection(new Point(0,0),new Point(7,0),new Point(5,5),new Point(5,-5)));
    }

    @Test
    void LineIntersection_0_0__7_0_And_0_5__10_Minus5() {
        assertEquals(new Point(5,0),spotting.findLineIntersection(new Point(0,0),new Point(7,0),new Point(0,5),new Point(10,-5)));
    }

    @Test
    void LineIntersection_0_0__7_0_And_0_2__10_Minus2() {
        assertEquals(new Point(5,0),spotting.findLineIntersection(new Point(0,0),new Point(7,0),new Point(0,2),new Point(10,-2)));
    }

    @Test
    void LineIntersection_5_5__5_Minus5_And_0_0__7_0() {
        assertEquals(new Point(5,0),spotting.findLineIntersection(new Point(5,5),new Point(5,-5),new Point(0,0),new Point(7,0)));
    }

    @Test
    void LineIntersection_0_0__5_5_And_0_5__5_0() {
        assertEquals(new Point(2.5,2.5),spotting.findLineIntersection(new Point(0,0),new Point(5,5),new Point(0,5),new Point(5,0)));
    }

    ///////////////////////////////////////////   findEndPointOfALine()  ///////////////////////////////////////////

    /*@Test
    void twoSamePoints(){
        double nullAngle=0.0;
        double lengthUnitary=1.0;
        Point pointExpected=new Point(1,0);
        assertEquals(pointExpected,spotting.findEndPointOfALine(point0_0,point0_0,nullAngle,lengthUnitary));
    }*/


    @Test
    void endPointOf_0_0_WithTargetOn_1000_0_distanceToAdd0(){
        double distanceToAdd = 0;
        assertEquals(new Point(1000,0),spotting.findEndPointOfALine(new Point(0,0), new Point(1000,0), distanceToAdd));
    }

    @Test
    void endPointOf_1000_0_WithTargetOn_0_0_distanceToAdd0(){
        double distanceToAdd = 0;
        assertEquals(new Point(0,0),spotting.findEndPointOfALine(new Point(1000,0), new Point(0,0), distanceToAdd));
    }

    @Test
    void endPointOf_0_0_WithTargetOn_1000_1000_distanceToAdd_Sqrt8(){
        double distanceToAdd = Math.sqrt(8);
        assertEquals(new Point(998,1002),spotting.findEndPointOfALine(new Point(0,0), new Point(1000,1000), distanceToAdd));
    }

    @Test
    void endPointOf_0_0_WithTargetOn_0_1000_distanceToAdd_100(){
        double distanceToAdd = 100;
        assertEquals(new Point(-100,1000),spotting.findEndPointOfALine(new Point(0,0), new Point(0,1000), distanceToAdd));
    }

    @Test
    void endPointOf_0_0_WithTargetOn_Minus1000_1000_distanceToAdd_Sqrt8(){
        double distanceToAdd = Math.sqrt(8);
        assertEquals(new Point(-1002,998),spotting.findEndPointOfALine(new Point(0,0), new Point(-1000,1000), distanceToAdd));
    }

    @Test
    void endPointOf_0_0_WithTargetOn_Minus1000_0_distanceToAdd_100(){
        double distanceToAdd = 100;
        assertEquals(new Point(-1000,-100),spotting.findEndPointOfALine(new Point(0,0), new Point(-1000,0), distanceToAdd));
    }

    @Test
    void endPointOf_0_0_WithTargetOn_Minus1000_Minus1000_distanceToAdd_Sqrt8(){
        double distanceToAdd = Math.sqrt(8);
        assertEquals(new Point(-998,-1002),spotting.findEndPointOfALine(new Point(0,0), new Point(-1000,-1000), distanceToAdd));
    }

    @Test
    void endPointOf_0_0_WithTargetOn_0_Minus1000_distanceToAdd_100(){
        double distanceToAdd = 100;
        assertEquals(new Point(100,-1000),spotting.findEndPointOfALine(new Point(0,0), new Point(0,-1000), distanceToAdd));
    }

    @Test
    void endPointOf_0_0_WithTargetOn_1000_Minus1000_distanceToAdd_Sqrt8(){
        double distanceToAdd = Math.sqrt(8);
        assertEquals(new Point(1002,-998),spotting.findEndPointOfALine(new Point(0,0), new Point(1000,-1000), distanceToAdd));
    }

    ///

    @Test
    void endPointOf_0_0_WithTargetOn_1000_1000_distanceToAdd_Sqrt32(){
        double distanceToAdd = Math.sqrt(32);
        assertEquals(new Point(996,1004),spotting.findEndPointOfALine(new Point(0,0), new Point(1000,1000), distanceToAdd));
    }

    @Test
    void endPointOf_0_0_WithTargetOn_1000_1000_distanceToAdd_MinusSqrt32(){
        double distanceToAdd = -Math.sqrt(32);
        assertEquals(new Point(1004,996),spotting.findEndPointOfALine(new Point(0,0), new Point(1000,1000), distanceToAdd));
    }

    @Test
    void endPointOf_1000_1000_WithTargetOn_0_0_distanceToAdd_Sqrt32(){
        double distanceToAdd = Math.sqrt(32);
        assertEquals(new Point(4.000000000000001,-4),spotting.findEndPointOfALine(new Point(1000,1000), new Point(0,0), distanceToAdd));
    }

    @Test
    void endPointOf_1000_1000_WithTargetOn_0_0_distanceToAdd_MinusSqrt32(){
        double distanceToAdd = -Math.sqrt(32);
        assertEquals(new Point(-4.000000000000001,4),spotting.findEndPointOfALine(new Point(1000,1000), new Point(0,0), distanceToAdd));
    }
}
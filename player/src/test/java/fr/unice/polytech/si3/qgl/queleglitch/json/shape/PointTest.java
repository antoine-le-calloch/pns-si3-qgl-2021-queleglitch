package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    Point point0_0;
    Point point1_0;
    Point point0_1;
    Point point1_1;
    Point pointMinus1_Minus1;
    double angleExpected=0.0;

    @BeforeEach
    void setUp(){
        point0_0= new Point(0,0);
        point1_0= new Point(1,0);
        point0_1= new Point(0,1);
        point1_1= new Point(1,1);
        pointMinus1_Minus1=new Point(-1,-1);
    }

    @Test
    void angleBetweenTwoPointsWithSameYAnglePostive(){
        assertEquals(Math.PI,point1_0.getAngleToAPoint(point0_0));
    }
    @Test
    void angleBetweenTwoPointsWithSameYAngleNull(){
        assertEquals(angleExpected,point0_0.getAngleToAPoint(point1_0));
    }
    @Test
    void angleBetweenTwoPointsWithSameX(){
        assertEquals(-Math.PI/2,point0_1.getAngleToAPoint(point0_0));
    }
    @Test
    void angleBetweenTwoPointsWithSameXPositiveAngle(){
        assertEquals(Math.PI/2,point0_0.getAngleToAPoint(point0_1));
    }

    @Test
    void angleBetweenTwoPointsWithPositiveAngle_origin_and_positive_point(){
        assertEquals(Math.PI/4,point0_0.getAngleToAPoint(point1_1));
    }

    @Test
    void angleBetweenTwoPointsWithNegativeAngle_origin_and_negative_point(){
        assertEquals(-3*Math.PI/4,point0_0.getAngleToAPoint(pointMinus1_Minus1));
    }
}
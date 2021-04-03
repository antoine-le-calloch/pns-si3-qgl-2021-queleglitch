package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    Line lineAB;
    Line lineAC;

    @BeforeEach
    void setUp(){
        lineAB=new Line(1,0);
        lineAC=new Line(-1,0);
    }

    @Test
    void constructorTest(){
        Point pointA=new Point(0,0);
        Point pointC=new Point(1,-1);
        Point pointB=new Point(1,1);
        assertEquals(lineAB,new Line(pointA,pointB));
        assertEquals(lineAC,new Line(pointA,pointC));
    }

}
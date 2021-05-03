package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeometryTest {

    Geometry geometry;
    InformationGame informationGame;
    Position checkPointPosition;
    Position boatPosition;

    @Nested
    class Ship0_0{

        @BeforeEach
        void setUp(){
            informationGame = new InformationGame();
            boatPosition = new Position(0,0,0);
            checkPointPosition = new Position();
        }

        @Test
        void ship0_0CheckPoint_1000_0(){
            checkPointPosition = new Position(1000,0,0);
            geometry = new Geometry(boatPosition);
            assertEquals(0,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_600_500(){
            checkPointPosition = new Position(600,500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(500.0/600.0),geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_1000_1000(){
            checkPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }
        @Test
        void ship0_0CheckPoint_0_1000(){
            checkPointPosition = new Position(0,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI/2,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }
        @Test
        void ship0_0CheckPoint_Minus1000_1000(){
            checkPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals((3*Math.PI)/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_Minus600_500(){
            checkPointPosition = new Position(-600,500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(600.0/500.0)+Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_Minus1000_0(){
            checkPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_Minus600_Minus500(){
            checkPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.atan(600.0/500.0)-Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_Minus1000_Minus1000(){
            checkPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-(3*Math.PI)/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_0_Minus1000(){
            checkPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.PI/2,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_1000_Minus1000(){
            checkPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_600_Minus500(){
            checkPointPosition = new Position(600,-500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.atan(500.0/600.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }


    }

    @Nested
    class Ship0_0_Rotate45 {


        @BeforeEach
        void setUp() {
            informationGame = new InformationGame();
            boatPosition = new Position(0, 0, Math.PI/4);
            checkPointPosition = new Position();

        }
        @Test
        void ship0_0Rotate45CheckPoint_600_500(){
            checkPointPosition = new Position(600,500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(500.0/600.0)-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_1000_1000(){
            checkPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(0, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_0_1000(){
            checkPointPosition = new Position(0,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_Minus1000_1000(){
            checkPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_Minus600_500(){
            checkPointPosition = new Position(-600,500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(600.0/500.0)+Math.PI/2-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_Minus1000_0(){
            checkPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI-Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_Minus600_Minus500(){
            checkPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(2*Math.PI+(-Math.atan(600.0/500.0)-3*Math.PI/4),geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_Minus1000_Minus1000(){
            checkPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.PI,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_0_Minus1000(){
            checkPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-3*Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_1000_Minus1000(){
            checkPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_600_Minus500(){
            checkPointPosition = new Position(600,-500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.atan(500.0/600.0)-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotate45CheckPoint_1000_0(){
            checkPointPosition = new Position(1000,0,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }


    }

    @Nested
    class ship_Minus1_Minus1{
        @BeforeEach
        void setUp() {
            informationGame = new InformationGame();
            boatPosition = new Position(-1, -1, 0);
            checkPointPosition = new Position();
        }
        @Test
        void shipMinus1_Minus1CheckPoint_1000_0(){
            checkPointPosition = new Position(1000,0,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(1.0/1001.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_600_500(){
            checkPointPosition = new Position(600,500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(501.0/601.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_1000_1000(){
            checkPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_0_1000(){
            checkPointPosition = new Position(0,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(1001.0/1.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_1000(){
            checkPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(999.0/1001.0)+Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus600_500(){
            checkPointPosition = new Position(-600,500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(599.0/501.0)+Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_0(){
            checkPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(999.0/1.0)+Math.PI/2,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus600_Minus500(){
            checkPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.atan(599.0/499.0)-Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_Minus1000(){
            checkPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-(3*Math.PI)/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_0_Minus1000(){
            checkPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.atan(999.0/1.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_1000_Minus1000(){
            checkPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.atan(999.0/1001.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_600_Minus500(){
            checkPointPosition = new Position(600,-500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.atan(499.0/601.0),geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void errorRunner(){
            boatPosition = new Position(4025.6758696195516,276.126027138292,-0.9675112924526189);
            geometry = new Geometry(boatPosition);
            assertEquals(0.8102567219821311,geometry.calculateAngleToCheckPoint(new Position(4138.730832374324, 258.1996058558562,0.0)));
        }
    }

    @Nested
    class isThisPointInARectangle{
        @Test
        void pointIn_0_0_And_RectangleIn_Minus52_8(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(0,0), rectangle.getRealPoints(new Point(-52,8)));
            assertTrue(isInTheRectangle);
        }

        @Test
        void pointIn_0_0_And_RectangleIn_Minus57p5_Minus5(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(0,0), rectangle.getRealPoints(new Point(-57.5,-5)));
            assertTrue(isInTheRectangle);
        }

        @Test
        void pointIn_0_0_And_RectangleIn_Minus57p5_Minus35(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(0,0), rectangle.getRealPoints(new Point(-57.5,-35)));
            assertFalse(isInTheRectangle);
        }

        @Test
        void pointIn_Minus82_0_And_RectangleIn_Minus0_0(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(-82,0), rectangle.getRealPoints(new Point(0,0)));
            assertTrue(isInTheRectangle);
        }

        @Test
        void pointIn_Minus83_0_And_RectangleIn_Minus0_0(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(-83,0), rectangle.getRealPoints(new Point(0,0)));
            assertFalse(isInTheRectangle);
        }

        @Test
        void pointIn_Minus82_15_And_RectangleIn_Minus0_0(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(-82,15), rectangle.getRealPoints(new Point(0,0)));
            assertTrue(isInTheRectangle);
        }

        @Test
        void pointIn_Minus82_Minus15_And_RectangleIn_Minus0_0(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(-82,-14), rectangle.getRealPoints(new Point(0,0)));
            assertTrue(isInTheRectangle);
        }

        @Test
        void pointIn_82_0_And_RectangleIn_Minus0_0(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(82,0), rectangle.getRealPoints(new Point(0,0)));
            assertTrue(isInTheRectangle);
        }

        @Test
        void pointIn_83_0_And_RectangleIn_Minus0_0(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(83,0), rectangle.getRealPoints(new Point(0,0)));
            assertFalse(isInTheRectangle);
        }

        @Test
        void pointIn_82_15_And_RectangleIn_Minus0_0(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(82,15), rectangle.getRealPoints(new Point(0,0)));
            assertTrue(isInTheRectangle);
        }

        @Test
        void pointIn_82_Minus15_And_RectangleIn_Minus0_0(){
            Rectangle rectangle = new Rectangle(30,165,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(82,-14), rectangle.getRealPoints(new Point(0,0)));
            assertTrue(isInTheRectangle);
        }

        @Test
        void pointIn_652_1073_And_RectangleIn_Minus852_1073(){
            Rectangle rectangle = new Rectangle(200,200,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(652.4393401841488,1073.521265453122), rectangle.getRealPoints(new Point(-852.098217695972,1073.521265453122)));
            assertFalse(isInTheRectangle);
        }

        @Test
        void pointIn_Minus852_Minus923_And_RectangleIn_Minus852_1073(){
            Rectangle rectangle = new Rectangle(200,200,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(-852.098217695972,-923.0675096651099), rectangle.getRealPoints(new Point(-852.098217695972,1073.521265453122)));
            assertFalse(isInTheRectangle);
        }

        @Test
        void pointIn_Minus652_Minus1073_And_RectangleIn_Minus852_1073(){
            Rectangle rectangle = new Rectangle(200,200,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(-652.4393401841488,-1073.521265453122), rectangle.getRealPoints(new Point(-852.098217695972,1073.521265453122)));
            assertFalse(isInTheRectangle);
        }

        @Test
        void pointIn_852_923_And_RectangleIn_Minus852_1073(){
            Rectangle rectangle = new Rectangle(200,200,0);
            boolean isInTheRectangle = Geometry.isThisPointInARectangle(new Point(852.098217695972,923.0675096651099), rectangle.getRealPoints(new Point(-852.098217695972,1073.521265453122)));
            assertFalse(isInTheRectangle);
        }
    }
}
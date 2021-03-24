package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
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
        void ship0_0Rotat45CheckPoint_600_500(){
            checkPointPosition = new Position(600,500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(500.0/600.0)-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_1000(){
            checkPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(0, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_0_1000(){
            checkPointPosition = new Position(0,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_1000(){
            checkPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus600_500(){
            checkPointPosition = new Position(-600,500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.atan(600.0/500.0)+Math.PI/2-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_0(){
            checkPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(boatPosition);
            assertEquals(Math.PI-Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus600_Minus500(){
            checkPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(2*Math.PI+(-Math.atan(600.0/500.0)-3*Math.PI/4),geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_Minus1000(){
            checkPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.PI,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_0_Minus1000(){
            checkPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-3*Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_Minus1000(){
            checkPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_600_Minus500(){
            checkPointPosition = new Position(600,-500,0);
            geometry = new Geometry(boatPosition);
            assertEquals(-Math.atan(500.0/600.0)-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_0(){
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
}
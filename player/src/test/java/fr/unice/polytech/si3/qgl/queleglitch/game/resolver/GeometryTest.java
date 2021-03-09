package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeometryTest {

    Geometry geometry;
    InformationGame informationGame;
    Position checkPointPosition;
    Position boatPosition;
    Position nextCheckPointPosition;


    @Nested
    class Ship0_0{


        @BeforeEach
        void setUp(){
            informationGame = new InformationGame();
            boatPosition = new Position(0,0,0);
            nextCheckPointPosition = new Position();

        }


        @Test
        void ship0_0CheckPoint_1000_0(){
            nextCheckPointPosition = new Position(1000,0,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(0,geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_600_500(){
            nextCheckPointPosition = new Position(600,500,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(Math.atan(500.0/600.0),geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_1000_1000(){
            nextCheckPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(Math.PI/4,geometry.calculateAngleToCheckPoint());
        }
        @Test
        void ship0_0CheckPoint_0_1000(){
            nextCheckPointPosition = new Position(0,1000,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(Math.PI/2,geometry.calculateAngleToCheckPoint());
        }
        @Test
        void ship0_0CheckPoint_Minus1000_1000(){
            nextCheckPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals((3*Math.PI)/4, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_Minus600_500(){
            nextCheckPointPosition = new Position(-600,500,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(Math.atan(600.0/500.0)+Math.PI/2, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_Minus1000_0(){
            nextCheckPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(Math.PI, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_Minus600_Minus500(){
            nextCheckPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(-Math.atan(600.0/500.0)-Math.PI/2, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_Minus1000_Minus1000(){
            nextCheckPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(-(3*Math.PI)/4,geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_0_Minus1000(){
            nextCheckPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(-Math.PI/2,geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_1000_Minus1000(){
            nextCheckPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(-Math.PI/4, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0CheckPoint_600_Minus500(){
            nextCheckPointPosition = new Position(600,-500,0);
            geometry = new Geometry(informationGame,checkPointPosition,nextCheckPointPosition,boatPosition);
            assertEquals(-Math.atan(500.0/600.0), geometry.calculateAngleToCheckPoint());
        }


    }

    @Nested
    class Ship0_0_Rotate45 {


        @BeforeEach
        void setUp() {
            informationGame = new InformationGame();
            boatPosition = new Position(0, 0, Math.PI/4);
            nextCheckPointPosition = new Position();

        }
        @Test
        void ship0_0Rotat45CheckPoint_600_500(){
            nextCheckPointPosition = new Position(600,500,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.atan(500.0/600.0)-Math.PI/4,geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_1000(){
            nextCheckPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(0, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_0_1000(){
            nextCheckPointPosition = new Position(0,1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.PI/4, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_1000(){
            nextCheckPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.PI/2, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus600_500(){
            nextCheckPointPosition = new Position(-600,500,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.atan(600.0/500.0)+Math.PI/2-Math.PI/4,geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_0(){
            nextCheckPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.PI-Math.PI/4, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus600_Minus500(){
            nextCheckPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(2*Math.PI+(-Math.atan(600.0/500.0)-3*Math.PI/4),geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_Minus1000(){
            nextCheckPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-Math.PI,geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_0_Minus1000(){
            nextCheckPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-3*Math.PI/4, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_Minus1000(){
            nextCheckPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-Math.PI/2, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_600_Minus500(){
            nextCheckPointPosition = new Position(600,-500,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-Math.atan(500.0/600.0)-Math.PI/4,geometry.calculateAngleToCheckPoint());
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_0(){
            nextCheckPointPosition = new Position(1000,0,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-Math.PI/4, geometry.calculateAngleToCheckPoint());
        }

    }

    @Nested
    class ship_Minus1_Minus1{
        @BeforeEach
        void setUp() {
            informationGame = new InformationGame();
            boatPosition = new Position(-1, -1, 0);
            nextCheckPointPosition = new Position();
        }
        @Test
        void shipMinus1_Minus1CheckPoint_1000_0(){
            nextCheckPointPosition = new Position(1000,0,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.atan(1.0/1001.0), geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_600_500(){
            nextCheckPointPosition = new Position(600,500,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.atan(501.0/601.0), geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_1000_1000(){
            nextCheckPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.PI/4, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_0_1000(){
            nextCheckPointPosition = new Position(0,1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.atan(1001.0/1.0), geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_1000(){
            nextCheckPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.atan(999.0/1001.0)+Math.PI/2, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus600_500(){
            nextCheckPointPosition = new Position(-600,500,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.atan(599.0/501.0)+Math.PI/2, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_0(){
            nextCheckPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(Math.atan(999.0/1.0)+Math.PI/2,geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus600_Minus500(){
            nextCheckPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-Math.atan(599.0/499.0)-Math.PI/2, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_Minus1000(){
            nextCheckPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-(3*Math.PI)/4, geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_0_Minus1000(){
            nextCheckPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-Math.atan(999.0/1.0), geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_1000_Minus1000(){
            nextCheckPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-Math.atan(999.0/1001.0), geometry.calculateAngleToCheckPoint());
        }

        @Test
        void shipMinus1_Minus1CheckPoint_600_Minus500(){
            nextCheckPointPosition = new Position(600,-500,0);
            geometry = new Geometry(informationGame, checkPointPosition, nextCheckPointPosition, boatPosition);
            assertEquals(-Math.atan(499.0/601.0),geometry.calculateAngleToCheckPoint());
        }

    }

}
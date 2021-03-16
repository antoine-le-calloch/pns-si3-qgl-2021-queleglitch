package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.game.Processing;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
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
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(0,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_600_500(){
            checkPointPosition = new Position(600,500,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(Math.atan(500.0/600.0),geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_1000_1000(){
            checkPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }
        @Test
        void ship0_0CheckPoint_0_1000(){
            checkPointPosition = new Position(0,1000,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(Math.PI/2,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }
        @Test
        void ship0_0CheckPoint_Minus1000_1000(){
            checkPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals((3*Math.PI)/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_Minus600_500(){
            checkPointPosition = new Position(-600,500,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(Math.atan(600.0/500.0)+Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_Minus1000_0(){
            checkPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(Math.PI, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_Minus600_Minus500(){
            checkPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(-Math.atan(600.0/500.0)-Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_Minus1000_Minus1000(){
            checkPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(-(3*Math.PI)/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_0_Minus1000(){
            checkPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(-Math.PI/2,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_1000_Minus1000(){
            checkPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(informationGame,boatPosition);
            assertEquals(-Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0CheckPoint_600_Minus500(){
            checkPointPosition = new Position(600,-500,0);
            geometry = new Geometry(informationGame,boatPosition);
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
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.atan(500.0/600.0)-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_1000(){
            checkPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(0, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_0_1000(){
            checkPointPosition = new Position(0,1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_1000(){
            checkPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus600_500(){
            checkPointPosition = new Position(-600,500,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.atan(600.0/500.0)+Math.PI/2-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_0(){
            checkPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.PI-Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus600_Minus500(){
            checkPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(2*Math.PI+(-Math.atan(600.0/500.0)-3*Math.PI/4),geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_Minus1000_Minus1000(){
            checkPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-Math.PI,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_0_Minus1000(){
            checkPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-3*Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_Minus1000(){
            checkPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_600_Minus500(){
            checkPointPosition = new Position(600,-500,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-Math.atan(500.0/600.0)-Math.PI/4,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void ship0_0Rotat45CheckPoint_1000_0(){
            checkPointPosition = new Position(1000,0,0);
            geometry = new Geometry(informationGame, boatPosition);
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
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.atan(1.0/1001.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_600_500(){
            checkPointPosition = new Position(600,500,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.atan(501.0/601.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_1000_1000(){
            checkPointPosition = new Position(1000,1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.PI/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_0_1000(){
            checkPointPosition = new Position(0,1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.atan(1001.0/1.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_1000(){
            checkPointPosition = new Position(-1000,1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.atan(999.0/1001.0)+Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus600_500(){
            checkPointPosition = new Position(-600,500,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.atan(599.0/501.0)+Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_0(){
            checkPointPosition = new Position(-1000,0,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(Math.atan(999.0/1.0)+Math.PI/2,geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus600_Minus500(){
            checkPointPosition = new Position(-600,-500,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-Math.atan(599.0/499.0)-Math.PI/2, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_Minus1000_Minus1000(){
            checkPointPosition = new Position(-1000,-1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-(3*Math.PI)/4, geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_0_Minus1000(){
            checkPointPosition = new Position(0,-1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-Math.atan(999.0/1.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_1000_Minus1000(){
            checkPointPosition = new Position(1000,-1000,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-Math.atan(999.0/1001.0), geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

        @Test
        void shipMinus1_Minus1CheckPoint_600_Minus500(){
            checkPointPosition = new Position(600,-500,0);
            geometry = new Geometry(informationGame, boatPosition);
            assertEquals(-Math.atan(499.0/601.0),geometry.calculateAngleToCheckPoint(checkPointPosition));
        }

    }

    /**
     * <h1><u>isCheckpointReached</u></h1>
     **/
/*
    @Nested
    class IsCheckpointReached {

        InformationGame informationGame;
        Geometry geometry;
        Ship ship;
        Checkpoint checkpoint;
        Goal regattaGoal;


        @BeforeEach
        void setUp() {
            checkpoint = new Checkpoint();
            regattaGoal = new RegattaGoal(new Checkpoint[]{checkpoint});

            ship = new Ship();

            informationGame = new InformationGame(regattaGoal,ship);
            geometry = new Geometry(informationGame);
        }

        @Test
        void checkpointisReached() {
            Position positionCheckpoint = new Position(0, 0, 0);
            Position positionShip = new Position(49, 0, 0);
            Shape shapeCheckpoint = new Circle(50);

            ship.setPosition(positionShip);
            checkpoint.setShape(shapeCheckpoint);
            checkpoint.setPosition(positionCheckpoint);

            assertTrue(geometry.isCheckpointReached());
        }*/

        /*
    public Geometry(InformationGame informationGame) {
        this.informationGame = informationGame;
        this.actualCheckPointPosition = ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition();
        this.currentBoatPosition=informationGame.getShip().getPosition();
    }
         */

        /*    public boolean isCheckpointReached() {
        return actualCheckPointPosition.getNorme(informationGame.getShip().getPosition()) <
                ((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius();
    }*/
/*
        @Test
        void checkpointisntReachedFar() {
            Position positionCheckpoint = new Position(100, 0, 0);
            Position positionShip = new Position(149, 0, 0);
            Shape shapeCheckpoint = new Circle(50);

            ship.setPosition(positionShip);
            checkpoint.setShape(shapeCheckpoint);
            checkpoint.setPosition(positionCheckpoint);

            assertTrue(geometry.isCheckpointReached());
        }

        @Test
        void checkpointisntReached() {
            Position positionCheckpoint = new Position(0, 0, 0);
            Position positionShip = new Position(50, 0, 0);
            Shape shapeCheckpoint = new Circle(50);

            ship.setPosition(positionShip);
            checkpoint.setShape(shapeCheckpoint);
            checkpoint.setPosition(positionCheckpoint);

            assertFalse(geometry.isCheckpointReached());
        }
    }*/
}
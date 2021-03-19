package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.Geometry;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
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

class ShipTest {

    Ship ship;

    @BeforeEach
    void setUp() {
    }

    /**
     * <h1><u>isCheckpointReached</u></h1>
     **/

    @Test
    void shipNotInCheckpointBefore1(){
        ship = new Ship(new Position(7921.4982795349215,1166.9421361241718,0),null,null,null,null);
        Checkpoint checkpoint = new Checkpoint(new Position(8019.417976524843,1210.6559684684694,0), new Circle(100));
        assertFalse(ship.isCheckpointReached(checkpoint));
    }

    @Test
    void shipNotInCheckpointAfter1(){
        ship = new Ship(new Position(8052.533587531556,1315.439151056136,0),null,null,null,null);
        Checkpoint checkpoint = new Checkpoint(new Position(8019.417976524843,1210.6559684684694,0), new Circle(100));
        assertFalse(ship.isCheckpointReached(checkpoint));
    }

    @Nested
    class IsCheckpointReached {

        InformationGame informationGame;
        Geometry geometry;
        Ship ship;
        Checkpoint checkpoint;
        Goal regattaGoal;

        @BeforeEach
        void setUp() {
        }

        @Test
        void checkpointisReached() {
            Position positionCheckpoint = new Position(0, 0, 0);
            Position positionShip = new Position(49, 0, 0);
            Shape shapeCheckpoint = new Circle(50);

            checkpoint = new Checkpoint(positionCheckpoint,shapeCheckpoint);
            ship = new Ship(positionShip);
            regattaGoal = new RegattaGoal(new Checkpoint[]{checkpoint});
            informationGame = new InformationGame(regattaGoal,ship);

            assertTrue(ship.isCheckpointReached(checkpoint));
        }

        @Test
        void checkpointisntReachedFar() {
            Position positionCheckpoint = new Position(100, 0, 0);
            Position positionShip = new Position(149, 0, 0);
            Shape shapeCheckpoint = new Circle(50);

            checkpoint = new Checkpoint(positionCheckpoint,shapeCheckpoint);
            ship = new Ship(positionShip);
            regattaGoal = new RegattaGoal(new Checkpoint[]{checkpoint});
            informationGame = new InformationGame(regattaGoal,ship);

            assertTrue(ship.isCheckpointReached(checkpoint));
        }

        @Test
        void checkpointisntReached() {
            Position positionCheckpoint = new Position(0, 0, 0);
            Position positionShip = new Position(50, 0, 0);
            Shape shapeCheckpoint = new Circle(50);

            checkpoint = new Checkpoint(positionCheckpoint,shapeCheckpoint);
            ship = new Ship(positionShip);
            regattaGoal = new RegattaGoal(new Checkpoint[]{checkpoint});
            informationGame = new InformationGame(regattaGoal,ship);

            assertFalse(ship.isCheckpointReached(checkpoint));
        }
    }
}
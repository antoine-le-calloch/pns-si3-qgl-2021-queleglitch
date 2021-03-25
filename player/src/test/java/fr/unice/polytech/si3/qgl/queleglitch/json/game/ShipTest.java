package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.Geometry;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Sail;
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
        ship = new Ship();
    }
    /**
     * <h1><u>isSailsOpen</u></h1>
     **/
    @Test
    void sailsOpen(){
        ship.setEntities(new Entities[]{new Sail(0,0,true)});
        assertTrue(ship.isSailsOpen());
    }

    @Test
    void sailsNotOpen(){
        ship.setEntities(new Entities[]{new Sail(0,0,false)});
        assertFalse(ship.isSailsOpen());
    }

    @Test
    void noSail(){
        ship.setEntities(new Entities[]{});
        assertFalse(ship.isSailsOpen());
    }


    /**
     * <h1><u>getNbSails</u></h1>
     **/
    @Test
    void OneSail(){
        ship.setEntities(new Entities[]{new Sail(0,0,true)});
        assertEquals(1,ship.getNbSails());
    }

    @Test
    void twoSails(){
        ship.setEntities(new Entities[]{new Sail(0,0,true),new Sail(0,0,true)});
        assertEquals(2,ship.getNbSails());
    }

    /**
     * <h1><u>getNbOars</u></h1>
     **/
    @Test
    void OneOar(){
        ship.setEntities(new Entities[]{new Oar(0,0)});
        assertEquals(1,ship.getNbOars());
    }

    @Test
    void twoOars(){
        ship.setEntities(new Entities[]{new Oar(0,0),new Oar(0,0)});
        assertEquals(2,ship.getNbOars());
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
        RegattaGoal regattaGoal;
        Checkpoint checkpoint;
        Shape shapeCheckpoint;
        Ship ship;

        @BeforeEach
        void setUp() {
            ship = new Ship();
            regattaGoal = new RegattaGoal();
            shapeCheckpoint = new Circle(50);
        }

        @Test
        void checkpointIsReached() {
            Position positionCheckpoint = new Position(0, 0, 0);
            Position positionShip = new Position(49, 0, 0);
            checkpoint = new Checkpoint(positionCheckpoint,shapeCheckpoint);

            ship.setPosition(positionShip);
            regattaGoal.setCheckpoints(new Checkpoint[]{checkpoint});
            regattaGoal.calculateOptiCheckpoint();
            informationGame = new InformationGame(regattaGoal,ship,null);

            assertTrue(ship.isCheckpointReached(checkpoint));
        }

        @Test
        void checkpointIsNotReachedFar() {
            Position positionCheckpoint = new Position(100, 0, 0);
            Position positionShip = new Position(149, 0, 0);
            checkpoint = new Checkpoint(positionCheckpoint,shapeCheckpoint);

            ship.setPosition(positionShip);
            regattaGoal.setCheckpoints(new Checkpoint[]{checkpoint});
            regattaGoal.calculateOptiCheckpoint();
            informationGame = new InformationGame(regattaGoal,ship,null);

            assertTrue(ship.isCheckpointReached(checkpoint));
        }

        @Test
        void checkpointIsNotReached() {
            Position positionCheckpoint = new Position(0, 0, 0);
            Position positionShip = new Position(50, 0, 0);
            checkpoint = new Checkpoint(positionCheckpoint,shapeCheckpoint);

            ship.setPosition(positionShip);
            regattaGoal.setCheckpoints(new Checkpoint[]{checkpoint});
            regattaGoal.calculateOptiCheckpoint();
            informationGame = new InformationGame(regattaGoal,ship,null);

            assertFalse(ship.isCheckpointReached(checkpoint));
        }
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProcessingTest {
    InformationGame informationGame;
    Processing processing;
    Ship ship;
    Checkpoint checkpoint;
    Goal regattaGoal;

    @BeforeEach
    void setUp() {
        checkpoint = new Checkpoint();
        regattaGoal = new RegattaGoal(new Checkpoint[]{checkpoint});

        ship = new Ship();

        informationGame = new InformationGame(regattaGoal,ship);
        processing = new Processing(informationGame);
    }


    /**
     * <h1><u>isCheckpointReached</u></h1>
     */

    @Test
    void checkpointisReached(){
        Position positionCheckpoint = new Position(0,0,0);
        Position positionShip = new Position(49,0,0);
        Shape shapeCheckpoint = new Circle(50);

        ship.setPosition(positionShip);
        checkpoint.setShape(shapeCheckpoint);
        checkpoint.setPosition(positionCheckpoint);

        assertTrue(processing.isCheckpointReached());
    }

    @Test
    void checkpointisntReachedFar(){
        Position positionCheckpoint = new Position(100,0,0);
        Position positionShip = new Position(149,0,0);
        Shape shapeCheckpoint = new Circle(50);

        ship.setPosition(positionShip);
        checkpoint.setShape(shapeCheckpoint);
        checkpoint.setPosition(positionCheckpoint);

        assertTrue(processing.isCheckpointReached());
    }

    @Test
    void checkpointisntReached(){
        Position positionCheckpoint = new Position(0,0,0);
        Position positionShip = new Position(50,0,0);
        Shape shapeCheckpoint = new Circle(50);

        ship.setPosition(positionShip);
        checkpoint.setShape(shapeCheckpoint);
        checkpoint.setPosition(positionCheckpoint);

        assertFalse(processing.isCheckpointReached());
    }

    /**
     * <h1><u>setDataNewRound</u></h1>
     */
/*
    @Test
    void isInformationGameGetNewRoundInformation(){
        Position firstPosition = new Position(0,0,0);

        informationGame.getShip().setPosition(firstPosition);
        assertEquals(informationGame.getShip().getPosition().getX(),0);

        Position positionShip = new Position(50,0,0);
        Ship otherShip = new Ship(positionShip);
        NextRound nextRound = new NextRound(otherShip);

        processing.setDataNewRound(nextRound);
        assertEquals(informationGame.getShip().getPosition().getX(),50);

    }
    */
}

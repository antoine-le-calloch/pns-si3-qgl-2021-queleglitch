package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartmoving;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Moving;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Turn;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovingToRudderTest {

    Rudder rudder;
    Sailor[] sailors;
    MovingToRudder movingToRudder;
    List<Sailor> sailorsAvailable;
    List<Entities> entitiesTooFar;
    List<Action> actionsList;

    @BeforeEach
    void setUp() {
        //movingToRudder = new MovingToRudder(rudder, new Tooling(new Box(2,2), sailors));
        sailorsAvailable = new ArrayList<>();
        entitiesTooFar = new ArrayList<>();
        actionsList = new ArrayList<>();
        rudder = new Rudder(7, 1);
    }


    ////////////////
    // test movingToRudder(), Rudder in (7,1)
    ////////////////

    @Test
    void useRudder_MovePossible_v1() {
        sailorsAvailable.add(new Sailor(2, 1, 0));
        movingToRudder = new MovingToRudder(rudder, new Tooling(new Box(2,2), sailorsAvailable.toArray(Sailor[]::new)));

        movingToRudder.movingAndUseRudder(Math.PI, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(5, 0, 0), actionsList.get(0));
        assertEquals(new Turn(Math.PI, 0), actionsList.get(1));
        assertEquals(0, entitiesTooFar.size());
    }

    @Test
    void useRudder_MoveNotPossible_v1() {
        sailorsAvailable.add(new Sailor(1, 1, 0));
        movingToRudder = new MovingToRudder(rudder, new Tooling(new Box(2,2), sailorsAvailable.toArray(Sailor[]::new)));

        movingToRudder.movingAndUseRudder(1, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(0, actionsList.size());
        assertEquals(1, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Rudder);
    }

    @Test
    void useRudder_MovePossible_v2() {
        sailorsAvailable.add(new Sailor(11, 2, 0));
        movingToRudder = new MovingToRudder(rudder, new Tooling(new Box(2,2), sailorsAvailable.toArray(Sailor[]::new)));

        movingToRudder.movingAndUseRudder(Math.PI, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(-4, -1, 0), actionsList.get(0));
        assertEquals(new Turn(Math.PI, 0), actionsList.get(1));
        assertEquals(0, entitiesTooFar.size());
    }

    @Test
    void useRudder_MoveNotPossible_v2() {
        sailorsAvailable.add(new Sailor(12, 2, 0));
        movingToRudder = new MovingToRudder(rudder, new Tooling(new Box(2,2), sailorsAvailable.toArray(Sailor[]::new)));

        movingToRudder.movingAndUseRudder(1, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(0, actionsList.size());
        assertEquals(1, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Rudder);
    }

    @Test
    void useRudder_MovePossible_v3() {
        sailorsAvailable.add(new Sailor(7, 6, 0));
        movingToRudder = new MovingToRudder(rudder, new Tooling(new Box(2,2), sailorsAvailable.toArray(Sailor[]::new)));

        movingToRudder.movingAndUseRudder(Math.PI, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(0, -5, 0), actionsList.get(0));
        assertEquals(new Turn(Math.PI, 0), actionsList.get(1));
        assertEquals(0, entitiesTooFar.size());
    }

    @Test
    void useRudder_MoveNotPossible_v3() {
        sailorsAvailable.add(new Sailor(7, 7, 0));
        movingToRudder = new MovingToRudder(rudder, new Tooling(new Box(2,2), sailorsAvailable.toArray(Sailor[]::new)));

        movingToRudder.movingAndUseRudder(1, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(0, actionsList.size());
        assertEquals(1, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Rudder);
    }
}
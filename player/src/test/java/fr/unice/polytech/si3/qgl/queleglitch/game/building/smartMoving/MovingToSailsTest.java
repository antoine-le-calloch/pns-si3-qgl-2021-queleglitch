package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartMoving;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.LiftSail;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.LowerSail;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Moving;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovingToSailsTest {

    List<Sailor> sailorsAvailable;
    List<Entities> entitiesTooFar;
    MovingToSails movingToSails;
    List<Action> actionsList;
    Sailor[] sailors;
    Tooling tooling;
    List<Sail> sail;

    @BeforeEach
    void setUp() {
        sail = Arrays.asList(new Sail[]{new Sail(3, 1, false)}.clone());
        sailorsAvailable = new ArrayList<>();
        entitiesTooFar = new ArrayList<>();
        actionsList = new ArrayList<>();
    }

    ////////////////
    // test movingToSails(), Sail in (3,1)
    ////////////////

    @Test
    void useSails_MovePossible_v1() {
        sailorsAvailable.add(new Sailor(-2, 1, 0));
        tooling = new Tooling(null,sailorsAvailable.toArray(Sailor[]::new));
        movingToSails = new MovingToSails(sail, tooling);

        movingToSails.movingAndUseSails(SailAction.LIFT, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(5, 0, 0), actionsList.get(0));
        assertEquals(new LiftSail(0), actionsList.get(1));
        assertEquals(0, entitiesTooFar.size());
    }

    @Test
    void useSails_MoveNotPossible_v1() {
        sailorsAvailable.add(new Sailor(-3, 1, 0));
        tooling = new Tooling(null,sailorsAvailable.toArray(Sailor[]::new));
        movingToSails = new MovingToSails(sail, tooling);

        movingToSails.movingAndUseSails(SailAction.LIFT, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(0, actionsList.size());
        assertEquals(1, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Sail);
    }

    @Test
    void useSails_MovePossible_v2() {
        sailorsAvailable.add(new Sailor(7, 2, 0));
        tooling = new Tooling(null,sailorsAvailable.toArray(Sailor[]::new));
        movingToSails = new MovingToSails(sail, tooling);

        movingToSails.movingAndUseSails(SailAction.LOWER, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(-4, -1, 0), actionsList.get(0));
        assertEquals(new LowerSail(0), actionsList.get(1));
        assertEquals(0, entitiesTooFar.size());
    }

    @Test
    void useSails_MoveNotPossible_v2() {
        sailorsAvailable.add(new Sailor(8, 2, 0));
        tooling = new Tooling(null,sailorsAvailable.toArray(Sailor[]::new));
        movingToSails = new MovingToSails(sail, tooling);

        movingToSails.movingAndUseSails(SailAction.LOWER, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(0, actionsList.size());
        assertEquals(1, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Sail);
    }

    @Test
    void useSails_MovePossible_v3() {
        sailorsAvailable.add(new Sailor(3, 6, 0));
        tooling = new Tooling(null,sailorsAvailable.toArray(Sailor[]::new));
        movingToSails = new MovingToSails(sail, tooling);

        movingToSails.movingAndUseSails(SailAction.LIFT, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(0, -5, 0), actionsList.get(0));
        assertEquals(new LiftSail(0), actionsList.get(1));
        assertEquals(0, entitiesTooFar.size());
    }

    @Test
    void useSails_MoveNotPossible_v3() {
        sailors = new Sailor[]{new Sailor(3, 7, 0)};
        sailorsAvailable.add(new Sailor(3, 7, 0));
        tooling = new Tooling(null,sailorsAvailable.toArray(Sailor[]::new));
        movingToSails = new MovingToSails(sail, tooling);

        movingToSails.movingAndUseSails(SailAction.LIFT, sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(0, actionsList.size());
        assertEquals(1, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Sail);
    }
}
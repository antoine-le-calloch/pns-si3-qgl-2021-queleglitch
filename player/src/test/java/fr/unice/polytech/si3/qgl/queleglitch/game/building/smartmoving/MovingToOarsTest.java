package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartmoving;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Moving;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Row;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovingToOarsTest {

    List<Sailor> sailorsAvailable;
    List<Entities> entitiesTooFar;
    MovingToOars movingToOars;

    List<Action> actionsList;
    List<Oar> rightOars;
    List<Oar> leftOars;
    Tooling tooling;


    @BeforeEach
    void setUp() {
        leftOars = Arrays.asList(new Oar[]{new Oar(1, 0), new Oar(2, 0), new Oar(3, 0), new Oar(4, 0)}.clone());
        rightOars = Arrays.asList(new Oar[]{new Oar(1, 2), new Oar(2, 2), new Oar(3, 2), new Oar(4, 2)}.clone());
        sailorsAvailable = new ArrayList<>();
        entitiesTooFar = new ArrayList<>();
        actionsList = new ArrayList<>();
    }

    ////////////////
    // test movingAndUseOars(), Oars in (1,0) - (2,0) - (3,0) - (4,0)
    //                                    (1,2) - (2,2) - (3,2) - (4,2)
    ////////////////

   




    @Test
    void useOars_MovesPossible_v1() {
        sailorsAvailable.add(new Sailor(-4, 0, 0));
        sailorsAvailable.add(new Sailor(9, 2, 1));
        tooling = new Tooling(null, sailorsAvailable.toArray(Sailor[]::new));
        movingToOars = new MovingToOars(leftOars, rightOars, tooling);

        movingToOars.movingAndUseOars(new NbOarsUsed(1,1), sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(5, 0, 0), actionsList.get(0));
        assertEquals(new Row(0), actionsList.get(1));
        assertEquals(new Moving(-5, 0, 1), actionsList.get(2));
        assertEquals(new Row(1), actionsList.get(3));
        assertEquals(0, entitiesTooFar.size());
    }

    @Test
    void useOars_MovesNotPossible_v1() {
        sailorsAvailable.add(new Sailor(-5, 0, 0));
        sailorsAvailable.add(new Sailor(10, 2, 1));
        tooling = new Tooling(null, sailorsAvailable.toArray(Sailor[]::new));
        movingToOars = new MovingToOars(leftOars, rightOars, tooling);

        movingToOars.movingAndUseOars(new NbOarsUsed(1, 1), sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(2, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Oar);
        assertTrue(entitiesTooFar.get(1) instanceof Oar);
    }

    @Test
    void useOars_MoveNotPossibleOnLeft_v1() {
        sailorsAvailable.add(new Sailor(-5, 0, 0));
        sailorsAvailable.add(new Sailor(9, 2, 1));
        tooling = new Tooling(null, sailorsAvailable.toArray(Sailor[]::new));
        movingToOars = new MovingToOars(leftOars, rightOars, tooling);

        movingToOars.movingAndUseOars(new NbOarsUsed(1, 1), sailorsAvailable, entitiesTooFar, actionsList);


        assertEquals(new Moving(-5, 0, 1), actionsList.get(0));
        assertEquals(new Row(1), actionsList.get(1));
        assertEquals(1, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Oar);
    }

    @Test
    void useOars_MoveNotPossibleOnRight_v1() {
        sailorsAvailable.add(new Sailor(-4, 0, 0));
        sailorsAvailable.add(new Sailor(10, 2, 1));
        tooling = new Tooling(null, sailorsAvailable.toArray(Sailor[]::new));
        movingToOars = new MovingToOars(leftOars, rightOars, tooling);

        movingToOars.movingAndUseOars(new NbOarsUsed(1, 1), sailorsAvailable, entitiesTooFar, actionsList);


        assertEquals(new Moving(5, 0, 0), actionsList.get(0));
        assertEquals(new Row(0), actionsList.get(1));
        assertEquals(1, entitiesTooFar.size());
        assertTrue(entitiesTooFar.get(0) instanceof Oar);
    }

    @Test
    void useOars_MovesPossible3Sailors_v2() {
        sailorsAvailable.add(new Sailor(-4, 0, 0));
        sailorsAvailable.add(new Sailor(-3, 0, 2));
        sailorsAvailable.add(new Sailor(-2, 0, 4));
        tooling = new Tooling(null, sailorsAvailable.toArray(Sailor[]::new));
        movingToOars = new MovingToOars(leftOars, rightOars, tooling);

        movingToOars.movingAndUseOars(new NbOarsUsed(3, 0), sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(5, 0, 4), actionsList.get(0));
        assertEquals(new Row(4), actionsList.get(1));
        assertEquals(new Moving(5, 0, 2), actionsList.get(2));
        assertEquals(new Row(2), actionsList.get(3));
        assertEquals(new Moving(5, 0, 0), actionsList.get(4));
        assertEquals(new Row(0), actionsList.get(5));
        assertEquals(0, entitiesTooFar.size());
    }

    /*@Test
    void useOars_MovesPossible6Sailors_v2(){
        sailors = new Sailor[]{new Sailor(-4,0,0), new Sailor(9,2,1),
                new Sailor(-3,0,2), new Sailor(8,2,3),
                new Sailor(-2,0,4), new Sailor(7,2,5)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseOars(3,0);

        assertEquals(new Moving(5,0,4), createActionsStrategie.actionsList.get(0));
        assertEquals(new Oar(4), createActionsStrategie.actionsList.get(1));
        //assertEquals(new Moving(-2,0,1), createActionsStrategie.actionsList.get(2));
        //assertEquals(new Oar(1), createActionsStrategie.actionsList.get(3));
        assertEquals(new Moving(5,0,2), createActionsStrategie.actionsList.get(2));
        assertEquals(new Oar(2), createActionsStrategie.actionsList.get(3));
        //assertEquals(new Moving(-5,0,3), createActionsStrategie.actionsList.get(6));
        //assertEquals(new Oar(3), createActionsStrategie.actionsList.get(7));
        assertEquals(new Moving(5,0,0), createActionsStrategie.actionsList.get(4));
        assertEquals(new Oar(0), createActionsStrategie.actionsList.get(5));
        //assertEquals(new Moving(-5,0,5), createActionsStrategie.actionsList.get(10));
        //assertEquals(new Oar(5), createActionsStrategie.actionsList.get(11));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }*/
}
package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Gouvernail;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Deck;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CreateActionsTest {

    Sailor[] sailors = {new Sailor(0, 0, 0),new Sailor(0, 0,1),new Sailor(0, 0,2),new Sailor(0, 0,3),new Sailor(0, 0,4)};
    Ship ship;
    CreateActions createActions;

    @BeforeEach
    void setUp() {
        ship = new Ship(null, new Entities[]{new Rame(0,1),new Rame(1,1),new Rame(2,1),
                                                    new Rame(0,0), new Rame(1,0), new Rame(2,0),
                                                    new Voile(0,0,false), new Gouvernail(3,0)},
                                              "",new Deck(2,5),new Rectangle());
    }


    @Test
    void StraightOnWithoutSailAndOpenedBefore(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,0,-1,4));
        List<Action> actions=createActions.buildingActions();
        assertEquals(new Moving(0,0,0),actions.get(0));
        assertEquals(new LOWER_SAIL(0),actions.get(1));
        assertEquals(new Moving(2,0,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(1,0,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(2,1,3),actions.get(6));
        assertEquals(new Oar(3),actions.get(7));
        assertEquals(new Moving(1,1,4),actions.get(8));
        assertEquals(new Oar(4),actions.get(9));
    }

    @Test
    void StraightOnWithoutSailAndClosedBefore(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,0,0,4));
        List<Action> actions=createActions.buildingActions();
        assertEquals(new Moving(2,0,0),actions.get(0));
        assertEquals(new Oar(0),actions.get(1));
        assertEquals(new Moving(1,0,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(2,1,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(1,1,3),actions.get(6));
        assertEquals(new Oar(3),actions.get(7));
        assertEquals(new Moving(2,0,4),actions.get(8));
    }

    @Test
    void StraightOnWithSail(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,0,1,5));
        List<Action> actions=createActions.buildingActions();
        assertEquals(new Moving(0,0,0),actions.get(0));
        assertEquals(new LIFT_SAIL(0),actions.get(1));
        assertEquals(new Moving(2,0,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(1,0,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(2,1,3),actions.get(6));
        assertEquals(new Oar(3),actions.get(7));
        assertEquals(new Moving(1,1,4),actions.get(8));
        assertEquals(new Oar(4),actions.get(9));
    }
    @Test
    void TurnToLeftAt90(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,3,0,4));
        List<Action> actions=createActions.buildingActions();
        assertEquals(new Moving(2,1,0),actions.get(0));
        assertEquals(new Oar(0),actions.get(1));
        assertEquals(new Moving(1,1,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(0,1,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(2,0,3),actions.get(6));
        assertEquals(new Moving(2,0,4),actions.get(7));
    }
    @Test
    void TurnToRightAt90(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,-3,0,4));
        List<Action> actions=createActions.buildingActions();
        assertEquals(new Moving(2,0,0),actions.get(0));
        assertEquals(new Oar(0),actions.get(1));
        assertEquals(new Moving(1,0,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(0,0,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(2,0,3),actions.get(6));
        assertEquals(new Moving(2,0,4),actions.get(7));
    }

  @Test
    void TurnToRightAtRight60WithMaxSpeed(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,-2,0,4));
        List<Action> actions = createActions.buildingActions();
        assertEquals(new Moving(2,0,0),actions.get(0));
        assertEquals(new Oar(0),actions.get(1));
        assertEquals(new Moving(1,0,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(0,0,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(2,1,3),actions.get(6));
        assertEquals(new Oar(3),actions.get(7));
        assertEquals(new Moving(2,0,4),actions.get(8));
    }

  @Test
    void TurnToLeftAtLeft60WithMaxSpeed(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,2,0,4));
        List<Action> actions=createActions.buildingActions();
        assertEquals(new Moving(2,0,0),actions.get(0));
        assertEquals(new Oar(0),actions.get(1));
        assertEquals(new Moving(2,1,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(1,1,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(0,1,3),actions.get(6));
        assertEquals(new Oar(3),actions.get(7));
        assertEquals(new Moving(2,0,4),actions.get(8));
    }

    @Test
    void TurnToLeftAtLeft30WithMaxSpeed(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,1,0,4));
        List<Action> actions=createActions.buildingActions();
        assertEquals(new Moving(2,0,0),actions.get(0));
        assertEquals(new Oar(0),actions.get(1));
        assertEquals(new Moving(1,0,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(2,1,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(1,1,3),actions.get(6));
        assertEquals(new Oar(3),actions.get(7));
        assertEquals(new Moving(0,1,4),actions.get(8));
        assertEquals(new Oar(4),actions.get(9));
    }

    @Test
    void TurnToRightAtRight30WithMaxSpeed(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,-1,0,4));
        List<Action> actions=createActions.buildingActions();
        assertEquals(new Moving(2,0,0),actions.get(0));
        assertEquals(new Oar(0),actions.get(1));
        assertEquals(new Moving(1,0,1),actions.get(2));
        assertEquals(new Oar(1),actions.get(3));
        assertEquals(new Moving(0,0,2),actions.get(4));
        assertEquals(new Oar(2),actions.get(5));
        assertEquals(new Moving(2,1,3),actions.get(6));
        assertEquals(new Oar(3),actions.get(7));
        assertEquals(new Moving(1,1,4),actions.get(8));
        assertEquals(new Oar(4),actions.get(9));
    }

/*
  @Test
    void TurnToRightAtRight60WithLowSpeed(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,-2,0,2));
        List<Action> actions=createActions.buildingActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertFalse(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,0)));
        assertTrue(actions.contains(new Moving(1,1,0)));
    }

  @Test
    void TurnToLeftAtLeft60WithLowSpeed(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,2,0,2));
        List<Action> actions=createActions.buildingActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertFalse(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
        assertTrue(actions.contains(new Moving(1,1,1)));
    }

    @Test
    void TurnToLeftAtLeft30WithLowSpeed(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,1,0,1));
        List<Action> actions=createActions.buildingActions();
        assertTrue(actions.contains(new Oar(0)));
        assertFalse(actions.contains(new Oar(1)));
        assertFalse(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
    }

    @Test
    void TurnToRightAtRight30WithLowSpeed(){
        createActions = new CreateActions(ship, sailors, new ToolsToUse(0,-1,0,1));
        List<Action> actions=createActions.buildingActions();
        assertTrue(actions.contains(new Oar(0)));
        assertFalse(actions.contains(new Oar(1)));
        assertFalse(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,0)));
    }*/
}
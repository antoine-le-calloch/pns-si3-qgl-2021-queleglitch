package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Moving;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.refactoring.ToolsToUse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class createActionsTest {

    Sailor[] sailors = {new Sailor(0, 0,0),new Sailor(0, 0,1),new Sailor(0, 0,2),new Sailor(0, 0,3)};
    Ship mockShip;
    CreateActions createActions;

    @BeforeEach
    void setUp() {
        mockShip = mock(Ship.class);
        List<Rame> rameAtRight = new ArrayList<>();
        rameAtRight.add(new Rame(0,1));
        rameAtRight.add(new Rame(1,1));
        rameAtRight.add(new Rame(2,1));
        List<Rame> rameAtLeft = new ArrayList<>();
        rameAtLeft.add(new Rame(0,0));
        rameAtLeft.add(new Rame(1,0));
        rameAtLeft.add(new Rame(2,0));
        Mockito.when(mockShip.getRamesAtLeft()).thenReturn(rameAtLeft);//donne le nombre de rame à gauche
        Mockito.when(mockShip.getRamesAtRight()).thenReturn(rameAtRight);//donne le nombre de rame à gauche
    }


    @Test
    void StraightOn(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,2,2));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertTrue(actions.contains(new Oar(2)));
        assertTrue(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
        assertTrue(actions.contains(new Moving(1,1,1)));
        assertTrue(actions.contains(new Moving(2,0,0)));
        assertTrue(actions.contains(new Moving(3,1,0)));
    }
    @Test
    void TurnToLeftAt90(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,0,3));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertTrue(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
        assertTrue(actions.contains(new Moving(1,1,1)));
        assertTrue(actions.contains(new Moving(2,2,1)));
    }
    @Test
    void TurnToRightAt90(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,3,0));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertTrue(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,0)));
        assertTrue(actions.contains(new Moving(1,1,0)));
        assertTrue(actions.contains(new Moving(2,2,0)));
    }

  @Test
    void TurnToRightAtRight60WithMaxSpeed(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,3,1));
        List<Action> actions = createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertTrue(actions.contains(new Oar(2)));
        assertTrue(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
        assertTrue(actions.contains(new Moving(1,0,0)));
        assertTrue(actions.contains(new Moving(2,1,0)));
        assertTrue(actions.contains(new Moving(3,2,0)));
    }

  @Test
    void TurnToRightAtLeft60WithMaxSpeed(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,1,3));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertTrue(actions.contains(new Oar(2)));
        assertTrue(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
        assertTrue(actions.contains(new Moving(1,1,1)));
        assertTrue(actions.contains(new Moving(2,2,1)));
        assertTrue(actions.contains(new Moving(3,0,0)));
    }

    @Test
    void TurnToRightAtLeft30WithMaxSpeed(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,1,2));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Moving(0,0,1)));
        assertTrue(actions.contains(new Moving(1,1,1)));
        assertTrue(actions.contains(new Moving(2,0,0)));
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertTrue(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
    }

    @Test
    void TurnToRightAtRight30WithMaxSpeed(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,2,1));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertTrue(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
        assertTrue(actions.contains(new Moving(1,0,0)));
        assertTrue(actions.contains(new Moving(2,1,0)));
    }


  @Test
    void TurnToRightAtRight60WithLowSpeed(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,2,0));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertFalse(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,0)));
        assertTrue(actions.contains(new Moving(1,1,0)));
    }

  @Test
    void TurnToRightAtLeft60WithLowSpeed(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,0,2));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertTrue(actions.contains(new Oar(1)));
        assertFalse(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
        assertTrue(actions.contains(new Moving(1,1,1)));
    }

    @Test
    void TurnToRightAtLeft30WithLowSpeed(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,0,1));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertFalse(actions.contains(new Oar(1)));
        assertFalse(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,1)));
    }

    @Test
    void TurnToRightAtRight30WithLowSpeed(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,1,0));
        List<Action> actions=createActions.getActions();
        assertTrue(actions.contains(new Oar(0)));
        assertFalse(actions.contains(new Oar(1)));
        assertFalse(actions.contains(new Oar(2)));
        assertFalse(actions.contains(new Oar(3)));
        assertTrue(actions.contains(new Moving(0,0,0)));
    }
}
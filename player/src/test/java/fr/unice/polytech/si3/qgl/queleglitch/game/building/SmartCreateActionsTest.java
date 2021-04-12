package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class SmartCreateActionsTest {

    Ship ship;
    Sailor[] sailors;
    List<Sailor> sailorsList;
    SmartCreateActions smartCreateActions;

    @BeforeEach
    void setUp() {
        ship = new Ship(null, new Entities[]{new Rudder(7, 1), new Sail(3, 1, false),
                new Oar(1, 0), new Oar(2, 0), new Oar(3, 0), new Oar(4, 0),
                new Oar(1, 2), new Oar(2, 2), new Oar(3, 2), new Oar(4, 2)},
                "", new Deck(4, 8), new Circle(5));

        sailors = new Sailor[]{new Sailor(0, 0, 0), new Sailor(1, 1, 1), new Sailor(-1, -1, 2)};
        sailorsList = Arrays.asList(sailors.clone());
        smartCreateActions = new SmartCreateActions(ship, sailors);
    }

    ////////////////
    // test createActions()
    ////////////////

    @Test
    void createActions_4Oar_1Rudder_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(Math.PI/4, SailAction.LIFT,new NbOarsUsed(2,2), false));

        assertEquals(12, actionList.size());
    }

    @Test
    void createActions_2Oar_1Rudder_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(Math.PI/4, SailAction.LIFT,new NbOarsUsed(1,1), false));

        assertEquals(10, actionList.size());
    }

    @Test
    void createActions_0Oar_1Rudder_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(Math.PI/4,SailAction.LIFT,new NbOarsUsed(0,0), false));

        assertEquals(8, actionList.size());
    }

    @Test
    void createActions_0Oar_0Rudder_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(0,SailAction.LIFT,new NbOarsUsed(0,0), false));

        assertEquals(7, actionList.size()); //need to change
    }

    @Test
    void createActions_0Oar_0Rudder_0Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(0, 0), false));

        assertEquals(6, actionList.size()); //need to change
    }
}

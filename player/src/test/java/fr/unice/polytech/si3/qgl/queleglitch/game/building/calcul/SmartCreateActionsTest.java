package fr.unice.polytech.si3.qgl.queleglitch.game.building.calcul;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.SmartCreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
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
                "", new Deck(4, 8), new Rectangle());

        sailors = new Sailor[]{new Sailor(0, 0, 0), new Sailor(1, 1, 1), new Sailor(-1, -1, 2)};
        sailorsList = Arrays.asList(sailors.clone());
        smartCreateActions = new SmartCreateActions(ship, sailors);
    }


    ////////////////
    // test nbBoxBetweenSailorAndPlace()
    ////////////////

    @Test
    void normBetween_0_0And_100_0() {
        assertEquals(100, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(100, 0)));
    }

    @Test
    void normBetween_0_0And_0_100() {
        assertEquals(100, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(0, 100)));
    }

    @Test
    void normBetween_100_0And_0_0() {
        assertEquals(100, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(100, 0, 0), new Box(0, 0)));
    }

    @Test
    void normBetween_0_100And_0_0() {
        assertEquals(100, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 100, 0), new Box(0, 0)));
    }

    @Test
    void normBetween_0_0And_Minus100_0() {
        assertEquals(100, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(-100, 0)));
    }

    @Test
    void normBetween_0_0And_0_Minus100() {
        assertEquals(100, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(0, -100)));
    }

    @Test
    void normBetween_Minus100_0And_0_0() {
        assertEquals(100, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(-100, 0, 0), new Box(0, 0)));
    }

    @Test
    void normBetween_0_Minus100And_0_0() {
        assertEquals(100, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, -100, 0), new Box(0, 0)));
    }

    @Test
    void normBetween_0_0And_1_1() {
        assertEquals(2, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(1, 1)));
    }

    @Test
    void normBetween_0_0And_Minus1_1() {
        assertEquals(2, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(-1, 1)));
    }

    @Test
    void normBetween_0_0And_Minus1_Minus1() {
        assertEquals(2, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(-1, -1)));
    }

    @Test
    void normBetween_0_0And_1_Minus1() {
        assertEquals(2, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(1, -1)));
    }

    /////////////////////////////////////////// 5 moves

    @Test
    void normBetween_0_0And_5_0() {
        assertEquals(5, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(5, 0)));
    }

    @Test
    void normBetween_0_0And_4_1() {
        assertEquals(5, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(4, 1)));
    }

    @Test
    void normBetween_0_0And_3_2() {
        assertEquals(5, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(3, 2)));
    }

    @Test
    void normBetween_0_0And_2_3() {
        assertEquals(5, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(2, 3)));
    }

    @Test
    void normBetween_0_0And_1_4() {
        assertEquals(5, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(1, 4)));
    }

    @Test
    void normBetween_0_0And_0_5() {
        assertEquals(5, smartCreateActions.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(0, 5)));
    }

    ////////////////
    // test nearestSailorBehind5()
    ////////////////

    @Test
    void nearestSailor_0_v0() {
        Box positionEntitiesToReach = new Box(0, 0);
        assertEquals(0, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_0_v1() {
        Box positionEntitiesToReach = new Box(1, 0);
        assertEquals(0, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_0_v2() {
        Box positionEntitiesToReach = new Box(0, 1);
        assertEquals(0, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_0_v3() {
        Box positionEntitiesToReach = new Box(-1, 0);
        assertEquals(0, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_0_v4() {
        Box positionEntitiesToReach = new Box(0, -1);
        assertEquals(0, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_1_v1() {
        Box positionEntitiesToReach = new Box(1, 1);
        assertEquals(1, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_1_v2() {
        Box positionEntitiesToReach = new Box(3, 3);
        assertEquals(1, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_1_v3() {
        Box positionEntitiesToReach = new Box(2, 1);
        assertEquals(1, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_1_v4() {
        Box positionEntitiesToReach = new Box(1, 2);
        assertEquals(1, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_2_v1() {
        Box positionEntitiesToReach = new Box(-1, -1);
        assertEquals(2, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_2_v2() {
        Box positionEntitiesToReach = new Box(-3, -3);
        assertEquals(2, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_2_v3() {
        Box positionEntitiesToReach = new Box(-2, -1);
        assertEquals(2, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_2_v4() {
        Box positionEntitiesToReach = new Box(-1, -2);
        assertEquals(2, smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_TooFar_OnZero() {
        Box positionEntitiesToReach = new Box(0, -6);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_OnZero() {
        Box positionEntitiesToReach = new Box(0, -5);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_TooFar_v1() {
        Box positionEntitiesToReach = new Box(7, 1);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_v1() {
        Box positionEntitiesToReach = new Box(6, 1);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_TooFar_v2() {
        Box positionEntitiesToReach = new Box(1, 7);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_v2() {
        Box positionEntitiesToReach = new Box(1, 6);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_TooFar_v3() {
        Box positionEntitiesToReach = new Box(4, 4);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_v3() {
        Box positionEntitiesToReach = new Box(3, 3);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_TooFar_v4() {
        Box positionEntitiesToReach = new Box(3, 5);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_v4() {
        Box positionEntitiesToReach = new Box(3, 4);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_TooFar_Minus_v1() {
        Box positionEntitiesToReach = new Box(-7, -1);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_Minus_v1() {
        Box positionEntitiesToReach = new Box(-6, -1);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_TooFar_Minus_v2() {
        Box positionEntitiesToReach = new Box(-1, -7);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_Minus_v2() {
        Box positionEntitiesToReach = new Box(-1, -6);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_TooFar_Minus_v3() {
        Box positionEntitiesToReach = new Box(-4, -4);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_Minus_v3() {
        Box positionEntitiesToReach = new Box(-3, -3);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_TooFar_Minus_v4() {
        Box positionEntitiesToReach = new Box(-3, -5);
        assertNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotTooFar_Minus_v4() {
        Box positionEntitiesToReach = new Box(-3, -4);
        assertNotNull(smartCreateActions.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    ////////////////
    // test buildMovingAction()
    ////////////////

    @Test
    void buildPossibleAction_v1() {
        Entities entitiesToReach = new Oar(4, 0);

        assertEquals(new Sailor(0, 0, 0), sailors[0]);

        assertEquals(new Moving(4, 0, 0), smartCreateActions.buildMovingAction(sailors[0], entitiesToReach));

        assertEquals(new Sailor(4, 0, 0), sailors[0]);
    }

    @Test
    void buildNotPossibleAction_v1() {
        Entities entitiesToReach = new Oar(6, 0);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(5, 0, 0), movingAction);
    }

    @Test
    void buildPossibleAction_v2() {
        Entities entitiesToReach = new Oar(0, 4);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(0, 4, 0), movingAction);
    }

    @Test
    void buildNotPossibleAction_v2() {
        Entities entitiesToReach = new Oar(0, 6);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(0, 5, 0), movingAction);
    }

    @Test
    void buildPossibleAction_v3() {
        Entities entitiesToReach = new Oar(3, 3);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[1], entitiesToReach);

        assertEquals(new Moving(2, 2, 1), movingAction);
    }

    @Test
    void buildNotPossibleAction_v3() {
        Entities entitiesToReach = new Oar(4, 4);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[1], entitiesToReach);

        assertEquals(new Moving(2, 3, 1), movingAction);
    }

    @Test
    void buildPossibleAction_v4() {
        Entities entitiesToReach = new Oar(0, 3);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(1, 4, 2), movingAction);
    }

    @Test
    void buildNotPossibleAction_v4() {
        Entities entitiesToReach = new Oar(2, 5);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(1, 4, 2), movingAction);
    }

    @Test
    void buildPossibleAction_v5() {
        Entities entitiesToReach = new Oar(-5, -2);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(-4, -1, 2), movingAction);
    }

    @Test
    void buildNotPossibleAction_v5() {
        Entities entitiesToReach = new Oar(-6, -3);
        Action movingAction = smartCreateActions.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(-3, -2, 2), movingAction);
    }

    ////////////////
    // test movingToRudder(), Rudder in (7,1)
    ////////////////

    @Test
    void useRudder_MovePossible_v1() {
        sailors = new Sailor[]{new Sailor(2, 1, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseRudder(Math.PI);

        assertEquals(new Moving(5, 0, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new Turn(Math.PI, 0), smartCreateActions.actionsList.get(1));
        assertEquals(0, smartCreateActions.entitiesTooFar.size());
    }

    @Test
    void useRudder_MoveNotPossible_v1() {
        sailors = new Sailor[]{new Sailor(1, 1, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseRudder(1);

        assertEquals(0, smartCreateActions.actionsList.size());
        assertEquals(1, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Rudder);
    }

    @Test
    void useRudder_MovePossible_v2() {
        sailors = new Sailor[]{new Sailor(11, 2, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseRudder(Math.PI);

        assertEquals(new Moving(-4, -1, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new Turn(Math.PI, 0), smartCreateActions.actionsList.get(1));
        assertEquals(0, smartCreateActions.entitiesTooFar.size());
    }

    @Test
    void useRudder_MoveNotPossible_v2() {
        sailors = new Sailor[]{new Sailor(12, 2, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseRudder(1);

        assertEquals(0, smartCreateActions.actionsList.size());
        assertEquals(1, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Rudder);
    }

    @Test
    void useRudder_MovePossible_v3() {
        sailors = new Sailor[]{new Sailor(7, 6, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseRudder(Math.PI);

        assertEquals(new Moving(0, -5, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new Turn(Math.PI, 0), smartCreateActions.actionsList.get(1));
        assertEquals(0, smartCreateActions.entitiesTooFar.size());
    }

    @Test
    void useRudder_MoveNotPossible_v3() {
        sailors = new Sailor[]{new Sailor(7, 7, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseRudder(1);

        assertEquals(0, smartCreateActions.actionsList.size());
        assertEquals(1, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Rudder);
    }

    ////////////////
    // test movingToSails(), Sail in (3,1)
    ////////////////

    @Test
    void useSails_MovePossible_v1() {
        sailors = new Sailor[]{new Sailor(-2, 1, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseSails(SailAction.LIFT);

        assertEquals(new Moving(5, 0, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new LiftSail(0), smartCreateActions.actionsList.get(1));
        assertEquals(0, smartCreateActions.entitiesTooFar.size());
    }

    @Test
    void useSails_MoveNotPossible_v1() {
        sailors = new Sailor[]{new Sailor(-3, 1, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseSails(SailAction.LIFT);

        assertEquals(0, smartCreateActions.actionsList.size());
        assertEquals(1, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Sail);
    }

    @Test
    void useSails_MovePossible_v2() {
        sailors = new Sailor[]{new Sailor(7, 2, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseSails(SailAction.LOWER);

        assertEquals(new Moving(-4, -1, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new LowerSail(0), smartCreateActions.actionsList.get(1));
        assertEquals(0, smartCreateActions.entitiesTooFar.size());
    }

    @Test
    void useSails_MoveNotPossible_v2() {
        sailors = new Sailor[]{new Sailor(8, 2, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseSails(SailAction.LOWER);

        assertEquals(0, smartCreateActions.actionsList.size());
        assertEquals(1, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Sail);
    }

    @Test
    void useSails_MovePossible_v3() {
        sailors = new Sailor[]{new Sailor(3, 6, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseSails(SailAction.LIFT);

        assertEquals(new Moving(0, -5, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new LiftSail(0), smartCreateActions.actionsList.get(1));
        assertEquals(0, smartCreateActions.entitiesTooFar.size());
    }

    @Test
    void useSails_MoveNotPossible_v3() {
        sailors = new Sailor[]{new Sailor(3, 7, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseSails(SailAction.LIFT);

        assertEquals(0, smartCreateActions.actionsList.size());
        assertEquals(1, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Sail);
    }

    ////////////////
    // test movingAndUseOars(), Oars in (1,0) - (2,0) - (3,0) - (4,0)
    //                                    (1,2) - (2,2) - (3,2) - (4,2)
    ////////////////

    @Test
    void useOars_MovesPossible_v1() {
        sailors = new Sailor[]{new Sailor(-4, 0, 0), new Sailor(9, 2, 1)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseOars(new NbOarsUsed(1,1));

        assertEquals(new Moving(5, 0, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(0), smartCreateActions.actionsList.get(1));
        assertEquals(new Moving(-5, 0, 1), smartCreateActions.actionsList.get(2));
        assertEquals(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(1), smartCreateActions.actionsList.get(3));
        assertEquals(0, smartCreateActions.entitiesTooFar.size());
    }

    @Test
    void useOars_MovesNotPossible_v1() {
        sailors = new Sailor[]{new Sailor(-5, 0, 0), new Sailor(10, 2, 1)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseOars(new NbOarsUsed(1, 1));

        assertEquals(2, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Oar);
        assertTrue(smartCreateActions.entitiesTooFar.get(1) instanceof Oar);
    }

    @Test
    void useOars_MoveNotPossibleOnLeft_v1() {
        sailors = new Sailor[]{new Sailor(-5, 0, 0), new Sailor(9, 2, 1)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseOars(new NbOarsUsed(1, 1));


        assertEquals(new Moving(-5, 0, 1), smartCreateActions.actionsList.get(0));
        assertEquals(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(1), smartCreateActions.actionsList.get(1));
        assertEquals(1, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Oar);
    }

    @Test
    void useOars_MoveNotPossibleOnRight_v1() {
        sailors = new Sailor[]{new Sailor(-4, 0, 0), new Sailor(10, 2, 1)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseOars(new NbOarsUsed(1, 1));


        assertEquals(new Moving(5, 0, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(0), smartCreateActions.actionsList.get(1));
        assertEquals(1, smartCreateActions.entitiesTooFar.size());
        assertTrue(smartCreateActions.entitiesTooFar.get(0) instanceof Oar);
    }

    @Test
    void useOars_MovesPossible3Sailors_v2() {
        sailors = new Sailor[]{new Sailor(-4, 0, 0),
                               new Sailor(-3, 0, 2),
                               new Sailor(-2, 0, 4)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingAndUseOars(new NbOarsUsed(3, 0));

        assertEquals(new Moving(5, 0, 4), smartCreateActions.actionsList.get(0));
        assertEquals(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(4), smartCreateActions.actionsList.get(1));
        assertEquals(new Moving(5, 0, 2), smartCreateActions.actionsList.get(2));
        assertEquals(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(2), smartCreateActions.actionsList.get(3));
        assertEquals(new Moving(5, 0, 0), smartCreateActions.actionsList.get(4));
        assertEquals(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(0), smartCreateActions.actionsList.get(5));
        assertEquals(0, smartCreateActions.entitiesTooFar.size());
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

    ////////////////
    // test movingToEntitiesTooFar()
    ////////////////

    @Test
    void movingToEntitiesTooFar_0Entities() {
        sailors = new Sailor[]{new Sailor(3, 6, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingToEntitiesTooFar();

        assertEquals(0, smartCreateActions.actionsList.size());
    }

    @Test
    void movingToEntitiesTooFar_1Oar() {
        sailors = new Sailor[]{new Sailor(3, 6, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);
        smartCreateActions.entitiesTooFar.add(new Oar(9, 0));

        smartCreateActions.movingToEntitiesTooFar();

        assertEquals(new Moving(1, -4, 0), smartCreateActions.actionsList.get(0));
    }

    @Test
    void movingToEntitiesTooFar_1Rudder() {
        sailors = new Sailor[]{new Sailor(3, 6, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);
        smartCreateActions.entitiesTooFar.add(new Rudder(0, 9));

        smartCreateActions.movingToEntitiesTooFar();

        assertEquals(new Moving(-2, 3, 0), smartCreateActions.actionsList.get(0));
    }

    @Test
    void movingToEntitiesTooFar_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 6, 0)};
        smartCreateActions = new SmartCreateActions(ship, sailors);
        smartCreateActions.entitiesTooFar.add(new Sail(-9, -9, false));

        smartCreateActions.movingToEntitiesTooFar();

        assertEquals(new Moving(-1, -4, 0), smartCreateActions.actionsList.get(0));
    }

    @Test
    void movingToEntitiesTooFar_3Entities() {
        sailors = new Sailor[]{new Sailor(0, 0, 0), new Sailor(1, 0, 1), new Sailor(2, 0, 2)};
        smartCreateActions = new SmartCreateActions(ship, sailors);
        smartCreateActions.entitiesTooFar.add(new Oar(9, 0));
        smartCreateActions.entitiesTooFar.add(new Rudder(0, 9));
        smartCreateActions.entitiesTooFar.add(new Sail(-9, -9, false));

        smartCreateActions.movingToEntitiesTooFar();

        assertEquals(new Moving(5, 0, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new Moving(-1, 4, 1), smartCreateActions.actionsList.get(1));
        assertEquals(new Moving(-1, -4, 2), smartCreateActions.actionsList.get(2));
    }

    ////////////////
    // test movingToEntitiesTooFar()
    ////////////////

    @Test
    void movingToCenter4W_8L() { //shape = (8 of length, 4 of width) so center on (3, 1)
        sailors = new Sailor[]{new Sailor(0, 0, 0), new Sailor(1, 1, 1), new Sailor(2, 0, 2)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingToCenter();

        assertEquals(new Moving(3, 1, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new Moving(2, 0, 1), smartCreateActions.actionsList.get(1));
        assertEquals(new Moving(1, 1, 2), smartCreateActions.actionsList.get(2));
    }

    @Test
    void movingToCenter5W_9L() { //shape = (5 of width, 9 of length) so center on (4, 2)
        ship = new Ship(null, new Entities[]{new Rudder(7, 1), new Sail(3, 1, false),
                new Oar(1, 0), new Oar(2, 0), new Oar(3, 0), new Oar(4, 0),
                new Oar(1, 2), new Oar(2, 2), new Oar(3, 2), new Oar(4, 2)},
                "", new Deck(5, 9), new Rectangle());

        sailors = new Sailor[]{new Sailor(0, 0, 0), new Sailor(1, 1, 1), new Sailor(2, 0, 2)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        smartCreateActions.movingToCenter();

        assertEquals(new Moving(3, 2, 0), smartCreateActions.actionsList.get(0));
        assertEquals(new Moving(3, 1, 1), smartCreateActions.actionsList.get(1));
        assertEquals(new Moving(2, 2, 2), smartCreateActions.actionsList.get(2));
    }

    ////////////////
    // test createActions()
    ////////////////

    @Test
    void createActions_4Oar_1Rudder_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                               new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(Math.PI/4, SailAction.LIFT,new NbOarsUsed(2,2)));

        assertEquals(12, actionList.size());
    }

    @Test
    void createActions_2Oar_1Rudder_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(Math.PI/4, SailAction.LIFT,new NbOarsUsed(1,1)));

        assertEquals(10, actionList.size());
    }

    @Test
    void createActions_0Oar_1Rudder_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(Math.PI/4,SailAction.LIFT,new NbOarsUsed(0,0)));

        assertEquals(8, actionList.size());
    }

    @Test
    void createActions_0Oar_0Rudder_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(0,SailAction.LIFT,new NbOarsUsed(0,0)));

        assertEquals(7, actionList.size()); //need to change
    }

    @Test
    void createActions_0Oar_0Rudder_0Sail() {
        sailors = new Sailor[]{new Sailor(3, 1, 0), new Sailor(3, 1, 1), new Sailor(1, 3, 2),
                new Sailor(3, 1, 3), new Sailor(3, 1, 4), new Sailor(1, 3, 5)};
        smartCreateActions = new SmartCreateActions(ship, sailors);

        List<Action> actionList = smartCreateActions.createActions(new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(0, 0)));

        assertEquals(6, actionList.size()); //need to change
    }
}

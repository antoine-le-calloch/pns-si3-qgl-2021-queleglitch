package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartMoving;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Moving;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToolingTest {
    List<Sailor> sailorsAvailable;
    List<Entities> entitiesTooFar;
    List<Action> actionsList;
    Sailor[] sailors;
    Tooling tooling;

    @BeforeEach
    void setUp() {
        sailorsAvailable = new ArrayList<>();
        sailorsAvailable.add(new Sailor(0, 0, 0));
        sailorsAvailable.add(new Sailor(1, 1, 1));
        sailorsAvailable.add(new Sailor(-1, -1, 2));
        sailors = sailorsAvailable.toArray(Sailor[]::new);
        tooling = new Tooling(null,sailors);
        entitiesTooFar = new ArrayList<>();
        actionsList = new ArrayList<>();
    }

    ////////////////
    // test nbBoxBetweenSailorAndPlace()
    ////////////////

    @Test
    void normBetween_0_0And_100_0() {
        assertEquals(100, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(100, 0)));
    }

    @Test
    void normBetween_0_0And_0_100() {
        assertEquals(100, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(0, 100)));
    }

    @Test
    void normBetween_100_0And_0_0() {
        assertEquals(100, tooling.nbBoxBetweenSailorAndPlace(new Sailor(100, 0, 0), new Box(0, 0)));
    }

    @Test
    void normBetween_0_100And_0_0() {
        assertEquals(100, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 100, 0), new Box(0, 0)));
    }

    @Test
    void normBetween_0_0And_Minus100_0() {
        assertEquals(100, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(-100, 0)));
    }

    @Test
    void normBetween_0_0And_0_Minus100() {
        assertEquals(100, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(0, -100)));
    }

    @Test
    void normBetween_Minus100_0And_0_0() {
        assertEquals(100, tooling.nbBoxBetweenSailorAndPlace(new Sailor(-100, 0, 0), new Box(0, 0)));
    }

    @Test
    void normBetween_0_Minus100And_0_0() {
        assertEquals(100, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, -100, 0), new Box(0, 0)));
    }

    @Test
    void normBetween_0_0And_1_1() {
        assertEquals(2, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(1, 1)));
    }

    @Test
    void normBetween_0_0And_Minus1_1() {
        assertEquals(2, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(-1, 1)));
    }

    @Test
    void normBetween_0_0And_Minus1_Minus1() {
        assertEquals(2, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(-1, -1)));
    }

    @Test
    void normBetween_0_0And_1_Minus1() {
        assertEquals(2, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(1, -1)));
    }

    /////////////////////////////////////////// 5 moves

    @Test
    void normBetween_0_0And_5_0() {
        assertEquals(5, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(5, 0)));
    }

    @Test
    void normBetween_0_0And_4_1() {
        assertEquals(5, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(4, 1)));
    }

    @Test
    void normBetween_0_0And_3_2() {
        assertEquals(5, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(3, 2)));
    }

    @Test
    void normBetween_0_0And_2_3() {
        assertEquals(5, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(2, 3)));
    }

    @Test
    void normBetween_0_0And_1_4() {
        assertEquals(5, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(1, 4)));
    }

    @Test
    void normBetween_0_0And_0_5() {
        assertEquals(5, tooling.nbBoxBetweenSailorAndPlace(new Sailor(0, 0, 0), new Box(0, 5)));
    }

    ////////////////
    // test nearestSailorBehind5()
    ////////////////

    @Test
    void nearestSailor_0_v0() {
        Box positionEntitiesToReach = new Box(0, 0);
        assertEquals(0, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_0_v1() {
        Box positionEntitiesToReach = new Box(1, 0);
        assertEquals(0, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_0_v2() {
        Box positionEntitiesToReach = new Box(0, 1);
        assertEquals(0, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_0_v3() {
        Box positionEntitiesToReach = new Box(-1, 0);
        assertEquals(0, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_0_v4() {
        Box positionEntitiesToReach = new Box(0, -1);
        assertEquals(0, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_1_v1() {
        Box positionEntitiesToReach = new Box(1, 1);
        assertEquals(1, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_1_v2() {
        Box positionEntitiesToReach = new Box(3, 3);
        assertEquals(1, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_1_v3() {
        Box positionEntitiesToReach = new Box(2, 1);
        assertEquals(1, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_1_v4() {
        Box positionEntitiesToReach = new Box(1, 2);
        assertEquals(1, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_2_v1() {
        Box positionEntitiesToReach = new Box(-1, -1);
        assertEquals(2, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_2_v2() {
        Box positionEntitiesToReach = new Box(-3, -3);
        assertEquals(2, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_2_v3() {
        Box positionEntitiesToReach = new Box(-2, -1);
        assertEquals(2, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_2_v4() {
        Box positionEntitiesToReach = new Box(-1, -2);
        assertEquals(2, tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable).getId());
    }

    @Test
    void nearestSailor_TooFar_OnZero() {
        Box positionEntitiesToReach = new Box(0, -6);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_OnZero() {
        Box positionEntitiesToReach = new Box(0, -5);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_TooFar_v1() {
        Box positionEntitiesToReach = new Box(7, 1);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_v1() {
        Box positionEntitiesToReach = new Box(6, 1);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_TooFar_v2() {
        Box positionEntitiesToReach = new Box(1, 7);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_v2() {
        Box positionEntitiesToReach = new Box(1, 6);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_TooFar_v3() {
        Box positionEntitiesToReach = new Box(4, 4);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_v3() {
        Box positionEntitiesToReach = new Box(3, 3);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_TooFar_v4() {
        Box positionEntitiesToReach = new Box(3, 5);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_v4() {
        Box positionEntitiesToReach = new Box(3, 4);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_TooFar_Minus_v1() {
        Box positionEntitiesToReach = new Box(-7, -1);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_Minus_v1() {
        Box positionEntitiesToReach = new Box(-6, -1);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_TooFar_Minus_v2() {
        Box positionEntitiesToReach = new Box(-1, -7);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_Minus_v2() {
        Box positionEntitiesToReach = new Box(-1, -6);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_TooFar_Minus_v3() {
        Box positionEntitiesToReach = new Box(-4, -4);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_Minus_v3() {
        Box positionEntitiesToReach = new Box(-3, -3);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_TooFar_Minus_v4() {
        Box positionEntitiesToReach = new Box(-3, -5);
        assertNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    @Test
    void nearestSailor_NotTooFar_Minus_v4() {
        Box positionEntitiesToReach = new Box(-3, -4);
        assertNotNull(tooling.nearestSailorBehind5(positionEntitiesToReach, sailorsAvailable));
    }

    ////////////////
    // test buildMovingAction()
    ////////////////

    @Test
    void buildPossibleAction_v1() {
        Entities entitiesToReach = new Oar(4, 0);

        assertEquals(new Sailor(0, 0, 0), sailors[0]);

        assertEquals(new Moving(4, 0, 0), tooling.buildMovingAction(sailors[0], entitiesToReach));

        assertEquals(new Sailor(4, 0, 0), sailors[0]);
    }

    @Test
    void buildNotPossibleAction_v1() {
        Entities entitiesToReach = new Oar(6, 0);
        Action movingAction = tooling.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(5, 0, 0), movingAction);
    }

    @Test
    void buildPossibleAction_v2() {
        Entities entitiesToReach = new Oar(0, 4);
        Action movingAction = tooling.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(0, 4, 0), movingAction);
    }

    @Test
    void buildNotPossibleAction_v2() {
        Entities entitiesToReach = new Oar(0, 6);
        Action movingAction = tooling.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(0, 5, 0), movingAction);
    }

    @Test
    void buildPossibleAction_v3() {
        Entities entitiesToReach = new Oar(3, 3);
        Action movingAction = tooling.buildMovingAction(sailors[1], entitiesToReach);

        assertEquals(new Moving(2, 2, 1), movingAction);
    }

    @Test
    void buildNotPossibleAction_v3() {
        Entities entitiesToReach = new Oar(4, 4);
        Action movingAction = tooling.buildMovingAction(sailors[1], entitiesToReach);

        assertEquals(new Moving(2, 3, 1), movingAction);
    }

    @Test
    void buildPossibleAction_v4() {
        Entities entitiesToReach = new Oar(0, 3);
        Action movingAction = tooling.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(1, 4, 2), movingAction);
    }

    @Test
    void buildNotPossibleAction_v4() {
        Entities entitiesToReach = new Oar(2, 5);
        Action movingAction = tooling.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(1, 4, 2), movingAction);
    }

    @Test
    void buildPossibleAction_v5() {
        Entities entitiesToReach = new Oar(-5, -2);
        Action movingAction = tooling.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(-4, -1, 2), movingAction);
    }

    @Test
    void buildNotPossibleAction_v5() {
        Entities entitiesToReach = new Oar(-6, -3);
        Action movingAction = tooling.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(-3, -2, 2), movingAction);
    }

    ////////////////
    // test movingToEntitiesTooFar()
    ////////////////

    @Test
    void movingToEntitiesTooFar_0Entities() {
        sailors = new Sailor[]{new Sailor(3, 6, 0)};
        tooling = new Tooling(new Box(0,0), sailors);

        tooling.movingToEntitiesTooFar(sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(0, actionsList.size());
    }

    @Test
    void movingToEntitiesTooFar_1Oar() {
        sailorsAvailable = new ArrayList<>();
        sailorsAvailable.add(new Sailor(3, 6, 0));
        tooling = new Tooling(new Box(0,0), sailorsAvailable.toArray(Sailor[]::new));
        entitiesTooFar.add(new Oar(9, 0));

        tooling.movingToEntitiesTooFar(sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(1, -4, 0), actionsList.get(0));
    }

    @Test
    void movingToEntitiesTooFar_1Rudder() {
        sailorsAvailable = new ArrayList<>();
        sailorsAvailable.add(new Sailor(3, 6, 0));
        tooling = new Tooling(new Box(0,0), sailorsAvailable.toArray(Sailor[]::new));
        entitiesTooFar.add(new Rudder(0, 9));

        tooling.movingToEntitiesTooFar(sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(-2, 3, 0), actionsList.get(0));
    }

    @Test
    void movingToEntitiesTooFar_1Sail() {
        sailors = new Sailor[]{new Sailor(3, 6, 0)};
        tooling = new Tooling(new Box(0,0), sailors);
        entitiesTooFar.add(new Sail(-9, -9, false));

        tooling.movingToEntitiesTooFar(sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(-1, -4, 0), actionsList.get(0));
    }

    @Test
    void movingToEntitiesTooFar_3Entities() {
        sailors = new Sailor[]{new Sailor(0, 0, 0), new Sailor(1, 0, 1), new Sailor(2, 0, 2)};
        tooling = new Tooling(new Box(0,0), sailors);
        entitiesTooFar.add(new Oar(9, 0));
        entitiesTooFar.add(new Rudder(0, 9));
        entitiesTooFar.add(new Sail(-9, -9, false));

        tooling.movingToEntitiesTooFar(sailorsAvailable, entitiesTooFar, actionsList);

        assertEquals(new Moving(5, 0, 0), actionsList.get(0));
        assertEquals(new Moving(-1, 4, 1), actionsList.get(1));
        assertEquals(new Moving(-1, -4, 2), actionsList.get(2));
    }

    ////////////////
    // test movingToEntitiesTooFar()
    ////////////////

    @Test
    void movingToCenter4W_8L() { //shape = (8 of length, 4 of width) so center on (3, 1)
        sailorsAvailable = new ArrayList<>();
        sailorsAvailable.add(new Sailor(0, 0, 0));
        sailorsAvailable.add(new Sailor(1, 1, 1));
        sailorsAvailable.add(new Sailor(2, 0, 2));
        tooling = new Tooling(new Box(3,1), sailorsAvailable.toArray(Sailor[]::new));

        tooling.movingToCenter(sailorsAvailable, actionsList);

        assertEquals(new Moving(3, 1, 0), actionsList.get(0));
        assertEquals(new Moving(2, 0, 1), actionsList.get(1));
        assertEquals(new Moving(1, 1, 2), actionsList.get(2));
    }

    @Test
    void movingToCenter5W_9L() { //shape = (5 of width, 9 of length) so center on (4, 2)
        sailorsAvailable = new ArrayList<>();
        sailorsAvailable.add(new Sailor(0, 0, 0));
        sailorsAvailable.add(new Sailor(1, 1, 1));
        sailorsAvailable.add(new Sailor(2, 0, 2));
        tooling = new Tooling(new Box(4,2), sailorsAvailable.toArray(Sailor[]::new));

        tooling.movingToCenter(sailorsAvailable, actionsList);

        assertEquals(new Moving(3, 2, 0), actionsList.get(0));
        assertEquals(new Moving(3, 1, 1), actionsList.get(1));
        assertEquals(new Moving(2, 2, 2), actionsList.get(2));
    }
}
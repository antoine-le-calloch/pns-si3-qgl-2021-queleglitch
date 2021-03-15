package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Moving;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Turn;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CreateActionsStrategieTest {

    Ship ship;
    Sailor []sailors;
    List<Sailor> sailorsList;
    List<MoveSailor> movingActionsList;
    CreateActionsStrategie createActionsStrategie;

    @BeforeEach
    void setUp() {
        ship = new Ship(null, new Entities[]{new Gouvernail(7,1), new Voile(3,1),
                                new Rame(1,0), new Rame(2,0), new Rame(3,0), new Rame(4,0),
                                new Rame(1,2), new Rame(2,2), new Rame(3,2), new Rame(4,2)},
                          "", new Deck(4,8), new Rectangle());

        sailors = new Sailor[]{new Sailor(0,0,0),new Sailor(1,1,1),new Sailor(-1,-1,2)};
        sailorsList = Arrays.asList(sailors.clone());
        movingActionsList = new ArrayList<>();
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);
    }


    ////////////////
    // test nbBoxBetweenSailorAndPlace()
    ////////////////

    @Test
    void normBetween_0_0And_100_0(){
        assertEquals(100, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(100,0)));
    }

    @Test
    void normBetween_0_0And_0_100(){
        assertEquals(100, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(0,100)));
    }

    @Test
    void normBetween_100_0And_0_0(){
        assertEquals(100, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(100,0,0),new Box(0,0)));
    }

    @Test
    void normBetween_0_100And_0_0(){
        assertEquals(100, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,100,0),new Box(0,0)));
    }

    @Test
    void normBetween_0_0And_Minus100_0(){
        assertEquals(100, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(-100,0)));
    }

    @Test
    void normBetween_0_0And_0_Minus100(){
        assertEquals(100, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(0,-100)));
    }

    @Test
    void normBetween_Minus100_0And_0_0(){
        assertEquals(100, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(-100,0,0),new Box(0,0)));
    }

    @Test
    void normBetween_0_Minus100And_0_0(){
        assertEquals(100, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,-100,0),new Box(0,0)));
    }

    @Test
    void normBetween_0_0And_1_1(){
        assertEquals(2, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(1,1)));
    }

    @Test
    void normBetween_0_0And_Minus1_1(){
        assertEquals(2, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(-1,1)));
    }

    @Test
    void normBetween_0_0And_Minus1_Minus1(){
        assertEquals(2, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(-1,-1)));
    }

    @Test
    void normBetween_0_0And_1_Minus1(){
        assertEquals(2, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(1,-1)));
    }

    /////////////////////////////////////////// 5 moves

    @Test
    void normBetween_0_0And_5_0(){
        assertEquals(5, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(5,0)));
    }

    @Test
    void normBetween_0_0And_4_1(){
        assertEquals(5, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(4,1)));
    }

    @Test
    void normBetween_0_0And_3_2(){
        assertEquals(5, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(3,2)));
    }

    @Test
    void normBetween_0_0And_2_3(){
        assertEquals(5, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(2,3)));
    }

    @Test
    void normBetween_0_0And_1_4(){
        assertEquals(5, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(1,4)));
    }

    @Test
    void normBetween_0_0And_0_5(){
        assertEquals(5, createActionsStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0,0),new Box(0,5)));
    }

    ////////////////
    // test nearestSailorBehind5()
    ////////////////

    @Test
    void nearestSailor_0_v0(){
        Box positionEntitiesToReach = new Box(0,0);
        assertEquals(0, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_0_v1(){
        Box positionEntitiesToReach = new Box(1,0);
        assertEquals(0, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_0_v2(){
        Box positionEntitiesToReach = new Box(0,1);
        assertEquals(0, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_0_v3(){
        Box positionEntitiesToReach = new Box(-1,0);
        assertEquals(0, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_0_v4(){
        Box positionEntitiesToReach = new Box(0,-1);
        assertEquals(0, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_1_v1(){
        Box positionEntitiesToReach = new Box(1,1);
        assertEquals(1, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_1_v2(){
        Box positionEntitiesToReach = new Box(3,3);
        assertEquals(1, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_1_v3(){
        Box positionEntitiesToReach = new Box(2,1);
        assertEquals(1, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_1_v4(){
        Box positionEntitiesToReach = new Box(1,2);
        assertEquals(1, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_2_v1(){
        Box positionEntitiesToReach = new Box(-1,-1);
        assertEquals(2, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_2_v2(){
        Box positionEntitiesToReach = new Box(-3,-3);
        assertEquals(2, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_2_v3(){
        Box positionEntitiesToReach = new Box(-2,-1);
        assertEquals(2, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_2_v4(){
        Box positionEntitiesToReach = new Box(-1,-2);
        assertEquals(2, createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList).getId());
    }

    @Test
    void nearestSailor_ToFar_OnZero(){
        Box positionEntitiesToReach = new Box(0,-6);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_OnZero(){
        Box positionEntitiesToReach = new Box(0,-5);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_ToFar_v1(){
        Box positionEntitiesToReach = new Box(7,1);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_v1(){
        Box positionEntitiesToReach = new Box(6,1);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_ToFar_v2(){
        Box positionEntitiesToReach = new Box(1,7);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_v2(){
        Box positionEntitiesToReach = new Box(1,6);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_ToFar_v3(){
        Box positionEntitiesToReach = new Box(4,4);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_v3(){
        Box positionEntitiesToReach = new Box(3,3);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_ToFar_v4(){
        Box positionEntitiesToReach = new Box(3,5);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_v4(){
        Box positionEntitiesToReach = new Box(3,4);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_ToFar_Minus_v1(){
        Box positionEntitiesToReach = new Box(-7,-1);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_Minus_v1(){
        Box positionEntitiesToReach = new Box(-6,-1);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_ToFar_Minus_v2(){
        Box positionEntitiesToReach = new Box(-1,-7);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_Minus_v2(){
        Box positionEntitiesToReach = new Box(-1,-6);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_ToFar_Minus_v3(){
        Box positionEntitiesToReach = new Box(-4,-4);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_Minus_v3(){
        Box positionEntitiesToReach = new Box(-3,-3);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_ToFar_Minus_v4(){
        Box positionEntitiesToReach = new Box(-3,-5);
        assertNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    @Test
    void nearestSailor_NotToFar_Minus_v4(){
        Box positionEntitiesToReach = new Box(-3,-4);
        assertNotNull(createActionsStrategie.nearestSailorBehind5(positionEntitiesToReach, sailorsList));
    }

    ////////////////
    // test buildMovingAction()
    ////////////////

    @Test
    void buildPossibleAction_v1(){
        Entities entitiesToReach = new Rame(4,0);

        assertEquals(new Sailor(0,0, 0),sailors[0]);

        assertEquals(new Moving(4,0, 0),createActionsStrategie.buildMovingAction(sailors[0], entitiesToReach));

        assertEquals(new Sailor(4,0, 0),sailors[0]);
    }

    @Test
    void buildNotPossibleAction_v1(){
        Entities entitiesToReach = new Rame(6,0);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(5, 0, 0),movingAction);
    }

    @Test
    void buildPossibleAction_v2(){
        Entities entitiesToReach = new Rame(0,4);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(0,4, 0),movingAction);
    }

    @Test
    void buildNotPossibleAction_v2(){
        Entities entitiesToReach = new Rame(0,6);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[0], entitiesToReach);

        assertEquals(new Moving(0,5, 0),movingAction);
    }

    @Test
    void buildPossibleAction_v3(){
        Entities entitiesToReach = new Rame(3,3);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[1], entitiesToReach);

        assertEquals(new Moving(2,2, 1),movingAction);
    }

    @Test
    void buildNotPossibleAction_v3(){
        Entities entitiesToReach = new Rame(4,4);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[1], entitiesToReach);

        assertEquals(new Moving(2,3, 1),movingAction);
    }

    @Test
    void buildPossibleAction_v4(){
        Entities entitiesToReach = new Rame(0,3);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(1,4, 2),movingAction);
    }

    @Test
    void buildNotPossibleAction_v4(){
        Entities entitiesToReach = new Rame(2,5);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(1,4, 2),movingAction);
    }

    @Test
    void buildPossibleAction_v5(){
        Entities entitiesToReach = new Rame(-5,-2);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(-4,-1, 2),movingAction);
    }

    @Test
    void buildNotPossibleAction_v5(){
        Entities entitiesToReach = new Rame(-6,-3);
        Action movingAction = createActionsStrategie.buildMovingAction(sailors[2], entitiesToReach);

        assertEquals(new Moving(-3,-2, 2),movingAction);
    }

    ////////////////
    // test movingToGouvernail(), Gouvernail in (7,1)
    ////////////////

    @Test
    void useGouvernail_MovePossible_v1(){
        sailors = new Sailor[]{new Sailor(2,1,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseGouvernail(Math.PI);

        assertEquals(new Moving(5,0,0), createActionsStrategie.actionsList.get(0));
        assertEquals(new Turn(Math.PI,0), createActionsStrategie.actionsList.get(1));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }

    @Test
    void useGouvernail_MoveNotPossible_v1(){
        sailors = new Sailor[]{new Sailor(1,1,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseGouvernail(1);

        assertEquals(0, createActionsStrategie.actionsList.size());
        assertEquals(1, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Gouvernail);
    }

    @Test
    void useGouvernail_MovePossible_v2(){
        sailors = new Sailor[]{new Sailor(11,2,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseGouvernail(Math.PI);

        assertEquals(new Moving(-4,-1,0), createActionsStrategie.actionsList.get(0));
        assertEquals(new Turn(Math.PI,0), createActionsStrategie.actionsList.get(1));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }

    @Test
    void useGouvernail_MoveNotPossible_v2(){
        sailors = new Sailor[]{new Sailor(12,2,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseGouvernail(1);

        assertEquals(0, createActionsStrategie.actionsList.size());
        assertEquals(1, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Gouvernail);
    }

    @Test
    void useGouvernail_MovePossible_v3(){
        sailors = new Sailor[]{new Sailor(7,6,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseGouvernail(Math.PI);

        assertEquals(new Moving(0,-5,0), createActionsStrategie.actionsList.get(0));
        assertEquals(new Turn(Math.PI,0), createActionsStrategie.actionsList.get(1));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }

    @Test
    void useGouvernail_MoveNotPossible_v3(){
        sailors = new Sailor[]{new Sailor(7,7,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseGouvernail(1);

        assertEquals(0, createActionsStrategie.actionsList.size());
        assertEquals(1, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Gouvernail);
    }

    ////////////////
    // test movingToVoiles(), Voile in (3,1)
    ////////////////

    @Test
    void useVoiles_MovePossible_v1(){
        sailors = new Sailor[]{new Sailor(-2,1,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseVoiles();

        assertEquals(new Moving(5,0,0), createActionsStrategie.actionsList.get(0));
        //assertEquals(new Sail(0), createActionsStrategie.actionsList.get(1));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }

    @Test
    void useVoiles_MoveNotPossible_v1(){
        sailors = new Sailor[]{new Sailor(-3,1,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseVoiles();

        assertEquals(0, createActionsStrategie.actionsList.size());
        assertEquals(1, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Voile);
    }

    @Test
    void useVoiles_MovePossible_v2(){
        sailors = new Sailor[]{new Sailor(7,2,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseVoiles();

        assertEquals(new Moving(-4,-1,0), createActionsStrategie.actionsList.get(0));
        //assertEquals(new Sail(0), createActionsStrategie.actionsList.get(0));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }

    @Test
    void useVoiles_MoveNotPossible_v2(){
        sailors = new Sailor[]{new Sailor(8,2,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseVoiles();

        assertEquals(0, createActionsStrategie.actionsList.size());
        assertEquals(1, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Voile);
    }

    @Test
    void useVoiles_MovePossible_v3(){
        sailors = new Sailor[]{new Sailor(3,6,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseVoiles();

        assertEquals(new Moving(0,-5,0), createActionsStrategie.actionsList.get(0));
        //assertEquals(new Sail(0), createActionsStrategie.actionsList.get(0));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }

    @Test
    void useVoiles_MoveNotPossible_v3(){
        sailors = new Sailor[]{new Sailor(3,7,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseVoiles();

        assertEquals(0, createActionsStrategie.actionsList.size());
        assertEquals(1, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Voile);
    }

    ////////////////
    // test movingAndUseRames(), Rames in (1,0) - (2,0) - (3,0) - (4,0)
    //                                    (1,2) - (2,2) - (3,2) - (4,2)
    ////////////////

    @Test
    void useRames_MovesPossible_v1(){
        sailors = new Sailor[]{new Sailor(-4,0,0),new Sailor(9,2,1)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseRames(1,1);

        assertEquals(new Moving(5,0,0), createActionsStrategie.actionsList.get(0));
        assertEquals(new Oar(0), createActionsStrategie.actionsList.get(1));
        assertEquals(new Moving(-5,0,1), createActionsStrategie.actionsList.get(2));
        assertEquals(new Oar(1), createActionsStrategie.actionsList.get(3));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }

    @Test
    void useRames_MovesNotPossible_v1(){
        sailors = new Sailor[]{new Sailor(-5,0,0),new Sailor(10,2,1)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseRames(1,1);

        assertEquals(2, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Rame);
        assertTrue(createActionsStrategie.entitiesTooFar.get(1) instanceof Rame);
    }

    @Test
    void useRames_MoveNotPossibleOnLeft_v1(){
        sailors = new Sailor[]{new Sailor(-5,0,0),new Sailor(9,2,1)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseRames(1,1);


        assertEquals(new Moving(-5,0,1), createActionsStrategie.actionsList.get(0));
        assertEquals(new Oar(1), createActionsStrategie.actionsList.get(1));
        assertEquals(1, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Rame);
    }

    @Test
    void useRames_MoveNotPossibleOnRight_v1(){
        sailors = new Sailor[]{new Sailor(-4,0,0),new Sailor(10,2,1)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseRames(1,1);


        assertEquals(new Moving(5,0,0), createActionsStrategie.actionsList.get(0));
        assertEquals(new Oar(0), createActionsStrategie.actionsList.get(1));
        assertEquals(1, createActionsStrategie.entitiesTooFar.size());
        assertTrue(createActionsStrategie.entitiesTooFar.get(0) instanceof Rame);
    }

    @Test
    void useRames_MovesPossible3Sailors_v2(){
        sailors = new Sailor[]{new Sailor(-4,0,0),
                               new Sailor(-3,0,2),
                               new Sailor(-2,0,4)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseRames(3,0);

        assertEquals(new Moving(5,0,4), createActionsStrategie.actionsList.get(0));
        assertEquals(new Oar(4), createActionsStrategie.actionsList.get(1));
        assertEquals(new Moving(5,0,2), createActionsStrategie.actionsList.get(2));
        assertEquals(new Oar(2), createActionsStrategie.actionsList.get(3));
        assertEquals(new Moving(5,0,0), createActionsStrategie.actionsList.get(4));
        assertEquals(new Oar(0), createActionsStrategie.actionsList.get(5));
        assertEquals(0, createActionsStrategie.entitiesTooFar.size());
    }

    /*@Test
    void useRames_MovesPossible6Sailors_v2(){
        sailors = new Sailor[]{new Sailor(-4,0,0), new Sailor(9,2,1),
                new Sailor(-3,0,2), new Sailor(8,2,3),
                new Sailor(-2,0,4), new Sailor(7,2,5)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingAndUseRames(3,0);

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
        assertEquals(0, createActionsStrategie.entitiesToFar.size());
    }*/

    ////////////////
    // test movingToEntitiesToFar(),  Gouvernail in (7,1), Voile in (3,1),
    //                                Rame in (1,0), Rame in (2,0), Rame in (3,0), Rame in (4,0),
    //                                Rame in (1,2), Rame in (2,2), Rame in (3,2), Rame in (4,2)}
    ////////////////

    /*@Test
    void movingToEntitiesToFar_0Entities(){
        sailors = new Sailor[]{new Sailor(3,6,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);

        createActionsStrategie.movingToEntitiesToFar();

        assertEquals(0, createActionsStrategie.actionsList.size());
    }

    @Test
    void movingToEntitiesToFar_1Entities(){
        sailors = new Sailor[]{new Sailor(3,6,0)};
        createActionsStrategie = new CreateActionsStrategie(sailors,ship);
        createActionsStrategie.entitiesTooFar.add(new Rame(9,0));

        createActionsStrategie.movingToEntitiesToFar();

        assertEquals(new Moving(), createActionsStrategie.actionsList.get(0));
    }*/
}
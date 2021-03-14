package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Box;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.MoveSailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveActionStrategieTest {

    Rame[] leftRames;
    Rame[] rightRames;
    Sailor sailor0_0;
    Sailor sailor0_2;
    Sailor sailor1_0;
    Sailor sailor1_2;
    Sailor sailor1_1;
    Sailor sailorMinus1_Minus1;
    List<Sailor> sailors;
    List<MoveSailor> movingActionsList;

    MoveActionStrategie moveActionStrategie;
    MoveActionStrategie moveActionStrategieInfoGame;

    @BeforeEach
    void setUp() {
        sailors = Arrays.asList(new Sailor[]{sailor0_0,sailor1_1,sailorMinus1_Minus1}.clone());
        sailor0_0 = new Sailor(0,0,0);
        sailor0_2 = new Sailor(0,2,3);
        sailor1_0 = new Sailor(1,0,4);
        sailor1_2 = new Sailor(1,2,5);
        sailor1_1 = new Sailor(1,1,1);
        leftRames = new Rame[]{new Rame(1,0), new Rame(2,0), new Rame(3,0), new Rame(4,0)};
        rightRames = new Rame[]{new Rame(1,2), new Rame(2,2), new Rame(3,2), new Rame(4,2)};
        sailorMinus1_Minus1 = new Sailor(-1,-1,2);
        movingActionsList = new ArrayList<>();
        moveActionStrategie = new MoveActionStrategie();
        //moveActionStrategieInfoGame = new MoveActionStrategie(new InformationGame());
    }


    ////////////////
    // test nbBoxBetweenSailorAndPlace()
    ////////////////

    @Test
    void normBetween_0_0And_100_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(100,0)));
    }

    @Test
    void normBetween_0_0And_0_100(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(0,100)));
    }

    @Test
    void normBetween_100_0And_0_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(100,0),new Box(0,0)));
    }

    @Test
    void normBetween_0_100And_0_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,100),new Box(0,0)));
    }

    @Test
    void normBetween_0_0And_Minus100_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(-100,0)));
    }

    @Test
    void normBetween_0_0And_0_Minus100(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(0,-100)));
    }

    @Test
    void normBetween_Minus100_0And_0_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(-100,0),new Box(0,0)));
    }

    @Test
    void normBetween_0_Minus100And_0_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,-100),new Box(0,0)));
    }

    @Test
    void normBetween_0_0And_1_1(){
        assertEquals(2,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(1,1)));
    }

    @Test
    void normBetween_0_0And_Minus1_1(){
        assertEquals(2,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(-1,1)));
    }

    @Test
    void normBetween_0_0And_Minus1_Minus1(){
        assertEquals(2,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(-1,-1)));
    }

    @Test
    void normBetween_0_0And_1_Minus1(){
        assertEquals(2,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(1,-1)));
    }

    /////////////////////////////////////////// 5 moves

    @Test
    void normBetween_0_0And_5_0(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(5,0)));
    }

    @Test
    void normBetween_0_0And_4_1(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(4,1)));
    }

    @Test
    void normBetween_0_0And_3_2(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(3,2)));
    }

    @Test
    void normBetween_0_0And_2_3(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(2,3)));
    }

    @Test
    void normBetween_0_0And_1_4(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(1,4)));
    }

    @Test
    void normBetween_0_0And_0_5(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new Box(0,5)));
    }

    ////////////////
    // test nearestSailorBehind5()
    ////////////////

    @Test
    void nearestSailor_0_v0(){
        Box positionEntitiesToReach = new Box(0,0);
        assertEquals(0,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_0_v1(){
        Box positionEntitiesToReach = new Box(1,0);
        assertEquals(0,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_0_v2(){
        Box positionEntitiesToReach = new Box(0,1);
        assertEquals(0,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_0_v3(){
        Box positionEntitiesToReach = new Box(-1,0);
        assertEquals(0,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_0_v4(){
        Box positionEntitiesToReach = new Box(0,-1);
        assertEquals(0,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_1_v1(){
        Box positionEntitiesToReach = new Box(1,1);
        assertEquals(1,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_1_v2(){
        Box positionEntitiesToReach = new Box(3,3);
        assertEquals(1,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_1_v3(){
        Box positionEntitiesToReach = new Box(2,1);
        assertEquals(1,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_1_v4(){
        Box positionEntitiesToReach = new Box(1,2);
        assertEquals(1,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_2_v1(){
        Box positionEntitiesToReach = new Box(-1,-1);
        assertEquals(2,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_2_v2(){
        Box positionEntitiesToReach = new Box(-3,-3);
        assertEquals(2,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_2_v3(){
        Box positionEntitiesToReach = new Box(-2,-1);
        assertEquals(2,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_2_v4(){
        Box positionEntitiesToReach = new Box(-1,-2);
        assertEquals(2,moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors).getId());
    }

    @Test
    void nearestSailor_ToFar_OnZero(){
        Box positionEntitiesToReach = new Box(0,-6);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_OnZero(){
        Box positionEntitiesToReach = new Box(0,-5);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_ToFar_v1(){
        Box positionEntitiesToReach = new Box(7,1);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_v1(){
        Box positionEntitiesToReach = new Box(6,1);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_ToFar_v2(){
        Box positionEntitiesToReach = new Box(1,7);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_v2(){
        Box positionEntitiesToReach = new Box(1,6);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_ToFar_v3(){
        Box positionEntitiesToReach = new Box(4,4);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_v3(){
        Box positionEntitiesToReach = new Box(3,3);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_ToFar_v4(){
        Box positionEntitiesToReach = new Box(3,5);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_v4(){
        Box positionEntitiesToReach = new Box(3,4);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_ToFar_Minus_v1(){
        Box positionEntitiesToReach = new Box(-7,-1);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_Minus_v1(){
        Box positionEntitiesToReach = new Box(-6,-1);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_ToFar_Minus_v2(){
        Box positionEntitiesToReach = new Box(-1,-7);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_Minus_v2(){
        Box positionEntitiesToReach = new Box(-1,-6);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_ToFar_Minus_v3(){
        Box positionEntitiesToReach = new Box(-4,-4);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_Minus_v3(){
        Box positionEntitiesToReach = new Box(-3,-3);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_ToFar_Minus_v4(){
        Box positionEntitiesToReach = new Box(-3,-5);
        assertNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    @Test
    void nearestSailor_NotToFar_Minus_v4(){
        Box positionEntitiesToReach = new Box(-3,-4);
        assertNotNull(moveActionStrategie.nearestSailorBehind5(positionEntitiesToReach,sailors));
    }

    ////////////////
    // test buildMovingAction()
    ////////////////

    @Test
    void buildPossibleAction_v1(){
        Entities entitiesToReach = new Rame(4,0);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailor0_0,entitiesToReach);
        assertEquals(4,movingAction.getX());
        assertEquals(0,movingAction.getY());
        assertEquals(0,movingAction.getId());
    }

    @Test
    void buildNotPossibleAction_v1(){
        Entities entitiesToReach = new Rame(6,0);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailor0_0,entitiesToReach);
        assertEquals(5,movingAction.getX());
        assertEquals(0,movingAction.getY());
        assertEquals(0,movingAction.getId());
    }

    @Test
    void buildPossibleAction_v2(){
        Entities entitiesToReach = new Rame(0,4);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailor0_0,entitiesToReach);
        assertEquals(0,movingAction.getX());
        assertEquals(4,movingAction.getY());
        assertEquals(0,movingAction.getId());
    }

    @Test
    void buildNotPossibleAction_v2(){
        Entities entitiesToReach = new Rame(0,6);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailor0_0,entitiesToReach);
        assertEquals(0,movingAction.getX());
        assertEquals(5,movingAction.getY());
        assertEquals(0,movingAction.getId());
    }

    @Test
    void buildPossibleAction_v3(){
        Entities entitiesToReach = new Rame(3,3);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailor1_1,entitiesToReach);
        assertEquals(2,movingAction.getX());
        assertEquals(2,movingAction.getY());
        assertEquals(1,movingAction.getId());
    }

    @Test
    void buildNotPossibleAction_v3(){
        Entities entitiesToReach = new Rame(4,4);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailor1_1,entitiesToReach);
        assertEquals(2,movingAction.getX());
        assertEquals(3,movingAction.getY());
        assertEquals(1,movingAction.getId());
    }

    @Test
    void buildPossibleAction_v4(){
        Entities entitiesToReach = new Rame(0,3);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailorMinus1_Minus1,entitiesToReach);
        assertEquals(1,movingAction.getX());
        assertEquals(4,movingAction.getY());
        assertEquals(2,movingAction.getId());
    }

    @Test
    void buildNotPossibleAction_v4(){
        Entities entitiesToReach = new Rame(2,5);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailorMinus1_Minus1,entitiesToReach);
        assertEquals(1,movingAction.getX());
        assertEquals(4,movingAction.getY());
        assertEquals(2,movingAction.getId());
    }

    @Test
    void buildPossibleAction_v5(){
        Entities entitiesToReach = new Rame(-5,-2);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailorMinus1_Minus1,entitiesToReach);
        assertEquals(-4,movingAction.getX());
        assertEquals(-1,movingAction.getY());
        assertEquals(2,movingAction.getId());
    }

    @Test
    void buildNotPossibleAction_v5(){
        Entities entitiesToReach = new Rame(-6,-3);
        MoveSailor movingAction = moveActionStrategie.buildMovingAction(sailorMinus1_Minus1,entitiesToReach);
        assertEquals(-3,movingAction.getX());
        assertEquals(-2,movingAction.getY());
        assertEquals(2,movingAction.getId());
    }

    ////////////////
    // test movingToGouvernail(double rudderAngle, List<MoveSailor> movingActionsList, List<Sailor> sailorsToMove, List<Entities> entitiesToFar){
    ////////////////

    @Test
    void notMovingToGouvernail(){
        assertEquals(0,movingActionsList.size());
        moveActionStrategie.movingToGouvernail(0, movingActionsList, sailors, null);
        assertEquals(0,movingActionsList.size());
    }
}
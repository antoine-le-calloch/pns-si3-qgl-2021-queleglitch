package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RegattaResolverTest {

    RegattaResolver regattaResolverNotUseWind;
    RegattaResolver regattaResolverUseWind;
    RegattaGoal mockRegattaGoal;
    Position positionCheckpointOpti;
    Checkpoint checkpoint;
    Ship mockShip;
    Wind windOrt0;
    Wind windOrtPi;

    @BeforeEach
    void setUp(){
        windOrt0 = new Wind(500,0);
        windOrtPi = new Wind(50,Math.PI);
        mockShip = mock(Ship.class);
        Mockito.when(mockShip.getNbOars()).thenReturn(10);
        Mockito.when(mockShip.getNbSails()).thenReturn(1);
        Mockito.when(mockShip.getPosition()).thenReturn(new Position(0,0,0));

        mockRegattaGoal = Mockito.mock(RegattaGoal.class);

        Sailor []sailors = new Sailor[10];

        regattaResolverUseWind = new RegattaResolver(new InformationGame(sailors,mockShip,mockRegattaGoal,windOrt0));
        regattaResolverNotUseWind = new RegattaResolver(new InformationGame(sailors,mockShip,mockRegattaGoal,windOrtPi));
    }

    @Test
    void checkpointFarSameOrientation_NeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(1100, 0, 0);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LIFT,new NbOarsUsed(4,4));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointFarSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(1100, 0, 0);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(5,5));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointFarOrientationPIOn4_NeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(1000, 1000, 0);

        ToolsToUse toolsToUse = new ToolsToUse(Math.PI/4,SailAction.LIFT,new NbOarsUsed(4,4));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointFarOrientationPIOn4_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(1000, 1000, 0);

        ToolsToUse toolsToUse = new ToolsToUse(Math.PI/4,SailAction.DO_NOTHING,new NbOarsUsed(4,4));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointCloseSameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(125, 0, 0);
        checkpoint = new Checkpoint(new Position(126, 0, 0), new Circle(40));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(5,5));
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSlowDownOf1SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(125, 0, 0);
        checkpoint = new Checkpoint(new Position(125, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4));
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseNotSlowDownOf2SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(60, 0, 0);
        checkpoint = new Checkpoint(new Position(113, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4));
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSlowDownOf2SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(60, 0, 0);
        checkpoint = new Checkpoint(new Position(111, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(3,3));
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSlowDownOf3SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(60, 0, 0);
        checkpoint = new Checkpoint(new Position(78, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(2,2));
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSlowDownOf4SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(40, 0, 0);
        checkpoint = new Checkpoint(new Position(45, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(1,1));
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSlowDownOf4AndLowerSameSailOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(40, 0, 0);
        checkpoint = new Checkpoint(new Position(20, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(1,1));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSlowDownOf3AndLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(40, 0, 0);
        checkpoint = new Checkpoint(new Position(52, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(2,2));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSlowDownOf2AndLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(40, 0, 0);
        checkpoint = new Checkpoint(new Position(84, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(3,3));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSlowDownOf1AndLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(100, 0, 0);
        checkpoint = new Checkpoint(new Position(115, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(4,4));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(120, 0, 0);
        checkpoint = new Checkpoint(new Position(148, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(5,5));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseSoLowerSailButToFarThanSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(180, 0, 0);
        checkpoint = new Checkpoint(new Position(200, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(5,5));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointNotTooCloseSlowDownOf0AndNotLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(700, 0, 0);
        checkpoint = new Checkpoint(new Position(720, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(5,5));
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooTooCloseSoNullSameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(10, 0, 0);
        checkpoint = new Checkpoint(new Position(15, 0, 0), new Circle(5));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        assertNull(regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseButOptiCheckpointFarSameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(200, 0, 0);
        checkpoint = new Checkpoint(new Position(15, 0, 0), new Circle(5));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(5,5));
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti));
    }

    @Test
    void checkpointTooCloseOptiCheckpointFarButTargetNotOptiCheckpointSameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(200, 0, 0);
        checkpoint = new Checkpoint(new Position(15, 0, 0), new Circle(5));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        assertNull(regattaResolverNotUseWind.resolveToolsToUse(checkpoint.getPosition()));
    }
}
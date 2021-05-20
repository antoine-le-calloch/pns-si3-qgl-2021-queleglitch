package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Rudder;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Watch;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextround.Wind;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

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
        Mockito.when(mockShip.getRudder()).thenReturn(new Rudder());
        Mockito.when(mockShip.getWatch()).thenReturn(new Watch());
        Mockito.when(mockShip.getSails()).thenReturn(new ArrayList<>());

        mockRegattaGoal = Mockito.mock(RegattaGoal.class);

        Sailor []sailors = new Sailor[10];

        regattaResolverUseWind = new RegattaResolver(new InformationGame(sailors,mockShip,mockRegattaGoal,windOrt0));
        regattaResolverNotUseWind = new RegattaResolver(new InformationGame(sailors,mockShip,mockRegattaGoal,windOrtPi));
    }

    @Test
    void checkpointFarSameOrientation_NeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(1100, 0, 0);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LIFT,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointFarSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(1100, 0, 0);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointFarOrientationPIOn4_NeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(1000, 1000, 0);

        ToolsToUse toolsToUse = new ToolsToUse(Math.PI/4,SailAction.LIFT,new NbOarsUsed(3,3), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointFarOrientationPIOn4_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(1000, 1000, 0);

        ToolsToUse toolsToUse = new ToolsToUse(Math.PI/4,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointCloseSameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(125, 0, 0);
        checkpoint = new Checkpoint(new Position(126, 0, 0), new Circle(40));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSlowDownOf1SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(125, 0, 0);
        checkpoint = new Checkpoint(new Position(125, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseNotSlowDownOf2SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(60, 0, 0);
        checkpoint = new Checkpoint(new Position(113, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSlowDownOf2SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(60, 0, 0);
        checkpoint = new Checkpoint(new Position(111, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(3,3), true);
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSlowDownOf3SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(60, 0, 0);
        checkpoint = new Checkpoint(new Position(78, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(2,2), true);
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSlowDownOf4SameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(40, 0, 0);
        checkpoint = new Checkpoint(new Position(45, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(1,1), true);
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSlowDownOf4AndLowerSameSailOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(40, 0, 0);
        checkpoint = new Checkpoint(new Position(20, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(1,1), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSlowDownOf3AndLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(40, 0, 0);
        checkpoint = new Checkpoint(new Position(52, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(2,2), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSlowDownOf2AndLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(40, 0, 0);
        checkpoint = new Checkpoint(new Position(84, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(3,3), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSlowDownOf1AndLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(100, 0, 0);
        checkpoint = new Checkpoint(new Position(115, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(120, 0, 0);
        checkpoint = new Checkpoint(new Position(148, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseSoLowerSailButToFarThanSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(180, 0, 0);
        checkpoint = new Checkpoint(new Position(200, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.LOWER,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointNotTooCloseSlowDownOf0AndNotLowerSailSameOrientation_NeedSail_SailHigh(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(true);
        positionCheckpointOpti = new Position(700, 0, 0);
        checkpoint = new Checkpoint(new Position(720, 0, 0), new Circle(20));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooTooCloseSoNullSameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(10, 0, 0);
        checkpoint = new Checkpoint(new Position(15, 0, 0), new Circle(5));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        assertNull(regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseButOptiCheckpointFarSameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(200, 0, 0);
        checkpoint = new Checkpoint(new Position(15, 0, 0), new Circle(5));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        ToolsToUse toolsToUse = new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true);
        assertEquals(toolsToUse, regattaResolverNotUseWind.resolveToolsToUse(positionCheckpointOpti,true));
    }

    @Test
    void checkpointTooCloseOptiCheckpointFarButTargetNotOptiCheckpointSameOrientation_NotNeedSail_SailLow(){
        Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
        positionCheckpointOpti = new Position(200, 0, 0);
        checkpoint = new Checkpoint(new Position(15, 0, 0), new Circle(5));
        Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint);

        assertNull(regattaResolverNotUseWind.resolveToolsToUse(checkpoint.getPosition(),true));
    }






    @Nested
    class PathFinding{

        RegattaResolver regattaResolver;
        Position position;

        @BeforeEach
        void setUp(){
            Mockito.when(mockShip.getPosition()).thenReturn(new Position(0,0,0));
            mockShip = mock(Ship.class);
            Mockito.when(mockShip.getNbOars()).thenReturn(10);
            Mockito.when(mockShip.getNbSails()).thenReturn(1);
            Mockito.when(mockShip.getPosition()).thenReturn(new Position(0,0,0));
            Mockito.when(mockShip.getRudder()).thenReturn(new Rudder());
            Mockito.when(mockShip.getWatch()).thenReturn(new Watch());
            Mockito.when(mockShip.getSails()).thenReturn(new ArrayList<>());
            mockRegattaGoal = Mockito.mock(RegattaGoal.class);
            Sailor []sailors = new Sailor[10];
            regattaResolver = new RegattaResolver(new InformationGame(sailors,mockShip,mockRegattaGoal,windOrtPi));
        }

        @Test
        void checkPointInFrontOfTheCheckpoint(){
            position=new Position(2000,0,0.0);
            assertEquals(new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true),regattaResolver.resolveToolsToUse(position,false));
        }

        @Test
        void checkPointAtLeftAngleToCorrectMinusThan90(){
            position=new Position(100,100,0.0);
            assertEquals(new ToolsToUse(Math.PI/4,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true),regattaResolver.resolveToolsToUse(position,false));
        }

        @Test
        void checkPointAtRightAngleToCorrectMinusThan90(){
            position=new Position(100,-100,0.0);
            assertEquals(new ToolsToUse(-Math.PI/4,SailAction.DO_NOTHING,new NbOarsUsed(4,4), true),regattaResolver.resolveToolsToUse(position,false));
        }

        @Test
        void checkPointAtLeftAngleToCorrectGreaterThan90(){
            position=new Position(-100,4,0.0);
            assertEquals(new ToolsToUse(Math.PI/4,SailAction.DO_NOTHING,new NbOarsUsed(0,5), true),regattaResolver.resolveToolsToUse(position,false));
        }

        @Test
        void checkPointAtRightAngleToCorrectGreaterThan90(){
            position=new Position(-100,-4,0.0);
            assertEquals(new ToolsToUse(-Math.PI/4,SailAction.DO_NOTHING,new NbOarsUsed(5,0), true),regattaResolver.resolveToolsToUse(position,false));
        }
    }
}
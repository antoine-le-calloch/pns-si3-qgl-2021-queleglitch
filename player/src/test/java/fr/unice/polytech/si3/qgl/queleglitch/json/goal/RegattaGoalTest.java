package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.RegattaResolver;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegattaGoalTest {

    RegattaGoal regattaGoal;
    Position position0;

    @BeforeEach
    void setUp() {
        regattaGoal = new RegattaGoal();
        position0 = new Position(0,0,0);
    }

    @Test
    void findNewPosition_Angle_0__d_100(){
        assertEquals(new Position(100,0,0),regattaGoal.findOptiCheckpoints(position0,0,100));
    }

    @Test
    void findNewPosition_Angle_PIOn4__d_Sqrt20000(){
        assertEquals(new Position(100.00000000000001,100,0),regattaGoal.findOptiCheckpoints(position0,Math.PI/4,Math.sqrt(20000)));
    }

    @Test
    void findNewPosition_Angle_PIOn2__d_100(){
        assertEquals(new Position(6.123233995736766E-15,100,0),regattaGoal.findOptiCheckpoints(position0,Math.PI/2,100));
    }

    @Test
    void findNewPosition_Angle_3PIOn4__d_Sqrt20000(){
        assertEquals(new Position(-100,100.00000000000001,0),regattaGoal.findOptiCheckpoints(position0,3*Math.PI/4,Math.sqrt(20000)));
    }

    @Test
    void findNewPosition_Angle_PI__d_100(){
        assertEquals(new Position(-100,1.2246467991473532E-14,0),regattaGoal.findOptiCheckpoints(position0,Math.PI,100));
    }

    @Test
    void findNewPosition_Angle_Minus3PIOn4__d_Sqrt20000(){
        assertEquals(new Position(-100,-100.00000000000001,0),regattaGoal.findOptiCheckpoints(position0,-3*Math.PI/4,Math.sqrt(20000)));
    }

    @Test
    void findNewPosition_Angle_MinusPIOn2__d_100(){
        assertEquals(new Position(6.123233995736766E-15,-100,0),regattaGoal.findOptiCheckpoints(position0,-Math.PI/2,100));
    }

    @Test
    void findNewPosition_Angle_MinusPIOn4__d_Sqrt20000(){
        assertEquals(new Position(100.00000000000001,-100.0,0),regattaGoal.findOptiCheckpoints(position0,-Math.PI/4,Math.sqrt(20000)));
    }

    ///////calculateOptiCheckpoint

    @Test
    void calculateOptiCheckpoint_100_100_To_100_Minus100(){
        regattaGoal = new RegattaGoal(new Checkpoint[]{new Checkpoint(new Position(100,-100,0), new Circle(100)), new Checkpoint(new Position(100,100,0), new Circle(5))});
        assertEquals(new Position(100,-2,0) ,regattaGoal.getPositionOptiCheckpoints()[0]);
        assertEquals(new Position(100,100,0) ,regattaGoal.getPositionOptiCheckpoints()[1]);
    }

    @Test
    void checkpointReachedtest(){
        regattaGoal = new RegattaGoal(new Checkpoint[]{new Checkpoint(new Position(100,-100,0), new Circle(100)), new Checkpoint(new Position(100,100,0), new Circle(5))});
        assertEquals(0,regattaGoal.getNumActualCheckpoint());
        regattaGoal.checkpointReached();
        assertEquals(1,regattaGoal.getNumActualCheckpoint());
        regattaGoal.checkpointReached();
        // all checkpoints reached
        assertEquals(1,regattaGoal.getNumActualCheckpoint());
    }

    @Test
    void get_Checkpoint_Reach_Test(){
        regattaGoal = new RegattaGoal(new Checkpoint[]{new Checkpoint(new Position(100,-100,0), new Circle(100)), new Checkpoint(new Position(100,100,0), new Circle(5))});
        regattaGoal.setCheckpointReach(true);
        assertTrue(regattaGoal.getCheckpointReach());
        regattaGoal.setCheckpointReach(false);
        assertFalse(regattaGoal.getCheckpointReach());
    }

    @Test
    void getCheckpointsTest(){
        Checkpoint[] checkpoints = new Checkpoint[]{new Checkpoint(new Position(100,-100,0), new Circle(100)), new Checkpoint(new Position(100,100,0), new Circle(5))};
        regattaGoal = new RegattaGoal(checkpoints);
        assertEquals(checkpoints,regattaGoal.getCheckpoints());
        System.out.println(regattaGoal.toString());
    }

    @Test
    void see_List_Of_Checkpoints(){
        Checkpoint[] checkpoints = new Checkpoint[]{new Checkpoint(new Position(100,-100,0), new Circle(100)), new Checkpoint(new Position(100,100,0), new Circle(5))};
        regattaGoal = new RegattaGoal(checkpoints);
        assertEquals(" | Checkpoint | x : 100.0 | y : -100.0 | Checkpoint | x : 100.0 | y : 100.0",regattaGoal.toString());
    }









}
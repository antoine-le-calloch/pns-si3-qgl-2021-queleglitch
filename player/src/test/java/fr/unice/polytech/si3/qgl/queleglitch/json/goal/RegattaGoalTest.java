package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegattaGoalTest {

    RegattaGoal regattaGoal;

    @BeforeEach
    void setUp() {
        regattaGoal = new RegattaGoal();
    }

    @Test
    void findNewPosition_Angle_0__d_100(){
        assertEquals(new Position(100,0,0),regattaGoal.findHowManyToMovePosition(0,100));
    }

    @Test
    void findNewPosition_Angle_PIOn4__d_Sqrt20000(){
        assertEquals(new Position(100.00000000000001,100,0),regattaGoal.findHowManyToMovePosition(Math.PI/4,Math.sqrt(20000)));
    }

    @Test
    void findNewPosition_Angle_PIOn2__d_100(){
        assertEquals(new Position(6.123233995736766E-15,100,0),regattaGoal.findHowManyToMovePosition(Math.PI/2,100));
    }

    @Test
    void findNewPosition_Angle_3PIOn4__d_Sqrt20000(){
        assertEquals(new Position(-100,100.00000000000001,0),regattaGoal.findHowManyToMovePosition(3*Math.PI/4,Math.sqrt(20000)));
    }

    @Test
    void findNewPosition_Angle_PI__d_100(){
        assertEquals(new Position(-100,1.2246467991473532E-14,0),regattaGoal.findHowManyToMovePosition(Math.PI,100));
    }

    @Test
    void findNewPosition_Angle_Minus3PIOn4__d_Sqrt20000(){
        assertEquals(new Position(-100,-100.00000000000001,0),regattaGoal.findHowManyToMovePosition(-3*Math.PI/4,Math.sqrt(20000)));
    }

    @Test
    void findNewPosition_Angle_MinusPIOn2__d_100(){
        assertEquals(new Position(6.123233995736766E-15,-100,0),regattaGoal.findHowManyToMovePosition(-Math.PI/2,100));
    }

    @Test
    void findNewPosition_Angle_MinusPIOn4__d_Sqrt20000(){
        assertEquals(new Position(100.00000000000001,-100.0,0),regattaGoal.findHowManyToMovePosition(-Math.PI/4,Math.sqrt(20000)));
    }

    ///////calculateOptiCheckpoint

    @Test
    void calculateOptiCheckpoint_100_100_To_100_Minus100(){
        regattaGoal = new RegattaGoal(new Checkpoint[]{new Checkpoint(new Position(100,-100,0), new Circle(100)), new Checkpoint(new Position(100,100,0), new Circle(5))});
        assertEquals(new Position(100,-2,0) ,regattaGoal.getPositionOptiCheckpoints()[0]);
        assertEquals(new Position(100,100,0) ,regattaGoal.getPositionOptiCheckpoints()[1]);
    }
}
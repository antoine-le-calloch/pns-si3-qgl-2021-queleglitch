package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
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
    void findNewPosition_Angle0_d100(){
        assertEquals(new Position(100,0,0),regattaGoal.findNewPosition(0,100));
    }
}
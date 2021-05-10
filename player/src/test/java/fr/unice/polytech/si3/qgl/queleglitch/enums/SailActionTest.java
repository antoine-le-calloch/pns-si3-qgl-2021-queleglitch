package fr.unice.polytech.si3.qgl.queleglitch.enums;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Sail;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SailActionTest {

    SailAction liftAction;
    SailAction doNothingAction;
    SailAction lowerAction;


    @BeforeEach
    void setUp(){
        liftAction = SailAction.LIFT;
        doNothingAction = SailAction.DO_NOTHING;
        lowerAction = SailAction.LOWER;
    }


    void toStringMethod(){
        assertEquals("Lift",liftAction.toString());
        assertEquals("Lower",lowerAction.toString());
        assertEquals("Do nothing",doNothingAction.toString());
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {


    LiftSail liftSail;
    LowerSail lowerSail;

    @BeforeEach
    void setUp(){
        liftSail= new LiftSail(1);
        lowerSail= new LowerSail(2);
    }

    @Test
    void sameId(){
        assertNotEquals(liftSail,lowerSail);
    }

    @Test
    void differentId(){
        assertEquals(liftSail,liftSail);
    }
}
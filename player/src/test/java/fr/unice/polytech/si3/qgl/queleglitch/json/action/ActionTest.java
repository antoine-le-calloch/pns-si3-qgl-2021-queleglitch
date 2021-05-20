package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {


    LiftSail liftSail;
    LowerSail liftSail2;

    @BeforeEach
    void setUp(){
        liftSail= new LiftSail(1);
        liftSail2= new LowerSail(2);
    }

    @Test
    void sameId(){
        assertEquals(liftSail,liftSail);
    }

    @Test
    void differentId(){
        assertNotEquals(liftSail,liftSail2);
    }
}
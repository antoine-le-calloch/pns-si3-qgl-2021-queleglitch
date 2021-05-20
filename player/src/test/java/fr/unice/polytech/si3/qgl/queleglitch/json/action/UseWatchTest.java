package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseWatchTest {

    UseWatch useWatchTest;
    UseWatch useWatchTest2;

    @BeforeEach
    void setUp(){
        useWatchTest = new UseWatch(3);
        useWatchTest2 = new UseWatch(3);
    }

    @Test
    void getTrueType() {
        assertEquals("USE_WATCH",useWatchTest.getType());
    }

    @Test
    void Equality_Test() {
        assertEquals(useWatchTest,useWatchTest2);
    }
}
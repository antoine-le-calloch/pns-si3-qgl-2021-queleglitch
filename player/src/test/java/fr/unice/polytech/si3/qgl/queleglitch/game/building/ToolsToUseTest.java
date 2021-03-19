package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolsToUseTest {

    ToolsToUse toolsToUse;

    @BeforeEach
    void setUp() {
    }

    @Test
    void angle0_rudder0_1Left_1RightOarUse() {
        toolsToUse = new ToolsToUse(0,0,0,0);
        assertEquals(0,toolsToUse.angle());
    }

    @Test
    void anglePI_rudderPI_1Left_1RightOarUse() {
        toolsToUse = new ToolsToUse(Math.PI,0,0,0);
        assertEquals(Math.PI,toolsToUse.angle());
    }

    @Test
    void speed() {
    }
}
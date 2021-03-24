package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolsToUseTest {

    ToolsToUse toolsToUse0;
    ToolsToUse toolsToUse1;

    @BeforeEach
    void setUp() {
        toolsToUse0 = new ToolsToUse(0, SailAction.DO_NOTHING, new NbOarsUsed(0,0));
        toolsToUse1 = new ToolsToUse(1, SailAction.LIFT, new NbOarsUsed(1,1));
    }

    ///////////////////////////////////////////////// equals() ////////////////////////////////////////////

    @Test
    void equals_SameObj(){
        assertEquals(toolsToUse0, toolsToUse0);
    }

    @Test
    void equals_All0(){
        assertEquals(toolsToUse0, new ToolsToUse(0,SailAction.DO_NOTHING,new NbOarsUsed(0,0)));
    }

    @Test
    void equals_All1(){
        assertEquals(toolsToUse1, new ToolsToUse(1,SailAction.LIFT,new NbOarsUsed(1,1)));
    }

    @Test
    void NotEquals_All1_All0(){
        assertNotEquals(toolsToUse1, toolsToUse0);
    }

    ///////////////////////////////////////////////// toString() ////////////////////////////////////////////

    @Test
    void sameString_All0_All0(){
        assertEquals(toolsToUse0.toString(), toolsToUse0.toString());
    }
}
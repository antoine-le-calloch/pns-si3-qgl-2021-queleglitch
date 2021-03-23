package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.Cockpit;
import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolsToUseTest {

    ToolsToUse toolsToUse0;
    ToolsToUse toolsToUse1;

    @BeforeEach
    void setUp() {
        toolsToUse0 = new ToolsToUse(0, VoileAction.DO_NOTHING, new int[]{0,0});
        toolsToUse1 = new ToolsToUse(1, VoileAction.LIFT, new int[]{1,1});
    }

    ///////////////////////////////////////////////// equals() ////////////////////////////////////////////

    @Test
    void equals_SameObj(){
        assertEquals(toolsToUse0, toolsToUse0);
    }

    @Test
    void equals_All0(){
        assertEquals(toolsToUse0, new ToolsToUse(0,VoileAction.DO_NOTHING,new int[]{0,0}));
    }

    @Test
    void equals_All1(){
        assertEquals(toolsToUse1, new ToolsToUse(1,VoileAction.LIFT,new int[]{1,1}));
    }

    @Test
    void NotEquals_All1_All0(){
        assertNotEquals(toolsToUse1, toolsToUse0);
    }

    @Test
    void NotEquals_NotInstanceOf(){ assertNotEquals(toolsToUse0,new Cockpit());}

    ///////////////////////////////////////////////// toString() ////////////////////////////////////////////

    @Test
    void sameString_All0_All0(){
        assertEquals(toolsToUse0.toString(), toolsToUse0.toString());
    }
}
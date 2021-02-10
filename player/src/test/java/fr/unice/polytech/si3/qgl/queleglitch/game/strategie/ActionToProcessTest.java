package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.queleglitch.Cockpit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionToProcessTest {

    Cockpit cockpit;
    ObjectMapper objectMapper;
    createActions createActions;


    @BeforeEach
    void setUp(){
        this.cockpit = new Cockpit();
        objectMapper = new ObjectMapper();
        String enter = "{\"goal\":{\"mode\":\"REGATTA\",\"checkpoints\":[{\"position\":{\"x\":1000,\"y\":0,\"orientation\":0},\"shape\":{\"type\":\"circle\",\"radius\":50}},{\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"shape\":{\"type\":\"circle\",\"radius\":50}}]},\"ship\":{\"type\":\"ship\",\"life\":100,\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"name\":\"Lescopaingsd'abord!\",\"deck\":{\"width\":2,\"length\":4},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":2,\"y\":0,\"type\":\"oar\"},{\"x\":3,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"oar\"},{\"x\":3,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"sail\",\"openned\":false},{\"x\":5,\"y\":0,\"type\":\"rudder\"}],\"shape\":{\"type\":\"rectangle\",\"width\":2,\"height\":4,\"orientation\":0}},\"sailors\":[{\"x\":0,\"y\":1,\"id\":0,\"name\":\"EdwardPouce\"},{\"x\":0,\"y\":1,\"id\":1,\"name\":\"TomPouce\"},{\"x\":0,\"y\":1,\"id\":2,\"name\":\"LoicPouce\"},{\"x\":0,\"y\":1,\"id\":3,\"name\":\"AntoinePouce\"}]}";
        cockpit.initGame(enter);
        //this.createActions = new createActions(cockpit.getInitGame());
    }

/*    @Test
    void move2SailorsOnEachSide(){
        createActions.buldingActions(2,2);
        assertEquals(2,cockpit.getInitGame().getSailorsAtRight().size());
        assertEquals(2,cockpit.getInitGame().getSailorsAtLeft().size());
    }

    @Test
    void move3SailorsOnLeft1OnRight(){
        createActions.buldingActions(3,1);
        assertEquals(1,cockpit.getInitGame().getSailorsAtRight().size());
        assertEquals(3,cockpit.getInitGame().getSailorsAtLeft().size());
    }*/
}
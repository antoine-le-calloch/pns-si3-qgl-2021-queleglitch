package fr.unice.polytech.si3.qgl.queleglitch;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CockpitTest {


    Cockpit cockpit;
    ObjectMapper objectMapper;
    String init;
    String nextRound;

    @BeforeEach
    void setUp() {
        final int FIRST_OAR = 0;
        this.cockpit = new Cockpit();
        objectMapper = new ObjectMapper();
        init = "{\"goal\":{\"mode\":\"REGATTA\",\"checkpoints\":[{\"position\":{\"x\":-221.64276401564362,\"y\":-833.3333333333336,\"orientation\":0.0},\"shape\":{\"type\":\"circle\",\"radius\":100.0}},{\"position\":{\"x\":-200.0,\"y\":1000.0,\"orientation\":0.0},\"shape\":{\"type\":\"circle\",\"radius\":80.0}}]},\"ship\":{\"type\":\"ship\",\"position\":{\"x\":0.0,\"y\":0.0,\"orientation\":0.0},\"name\":\"queleglitch\",\"deck\":{\"width\":2,\"length\":4},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":0,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"oar\"},{\"x\":3,\"y\":0,\"type\":\"oar\"},{\"x\":3,\"y\":1,\"type\":\"oar\"}],\"life\":300,\"shape\":{\"type\":\"rectangle\",\"width\":2.0,\"height\":4.0,\"orientation\":0.0}},\"sailors\":[{\"x\":0,\"y\":0,\"id\":0,\"name\":\"Luffy Pouce\"},{\"x\":0,\"y\":1,\"id\":1,\"name\":\"Edward Teach\"},{\"x\":1,\"y\":0,\"id\":2,\"name\":\"Edward Teach\"},{\"x\":1,\"y\":1,\"id\":3,\"name\":\"Tom Teach\"}],\"shipCount\":1}";
        cockpit.initGame(init);
    }

    @Test
    void nextRoundTest(){
        nextRound = "{\"ship\":{\"type\":\"ship\",\"position\":{\"x\":0.0,\"y\":0.0,\"orientation\":0.0},\"name\":\"queleglitch\",\"deck\":{\"width\":2,\"length\":4},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":0,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"oar\"},{\"x\":3,\"y\":0,\"type\":\"oar\"},{\"x\":3,\"y\":1,\"type\":\"oar\"}],\"life\":300,\"shape\":{\"type\":\"rectangle\",\"width\":2.0,\"height\":4.0,\"orientation\":0.0}},\"visibleEntities\":[],\"wind\":{\"orientation\":0.0,\"strength\":0.0}}";
        String nextRoundOut = cockpit.nextRound(nextRound);
        assertEquals("[{\"sailorId\":0,\"type\":\"MOVING\",\"xdistance\":1,\"ydistance\":0},{\"sailorId\":1,\"type\":\"MOVING\",\"xdistance\":2,\"ydistance\":-1},{\"sailorId\":2,\"type\":\"MOVING\",\"xdistance\":2,\"ydistance\":0},{\"sailorId\":0,\"type\":\"OAR\"},{\"sailorId\":1,\"type\":\"OAR\"},{\"sailorId\":2,\"type\":\"OAR\"}]",nextRoundOut);
    }
}
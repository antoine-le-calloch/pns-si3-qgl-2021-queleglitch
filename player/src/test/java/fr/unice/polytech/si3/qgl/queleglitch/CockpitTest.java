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
    int FIRST_OAR;

    @BeforeEach
    void setUp() {
        final int FIRST_OAR=0;
        this.cockpit = new Cockpit();
        objectMapper = new ObjectMapper();
        init = "{\"goal\": {\"mode\": \"REGATTA\",\"checkpoints\": [{\"position\": {\"x\": 1000,\"y\": 0,\"orientation\": 0},\"shape\": {\"type\": \"circle\",\"radius\": 50}},{\"position\": {\"x\": 0,\"y\": 0,\"orientation\": 0},\"shape\": {\"type\": \"circle\",\"radius\": 50}}]},\"ship\": {\"type\": \"ship\",\"life\": 100,\"position\": {\"x\": 0,\"y\": 0,\"orientation\": 0},\"name\": \"Les copaings d'abord!\",\"deck\": {\"width\": 2,\"length\": 4},\"entities\": [{\"x\": 0,\"y\": 0,\"type\": \"oar\"},{\"x\": 1,\"y\": 0,\"type\": \"oar\"},{\"x\": 2,\"y\": 0,\"type\": \"oar\"},{\"x\": 0,\"y\": 1,\"type\": \"oar\"},{\"x\": 1,\"y\": 1,\"type\": \"oar\"},{\"x\": 2,\"y\": 1,\"type\": \"oar\"},{\"x\": 2,\"y\": 1,\"type\": \"sail\",\"openned\": false},{\"x\": 3,\"y\": 0,\"type\": \"rudder\"}],\"shape\": {\"type\": \"rectangle\",\"width\": 3,\"height\": 6,\"orientation\": 0}},\"sailors\": [{\"x\": 0,\"y\": 0,\"id\": 0,\"name\": \"Edward Teach\"},{\"x\": 0,\"y\": 1,\"id\": 1,\"name\": \"Edward Pouce\"},{\"x\": 0,\"y\": 2,\"id\": 2,\"name\": \"Tom Pouce\"},{\"x\": 1,\"y\": 0,\"id\": 3,\"name\": \"Jack Teach\"}]}";
    }

    /*@Test
    void nextRoundTest(){
        nextRound = "{\"ship\":{\"type\":\"ship\",\"life\":100,\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"name\":\"Lescopaingsd'abord!\",\"deck\":{\"width\":2,\"length\":4},\"entities\": [{\"x\": 0,\"y\": 0,\"type\": \"oar\"},{\"x\": 1,\"y\": 0,\"type\": \"oar\"},{\"x\": 2,\"y\": 0,\"type\": \"oar\"},{\"x\": 0,\"y\": 1,\"type\": \"oar\"},{\"x\": 1,\"y\": 1,\"type\": \"oar\"},{\"x\": 2,\"y\": 1,\"type\": \"oar\"},{\"x\": 2,\"y\": 1,\"type\": \"sail\",\"openned\": false},{\"x\": 3,\"y\": 0,\"type\": \"rudder\"}],\"shape\":{\"type\":\"rectangle\",\"width\":2,\"height\":4,\"orientation\":0}}}";
        String nextRoundOut;
        nextRoundOut = cockpit.nextRound(nextRound);
        assertEquals("[{\"type\":\"MOVING\",\"sailorId\":2,\"xdistance\":1,\"ydistance\":1},{\"type\":\"MOVING\",\"sailorId\":3,\"xdistance\":0,\"ydistance\":0},{\"type\":\"MOVING\",\"sailorId\":4,\"xdistance\":0,\"ydistance\":0},{\"type\":\"MOVING\",\"sailorId\":5,\"xdistance\":3,\"ydistance\":0},{\"type\":\"OAR\",\"sailorId\":2},{\"type\":\"OAR\",\"sailorId\":3},{\"type\":\"OAR\",\"sailorId\":4},{\"type\":\"OAR\",\"sailorId\":5}]",nextRoundOut);
    }

    @Test
    void LogTest() {
        assertEquals("[NEW TURN, Ship coordinates: , Bateau | orientation : 0.0 | x : 0.0 | y : 0.0,  ---- , Checkpoint coordinates: ,  | Checkpoint | x : 1000.0 | y : 0.0 | Checkpoint | x : 0.0 | y : 0.0,  ---- , Marin 2 | position x : 0 | position y : 1,  ---- , Marin 3 | position x : 0 | position y : 1,  ---- , Marin 4 | position x : 1 | position y : 0,  ---- , Marin 5 | position x : 1 | position y : 0]",cockpit.getLogs().toString());
    }
    

    @Test
    void wrongOarSelected(){
        final int SECOND_OAR=1;
        assertNotEquals(cockpit.informationGame.getShip().getEntities()[SECOND_OAR],cockpit.informationGame.getShip().getEntities()[FIRST_OAR]);
    }

    @Test
    void goodOarSelected(){
        int xExpectedOfTheFirstOar=1;
        int yExpectedOfTheFirstOar=0;
        Rame rame=(Rame)cockpit.informationGame.getShip().getEntities()[FIRST_OAR];
        assertEquals(rame.getX(),xExpectedOfTheFirstOar);
        assertEquals(rame.getY(),yExpectedOfTheFirstOar);
    }*/
}
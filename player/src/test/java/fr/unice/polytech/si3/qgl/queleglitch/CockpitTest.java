package fr.unice.polytech.si3.qgl.queleglitch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.queleglitch.Cockpit;
import fr.unice.polytech.si3.qgl.queleglitch.entitie.Rame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CockpitTest {


    Cockpit cockpit;
    ObjectMapper objectMapper;
    String enter;
    int FIRST_OAR;

    @BeforeEach
    void setUp() {
        final int FIRST_OAR=0;
        this.cockpit = new Cockpit();
        objectMapper = new ObjectMapper();
        enter="{\"goal\":{\"mode\":\"REGATTA\",\"checkpoints\":[{\"position\":{\"x\":1000,\"y\":0,\"orientation\":0},\"shape\":{\"type\":\"circle\",\"radius\":50}},{\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"shape\":{\"type\":\"circle\",\"radius\":50}}]},\"ship\":{\"type\":\"ship\",\"life\":100,\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"name\":\"Lescopaingsd'abord!\",\"deck\":{\"width\":3,\"length\":6},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":2,\"type\":\"oar\"},{\"x\":3,\"y\":0,\"type\":\"oar\"},{\"x\":3,\"y\":2,\"type\":\"oar\"},{\"x\":4,\"y\":0,\"type\":\"oar\"},{\"x\":4,\"y\":2,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"sail\",\"openned\":false},{\"x\":5,\"y\":0,\"type\":\"rudder\"}],\"shape\":{\"type\":\"rectangle\",\"width\":3,\"height\":6,\"orientation\":0}},\"sailors\":[{\"x\":0,\"y\":1,\"id\":2,\"name\":\"EdwardPouce\"},{\"x\":0,\"y\":2,\"id\":3,\"name\":\"TomPouce\"}]}";
        cockpit.initGame(enter);
    }

    @Test
    void nextRoundTest(){
        assertEquals("[{\"type\":\"OAR\",\"sailorId\":2},{\"type\":\"OAR\",\"sailorId\":3}]",cockpit.nextRound(""));
    }

    @Test
    void LogTest() {
        assertEquals("[NEW TURN, Ship coordinates: , Bateau | orientation : 0.0 | x : 0.0 | y : 0.0,  ---- , Checkpoint coordinates: ,  | Checkpoint | x : 1000.0 | y : 0.0 | Checkpoint | x : 0.0 | y : 0.0,  ---- , Marin 2 | position x : 0 | position y : 1,  ---- , Marin 3 | position x : 0 | position y : 2]",cockpit.getLogs().toString());
    }

    @Test
    void entitieInexistant(){
        final int OUT_OF_BOUND=6;
        assertNull(cockpit.initGame.getShip().getEntities()[OUT_OF_BOUND]);
    }

    @Test
    void wrongOarSelected(){
        final int SECOND_OAR=1;
        assertNotEquals(cockpit.initGame.getShip().getEntities()[SECOND_OAR],cockpit.initGame.getShip().getEntities()[FIRST_OAR]);
    }

    @Test
    void goodOarSelected(){
        int xExpectedOfTheFirstOar=1;
        int yExpectedOfTheFirstOar=0;
        Rame rame=(Rame)cockpit.initGame.getShip().getEntities()[FIRST_OAR];
        assertEquals(rame.getX(),xExpectedOfTheFirstOar);
        assertEquals(rame.getY(),yExpectedOfTheFirstOar);
    }
}
package fr.unice.polytech.si3.qgl.queleglitch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.queleglitch.Cockpit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CockpitTest {

    Cockpit cockpit;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.cockpit = new Cockpit();
        objectMapper = new ObjectMapper();
    }

    @Test
    void nextRoundTest(){
        cockpit.initGame("{\"goal\":{\"mode\":\"REGATTA\",\"checkpoints\":[{\"position\":{\"x\":1000,\"y\":0,\"orientation\":0},\"shape\":{\"type\":\"circle\",\"radius\":50}},{\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"shape\":{\"type\":\"circle\",\"radius\":50}}]},\"ship\":{\"type\":\"ship\",\"life\":100,\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"name\":\"Lescopaingsd'abord!\",\"deck\":{\"width\":3,\"length\":6},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":2,\"type\":\"oar\"},{\"x\":3,\"y\":0,\"type\":\"oar\"},{\"x\":3,\"y\":2,\"type\":\"oar\"},{\"x\":4,\"y\":0,\"type\":\"oar\"},{\"x\":4,\"y\":2,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"sail\",\"openned\":false},{\"x\":5,\"y\":0,\"type\":\"rudder\"}],\"shape\":{\"type\":\"rectangle\",\"width\":3,\"height\":6,\"orientation\":0}},\"sailors\":[{\"x\":0,\"y\":1,\"id\":2,\"name\":\"EdwardPouce\"},{\"x\":0,\"y\":2,\"id\":3,\"name\":\"TomPouce\"}]}");
        assertEquals("{\"sailorId\":2,\"type\":\"OAR\"}{\"sailorId\":3,\"type\":\"OAR\"}",cockpit.nextRound(""));
    }
}
package fr.unice.polytech.si3.qgl.queleglitch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class CockpitTest {

    String nextRound = "";
    Cockpit cockpit;

    @BeforeEach
    void setUp() throws IOException {
        BufferedReader initGameFile = new BufferedReader(new FileReader("initGameFile"));
        cockpit = new Cockpit();
        cockpit.initGame(initGameFile.readLine());
        initGameFile.close();

    }

    @Test
    void nextRoundTest() throws IOException {
        BufferedReader nextRoundFile = new BufferedReader(new FileReader("nextRoundFile"));
        String line;

        while ((line = nextRoundFile.readLine()) != null)
            nextRound += line;
        nextRoundFile.close();

        String nextRoundOut = cockpit.nextRound(nextRound);
        assertEquals("[{\"sailorId\":0,\"type\":\"MOVING\",\"xdistance\":1,\"ydistance\":0},{\"sailorId\":1,\"type\":\"MOVING\",\"xdistance\":2,\"ydistance\":-1},{\"sailorId\":2,\"type\":\"MOVING\",\"xdistance\":2,\"ydistance\":0},{\"sailorId\":0,\"type\":\"OAR\"},{\"sailorId\":1,\"type\":\"OAR\"},{\"sailorId\":2,\"type\":\"OAR\"}]",nextRoundOut);
    }
}
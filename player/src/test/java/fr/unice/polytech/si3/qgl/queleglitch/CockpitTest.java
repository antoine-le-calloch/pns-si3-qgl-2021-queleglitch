package fr.unice.polytech.si3.qgl.queleglitch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class CockpitTest {

    String initGame = "";
    String nextRound = "";
    String round2 = "";
    String output = "";
    Cockpit cockpit;

    @BeforeEach
    void setUp() throws IOException {
        BufferedReader initGameFile = new BufferedReader(new FileReader("initGameFile"));
        String line;

        while ((line = initGameFile.readLine()) != null)
            initGame += line;
        initGameFile.close();

        cockpit = new Cockpit();
        cockpit.initGame(initGame.replaceAll("\\s", ""));

    }
/*
    @Test
    void nextRoundTest() throws IOException {
        BufferedReader nextRoundFile = new BufferedReader(new FileReader("nextRoundFile"));
        BufferedReader round2File = new BufferedReader(new FileReader("round2File"));
        BufferedReader outputFile = new BufferedReader(new FileReader("outputFile"));
        String line;

        while ((line = nextRoundFile.readLine()) != null)
            nextRound += line;
        nextRoundFile.close();

        while ((line = outputFile.readLine()) != null)
            output += line.replaceAll("\\s", "");
        outputFile.close();

        String nextRoundOut = cockpit.nextRound(nextRound);
        System.out.println(nextRoundOut);

        while ((line = round2File.readLine()) != null)
            round2 += line;
        round2File.close();

        String round2Out = cockpit.nextRound(round2);
        System.out.println(round2Out);
    }*/
}
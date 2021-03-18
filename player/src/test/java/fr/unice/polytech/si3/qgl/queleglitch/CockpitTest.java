package fr.unice.polytech.si3.qgl.queleglitch;

import static org.junit.jupiter.api.Assertions.*;

import fr.unice.polytech.si3.qgl.queleglitch.fileReader.FileOpener;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CockpitTest {

    FileOpener fileOpener;
    Cockpit cockpitGame2;

    @BeforeEach
    void setUp() {
        fileOpener = new FileOpener("src\\test\\java\\fr\\unice\\polytech\\si3\\qgl\\queleglitch\\txtJson\\test");

        cockpitGame2 = new Cockpit();
        cockpitGame2.initGame(fileOpener.getTxtInFile("2\\initGameFile"));
    }

    @Test
    void Test_input1() {
        Cockpit cockpitGame1 = new Cockpit();
        cockpitGame1.initGame(fileOpener.getTxtInFile("1\\initGameFile"));
        String actualOutput = cockpitGame1.nextRound(fileOpener.getTxtInFile("1\\nextRoundFile"));

        assertEquals(fileOpener.getTxtInFile("1\\outputFile"),actualOutput);
    }

    @Test
    void Test_input2_HowToReachCheckpoint2WEEK6() {
        ((RegattaGoal) cockpitGame2.informationGame.goal).numActualCheckpoint = 2;

        String actualOutput = cockpitGame2.nextRound(fileOpener.getTxtInFile("2\\nextRoundFile"));

        assertEquals(fileOpener.getTxtInFile("2\\outputFile"),actualOutput);
    }

    @Test
    void Test_input2_HowToReachCheckpoint2WEEK6_NextRound() {
        ((RegattaGoal) cockpitGame2.informationGame.goal).numActualCheckpoint = 2;

        String actualOutput = cockpitGame2.nextRound(fileOpener.getTxtInFile("2\\nextRoundFile_roundNext"));

        assertEquals(fileOpener.getTxtInFile("2\\outputFile_roundNext"),actualOutput);
    }
}
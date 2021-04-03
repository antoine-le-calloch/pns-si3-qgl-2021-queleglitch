//package fr.unice.polytech.si3.qgl.queleglitch;

/*import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class CockpitTest {

    Cockpit cockpitGame2;
    String path;

    @BeforeEach
    void setUp() {
        path = "\\txtJson\\test";

        cockpitGame2 = new Cockpit();
        cockpitGame2.initGame(getTxtInFile("2\\initGameFile"));
    }

    @Test
    void Test_input1() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("1\\initGameFile"));
        String actualOutput = cockpitGame.nextRound(getTxtInFile("1\\nextRoundFile"));

        assertEquals(getTxtInFile("1\\outputFile"), actualOutput);
    }

    @Test
    void Test_input2_HowToReachCheckpoint2WEEK6() {
        cockpitGame2.informationGame.getRegattaGoal().setNumActualCheckpoint(2);

        String actualOutput = cockpitGame2.nextRound(getTxtInFile("2\\nextRoundFile"));

        assertEquals(getTxtInFile("2\\outputFile"), actualOutput);
    }

    @Test
    void Test_input2_HowToReachCheckpoint2WEEK6_NextRound() {
        cockpitGame2.informationGame.getRegattaGoal().setNumActualCheckpoint(2);

        String actualOutput = cockpitGame2.nextRound(getTxtInFile("2\\nextRoundFile_roundNext"));

        assertEquals(getTxtInFile("2\\outputFile_roundNext"), actualOutput);
    }

    @Test
    void Test_input3() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("3\\initGameFile"));
        String actualOutput = cockpitGame.nextRound(getTxtInFile("3\\nextRoundFile"));

        assertEquals(getTxtInFile("3\\outputFile"), actualOutput);
    }

    @Test
    void Test_input4() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("4\\initGameFile"));

        cockpitGame.informationGame.getRegattaGoal().setNumActualCheckpoint(2);
        String actualOutput = cockpitGame.nextRound(getTxtInFile("4\\nextRoundFile"));

        assertEquals(getTxtInFile("4\\outputFile"), actualOutput);
    }

    @Test
    void Test_input5() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("5\\initGameFile"));

        cockpitGame.informationGame.getRegattaGoal().setNumActualCheckpoint(1);
        String actualOutput = cockpitGame.nextRound(getTxtInFile("5\\nextRoundFile"));

        assertEquals(getTxtInFile("5\\outputFile"), actualOutput);
    }

    @Test
    void Test_input6() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("6\\initGameFile"));

        cockpitGame.informationGame.getRegattaGoal().setNumActualCheckpoint(1);
        String actualOutput = cockpitGame.nextRound(getTxtInFile("6\\nextRoundFile"));

        assertEquals(getTxtInFile("6\\outputFile"), actualOutput);
    }

    @Test
    void Test_input7() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("7\\initGameFile"));

        String actualOutput = cockpitGame.nextRound(getTxtInFile("7\\nextRoundFile"));

        assertEquals(getTxtInFile("7\\outputFile"), actualOutput);
    }

    @Test
    void Test_input8() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("8\\initGameFile"));

        String actualOutput = cockpitGame.nextRound(getTxtInFile("8\\nextRoundFile"));

        assertEquals(getTxtInFile("8\\outputFile"), actualOutput);
    }

    @Test
    void Test_input9() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("9\\initGameFile"));

        String actualOutput = cockpitGame.nextRound(getTxtInFile("9\\nextRoundFile"));

        assertEquals(getTxtInFile("9\\outputFile"), actualOutput);
    }

    ///////////methode to open the text file with Json
    private String getTxtInFile(String fileName) {
        try {
            InputStream inputStream = CockpitTest.class.getResourceAsStream(path + fileName);
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isReader);
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString().replaceAll("\\s", "");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}*/
package fr.unice.polytech.si3.qgl.queleglitch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class CockpitTest {

    String path;

    @BeforeEach
    void setUp() {
        path = "\\txtJson\\test";
    }

    /*@Test
    void Test_inputRound0() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("Round0\\initGameFile"));
        String actualOutput = cockpitGame.nextRound(getTxtInFile("Round0\\nextRound1File"));

        assertEquals(getTxtInFile("Round0\\output1File"), actualOutput);

        System.out.println();

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round0\\nextRound2File"));

        assertEquals(getTxtInFile("Round0\\output2File"), actualOutput);
    }*/

    /*@Test
    void Test_inputRound0Week11() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("Round0Week11\\initGameFile"));
        String actualOutput = cockpitGame.nextRound(getTxtInFile("Round0Week11\\nextRound1File"));

        assertEquals(getTxtInFile("Round0Week11\\output1File"), actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round0Week11\\nextRound2File"));

        assertEquals(getTxtInFile("Round0Week11\\output2File"), actualOutput);
    }

    @Test
    void Test_inputRound44Week11() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("Round44Week11\\initGameFile"));
        cockpitGame.informationGame.getRegattaGoal().setNumActualCheckpoint(2);
        String actualOutput = cockpitGame.nextRound(getTxtInFile("Round44Week11\\nextRoundMinus1File"));

        assertEquals(getTxtInFile("Round44Week11\\outputMinus1File"), actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round44Week11\\nextRound1File"));

        assertEquals(getTxtInFile("Round44Week11\\output1File"), actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round44Week11\\nextRound2File"));

        assertEquals(getTxtInFile("Round44Week11\\output2File"), actualOutput);
    }*/

    /*@Test
    void Test_input1() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("1\\initGameFile"));
        String actualOutput = cockpitGame.nextRound(getTxtInFile("1\\nextRoundFile"));

        assertEquals(getTxtInFile("1\\outputFile"), actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("1\\nextRound2File"));

        assertEquals(getTxtInFile("1\\output2File"), actualOutput);
    }


    @Test
    void Test_inputRound14() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("Round14\\initGameFile"));
        cockpitGame.informationGame.getRegattaGoal().setNumActualCheckpoint(1);
        String actualOutput = cockpitGame.nextRound(getTxtInFile("Round14\\nextRoundMinus2File"));

        assertEquals(getTxtInFile("Round14\\outputMinus2File"), actualOutput);

        System.out.println(actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round14\\nextRoundMinus1File"));

        assertEquals(getTxtInFile("Round14\\outputMinus1File"), actualOutput);

        System.out.println(actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round14\\nextRound1File"));

        assertEquals(getTxtInFile("Round14\\output1File"), actualOutput);

        System.out.println(actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round14\\nextRound2File"));

        assertEquals(getTxtInFile("Round14\\output2File"), actualOutput);
    }*/

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
            return null; }
    }
}
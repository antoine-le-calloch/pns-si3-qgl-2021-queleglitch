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

    @Test
    void Test_inputRound0() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("Round0\\initGameFile"));
        String actualOutput = cockpitGame.nextRound(getTxtInFile("Round0\\nextRound1File"));

        assertEquals(getTxtInFile("Round0\\output1File"), actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round0\\nextRound2File"));

        assertEquals(getTxtInFile("Round0\\output2File"), actualOutput);
    }

    @Test
    void Test_inputRound0Week3P() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("Round0Week3P\\initGameFile"));
        String actualOutput = cockpitGame.nextRound(getTxtInFile("Round0Week3P\\nextRound1File"));

        assertEquals(getTxtInFile("Round0Week3P\\output1File"), actualOutput);
    }

    @Test
    void Test_inputRound0Week11() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("Round0Week11\\initGameFile"));
        String actualOutput = cockpitGame.nextRound(getTxtInFile("Round0Week11\\nextRound1File"));

        assertEquals(getTxtInFile("Round0Week11\\output1File"), actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("Round0Week11\\nextRound2File"));

        assertEquals(getTxtInFile("Round0Week11\\output2File"), actualOutput);
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
            return null; }
    }
}
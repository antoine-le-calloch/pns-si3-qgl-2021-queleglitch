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
    void Test_input1() {
        Cockpit cockpitGame = new Cockpit();
        cockpitGame.initGame(getTxtInFile("1\\initGameFile"));
        cockpitGame.informationGame.getRegattaGoal().setNumActualCheckpoint(1);
        cockpitGame.nextRound(getTxtInFile("1\\nextRoundMin1File"));

        String actualOutput = cockpitGame.nextRound(getTxtInFile("1\\nextRoundFile"));

        assertEquals(getTxtInFile("1\\outputFile"), actualOutput);

        actualOutput = cockpitGame.nextRound(getTxtInFile("1\\nextRound2File"));

        assertEquals(getTxtInFile("1\\output2File"), actualOutput);
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
            return null;
        }
    }
}
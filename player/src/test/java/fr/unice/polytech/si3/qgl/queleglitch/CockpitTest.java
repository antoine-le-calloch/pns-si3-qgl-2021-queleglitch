package fr.unice.polytech.si3.qgl.queleglitch;

import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import static org.junit.jupiter.api.Assertions.*;
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
        Cockpit cockpitGame1 = new Cockpit();
        cockpitGame1.initGame(getTxtInFile("1\\initGameFile"));
        String actualOutput = cockpitGame1.nextRound(getTxtInFile("1\\nextRoundFile"));

        assertEquals(getTxtInFile("1\\outputFile"), actualOutput);
    }

    @Test
    void Test_input2_HowToReachCheckpoint2WEEK6() {
        ((RegattaGoal) cockpitGame2.informationGame.goal).numActualCheckpoint = 2;

        String actualOutput = cockpitGame2.nextRound(getTxtInFile("2\\nextRoundFile"));

        assertEquals(getTxtInFile("2\\outputFile"), actualOutput);
    }

    @Test
    void Test_input2_HowToReachCheckpoint2WEEK6_NextRound() {
        ((RegattaGoal) cockpitGame2.informationGame.goal).numActualCheckpoint = 2;

        String actualOutput = cockpitGame2.nextRound(getTxtInFile("2\\nextRoundFile_roundNext"));

        assertEquals(getTxtInFile("2\\outputFile_roundNext"), actualOutput);
    }

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
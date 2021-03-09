package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OarActionStrategieTest {

    OarActionStrategie oarActionStrategie;

    @BeforeEach
    void setUp(){
        oarActionStrategie = new OarActionStrategie(new InformationGame(),2);
    }

    @Test
    void noAngleToCorrectWithOars(){
        assertEquals(0,oarActionStrategie.actionResolver(Math.PI/8));
    }


    @Test
    void anglePositiveToCorrectWithOars(){
        assertEquals(1,oarActionStrategie.actionResolver(Math.PI));
    }

    @Test
    void angleNegativeToCorrectWithOars(){
        assertEquals(-1,oarActionStrategie.actionResolver(-Math.PI));
    }
}
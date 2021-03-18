package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OarStrategyTest {

    OarStrategy oarStrategy;

    @BeforeEach
    void setUp(){
        oarStrategy = new OarStrategy(new InformationGame(),2);
    }

    @Test
    void noAngleToCorrectWithOars(){
        assertEquals(0, oarStrategy.getDifferenceOarRightLeftStrategy(Math.PI/8));
    }


    @Test
    void anglePositiveToCorrectWithOars(){
        assertEquals(1, oarStrategy.getDifferenceOarRightLeftStrategy(Math.PI));
    }

    @Test
    void angleNegativeToCorrectWithOars(){
        assertEquals(-1, oarStrategy.getDifferenceOarRightLeftStrategy(-Math.PI));
    }
}
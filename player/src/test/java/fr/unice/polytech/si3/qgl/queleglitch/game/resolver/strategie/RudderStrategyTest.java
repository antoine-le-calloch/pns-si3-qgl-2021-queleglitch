package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RudderStrategyTest {


    RudderStrategy rudderStrategy;

    @BeforeEach
    void setUp(){
        rudderStrategy =new RudderStrategy(new InformationGame());
    }

    @Test
    void angleToCorrectPositiveLessThanLimitRudder(){
        assertEquals(Math.PI/8, rudderStrategy.getRudderStrategy(Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeLessThanLimitRudder(){
        assertEquals(-Math.PI/8, rudderStrategy.getRudderStrategy(-Math.PI/8));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudder(){
        assertEquals(0, rudderStrategy.getRudderStrategy(Math.PI/2));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudder(){
        assertEquals(0, rudderStrategy.getRudderStrategy(-Math.PI/2));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudderLessThanLimitOar(){
        assertEquals(-Math.PI/8, rudderStrategy.getRudderStrategy(3*Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudderLessThanLimitOar(){
        assertEquals(Math.PI/8, rudderStrategy.getRudderStrategy(-3*Math.PI/8));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudderMoreThanLimitOar(){
        assertEquals(Math.PI/8, rudderStrategy.getRudderStrategy(5*Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudderMoreThanLimitOar(){
        assertEquals(-Math.PI/8, rudderStrategy.getRudderStrategy(-5*Math.PI/8));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudderPlusThanLimitOar(){
        assertEquals(Math.PI/4, rudderStrategy.getRudderStrategy(7*Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudderPlusThanLimitOar(){
        assertEquals(-Math.PI/4, rudderStrategy.getRudderStrategy(-7*Math.PI/8));
    }

    @Test
    void angleToCorrectInTheBack(){
        assertEquals(Math.PI/4, rudderStrategy.getRudderStrategy(Math.PI));
    }
}
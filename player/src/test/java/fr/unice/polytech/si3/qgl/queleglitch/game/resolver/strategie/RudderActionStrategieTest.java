package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RudderActionStrategieTest {


    RudderActionStrategie rudderActionStrategie;

    @BeforeEach
    void setUp(){
        rudderActionStrategie=new RudderActionStrategie(new InformationGame());
    }

    @Test
    void angleToCorrectPositiveLessThanLimitRudder(){
        assertEquals(Math.PI/8,rudderActionStrategie.rudderActionResolver(Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeLessThanLimitRudder(){
        assertEquals(-Math.PI/8,rudderActionStrategie.rudderActionResolver(-Math.PI/8));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudder(){
        assertEquals(0,rudderActionStrategie.rudderActionResolver(Math.PI/2));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudder(){
        assertEquals(0,rudderActionStrategie.rudderActionResolver(-Math.PI/2));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudderLessThanLimitOar(){
        assertEquals(-Math.PI/8,rudderActionStrategie.rudderActionResolver(3*Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudderLessThanLimitOar(){
        assertEquals(Math.PI/8,rudderActionStrategie.rudderActionResolver(-3*Math.PI/8));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudderMoreThanLimitOar(){
        assertEquals(Math.PI/8,rudderActionStrategie.rudderActionResolver(5*Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudderMoreThanLimitOar(){
        assertEquals(-Math.PI/8,rudderActionStrategie.rudderActionResolver(-5*Math.PI/8));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudderPlusThanLimitOar(){
        assertEquals(Math.PI/4,rudderActionStrategie.rudderActionResolver(7*Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudderPlusThanLimitOar(){
        assertEquals(-Math.PI/4,rudderActionStrategie.rudderActionResolver(-7*Math.PI/8));
    }

    @Test
    void angleToCorrectInTheBack(){
        assertEquals(Math.PI/4,rudderActionStrategie.rudderActionResolver(Math.PI));
    }
}
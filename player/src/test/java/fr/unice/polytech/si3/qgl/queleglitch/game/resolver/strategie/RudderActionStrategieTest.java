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
        assertEquals(Math.PI/8,rudderActionStrategie.actionResolver(Math.PI/8));
    }

    @Test
    void angleToCorrectNegativeLessThanLimitRudder(){
        assertEquals(-Math.PI/8,rudderActionStrategie.actionResolver(-Math.PI/8));
    }

    @Test
    void angleToCorrectPositiveMoreThanLimitRudder(){
        assertEquals(Math.PI/4,rudderActionStrategie.actionResolver(Math.PI/2));
    }

    @Test
    void angleToCorrectNegativeMoreThanLimitRudder(){
        assertEquals(-Math.PI/4,rudderActionStrategie.actionResolver(-Math.PI/2));
    }

}
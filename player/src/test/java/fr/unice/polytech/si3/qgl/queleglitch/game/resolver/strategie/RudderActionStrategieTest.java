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
    void angleToCorrectNegative(){
    }

}
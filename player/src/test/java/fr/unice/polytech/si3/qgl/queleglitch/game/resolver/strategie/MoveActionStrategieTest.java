package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.PositionSailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveActionStrategieTest {

    MoveActionStrategie moveActionStrategie;

    @BeforeEach
    void setUp() {
        moveActionStrategie = new MoveActionStrategie();
    }

    @Test
    void normBetween_0_0And_100_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(100,0)));
    }

    @Test
    void normBetween_0_0And_0_100(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(0,100)));
    }

    @Test
    void normBetween_100_0And_0_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(100,0),new PositionSailor(0,0)));
    }

    @Test
    void normBetween_0_100And_0_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,100),new PositionSailor(0,0)));
    }

    @Test
    void normBetween_0_0And_Minus100_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(-100,0)));
    }

    @Test
    void normBetween_0_0And_0_Minus100(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(0,-100)));
    }

    @Test
    void normBetween_Minus100_0And_0_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(-100,0),new PositionSailor(0,0)));
    }

    @Test
    void normBetween_0_Minus100And_0_0(){
        assertEquals(100,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,-100),new PositionSailor(0,0)));
    }

    @Test
    void normBetween_0_0And_1_1(){
        assertEquals(2,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(1,1)));
    }

    @Test
    void normBetween_0_0And_Minus1_1(){
        assertEquals(2,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(-1,1)));
    }

    @Test
    void normBetween_0_0And_Minus1_Minus1(){
        assertEquals(2,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(-1,-1)));
    }

    @Test
    void normBetween_0_0And_1_Minus1(){
        assertEquals(2,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(1,-1)));
    }

    /////////////////////////////////////////// 5 moves

    @Test
    void normBetween_0_0And_5_0(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(5,0)));
    }

    @Test
    void normBetween_0_0And_4_1(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(4,1)));
    }

    @Test
    void normBetween_0_0And_3_2(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(3,2)));
    }

    @Test
    void normBetween_0_0And_2_3(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(2,3)));
    }

    @Test
    void normBetween_0_0And_1_4(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(1,4)));
    }

    @Test
    void normBetween_0_0And_0_5(){
        assertEquals(5,moveActionStrategie.nbBoxBetweenSailorAndPlace(new Sailor(0,0),new PositionSailor(0,5)));
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckpointTest {

    Position positionCheckpoint;
    Position positionCheckpoint100_0;

    @BeforeEach
    void setUp() {
        positionCheckpoint = new Position(0, 0, 0);
        positionCheckpoint100_0 = new Position(100, 0, 0);
    }

    @Test
    void getAngleToAPlaceIn_100_0(){
        assertEquals(0, positionCheckpoint.getAngleToAPlace(new Position(100, 0, 0)));
    }

    @Test
    void getAngleToAPlaceIn_100_100(){
        assertEquals(Math.PI/4, positionCheckpoint.getAngleToAPlace(new Position(100, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_0_100(){
        assertEquals(Math.PI/2, positionCheckpoint.getAngleToAPlace(new Position(0, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_100(){
        assertEquals(3*Math.PI/4, positionCheckpoint.getAngleToAPlace(new Position(-100, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_0(){
        assertEquals(Math.PI, positionCheckpoint.getAngleToAPlace(new Position(-100, 0, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_Minus100(){
        assertEquals(-3*Math.PI/4, positionCheckpoint.getAngleToAPlace(new Position(-100, -100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_0_Minus100(){
        assertEquals(-Math.PI/2, positionCheckpoint.getAngleToAPlace(new Position(0, -100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_100_Minus100(){
        assertEquals(-Math.PI/4, positionCheckpoint.getAngleToAPlace(new Position(100, -100, 0)));
    }

    /////position 100_0

    @Test
    void getAngleToAPlaceIn_100_0_PositionIn100_0(){
        assertEquals(0, positionCheckpoint100_0.getAngleToAPlace(new Position(200, 0, 0)));
    }

    @Test
    void getAngleToAPlaceIn_100_100_PositionIn100_0(){
        assertEquals(Math.PI/4, positionCheckpoint100_0.getAngleToAPlace(new Position(200, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_0_100_PositionIn100_0(){
        assertEquals(Math.PI/2, positionCheckpoint100_0.getAngleToAPlace(new Position(100, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_100_PositionIn100_0(){
        assertEquals(3*Math.PI/4, positionCheckpoint100_0.getAngleToAPlace(new Position(0, 100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_0_PositionIn100_0(){
        assertEquals(Math.PI, positionCheckpoint100_0.getAngleToAPlace(new Position(0, 0, 0)));
    }

    @Test
    void getAngleToAPlaceIn_Minus100_Minus100_PositionIn100_0(){
        assertEquals(-3*Math.PI/4, positionCheckpoint100_0.getAngleToAPlace(new Position(0, -100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_0_Minus100_PositionIn100_0(){
        assertEquals(-Math.PI/2, positionCheckpoint100_0.getAngleToAPlace(new Position(100, -100, 0)));
    }

    @Test
    void getAngleToAPlaceIn_100_Minus100_PositionIn100_0(){
        assertEquals(-Math.PI/4, positionCheckpoint100_0.getAngleToAPlace(new Position(200, -100, 0)));
    }

    /////getDistanceToAPlace

    @Test
    void getDistanceToAPlaceIn_100_0(){
        assertEquals(100, positionCheckpoint.getNorme(new Position(100, 0, 0)));
    }

    @Test
    void getDistanceToAPlaceIn_100_100(){
        assertEquals(Math.sqrt(20000), positionCheckpoint.getNorme(new Position(100, 100, 0)));
    }

    @Test
    void getDistanceToAPlaceIn_0_100(){
        assertEquals(100, positionCheckpoint.getNorme(new Position(0, 100, 0)));
    }

    @Test
    void getDistanceToAPlaceIn_Minus100_100(){
        assertEquals(Math.sqrt(20000), positionCheckpoint.getNorme(new Position(-100, 100, 0)));
    }

    @Test
    void getDistanceToAPlaceIn_Minus100_0(){
        assertEquals(100, positionCheckpoint.getNorme(new Position(-100, 0, 0)));
    }

    @Test
    void getDistanceToAPlaceIn_Minus100_Minus100(){
        assertEquals(Math.sqrt(20000), positionCheckpoint.getNorme(new Position(-100, -100, 0)));
    }

    @Test
    void getDistanceToAPlaceIn_0_Minus100(){
        assertEquals(100, positionCheckpoint.getNorme(new Position(0, -100, 0)));
    }

    @Test
    void getDistanceToAPlaceIn_100_Minus100(){
        assertEquals(Math.sqrt(20000), positionCheckpoint.getNorme(new Position(100, -100, 0)));
    }
}
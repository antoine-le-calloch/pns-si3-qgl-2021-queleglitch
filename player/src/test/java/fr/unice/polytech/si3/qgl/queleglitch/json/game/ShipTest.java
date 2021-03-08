package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
/*
    Ship shipIn0_0;
    Ship shipIn0_0Rotate45;
    Ship shipInMinus1_Minus1;
    Position checkPointPosition;

    @BeforeEach
    void setUp() {
        shipIn0_0 = new Ship(new Position(0,0,0));
        shipIn0_0Rotate45 = new Ship(new Position(0,0,Math.PI/4));
        shipInMinus1_Minus1 = new Ship(new Position(-1,-1,0));
    }

    @Test
    void ship0_0CheckPoint_1000_0(){
        checkPointPosition = new Position(1000,0,0);
        assertEquals(0, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_600_500(){
        checkPointPosition = new Position(600,500,0);
        assertEquals(Math.atan(500.0/600.0), shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_1000_1000(){
        checkPointPosition = new Position(1000,1000,0);
        assertEquals(Math.PI/4, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_0_1000(){
        checkPointPosition = new Position(0,1000,0);
        assertEquals(Math.PI/2, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_Minus1000_1000(){
        checkPointPosition = new Position(-1000,1000,0);
        assertEquals((3*Math.PI)/4, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_Minus600_500(){
        checkPointPosition = new Position(-600,500,0);
        assertEquals(Math.atan(600.0/500.0)+Math.PI/2, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_Minus1000_0(){
        checkPointPosition = new Position(-1000,0,0);
        assertEquals(Math.PI, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_Minus600_Minus500(){
        checkPointPosition = new Position(-600,-500,0);
        assertEquals(-Math.atan(600.0/500.0)-Math.PI/2, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_Minus1000_Minus1000(){
        checkPointPosition = new Position(-1000,-1000,0);
        assertEquals(-(3*Math.PI)/4, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_0_Minus1000(){
        checkPointPosition = new Position(0,-1000,0);
        assertEquals(-Math.PI/2, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_1000_Minus1000(){
        checkPointPosition = new Position(1000,-1000,0);
        assertEquals(-Math.PI/4, shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0CheckPoint_600_Minus500(){
        checkPointPosition = new Position(600,-500,0);
        assertEquals(-Math.atan(500.0/600.0), shipIn0_0.calculateAngleToCheckPoint(checkPointPosition));
    }
*/
    /**
     * <h1><u>Angle : bateau en (-1 : -1) rotate 45°</u></h1>
     */
/*
    @Test
    void ship0_0Rotat45CheckPoint_600_500(){
        checkPointPosition = new Position(600,500,0);
        assertEquals(Math.atan(500.0/600.0)-Math.PI/4, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_1000_1000(){
        checkPointPosition = new Position(1000,1000,0);
        assertEquals(0, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_0_1000(){
        checkPointPosition = new Position(0,1000,0);
        assertEquals(Math.PI/4, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus1000_1000(){
        checkPointPosition = new Position(-1000,1000,0);
        assertEquals(Math.PI/2, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus600_500(){
        checkPointPosition = new Position(-600,500,0);
        assertEquals(Math.atan(600.0/500.0)+Math.PI/2-Math.PI/4, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus1000_0(){
        checkPointPosition = new Position(-1000,0,0);
        assertEquals(Math.PI-Math.PI/4, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus600_Minus500(){
        checkPointPosition = new Position(-600,-500,0);
        assertEquals(2*Math.PI+(-Math.atan(600.0/500.0)-3*Math.PI/4), shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus1000_Minus1000(){
        checkPointPosition = new Position(-1000,-1000,0);
        assertEquals(-Math.PI, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_0_Minus1000(){
        checkPointPosition = new Position(0,-1000,0);
        assertEquals(-3*Math.PI/4, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_1000_Minus1000(){
        checkPointPosition = new Position(1000,-1000,0);
        assertEquals(-Math.PI/2, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_600_Minus500(){
        checkPointPosition = new Position(600,-500,0);
        assertEquals(-Math.atan(500.0/600.0)-Math.PI/4, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void ship0_0Rotat45CheckPoint_1000_0(){
        checkPointPosition = new Position(1000,0,0);
        assertEquals(-Math.PI/4, shipIn0_0Rotate45.calculateAngleToCheckPoint(checkPointPosition));
    }
*/
    /**
     * <h1><u>Angle : bateau en (-1 : -1) rotate 0°</u></h1>
     */
/*
    @Test
    void shipMinus1_Minus1CheckPoint_1000_0(){
        checkPointPosition = new Position(1000,0,0);
        assertEquals(Math.atan(1.0/1001.0), shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_600_500(){
        checkPointPosition = new Position(600,500,0);
        assertEquals(Math.atan(501.0/601.0), shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_1000_1000(){
        checkPointPosition = new Position(1000,1000,0);
        assertEquals(Math.PI/4, shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_0_1000(){
        checkPointPosition = new Position(0,1000,0);
        assertEquals(Math.atan(1001.0/1.0), shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_Minus1000_1000(){
        checkPointPosition = new Position(-1000,1000,0);
        assertEquals(Math.atan(999.0/1001.0)+Math.PI/2, shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_Minus600_500(){
        checkPointPosition = new Position(-600,500,0);
        assertEquals(Math.atan(599.0/501.0)+Math.PI/2, shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_Minus1000_0(){
        checkPointPosition = new Position(-1000,0,0);
        assertEquals(Math.atan(999.0/1.0)+Math.PI/2, shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_Minus600_Minus500(){
        checkPointPosition = new Position(-600,-500,0);
        assertEquals(-Math.atan(599.0/499.0)-Math.PI/2, shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_Minus1000_Minus1000(){
        checkPointPosition = new Position(-1000,-1000,0);
        assertEquals(-(3*Math.PI)/4, shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_0_Minus1000(){
        checkPointPosition = new Position(0,-1000,0);
        assertEquals(-Math.atan(999.0/1.0), shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_1000_Minus1000(){
        checkPointPosition = new Position(1000,-1000,0);
        assertEquals(-Math.atan(999.0/1001.0), shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }

    @Test
    void shipMinus1_Minus1CheckPoint_600_Minus500(){
        checkPointPosition = new Position(600,-500,0);
        assertEquals(-Math.atan(499.0/601.0), shipInMinus1_Minus1.calculateAngleToCheckPoint(checkPointPosition));
    }*/
}
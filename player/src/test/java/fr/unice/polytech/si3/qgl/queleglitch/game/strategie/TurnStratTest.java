package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnStratTest {

    TurnStrat turnStrat;
    Position shipIn0_0;
    Position shipIn0_0Rotate45;
    Position shipInMinus1_Minus1;
    Position checkPointPosition;

    @BeforeEach
    void setUp() {
        shipIn0_0 = new Position(0,0,0);
        shipIn0_0Rotate45 = new Position(0,0,Math.PI/4);
        shipInMinus1_Minus1 = new Position(-1,-1,0);
    }

    @Test
    void ship0_0CheckPoint_1000_0(){
        checkPointPosition = new Position(1000,0,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(0,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_600_500(){
        checkPointPosition = new Position(600,500,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(Math.atan(500.0/600.0),turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_1000_1000(){
        checkPointPosition = new Position(1000,1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(Math.PI/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_0_1000(){
        checkPointPosition = new Position(0,1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(Math.PI/2,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_Minus1000_1000(){
        checkPointPosition = new Position(-1000,1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals((3*Math.PI)/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_Minus600_500(){
        checkPointPosition = new Position(-600,500,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(Math.atan(600.0/500.0)+Math.PI/2,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_Minus1000_0(){
        checkPointPosition = new Position(-1000,0,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(Math.PI,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_Minus600_Minus500(){
        checkPointPosition = new Position(-600,-500,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(-Math.atan(600.0/500.0)-Math.PI/2,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_Minus1000_Minus1000(){
        checkPointPosition = new Position(-1000,-1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(-(3*Math.PI)/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_0_Minus1000(){
        checkPointPosition = new Position(0,-1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(-Math.PI/2,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_1000_Minus1000(){
        checkPointPosition = new Position(1000,-1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(-Math.PI/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0CheckPoint_600_Minus500(){
        checkPointPosition = new Position(600,-500,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0);
        assertEquals(-Math.atan(500.0/600.0),turnStrat.calculateAngle());
    }

    /////////////////////////////bateau à 45°

    @Test
    void ship0_0Rotat45CheckPoint_600_500(){
        checkPointPosition = new Position(600,500,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(Math.atan(500.0/600.0)-Math.PI/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_1000_1000(){
        checkPointPosition = new Position(1000,1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(0,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_0_1000(){
        checkPointPosition = new Position(0,1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(Math.PI/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus1000_1000(){
        checkPointPosition = new Position(-1000,1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(Math.PI/2,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus600_500(){
        checkPointPosition = new Position(-600,500,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(Math.atan(600.0/500.0)+Math.PI/2-Math.PI/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus1000_0(){
        checkPointPosition = new Position(-1000,0,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(Math.PI-Math.PI/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus600_Minus500(){
        checkPointPosition = new Position(-600,-500,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(2*Math.PI+(-Math.atan(600.0/500.0)-3*Math.PI/4),turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_Minus1000_Minus1000(){
        checkPointPosition = new Position(-1000,-1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(-Math.PI,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_0_Minus1000(){
        checkPointPosition = new Position(0,-1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(-3*Math.PI/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_1000_Minus1000(){
        checkPointPosition = new Position(1000,-1000,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(-Math.PI/2,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_600_Minus500(){
        checkPointPosition = new Position(600,-500,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(-Math.atan(500.0/600.0)-Math.PI/4,turnStrat.calculateAngle());
    }

    @Test
    void ship0_0Rotat45CheckPoint_1000_0(){
        checkPointPosition = new Position(1000,0,0);
        turnStrat = new TurnStrat(checkPointPosition,shipIn0_0Rotate45);
        assertEquals(-Math.PI/4,turnStrat.calculateAngle());
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StratTest {

    Strat strat;
    Ship shipIn0_0;
    RegattaGoal regattaGoal;

    @BeforeEach
    void setUp() {
        shipIn0_0 = new Ship(new Position(0,0,0));
        regattaGoal = new RegattaGoal();
    }

    /**
     * <h1><u>ToolToUse test angle</u></h1>
     */

    @Test
    void toolsToUseShip0_0CheckPoint_1000_0(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(1000, 0, 0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(2,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_600_500(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(600,500,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(1,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_1000_1000(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(1000,1000,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(1,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_0_1000(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(0,1000,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(0,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_Minus1000_1000(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(-1000,1000,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(0,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_Minus600_500(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(-600,500,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(0,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_Minus1000_0(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(-1000,0,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(0,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_Minus600_Minus500(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(-600,-500,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(3,0), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_Minus1000_Minus1000(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(-1000,-1000,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(3,0), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_0_Minus1000(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(0,-1000,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(3,0), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_1000_Minus1000(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(1000,-1000,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(3,1), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0CheckPoint_600_Minus500(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(600,-500,0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,100);
        assertEquals(new ToolsToUse(2,1), strat.getToolsToUse());
    }

    /**
     * <h1><u>ToolToUse distance ship-checkpoint</u></h1>
     */

    @Test
    void toolsToUseCheckpoint110Meters() {
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(110, 0, 0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,0);
        assertEquals(new ToolsToUse(2,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint109Meters(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(109, 0, 0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,0);
        assertEquals(new ToolsToUse(1,1), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint40Radius150Meters(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(150, 0, 0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,40);
        assertEquals(new ToolsToUse(2,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint1000Radius1010Meters2CheckpointBehind(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(1010, 0, 0), new Circle()),2);
        regattaGoal.addCheckpoint(new Checkpoint(new Position(-1010, 0, 0), new Circle()) ,1);
        strat = new Strat(regattaGoal,shipIn0_0,1000);
        assertEquals(new ToolsToUse(1,1), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint1000Radius1010Meters2CheckpointFront(){
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(1010, 0, 0), new Circle()),2);
        regattaGoal.addCheckpoint(new Checkpoint(new Position(2010, 0, 0), new Circle()) ,1);
        strat = new Strat(regattaGoal,shipIn0_0,1000);
        assertEquals(new ToolsToUse(2,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint100metersPidiv3Angle(){ // 1/2 * 100 , sqrt(3)/2 * 100
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(50, 86.60, 0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,0);
        assertEquals(new ToolsToUse(0,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint100metersPidiv6Angle(){ // sqrt(3)/2 * 100 , 1/2 * 100
        regattaGoal = new RegattaGoal(new Checkpoint(new Position(86.60, 50, 0), new Circle()),1);
        strat = new Strat(regattaGoal,shipIn0_0,0);
        assertEquals(new ToolsToUse(0,1), strat.getToolsToUse());
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Deck;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StratTest {

    Ship ship;
    Strat strat;
    Ship shipIn0_0;
    RegattaGoal regattaGoal;
    InformationGame infoGame6Rames4Sailors;

    @BeforeEach
    void setUp() {
        ship = new Ship(new Position(0, 0, 0), new Entities[]{new Rame(), new Rame(), new Rame(), new Rame(), new Rame(), new Rame()}, "initGameFile", new Deck(), new Rectangle());
        infoGame6Rames4Sailors = new InformationGame(new Sailor[]{new Sailor(),new Sailor(),new Sailor(),new Sailor()},ship,new RegattaGoal());
    }

    /**
     * <h1><u>ToolToUse initGameFile angle</u></h1>
     */

    @Test
    void toolsToUseShip0_0Checkpoint_1000_0(){
        Position checkpoint_1000_0 = new Position(1000, 0, 0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_1000_0, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_0),2,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_600_500(){
        Position checkpoint_600_500 = new Position(600,500,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_600_500, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_600_500),1,1), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_1000_1000(){
        Position checkpoint_1000_1000 = new Position(1000,1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_1000_1000, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_1000),1,1), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_0_1000(){
        Position checkpoint_0_1000 = new Position(0,1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_0_1000, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_0_1000)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_Minus1000_1000(){
        Position checkpoint_Minus1000_1000 = new Position(-1000,1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_Minus1000_1000, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_1000)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_Minus600_500(){
        Position checkpoint_Minus600_500 = new Position(-600,500,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_Minus600_500, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus600_500)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_Minus1000_0(){
        Position checkpoint_Minus1000_0 = new Position(-1000,0,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_Minus1000_0, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_0)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_Minus600_Minus500(){
        Position checkpoint_Minus600_Minus500 = new Position(-600,-500,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_Minus600_Minus500, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus600_Minus500)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_Minus1000_Minus1000(){
        Position checkpoint_Minus1000_Minus1000 = new Position(-1000,-1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_Minus1000_Minus1000, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_Minus1000)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_0_Minus1000(){
        Position checkpoint_0_Minus1000 = new Position(0,-1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_0_Minus1000, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_0_Minus1000)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_1000_Minus1000(){
        Position checkpoint_1000_Minus1000 = new Position(1000,-1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_1000_Minus1000, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_Minus1000),1,1), strat.getToolsToUse());
    }

    @Test
    void toolsToUseShip0_0Checkpoint_600_Minus500(){
        Position checkpoint_600_Minus500 = new Position(600,-500,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint_600_Minus500, new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),100);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_600_Minus500),1,1), strat.getToolsToUse());
    }

    /**
     * <h1><u>ToolToUse distance ship-checkpoint</u></h1>
     */

    /*@Test
    void toolsToUseCheckpoint110Meters() {
        Position checkpoint = new Position(,,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint0), new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),0);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint109Meters(){
        Position checkpoint = new Position(,,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint0), new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),0);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint40Radius150Meters(){
        Position checkpoint = new Position(,,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint0), new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),40);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint1000Radius1010Meters2CheckpointBehind(){
        Position checkpoint = new Position(,,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint 0), new Circle()),2));
        regattaGoal.addCheckpoint(new Checkpoint(new Position(-1010, 0, 0), new Circle()) ,1);
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),1000);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint1000Radius1010Meters2CheckpointFront(){
        Position checkpoint = new Position(,,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint 0), new Circle()),2));
        regattaGoal.addCheckpoint(new Checkpoint(new Position(2010, 0, 0), new Circle()) ,1);
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),1000);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint100metersPidiv3Angle(){ // 1/2 * 100 , sqrt(3)/2 * 100
        Position checkpoint = new Position(,,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint0, 0), new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),0);
        assertEquals(new ToolsToUse(0,0,2), strat.getToolsToUse());
    }

    @Test
    void toolsToUseCheckpoint100metersPidiv6Angle(){ // sqrt(3)/2 * 100 , 1/2 * 100
        Position checkpoint = new Position(,,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint(checkpoint0, 0), new Circle()),1));
        strat = new Strat(infoGame6Rames4Sailors,100);
        //strat = new Strat(new InformationGame(regattaGoal,shipIn0_0),0);
        assertEquals(new ToolsToUse(0,0,1), strat.getToolsToUse());
    }*/
}
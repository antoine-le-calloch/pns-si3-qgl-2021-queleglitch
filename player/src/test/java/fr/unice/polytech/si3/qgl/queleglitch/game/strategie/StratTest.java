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
    Ship ship_Minus1_Minus1_orient45;
    InformationGame infoGame6Rames4Sailors;
    InformationGame infoGame6Rames5Sailors;
    InformationGame infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45;

    @BeforeEach
    void setUp() {
        ship = new Ship(new Position(0, 0, 0), new Entities[]{new Rame(), new Rame(), new Rame(), new Rame(), new Rame(), new Rame()}, "Giga Boss", new Deck(), new Rectangle());
        ship_Minus1_Minus1_orient45 = new Ship(new Position(-1, -1, Math.PI/4), new Entities[]{new Rame(), new Rame(), new Rame(), new Rame(), new Rame(), new Rame()}, "Giga Boss", new Deck(), new Rectangle());
        infoGame6Rames4Sailors = new InformationGame(new Sailor[]{new Sailor(),new Sailor(),new Sailor(),new Sailor()},ship,new RegattaGoal());
        infoGame6Rames5Sailors = new InformationGame(new Sailor[]{new Sailor(),new Sailor(),new Sailor(),new Sailor(),new Sailor()},ship,new RegattaGoal());
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45 = new InformationGame(new Sailor[]{new Sailor(),new Sailor(),new Sailor(),new Sailor(),new Sailor()},ship_Minus1_Minus1_orient45,new RegattaGoal());;
    }

    /**
     * <h1><u>ToolToUse initGameFile angle</u></h1>
     */

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_1000_0(){
        Position checkpoint_1000_0 = new Position(1000, 0, 0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_0, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_0),2,2), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_600_500(){
        Position checkpoint_600_500 = new Position(600,500,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_600_500, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_600_500),1,1), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_1000_1000(){
        Position checkpoint_1000_1000 = new Position(1000,1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_1000),1,1), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_0_1000(){
        Position checkpoint_0_1000 = new Position(0,1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_0_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_0_1000),1,1), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_Minus1000_1000(){
        Position checkpoint_Minus1000_1000 = new Position(-1000,1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_1000)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_Minus600_500(){
        Position checkpoint_Minus600_500 = new Position(-600,500,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus600_500, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus600_500)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_Minus1000_0(){
        Position checkpoint_Minus1000_0 = new Position(-1000,0,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_0, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_0)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_Minus600_Minus500(){
        Position checkpoint_Minus600_Minus500 = new Position(-600,-500,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus600_Minus500, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus600_Minus500)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_Minus1000_Minus1000(){
        Position checkpoint_Minus1000_Minus1000 = new Position(-1000,-1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_Minus1000)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_0_Minus1000(){
        Position checkpoint_0_Minus1000 = new Position(0,-1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_0_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_0_Minus1000),1,1), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_1000_Minus1000(){
        Position checkpoint_1000_Minus1000 = new Position(1000,-1000,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_Minus1000),1,1), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseShip0_0Checkpoint_600_Minus500(){
        Position checkpoint_600_Minus500 = new Position(600,-500,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_600_Minus500, new Circle(100))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_600_Minus500),1,1), strat.getToolsToUse());
    }

    /**
     * <h1><u>ToolToUse distance ship-checkpoint</u></h1>
     */

    @Test
    void _4SailorsToolsToUseCheckpoint54mToReachWithNextCheckpointBehind_154_0(){
        Position checkpoint_154_0 = new Position(154,0,0);
        Position checkpoint_Minus154_0 = new Position(-154,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_154_0, new Circle(100)),new Checkpoint(checkpoint_Minus154_0, new Circle(100))});
        infoGame6Rames4Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseCheckpoint55mToReachWithNextCheckpointBehind_155_0(){
        Position checkpoint_155_0 = new Position(155,0,0);
        Position checkpoint_Minus155_0 = new Position(-155,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_155_0, new Circle(100)),new Checkpoint(checkpoint_Minus155_0, new Circle(100))});
        infoGame6Rames4Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseCheckpoint55mToReachLastCheckpoint_155_0(){
        Position checkpoint_155_0 = new Position(155,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_155_0, new Circle(100))});
        infoGame6Rames4Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseCheckpoint55mToReachWithNextCheckpointInFront_155_0(){
        Position checkpoint_155_0 = new Position(155,0,0);
        Position checkpoint_Minus155_0 = new Position(555,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_155_0, new Circle(100)),new Checkpoint(checkpoint_Minus155_0, new Circle(100))});
        infoGame6Rames4Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseCheckpoint56mToReachWithNextCheckpointBehind_156_0(){
        Position checkpoint_156_0 = new Position(156,0,0);
        Position checkpoint_Minus156_0 = new Position(-156,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_156_0, new Circle(100)),new Checkpoint(checkpoint_Minus156_0, new Circle(100))});
        infoGame6Rames4Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }


    @Test
    void _4SailorsToolsToUseCheckpoint1000Radius20m_1020_0(){
        Position checkpoint_1020_0 = new Position(1020,0,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1020_0, new Circle(1000))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseCheckpoint90Radius20m_110_0(){
        Position checkpoint_110_0 = new Position(110,0,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_110_0, new Circle(90))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseCheckpoint55Radius20m_75_0(){
        Position checkpoint_75_0 = new Position(75,0,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_75_0, new Circle(55))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseCheckpoint54Radius100m_154_0(){
        Position checkpoint_154_0 = new Position(154,0,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_154_0, new Circle(54))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _4SailorsToolsToUseCheckpoint54Radius0m_54_0(){
        Position checkpoint_54_0 = new Position(54,0,0);
        infoGame6Rames4Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_54_0, new Circle(54))}));
        strat = new Strat(infoGame6Rames4Sailors);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    ///6 rames 5 sailors

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_1000_0(){
        Position checkpoint_1000_0 = new Position(1000, 0, 0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_0, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_0),2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_600_500(){
        Position checkpoint_600_500 = new Position(600,500,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_600_500, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_600_500),2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_1000_1000(){
        Position checkpoint_1000_1000 = new Position(1000,1000,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_1000),2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_0_1000(){
        Position checkpoint_0_1000 = new Position(0,1000,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_0_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_0_1000),2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_Minus1000_1000(){
        Position checkpoint_Minus1000_1000 = new Position(-1000,1000,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_1000)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_Minus600_500(){
        Position checkpoint_Minus600_500 = new Position(-600,500,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus600_500, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus600_500)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_Minus1000_0(){
        Position checkpoint_Minus1000_0 = new Position(-1000,0,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_0, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_0)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_Minus600_Minus500(){
        Position checkpoint_Minus600_Minus500 = new Position(-600,-500,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus600_Minus500, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus600_Minus500)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_Minus1000_Minus1000(){
        Position checkpoint_Minus1000_Minus1000 = new Position(-1000,-1000,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_Minus1000_Minus1000)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_0_Minus1000(){
        Position checkpoint_0_Minus1000 = new Position(0,-1000,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_0_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_0_Minus1000),2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_1000_Minus1000(){
        Position checkpoint_1000_Minus1000 = new Position(1000,-1000,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_1000_Minus1000),2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseShip0_0Checkpoint_600_Minus500(){
        Position checkpoint_600_Minus500 = new Position(600,-500,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_600_Minus500, new Circle(100))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(ship.calculateAngleToCheckPoint(checkpoint_600_Minus500),2,2), strat.getToolsToUse());
    }

    /**
     * <h1><u>ToolToUse distance ship-checkpoint</u></h1>
     */

    @Test
    void _5SailorsToolsToUseCheckpoint54mToReachWithNextCheckpointBehind_154_0(){
        Position checkpoint_154_0 = new Position(154,0,0);
        Position checkpoint_Minus154_0 = new Position(-154,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_154_0, new Circle(100)),new Checkpoint(checkpoint_Minus154_0, new Circle(100))});
        infoGame6Rames5Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseCheckpoint55mToReachWithNextCheckpointBehind_155_0(){
        Position checkpoint_155_0 = new Position(155,0,0);
        Position checkpoint_Minus155_0 = new Position(-155,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_155_0, new Circle(100)),new Checkpoint(checkpoint_Minus155_0, new Circle(100))});
        infoGame6Rames5Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseCheckpoint55mToReachLastCheckpoint_155_0(){
        Position checkpoint_155_0 = new Position(155,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_155_0, new Circle(100))});
        infoGame6Rames5Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseCheckpoint55mToReachWithNextCheckpointInFront_155_0(){
        Position checkpoint_155_0 = new Position(155,0,0);
        Position checkpoint_Minus155_0 = new Position(555,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_155_0, new Circle(100)),new Checkpoint(checkpoint_Minus155_0, new Circle(100))});
        infoGame6Rames5Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseCheckpoint56mToReachWithNextCheckpointBehind_156_0(){
        Position checkpoint_156_0 = new Position(156,0,0);
        Position checkpoint_Minus156_0 = new Position(-156,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_156_0, new Circle(100)),new Checkpoint(checkpoint_Minus156_0, new Circle(100))});
        infoGame6Rames5Sailors.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }


    @Test
    void _5SailorsToolsToUseCheckpoint1000Radius20m_1020_0(){
        Position checkpoint_1020_0 = new Position(1020,0,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1020_0, new Circle(1000))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseCheckpoint90Radius20m_110_0(){
        Position checkpoint_110_0 = new Position(110,0,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_110_0, new Circle(90))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseCheckpoint55Radius20m_75_0(){
        Position checkpoint_75_0 = new Position(75,0,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_75_0, new Circle(55))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseCheckpoint54Radius100m_154_0(){
        Position checkpoint_154_0 = new Position(154,0,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_154_0, new Circle(54))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void _5SailorsToolsToUseCheckpoint54Radius0m_54_0(){
        Position checkpoint_54_0 = new Position(54,0,0);
        infoGame6Rames5Sailors.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_54_0, new Circle(54))}));
        strat = new Strat(infoGame6Rames5Sailors);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    ///6 rames 5 sailors, ship in -1,-1

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_1000_0(){
        Position checkpoint_1000_0 = new Position(1000, 0, 0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_0, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_1000_0),2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_600_500(){
        Position checkpoint_600_500 = new Position(600,500,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_600_500, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_600_500),2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_1000_1000(){
        Position checkpoint_1000_1000 = new Position(1000,1000,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_1000_1000),2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_0_1000(){
        Position checkpoint_0_1000 = new Position(0,1000,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_0_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_0_1000),2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_Minus1000_1000(){
        Position checkpoint_Minus1000_1000 = new Position(-1000,1000,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_Minus1000_1000),2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_Minus600_500(){
        Position checkpoint_Minus600_500 = new Position(-600,500,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus600_500, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_Minus600_500)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_Minus1000_0(){
        Position checkpoint_Minus1000_0 = new Position(-1000,0,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_0, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_Minus1000_0)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_Minus600_Minus500(){
        Position checkpoint_Minus600_Minus500 = new Position(-600,-500,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus600_Minus500, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_Minus600_Minus500)-Math.PI/2,0,3), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_Minus1000_Minus1000(){
        Position checkpoint_Minus1000_Minus1000 = new Position(-1000,-1000,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_Minus1000_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_Minus1000_Minus1000)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_0_Minus1000(){
        Position checkpoint_0_Minus1000 = new Position(0,-1000,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_0_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_0_Minus1000)+Math.PI/2,3,0), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_1000_Minus1000(){
        Position checkpoint_1000_Minus1000 = new Position(1000,-1000,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1000_Minus1000, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_1000_Minus1000),2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseShip0_0Checkpoint_600_Minus500(){
        Position checkpoint_600_Minus500 = new Position(600,-500,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_600_Minus500, new Circle(100))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(ship_Minus1_Minus1_orient45.calculateAngleToCheckPoint(checkpoint_600_Minus500),2,2), strat.getToolsToUse());
    }

    /**
     * <h1><u>ToolToUse distance ship-checkpoint</u></h1>
     */

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseCheckpoint54mToReachWithNextCheckpointBehind_154_0(){
        Position checkpoint_154_0 = new Position(101,101,0);
        Position checkpoint_Minus154_0 = new Position(-154,-154,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_154_0, new Circle(100)),new Checkpoint(checkpoint_Minus154_0, new Circle(100))});
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseCheckpoint55mToReachLastCheckpoint_155_0(){
        Position checkpoint_155_0 = new Position(101,101,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_155_0, new Circle(100))});
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseCheckpoint55mToReachWithNextCheckpointInFront_155_0(){
        Position checkpoint_155_0 = new Position(101,101,0);
        Position checkpoint_Minus155_0 = new Position(555,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_155_0, new Circle(100)),new Checkpoint(checkpoint_Minus155_0, new Circle(100))});
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseCheckpoint56mToReachWithNextCheckpointBehind_156_0(){
        Position checkpoint_156_0 = new Position(120,120,0);
        Position checkpoint_Minus156_0 = new Position(-156,0,0);
        RegattaGoal regattaGoal2Checkpoint = new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_156_0, new Circle(100)),new Checkpoint(checkpoint_Minus156_0, new Circle(100))});
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(regattaGoal2Checkpoint);
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }


    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseCheckpoint1000Radius1000Circle_1020_0(){
        Position checkpoint_1020_0 = new Position(1,1,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_1020_0, new Circle(1000))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseCheckpoint90Radius90Circle_110_0(){
        Position checkpoint_110_0 = new Position(38,38,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_110_0, new Circle(90))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseCheckpoint54Radius54Circle_154_0(){
        Position checkpoint_154_0 = new Position(39,39,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_154_0, new Circle(54))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(0,2,2), strat.getToolsToUse());
    }

    @Test
    void Minus1_Minus1_Orient45_5SailorsToolsToUseCheckpoint54Radius54Circle_54_0(){
        Position checkpoint_54_0 = new Position(38,38,0);
        infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45.setGoal(new RegattaGoal(new Checkpoint[]{new Checkpoint(checkpoint_54_0, new Circle(54))}));
        strat = new Strat(infoGame6Rames5SailorsShipIn_Minus1_Minus1_orient45);
        assertEquals(new ToolsToUse(0,1,1), strat.getToolsToUse());
    }
}
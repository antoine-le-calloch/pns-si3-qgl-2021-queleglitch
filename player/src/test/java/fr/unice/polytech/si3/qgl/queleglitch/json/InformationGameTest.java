package fr.unice.polytech.si3.qgl.queleglitch.json;

import fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding.Grid;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.SeaEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class InformationGameTest {

    Grid grid;
    Point shipPoint0;
    RegattaGoal mockGoal;
    SeaEntities seaEntities;
    InformationGame informationGame;

    @BeforeEach
    void setUp() {
        grid = new Grid(5200,200,200);
        seaEntities = new SeaEntities(null);
        shipPoint0 = new Point(0,0);
        informationGame = new InformationGame();
        mockGoal = mock(RegattaGoal.class);


    }

    ////////////////////////////////////////////    checkpointOutOfGrid    //////////////////////////////////////////

    @Test
    void grid_5000Side_checkpoint5000_0() {
        Mockito.when(mockGoal.getPositionActualOptiCheckpoint()).thenReturn(new Position(5000,0,0));
        Point checkpoint = new Point(5000,0);
        informationGame.setGoal(mockGoal);
        informationGame.setGrid(grid);
        grid.create(shipPoint0,checkpoint,seaEntities);
        assertTrue(informationGame.checkpointOutOfGrid());
    }

    @Test
    void grid_5000Side_checkpoint0_5000() {
        Mockito.when(mockGoal.getPositionActualOptiCheckpoint()).thenReturn(new Position(0,5000,0));
        Point checkpoint = new Point(0,5000);
        informationGame.setGoal(mockGoal);
        informationGame.setGrid(grid);
        grid.create(shipPoint0,checkpoint,seaEntities);
        assertTrue(informationGame.checkpointOutOfGrid());
    }

    @Test
    void grid_5000Side_checkpoint1000_0() {
        Mockito.when(mockGoal.getPositionActualOptiCheckpoint()).thenReturn(new Position(1000,0,0));
        Point checkpoint = new Point(1000,0);
        informationGame.setGoal(mockGoal);
        informationGame.setGrid(grid);
        grid.create(shipPoint0,checkpoint,seaEntities);
        assertFalse(informationGame.checkpointOutOfGrid());
    }

    @Test
    void grid_5000Side_checkpoint0_1000() {
        Mockito.when(mockGoal.getPositionActualOptiCheckpoint()).thenReturn(new Position(0,1000,0));
        Point checkpoint = new Point(0,1000);
        informationGame.setGoal(mockGoal);
        informationGame.setGrid(grid);
        grid.create(shipPoint0,checkpoint,seaEntities);
        assertFalse(informationGame.checkpointOutOfGrid());
    }

}
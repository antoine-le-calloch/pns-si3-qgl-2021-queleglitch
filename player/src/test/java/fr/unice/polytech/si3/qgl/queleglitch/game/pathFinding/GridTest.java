package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.SeaEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GridTest {

    Grid grid;
    SeaEntities seaEntities;
    Position shipPosition0;
    Position shipPosition1;
    Position checkpoint0;
    Position checkpoint1;
    Position checkpointOrtPIOn2;
    Position checkpointMinusOrtPIOn2;

    @BeforeEach
    void setUp() {
        grid = new Grid();
        seaEntities = new SeaEntities(null);
        shipPosition0 = new Position(0,0,0);
        shipPosition1 = new Position(1,1,0);
        checkpoint0 = new Position(100,0,0);
        checkpoint1 = new Position(100,1,0);
        checkpointOrtPIOn2 = new Position(1,100,0);
        checkpointMinusOrtPIOn2 = new Position(1,-100,0);
    }

    /////////////////////////////////////   findNextCaseCentralPoint    /////////////////////////////////////

    /////ship0

    @Test
    void nextCase_C0_L0_ship0_ort0() {
        Point point = grid.findNextCaseCentralPoint(0,0,0,shipPosition0);
        assertEquals(new Point(2500-(165/2.0),2500-(0.5*30)),point);
    }

    @Test
    void nextCase_C1_L0_ship0_ort0() {
        Point point = grid.findNextCaseCentralPoint(1,0,0,shipPosition0);
        assertEquals(new Point(2500-(1.5*165),2500-(0.5*30)),point);
    }

    @Test
    void nextCase_C0_L1_ship0_ort0() {
        Point point = grid.findNextCaseCentralPoint(0,1,0,shipPosition0);
        assertEquals(new Point(2500-(165/2.0),2500-(1.5*30)),point);
    }

    @Test
    void nextCase_C1_L1_ship0_ort0() {
        Point point = grid.findNextCaseCentralPoint(1,1,0,shipPosition0);
        assertEquals(new Point(2500-(1.5*165),2500-(1.5*30)),point);
    }

    @Test
    void nextCase_C0_L2_ship0_ort0() {
        Point point = grid.findNextCaseCentralPoint(0,2,0,shipPosition0);
        assertEquals(new Point(2500-(165/2.0),2500-(2.5*30)),point);
    }

    @Test
    void nextCase_C0_LMaxMinus1_ship0_ort0() {
        Point point = grid.findNextCaseCentralPoint(0,5000/30-1,0,shipPosition0);
        assertEquals(new Point(2500-(165/2.0),2500-(165.5*30)),point);
    }

    /////ship1

    @Test
    void nextCase_C1_L0_ship1_ort0() {
        Point point = grid.findNextCaseCentralPoint(1,0,0,shipPosition1);
        assertEquals(new Point(2501-(1.5*165),2501-(0.5*30)),point);
    }

    @Test
    void nextCase_C0_L0_ship1_ort0() {
        Point point = grid.findNextCaseCentralPoint(0,0,0,shipPosition1);
        assertEquals(new Point(2501-(165/2.0),2501-(0.5*30)),point);
    }

    @Test
    void nextCase_C0_L1_ship1_ort0() {
        Point point = grid.findNextCaseCentralPoint(0,1,0,shipPosition1);
        assertEquals(new Point(2501-(165/2.0),2501-(1.5*30)),point);
    }

    @Test
    void nextCase_C0_L2_ship1_ort0() {
        Point point = grid.findNextCaseCentralPoint(0,2,0,shipPosition1);
        assertEquals(new Point(2501-(165/2.0),2501-(2.5*30)),point);
    }

    @Test
    void nextCase_C0_LMaxMinus1_ship1_ort0() {
        Point point = grid.findNextCaseCentralPoint(0,5000/30-1,0,shipPosition1);
        assertEquals(new Point(2501-(165/2.0),2501-(165.5*30)),point);
    }

    /////ort PI/2

    @Test
    void nextCase_C1_L0_ship1_ortPIOn2() {
        Point point = grid.findNextCaseCentralPoint(1,0,Math.PI/2,shipPosition1);
        assertEquals(new Point(-2499+(0.5*30),2501-(1.5*165)),point);
    }

    @Test
    void nextCase_C0_L0_ship1_ortPIOn2() {
        Point point = grid.findNextCaseCentralPoint(0,0,Math.PI/2,shipPosition1);
        assertEquals(new Point(-2499+(0.5*30),2501-(165/2.0)),point);
    }

    @Test
    void nextCase_C0_LMaxMinus1_ship1_ortPIOn2() {
        Point point = grid.findNextCaseCentralPoint(0,5000/30-1,Math.PI/2,shipPosition1);
        assertEquals(new Point(-2499+(165.5*30),2501-(165/2.0)),point);
    }

    /////ort -PI/2

    @Test
    void nextCase_C1_L0_ship1_ortMinusPIOn2() {
        Point point = grid.findNextCaseCentralPoint(1,0,-Math.PI/2,shipPosition1);
        assertEquals(new Point(2501-(0.5*30),-2499+(1.5*165)),point);
    }

    @Test
    void nextCase_C0_L0_ship1_ortMinusPIOn2() {
        Point point = grid.findNextCaseCentralPoint(0,0,-Math.PI/2,shipPosition1);
        assertEquals(new Point(2501-(0.5*30),-2499+(165/2.0)),point);
    }

    @Test
    void nextCase_C0_LMaxMinus1_ship1_ortMinusPIOn2() {
        Point point = grid.findNextCaseCentralPoint(0,5000/30-1,-Math.PI/2,shipPosition1);
        assertEquals(new Point(2501-(165.5*30),-2499+(165/2.0)),point);
    }

    /////////////////////////////////////   create    /////////////////////////////////////

  /*  @Test
    void create_C0_L0_ship0_ort0() {
        grid.create(shipPosition0, checkpoint0,seaEntities);
        Point point = grid.getGrid()[0][0].getCentralCasePoint();
        assertEquals(new Point(2500-(165/2.0),2500-(0.5*30)),point);
    }

    @Test
    void create_C1_L0_ship0_ort0() {
        grid.create(shipPosition0, checkpoint0,seaEntities);
        Point point = grid.getGrid()[1][0].getCentralCasePoint();
        assertEquals(new Point(2500-(1.5*165),2500-(0.5*30)),point);
    }

    @Test
    void create_C0_L1_ship0_ort0() {
        grid.create(shipPosition0, checkpoint0,seaEntities);
        Point point = grid.getGrid()[0][1].getCentralCasePoint();
        assertEquals(new Point(2500-(165/2.0),2500-(1.5*30)),point);
    }

    @Test
    void create_C1_L1_ship0_ort0() {
        grid.create(shipPosition0, checkpoint0,seaEntities);
        Point point = grid.getGrid()[1][1].getCentralCasePoint();
        assertEquals(new Point(2500-(1.5*165),2500-(1.5*30)),point);
    }

    @Test
    void create_C0_L2_ship0_ort0() {
        grid.create(shipPosition0, checkpoint0,seaEntities);
        Point point = grid.getGrid()[0][2].getCentralCasePoint();
        assertEquals(new Point(2500-(165/2.0),2500-(2.5*30)),point);
    }

    @Test
    void create_C0_LMaxMinus1_ship0_ort0() {
        grid.create(shipPosition0, checkpoint0,seaEntities);
        Point point = grid.getGrid()[0][165].getCentralCasePoint();
        assertEquals(new Point(2500-(165/2.0),2500-(165.5*30)),point);
    }

    /////ship1

    @Test
    void create_C1_L0_ship1_ort0() {
        grid.create(shipPosition1, checkpoint1,seaEntities);
        Point point = grid.getGrid()[1][0].getCentralCasePoint();
        assertEquals(new Point(2501-(1.5*165),2501-(0.5*30)),point);
    }

    @Test
    void create_C0_L0_ship1_ort0() {
        grid.create(shipPosition1, checkpoint1,seaEntities);
        Point point = grid.getGrid()[0][0].getCentralCasePoint();
        assertEquals(new Point(2501-(165/2.0),2501-(0.5*30)),point);
    }

    @Test
    void create_C0_L1_ship1_ort0() {
        grid.create(shipPosition1, checkpoint1,seaEntities);
        Point point = grid.getGrid()[0][1].getCentralCasePoint();
        assertEquals(new Point(2501-(165/2.0),2501-(1.5*30)),point);
    }

    @Test
    void create_C0_L2_ship1_ort0() {
        grid.create(shipPosition1, checkpoint1,seaEntities);
        Point point = grid.getGrid()[0][2].getCentralCasePoint();
        assertEquals(new Point(2501-(165/2.0),2501-(2.5*30)),point);
    }

    @Test
    void create_C0_LMaxMinus1_ship1_ort0() {
        grid.create(shipPosition1, checkpoint1,seaEntities);
        Point point = grid.getGrid()[0][165].getCentralCasePoint();
        assertEquals(new Point(2501-(165/2.0),2501-(165.5*30)),point);
    }

    /////ort PI/2

    @Test
    void create_C1_L0_ship1_ortPIOn2() {
        grid.create(shipPosition1, checkpointOrtPIOn2,seaEntities);
        Point point = grid.getGrid()[1][0].getCentralCasePoint();
        assertEquals(new Point(-2499+(0.5*30),2501-(1.5*165)),point);
    }

    @Test
    void create_C0_L0_ship1_ortPIOn2() {
        grid.create(shipPosition1, checkpointOrtPIOn2,seaEntities);
        Point point = grid.getGrid()[0][0].getCentralCasePoint();
        assertEquals(new Point(-2499+(0.5*30),2501-(165/2.0)),point);
    }

    @Test
    void create_C0_LMaxMinus1_ship1_ortPIOn2() {
        grid.create(shipPosition1, checkpointOrtPIOn2,seaEntities);
        Point point = grid.getGrid()[0][165].getCentralCasePoint();
        assertEquals(new Point(-2499+(165.5*30),2501-(165/2.0)),point);
    }

    /////ort -PI/2

    @Test
    void create_C1_L0_ship1_ortMinusPIOn2() {
        grid.create(shipPosition1, checkpointMinusOrtPIOn2,seaEntities);
        Point point = grid.getGrid()[1][0].getCentralCasePoint();
        assertEquals(new Point(2501-(0.5*30),-2499+(1.5*165)),point);
    }

    @Test
    void create_C0_L0_ship1_ortMinusPIOn2() {
        grid.create(shipPosition1, checkpointMinusOrtPIOn2,seaEntities);
        Point point = grid.getGrid()[0][0].getCentralCasePoint();
        assertEquals(new Point(2501-(0.5*30),-2499+(165/2.0)),point);
    }

    @Test
    void create_C0_LMaxMinus1_ship1_ortMinusPIOn2() {
        grid.create(shipPosition1, checkpointMinusOrtPIOn2,seaEntities);
        Point point = grid.getGrid()[0][165].getCentralCasePoint();
        assertEquals(new Point(2501-(165.5*30),-2499+(165/2.0)),point);
    }*/
}
package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.SeaEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import static org.junit.jupiter.api.Assertions.*;

import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GridTest {

    Grid grid;
    Point shipPoint0;
    Point shipPoint1;
    Point checkpoint0;
    Point checkpoint1;
    Point checkpointOrtPIOn2;
    Point checkpointMinusOrtPIOn2;
    SeaEntities seaEntities;
    SeaEntities seaEntities1Reef;

    @BeforeEach
    void setUp() {
        grid = new Grid(5000,40,200);
        seaEntities = new SeaEntities(null);
        seaEntities1Reef = new SeaEntities(new VisibleEntities[]{new Reef(new Position(150,0,0),new Rectangle(10,10,0))});
        shipPoint0 = new Point(0,0);
        shipPoint1 = new Point(1,1);
        checkpoint0 = new Point(100,0);
        checkpoint1 = new Point(100,1);
        checkpointOrtPIOn2 = new Point(1,100);
        checkpointMinusOrtPIOn2 = new Point(1,-100);
    }
    //////////////////////////////////////    getColAndLineOfAPosition    //////////////////////////////////////

    @Test
    void getColAndLineOf_0_0() {
        grid.create(shipPoint0,checkpoint0);
        int[] colLin = grid.getColAndLineOfAPosition(new Position(0,0,0));
        assertEquals(12,colLin[0]);
        assertEquals(62,colLin[1]);
    }

    @Test
    void getColAndLineOf_2500_2500() {
        grid.create(shipPoint0,checkpoint0);
        int[] colLin = grid.getColAndLineOfAPosition(new Position(2500,2500,0));
        assertEquals(0,colLin[0]);
        assertEquals(0,colLin[1]);
    }

    @Test
    void getColAndLineOf_Minus2499_2500() {
        grid.create(shipPoint0,checkpoint0);
        int[] colLin = grid.getColAndLineOfAPosition(new Position(-2500,2500,0));
        assertEquals(24,colLin[0]);
        assertEquals(0,colLin[1]);
    }

    @Test
    void getColAndLineOf_Minus2499_Minus2499() {
        grid.create(shipPoint0,checkpoint0);
        int[] colLin = grid.getColAndLineOfAPosition(new Position(-2500,-2500,0));
        assertEquals(24,colLin[0]);
        assertEquals(124,colLin[1]);
    }

    @Test
    void getColAndLineOf_2500_Minus2499() {
        grid.create(shipPoint0,checkpoint0);
        int[] colLin = grid.getColAndLineOfAPosition(new Position(2500,-2500,0));
        assertEquals(0,colLin[0]);
        assertEquals(124,colLin[1]);
    }

    @Test
    void getColAndLineOf_10000_2500() {
        grid.create(shipPoint0,checkpoint0);
        int[] colLin = grid.getColAndLineOfAPosition(new Position(10000,2500,0));
        assertNull(colLin);
    }

    //////////////////////////////////////    getCaseOfAPosition    //////////////////////////////////////

    @Test
    void getCaseWeightOf_0_0() {
        grid.create(shipPoint0,checkpoint0);
        Case caseOfAPosition = grid.getCaseOfAPosition(new Position(0,0,0));
        assertEquals(-1,caseOfAPosition.getWeight());
    }

    @Test
    void getCaseOf_0_0() {
        grid.create(shipPoint0,checkpoint0);
        Case caseOfAPosition = grid.getCaseOfAPosition(new Position(0,0,0));
        assertEquals(0,caseOfAPosition.getCentralPoint().getX());
        assertEquals(0,caseOfAPosition.getCentralPoint().getY());
    }

    @Test
    void getCaseOf_2500_2500() {
        grid.create(shipPoint0,checkpoint0);
        Case caseOfAPosition = grid.getCaseOfAPosition(new Position(2500,2500,0));
        assertEquals(2400,caseOfAPosition.getCentralPoint().getX());
        assertEquals(2480,caseOfAPosition.getCentralPoint().getY());
    }

    @Test
    void getCaseOf_Minus2499_2500() {
        grid.create(shipPoint0,checkpoint0);
        Case caseOfAPosition = grid.getCaseOfAPosition(new Position(-2500,2500,0));
        assertEquals(-2400,caseOfAPosition.getCentralPoint().getX());
        assertEquals(2480,caseOfAPosition.getCentralPoint().getY());
    }

    @Test
    void getCaseOf_Minus2499_Minus2499() {
        grid.create(shipPoint0,checkpoint0);
        Case caseOfAPosition = grid.getCaseOfAPosition(new Position(-2500,-2500,0));
        assertEquals(-2400,caseOfAPosition.getCentralPoint().getX());
        assertEquals(-2480,caseOfAPosition.getCentralPoint().getY());
    }

    @Test
    void getCaseOf_2500_Minus2499() {
        grid.create(shipPoint0,checkpoint0);
        Case caseOfAPosition = grid.getCaseOfAPosition(new Position(2500,-2500,0));
        assertEquals(2400,caseOfAPosition.getCentralPoint().getX());
        assertEquals(-2480,caseOfAPosition.getCentralPoint().getY());
    }

    //////////////////////////////////////    processCaseWeightByColAndLin    //////////////////////////////////////

    @Test
    void processCaseWeightByColAndLin_SideLength1_CaseW1_CaseH1() {
        Grid grid = new Grid(1,1,1);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeightByColAndLin(0,0,0);
        assertEquals(0,grid.getCase(0,0).getWeight());
    }

    @Test
    void processCaseWeightByColAndLin_SideLength5_CaseW1_CaseH1() {
        Grid grid = new Grid(5,1,1);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeightByColAndLin(2,2,0);
        assertEquals(0,grid.getCase(2,2).getWeight());
        assertEquals(1,grid.getCase(1,2).getWeight());
        assertEquals(1,grid.getCase(1,1).getWeight());
        assertEquals(2,grid.getCase(0,1).getWeight());
        assertEquals(2,grid.getCase(0,0).getWeight());
    }

    @Test
    void processCaseWeightByColAndLin_SideLength11_CaseW1_CaseH1() {
        Grid grid = new Grid(11,1,1);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeightByColAndLin(5,5,0);
        assertEquals(5,grid.getCase(0,0).getWeight());
        assertEquals(5,grid.getCase(0,1).getWeight());
        assertEquals(4,grid.getCase(1,1).getWeight());
        assertEquals(4,grid.getCase(1,2).getWeight());
        assertEquals(3,grid.getCase(2,2).getWeight());
    }

    @Test
    void processCaseWeightByColAndLin_SideLength21_CaseW1_CaseH1() {
        Grid grid = new Grid(21,1,1);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeightByColAndLin(10,10,0);
        assertEquals(10,grid.getCase(0,0).getWeight());
        assertEquals(10,grid.getCase(0,1).getWeight());
        assertEquals(9,grid.getCase(1,1).getWeight());
        assertEquals(9,grid.getCase(1,2).getWeight());
        assertEquals(8,grid.getCase(2,2).getWeight());
    }

    @Test
    void processCaseWeightByColAndLin_SideLength10_CaseW2_CaseH2() {
        Grid grid = new Grid(10,2,2);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeightByColAndLin(2,2,0);
        assertEquals(0,grid.getCase(2,2).getWeight());
        assertEquals(1,grid.getCase(3,2).getWeight());
        assertEquals(1,grid.getCase(3,1).getWeight());
        assertEquals(2,grid.getCase(4,1).getWeight());
        assertEquals(2,grid.getCase(4,0).getWeight());
    }

    @Test
    void processCaseWeightByColAndLin_SideLength22_CaseW2_CaseH2() {
        Grid grid = new Grid(22,2,2);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeightByColAndLin(5,5,0);
        assertEquals(5,grid.getCase(0,0).getWeight());
        assertEquals(5,grid.getCase(0,1).getWeight());
        assertEquals(4,grid.getCase(1,1).getWeight());
        assertEquals(4,grid.getCase(1,2).getWeight());
        assertEquals(3,grid.getCase(2,2).getWeight());
    }

    @Test
    void processCaseWeightByColAndLin_SideLength1000_CaseW200_CaseH200() {
        Grid grid = new Grid(1000,200,200);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeightByColAndLin(2,2,0);
        assertEquals(0,grid.getCase(2,2).getWeight());
        assertEquals(1,grid.getCase(3,2).getWeight());
        assertEquals(1,grid.getCase(3,1).getWeight());
        assertEquals(2,grid.getCase(4,1).getWeight());
        assertEquals(2,grid.getCase(4,0).getWeight());
    }

    @Test
    void processCaseWeightByColAndLin_SideLength5001_CaseW1_CaseH1() {
        Grid grid = new Grid(5100,100,100);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeightByColAndLin(25,25,0);
        assertEquals(25,grid.getCase(0,0).getWeight());
        assertEquals(25,grid.getCase(0,1).getWeight());
        assertEquals(24,grid.getCase(1,1).getWeight());
        assertEquals(24,grid.getCase(1,2).getWeight());
        assertEquals(23,grid.getCase(2,2).getWeight());
    }

    ////////////////////////////////////////////    processCaseWeight    //////////////////////////////////////////

    @Test
    void processCaseWeight_SideLength1_CaseW1_CaseH1() {
        Grid grid = new Grid(1,1,1);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(0,grid.getCase(0,0).getWeight());
    }

    @Test
    void processCaseWeight_SideLength5_CaseW1_CaseH1() {
        Grid grid = new Grid(5,1,1);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(0,grid.getCase(2,2).getWeight());
        assertEquals(1,grid.getCase(1,2).getWeight());
        assertEquals(1,grid.getCase(1,1).getWeight());
        assertEquals(2,grid.getCase(0,1).getWeight());
        assertEquals(2,grid.getCase(0,0).getWeight());
    }

    @Test
    void processCaseWeight_SideLength11_CaseW1_CaseH1() {
        Grid grid = new Grid(11,1,1);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(5,grid.getCase(0,0).getWeight());
        assertEquals(5,grid.getCase(0,1).getWeight());
        assertEquals(4,grid.getCase(1,1).getWeight());
        assertEquals(4,grid.getCase(1,2).getWeight());
        assertEquals(3,grid.getCase(2,2).getWeight());
    }

    @Test
    void processCaseWeight_SideLength21_CaseW1_CaseH1() {
        Grid grid = new Grid(21,1,1);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(10,grid.getCase(0,0).getWeight());
        assertEquals(10,grid.getCase(0,1).getWeight());
        assertEquals(9,grid.getCase(1,1).getWeight());
        assertEquals(9,grid.getCase(1,2).getWeight());
        assertEquals(8,grid.getCase(2,2).getWeight());
    }

    @Test
    void processCaseWeight_SideLength10_CaseW2_CaseH2() {
        Grid grid = new Grid(10,2,2);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(0,grid.getCase(2,2).getWeight());
        assertEquals(1,grid.getCase(3,2).getWeight());
        assertEquals(1,grid.getCase(3,1).getWeight());
        assertEquals(2,grid.getCase(4,1).getWeight());
        assertEquals(2,grid.getCase(4,0).getWeight());
    }

    @Test
    void processCaseWeight_SideLength22_CaseW2_CaseH2() {
        Grid grid = new Grid(22,2,2);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(5,grid.getCase(0,0).getWeight());
        assertEquals(5,grid.getCase(0,1).getWeight());
        assertEquals(4,grid.getCase(1,1).getWeight());
        assertEquals(4,grid.getCase(1,2).getWeight());
        assertEquals(3,grid.getCase(2,2).getWeight());
    }

    @Test
    void processCaseWeight_SideLength1000_CaseW200_CaseH200() {
        Grid grid = new Grid(1000,200,200);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(0,grid.getCase(2,2).getWeight());
        assertEquals(1,grid.getCase(3,2).getWeight());
        assertEquals(1,grid.getCase(3,1).getWeight());
        assertEquals(2,grid.getCase(4,1).getWeight());
        assertEquals(2,grid.getCase(4,0).getWeight());
    }

    @Test
    void processCaseWeight_SideLength5100_CaseW100_CaseH100() {
        Grid grid = new Grid(5100,100,100);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(25,grid.getCase(0,0).getWeight());
        assertEquals(25,grid.getCase(0,1).getWeight());
        assertEquals(24,grid.getCase(1,1).getWeight());
        assertEquals(24,grid.getCase(1,2).getWeight());
        assertEquals(23,grid.getCase(2,2).getWeight());
    }

    @Test
    void processCaseWeight_SideLength5000_CaseW200_CaseH200_0Reef_Case1() {
        Grid grid = new Grid(5000,200,200);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(1,grid.getCase(11,12).getWeight());
    }

    @Test
    void processCaseWeight_SideLength5000_CaseW200_CaseH200_0Reef_Case2() {
        Grid grid = new Grid(5000,200,200);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(2,grid.getCase(10,12).getWeight());
    }

    @Test
    void processCaseWeight_SideLength5000_CaseW200_CaseH200_1Reef_Case1() {
        Grid grid = new Grid(5000,200,200);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(1,grid.getCase(11,12).getWeight());
    }

    @Test
    void processCaseWeight_SideLength5000_CaseW200_CaseH200_1Reef_Case2() {
        Grid grid = new Grid(5000,200,200);
        grid.create(shipPoint0,checkpoint0);
        grid.processCaseWeight(shipPoint0);
        assertEquals(2,grid.getCase(10,12).getWeight());
    }

    ///////////////////////////////////////////////   findCasePoint    ///////////////////////////////////////////////

    /////ship0
    @Test
    void casePoint_C0_L0_ship0_ort0() {
        Point[] points = grid.findCasePoints(0,0,0, shipPoint0);
        assertEquals(new Point(2500-(0.5*200),2500-(0.5*40)),points[0]);
    }

    @Test
    void casePoint_C1_L0_ship0_ort0() {
        Point[] points = grid.findCasePoints(1,0,0, shipPoint0);
        assertEquals(new Point(2500-(1.5*200),2500-(0.5*40)),points[0]);
    }

    @Test
    void casePoint_C0_L1_ship0_ort0() {
        Point[] points = grid.findCasePoints(0,1,0, shipPoint0);
        assertEquals(new Point(2500-(0.5*200),2500-(1.5*40)),points[0]);
    }

    @Test
    void casePoint_C1_L1_ship0_ort0() {
        Point[] points = grid.findCasePoints(1,1,0, shipPoint0);
        assertEquals(new Point(2500-(1.5*200),2500-(1.5*40)),points[0]);
    }

    @Test
    void casePoint_C0_L2_ship0_ort0() {
        Point[] points = grid.findCasePoints(0,2,0, shipPoint0);
        assertEquals(new Point(2500-(0.5*200),2500-(2.5*40)),points[0]);
    }

    @Test
    void casePoint_C0_L0_And_LMax_ship0_ort0() {
        Point[] points = grid.findCasePoints(0,0,0, shipPoint0);
        assertEquals(new Point(2500-(0.5*200),2500-(0.5*40)),points[0]);
        assertEquals(new Point(2500-(0.5*200),-2500+(0.5*40)),points[3]);
    }

    @Test
    void casePoint_C0_L82_And_L84_ship0_ort0() {
        Point[] points = grid.findCasePoints(0,82,0, shipPoint0);
        assertEquals(new Point(2500-(0.5*200),2500-(82.5*40)),points[0]);
        assertEquals(new Point(2500-(0.5*200),-2500+(82.5*40)),points[3]);
    }

    @Test
    void casePoint_C0_L83_And_L83_ship0_ort0() {
        Point[] points = grid.findCasePoints(0,83,0, shipPoint0);
        assertEquals(new Point(2500-(0.5*200),2500-(83.5*40)),points[0]);
        assertEquals(new Point(2500-(0.5*200),-2500+(83.5*40)),points[3]);
    }

    @Test
    void casePoint_CMax_LMax_ship0_ort0() {
        Point[] points = grid.findCasePoints(0,0,0, shipPoint0);
        assertEquals(new Point(-2500+(0.5*200),-2500+(0.5*40)),points[2]);
    }

    /////ship1
    @Test
    void casePoint_C1_L0_ship1_ort0() {
        Point[] points = grid.findCasePoints(1,0,0, shipPoint1);
        assertEquals(new Point(2501-(1.5*200),2501-(0.5*40)),points[0]);
    }

    @Test
    void casePoint_C0_L0_ship1_ort0() {
        Point[] points = grid.findCasePoints(0,0,0, shipPoint1);
        assertEquals(new Point(2501-(0.5*200),2501-(0.5*40)),points[0]);
    }

    @Test
    void casePoint_C0_L1_ship1_ort0() {
        Point[] points = grid.findCasePoints(0,1,0, shipPoint1);
        assertEquals(new Point(2501-(0.5*200),2501-(1.5*40)),points[0]);
    }

    @Test
    void casePoint_C0_L2_ship1_ort0() {
        Point[] points = grid.findCasePoints(0,2,0, shipPoint1);
        assertEquals(new Point(2501-(0.5*200),2501-(2.5*40)),points[0]);
    }

    @Test
    void casePoint_C0_LMax_ship1_ort0() {
        Point[] points = grid.findCasePoints(0,0,0, shipPoint1);
        assertEquals(new Point(2501-(0.5*200),2501-(124.5*40)),points[3]);
    }

    /////ort PI/2
    @Test
    void casePoint_C1_L0_ship1_ortPIOn2() {
        Point[] points = grid.findCasePoints(1,0,Math.PI/2, shipPoint1);
        assertEquals(new Point(-2499+(0.5*40),2501-(1.5*200)),points[0]);
    }

    @Test
    void casePoint_C0_L0_ship1_ortPIOn2() {
        Point[] points = grid.findCasePoints(0,0,Math.PI/2, shipPoint1);
        assertEquals(new Point(-2499+(0.5*40),2501-(0.5*200)),points[0]);
    }

    @Test
    void casePoint_C0_LMax_ship1_ortPIOn2() {
        Point[] points = grid.findCasePoints(0,0,Math.PI/2, shipPoint1);
        assertEquals(new Point(-2499+(124.5*40),2501-(0.5*200)),points[3]);
    }

    /////ort -PI/2
    @Test
    void casePoint_C1_L0_ship1_ortMinusPIOn2() {
        Point[] points = grid.findCasePoints(1,0,-Math.PI/2, shipPoint1);
        assertEquals(new Point(2501-(0.5*40),-2499+(1.5*200)),points[0]);
    }

    @Test
    void casePoint_C0_L0_ship1_ortMinusPIOn2() {
        Point[] points = grid.findCasePoints(0,0,-Math.PI/2, shipPoint1);
        assertEquals(new Point(2501-(0.5*40),-2499+(0.5*200)),points[0]);
    }

    @Test
    void casePoint_C0_LMax_ship1_ortMinusPIOn2() {
        Point[] points = grid.findCasePoints(0,0,-Math.PI/2, shipPoint1);
        assertEquals(new Point(2501-(124.5*40),-2499+(0.5*200)),points[3]);
    }

    /////////////////////////////////////   create    /////////////////////////////////////

    @Test
    void create_C0_L0_ship0_ort0() {
        grid.create(shipPoint0, checkpoint0);
        Point point = grid.getCase(0,0).getCentralPoint();
        assertEquals(new Point(2500-(0.5*200),2500-(0.5*40)),point);
    }

    @Test
    void create_C1_L0_ship0_ort0() {
        grid.create(shipPoint0, checkpoint0);
        Point point = grid.getCase(1,0).getCentralPoint();
        assertEquals(new Point(2500-(1.5*200),2500-(0.5*40)),point);
    }

    @Test
    void create_C0_L1_ship0_ort0() {
        grid.create(shipPoint0, checkpoint0);
        Point point = grid.getCase(0,1).getCentralPoint();
        assertEquals(new Point(2500-(0.5*200),2500-(1.5*40)),point);
    }

    @Test
    void create_C1_L1_ship0_ort0() {
        grid.create(shipPoint0, checkpoint0);
        Point point = grid.getCase(1,1).getCentralPoint();
        assertEquals(new Point(2500-(1.5*200),2500-(1.5*40)),point);
    }

    @Test
    void create_C0_L2_ship0_ort0() {
        grid.create(shipPoint0, checkpoint0);
        Point point = grid.getCase(0,2).getCentralPoint();
        assertEquals(new Point(2500-(0.5*200),2500-(2.5*40)),point);
    }

    @Test
    void create_C0_LMaxMinus1_ship0_ort0() {
        grid.create(shipPoint0, checkpoint0);
        Point point = grid.getCase(0,124).getCentralPoint();
        assertEquals(new Point(2500-(0.5*200),2500-(124.5*40)),point);
    }

    /////ship1

    @Test
    void create_C1_L0_ship1_ort0() {
        grid.create(shipPoint1, checkpoint1);
        Point point = grid.getCase(1,0).getCentralPoint();
        assertEquals(new Point(2501-(1.5*200),2501-(0.5*40)),point);
    }

    @Test
    void create_C0_L0_ship1_ort0() {
        grid.create(shipPoint1, checkpoint1);
        Point point = grid.getCase(0,0).getCentralPoint();
        assertEquals(new Point(2501-(0.5*200),2501-(0.5*40)),point);
    }

    @Test
    void create_C0_L1_ship1_ort0() {
        grid.create(shipPoint1, checkpoint1);
        Point point = grid.getCase(0,1).getCentralPoint();
        assertEquals(new Point(2501-(0.5*200),2501-(1.5*40)),point);
    }

    @Test
    void create_C0_L2_ship1_ort0() {
        grid.create(shipPoint1, checkpoint1);
        Point point = grid.getCase(0,2).getCentralPoint();
        assertEquals(new Point(2501-(0.5*200),2501-(2.5*40)),point);
    }

    @Test
    void create_C0_LMaxMinus1_ship1_ort0() {
        grid.create(shipPoint1, checkpoint1);
        Point point = grid.getCase(0,124).getCentralPoint();
        assertEquals(new Point(2501-(0.5*200),2501-(124.5*40)),point);
    }

    /////ort PI/2
    @Test
    void create_C1_L0_ship1_ortPIOn2() {
        grid.create(shipPoint1, checkpointOrtPIOn2);
        Point point = grid.getCase(1,0).getCentralPoint();
        assertEquals(new Point(-2499+(0.5*40),2501-(1.5*200)),point);
    }

    @Test
    void create_C0_L0_ship1_ortPIOn2() {
        grid.create(shipPoint1, checkpointOrtPIOn2);
        Point point = grid.getCase(0,0).getCentralPoint();
        assertEquals(new Point(-2499+(0.5*40),2501-(0.5*200)),point);
    }

    @Test
    void create_C0_LMaxMinus1_ship1_ortPIOn2() {
        grid.create(shipPoint1, checkpointOrtPIOn2);
        Point point = grid.getCase(0,124).getCentralPoint();
        assertEquals(new Point(-2499+(124.5*40),2501-(0.5*200)),point);
    }

    /////ort -PI/2
    @Test
    void create_C1_L0_ship1_ortMinusPIOn2() {
        grid.create(shipPoint1, checkpointMinusOrtPIOn2);
        Point point = grid.getCase(1,0).getCentralPoint();
        assertEquals(new Point(2501-(0.5*40),-2499+(1.5*200)),point);
    }

    @Test
    void create_C0_L0_ship1_ortMinusPIOn2() {
        grid.create(shipPoint1, checkpointMinusOrtPIOn2);
        Point point = grid.getCase(0,0).getCentralPoint();
        assertEquals(new Point(2501-(0.5*40),-2499+(0.5*200)),point);
    }

    @Test
    void create_C0_LMaxMinus1_ship1_ortMinusPIOn2() {
        grid.create(shipPoint1, checkpointMinusOrtPIOn2);
        Point point = grid.getCase(0,124).getCentralPoint();
        assertEquals(new Point(2501-(124.5*40),-2499+(0.5*200)),point);
    }

    ///////////reef

    @Test
    void create_OneReef_C0_L0_ship0_ort0() {
        grid.create(shipPoint0, checkpoint0);
        Case gridCase = grid.getCase(11,62);
        assertFalse(gridCase.isReef());
    }
}
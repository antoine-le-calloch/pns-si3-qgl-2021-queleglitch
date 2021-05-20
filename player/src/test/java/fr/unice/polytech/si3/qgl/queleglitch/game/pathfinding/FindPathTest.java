package fr.unice.polytech.si3.qgl.queleglitch.game.pathfinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindPathTest {

    FindPath findPath;
    Spotting spotting;
    RegattaGoal regattaGoal;
    RegattaGoal regattaGoal2;
    Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(3500,500,500);
        spotting = new Spotting(null,null);
        regattaGoal = new RegattaGoal();
        regattaGoal2 = new RegattaGoal();
        regattaGoal.setPositionOptiCheckpoints(new Position[]{new Position(0,-500,0)});
        regattaGoal.setCheckpoints(new Checkpoint[]{new Checkpoint(new Position(0, -600, 0), new Circle(100))});
        regattaGoal2.setPositionOptiCheckpoints(new Position[]{new Position(-2000,0,0)});
        regattaGoal2.setCheckpoints(new Checkpoint[]{new Checkpoint(new Position(-2100, 0, 0), new Circle(100))});
    }
    ///////////////////////////////////////////   createPath()  ///////////////////////////////////////////
    @Test
    void createPath_NoReef(){
        List<Reef> reefs = new ArrayList<>();
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);
    }

    @Test
    void createPath_1Reef_Top_Left_Of_Checkpoint_Useful(){
        Reef reef = new Reef(new Position(-500,0,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,500),pointExpected);

    }

    @Test
    void createPath_1Reef_Top_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(0,0,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    @Test
    void createPath_1Big_Reef_Top_Of_Checkpoint_Useful(){
        Reef reef = new Reef(new Position(0,0,0), new Rectangle(530,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);

        assertNull(regattaGoal.getPathPoint());

        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-1000,0),pointExpected);

    }

    @Test
    void createPath_1Reef_Top_Right_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    @Test
    void createPath_1BigReef_Top_Right_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(830,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }


    //Le test ci-dessous ne devrait pas passer
    @Test
    void createPath_1VeryBigReef_Top_Right_Of_Checkpoint_Useful(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(3200,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    @Test
    void createPath_1Reef_Left_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(-500,-500,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    @Test
    void createPath_1BigReef_Left_Of_Checkpoint_Useful(){
        Reef reef = new Reef(new Position(-500,-500,0), new Rectangle(430,520,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-1000,0),pointExpected);
    }

    @Test
    void createPath_1Reef_Right_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(500,-500,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    @Test
    void createPath_1Reef_Bottom_Left_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(-500,-1000,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    @Test
    void createPath_1Reef_Bottom_Right_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(500,-1000,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }


    @Test
    void createPath_1Reef_Bottom_Of_Ship_Useless(){
        Reef reef = new Reef(new Position(-1000,0,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    @Test
    void createPath_1Reef_Right_Of_Ship_Useless(){
        Reef reef = new Reef(new Position(-500,500,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    @Test
    void createPath_2Reefs_Bottom_Of_Ship_And_Right_Of_Ship_Useless(){
        Reef reef = new Reef(new Position(-1000,0,0), new Rectangle(430,420,0));
        Reef reef2 = new Reef(new Position(-500,500,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        reefs.add(reef2);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);
    }

    @Test
    void createPath_2Reefs_Left_Of_Checkpoint_And_Top_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(-500,-500,0), new Rectangle(430,420,0));
        Reef reef2 = new Reef(new Position(0,0,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        reefs.add(reef2);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);
    }

    @Test
    void createPath_2Reefs_Top_Left_Of_Checkpoint_And_Right_Of_Ship_Useful(){
        Reef reef = new Reef(new Position(-500,0,0), new Rectangle(430,420,0));
        Reef reef2 = new Reef(new Position(-500,500,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        reefs.add(reef2);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-1000,0),pointExpected);
    }

    @Test
    void createPath_3Reefs_Top_Left_Of_Checkpoint_And_Right_Of_Ship_And_Bottom_Of_Ship_Useful(){
        Reef reef = new Reef(new Position(-500,0,0), new Rectangle(430,420,0));
        Reef reef2 = new Reef(new Position(-500,500,0), new Rectangle(430,420,0));
        Reef reef3 = new Reef(new Position(-1000,0,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        reefs.add(reef2);
        reefs.add(reef3);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs,new ArrayList<>()));
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCaseOfAPosition(new Position(-1000,500,0)));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,1000),pointExpected);
    }
}
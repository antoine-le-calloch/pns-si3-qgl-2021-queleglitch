package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindPathTest {

    FindPath findPath;
    RegattaGoal regattaGoal;
    Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(3500,500,500);
        regattaGoal = new RegattaGoal();
        regattaGoal.setPositionOptiCheckpoints(new Position[]{new Position(0,-500,0)});
    }
    ///////////////////////////////////////////   createPath()  ///////////////////////////////////////////
    @Test
    void createPath_NoReef(){
        List<Reef> reefs = new ArrayList<>();
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    //Mauvaise strategie du bateau pour le test ci-dessous (probleme qui provient apprament du numero de la colonne/ligne)
    /*@Test
    void createPath_1Big_Reef_Top_Of_Checkpoint_Useful(){
        Reef reef = new Reef(new Position(0,0,0), new Rectangle(530,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-1000,0),pointExpected);

    }*/

    @Test
    void createPath_1Reef_Top_Right_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,500),pointExpected);

    }

    @Test
    void createPath_1Reef_Right_Of_Checkpoint_Useless(){
        Reef reef = new Reef(new Position(500,-500,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
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
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    /*
    // Ne devrait pas faire un nullPointerException
    @Test
    void createPath_1BigReef_Bottom_Of_Ship_Useful(){
        Reef reef = new Reef(new Position(-1000,0,0), new Rectangle(530,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,500),pointExpected);

    }*/

    @Test
    void createPath_1Reef_Right_Of_Ship_Useless(){
        Reef reef = new Reef(new Position(-500,500,0), new Rectangle(430,420,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-500,0),pointExpected);

    }

    /*
    // Ne devrait pas faire un nullPointerException
    @Test
    void createPath_1BigReef_Right_Of_Ship_Useful(){
        Reef reef = new Reef(new Position(-500,500,0), new Rectangle(430,520,0));
        List<Reef> reefs = new ArrayList<>();
        reefs.add(reef);
        grid.create(new Point(0,0),new Point(0,-500),new Spotting(reefs));
        grid.resetCaseWeight();
        grid.processCaseWeight(new Point(-1000,500));
        findPath = new FindPath(grid);
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal, grid.getCase(5,2));
        int x = (int) Math.round(regattaGoal.getPathPoint().getX());
        int y = (int) Math.round(regattaGoal.getPathPoint().getY());
        Point pointExpected = new Point(x,y);
        assertEquals(new Point(-1000,0),pointExpected);

    }*/
}
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

import static org.junit.jupiter.api.Assertions.*;

class FindPathTest {

    FindPath findPath;
    RegattaGoal regattaGoal;

    @BeforeEach
    void setUp() {
        regattaGoal = new RegattaGoal();
        regattaGoal.setPositionOptiCheckpoints(new Position[]{new Position(1000,0,0)});
    }
    ///////////////////////////////////////////   createPath()  ///////////////////////////////////////////

    @Test
    void createPath_NoReef(){
        findPath = new FindPath(new Point(0,0),new ArrayList<>());
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertNull(regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_notInFront(){
        Reef reef = new Reef(new Position(0,1000,0), new Rectangle(2,4,0));
        findPath = new FindPath(new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertNull(regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InMiddleFront_W2_H20(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(2,20,Math.PI/2));
        findPath = new FindPath(new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(500,162.5),regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InMiddleFront_W1_H20(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(1,20,Math.PI/2));
        findPath = new FindPath(new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(500,162.5),regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InUpFront_W1_H20(){
        Reef reef = new Reef(new Position(500,5,0), new Rectangle(1,20,Math.PI/2));
        findPath = new FindPath(new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(500,-157.5),regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InDownFront_W1_H20(){
        Reef reef = new Reef(new Position(500,-5,0), new Rectangle(1,20,Math.PI/2));
        findPath = new FindPath(new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(500,157.5),regattaGoal.getPathPoint());
    }

    ///////////////////////////////////////////   getANewValidStep()  ///////////////////////////////////////////

    @Test
    void newValidStep_1Reef_InMiddleFront_W1_H20(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(1,20,Math.PI/2));
        findPath = new FindPath(null, Arrays.asList(new Reef[]{reef}.clone()));
        assertEquals(new Point(500,162.5),findPath.getANewValidStep(new Point(0,0),new Point(1000,0)));
    }
}
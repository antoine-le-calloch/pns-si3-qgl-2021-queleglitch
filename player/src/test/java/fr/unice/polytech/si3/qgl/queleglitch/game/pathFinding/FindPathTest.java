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
/*
    @Test
    void createPath_NoReef(){
        findPath = new FindPath(4, new Point(0,0),new ArrayList<>());
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertNull(regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_notInFront(){
        Reef reef = new Reef(new Position(0,1000,0), new Rectangle(8,4,0));
        findPath = new FindPath(4, new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertNull(regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InMiddleFront_W8_H0_ShipWidth8(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(8,0,0));
        findPath = new FindPath(8, new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(500,40.0),regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InMiddleFront_W8_H0(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(8,0,0));
        findPath = new FindPath(4, new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(500,37.5),regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InMiddleFront_W8_H20(){
        Reef reef = new Reef(new Position(500,0,0), new Rectangle(8,20,Math.PI/2));
        findPath = new FindPath(4, new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(499.99999999999994,42.5),regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InUpFront_W8_H20(){
        Reef reef = new Reef(new Position(500,5,0), new Rectangle(8,20,Math.PI/2));
        findPath = new FindPath(4, new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(500,-37.5),regattaGoal.getPathPoint());
    }

    @Test
    void createPath_1Reef_InDownFront_W8_H20(){
        Reef reef = new Reef(new Position(500,-5,0), new Rectangle(8,20,Math.PI/2));
        findPath = new FindPath(4, new Point(0,0), Arrays.asList(new Reef[]{reef}.clone()));
        assertNull(regattaGoal.getPathPoint());
        findPath.createPath(regattaGoal);
        assertEquals(new Point(500,37.5),regattaGoal.getPathPoint());
    }*/
}
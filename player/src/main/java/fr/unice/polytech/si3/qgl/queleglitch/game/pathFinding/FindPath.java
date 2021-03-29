package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import java.util.ArrayList;
import java.util.List;

public class FindPath {

    Point shipPoint;
    Spotting spotting;
    List<Reef> visibleReef;
    List<Point> stepToReach;

    public FindPath(Point shipPosition, List<Reef> visibleReef){
        this.shipPoint = shipPosition;
        this.visibleReef = visibleReef;
        this.stepToReach = new ArrayList<>();
        this.spotting = new Spotting(visibleReef);

        stepToReach.add(shipPoint);
    }

    public void createPath(RegattaGoal regattaGoal){
        if(spotting.isReefsBetween2Points(stepToReach.get(0), regattaGoal.getPositionActualOptiCheckpoint().toPoint())) {
            Point pathPoint = getANewValidStep(stepToReach.get(0), regattaGoal.getPositionActualOptiCheckpoint().toPoint());
            regattaGoal.setPathPoint(pathPoint);
        }
        regattaGoal.setPathPoint(null);
        /*for (int i = 0; i < stepToReach.size()-1; i++) {
            if(spotting.isReefsBetween2Points(stepToReach.get(i), regattaGoal.getPositionActualOptiCheckpoint().toPoint()))
                pathPoint = getANewValidStep(stepToReach.get(i), stepToReach.get(i+1));
        }*/
    }

    public Point getANewValidStep(Point startPoint, Point pointToReach){
        Point endStartPoint;
        Point endPointToReach;
        double angleToAdd = 0;
        while (true){
            angleToAdd += 2*Math.PI/180;
            endStartPoint = spotting.findEndPointOfALine(startPoint, pointToReach, angleToAdd, 1000);
            endPointToReach = spotting.findEndPointOfALine(pointToReach,startPoint, -angleToAdd, 1000);
            if(!spotting.isReefsBetween2Points(startPoint, endStartPoint) && !spotting.isReefsBetween2Points(pointToReach, endPointToReach)){
                return spotting.findLineIntersection(startPoint,endStartPoint,pointToReach,endPointToReach);
            }
            endStartPoint = spotting.findEndPointOfALine(startPoint, pointToReach, -angleToAdd, 1000);
            endPointToReach = spotting.findEndPointOfALine(pointToReach, startPoint, angleToAdd, 1000);
            if(!spotting.isReefsBetween2Points(startPoint, endStartPoint) && !spotting.isReefsBetween2Points(pointToReach, endPointToReach)){
                return spotting.findLineIntersection(startPoint,endStartPoint,pointToReach,endPointToReach);
            }
        }
    }
}
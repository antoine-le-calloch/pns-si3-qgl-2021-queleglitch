package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import java.util.ArrayList;
import java.util.List;

public class FindPath {

    private final Spotting spotting;
    private final List<Point> stepToReach;

    public FindPath(Point shipPoint, List<Reef> visibleReef){
        this.stepToReach = new ArrayList<>();
        this.spotting = new Spotting(visibleReef);

        stepToReach.add(shipPoint);
    }

    public void createPath(RegattaGoal regattaGoal){
        if(spotting.isReefsBetween2Points(stepToReach.get(0), regattaGoal.getPositionActualOptiCheckpoint().toPoint())) {
            Point pathPoint = getANewValidStep(stepToReach.get(0), regattaGoal.getPositionActualOptiCheckpoint().toPoint());
            regattaGoal.setPathPoint(pathPoint);
        }
        else
            regattaGoal.setPathPoint(null);
        /*for (int i = 0; i < stepToReach.size()-1; i++) {
            if(spotting.isReefsBetween2Points(stepToReach.get(i), regattaGoal.getPositionActualOptiCheckpoint().toPoint()))
                pathPoint = getANewValidStep(stepToReach.get(i), stepToReach.get(i+1));
        }*/
    }

    public Point getANewValidStep(Point startPoint, Point pointToReach){
        Point endStartPoint;
        Point endPointToReach;
        double distanceToAdd = 0;
        while (true){
            distanceToAdd += 5;
            endStartPoint = spotting.findEndPointOfALine(startPoint, pointToReach, distanceToAdd);
            endPointToReach = spotting.findEndPointOfALine(pointToReach,startPoint, -distanceToAdd);
            if(!spotting.isReefsBetween2Points(startPoint, endStartPoint) && !spotting.isReefsBetween2Points(pointToReach, endPointToReach)){
                distanceToAdd += 5;
                endStartPoint = spotting.findEndPointOfALine(startPoint, pointToReach, distanceToAdd);
                endPointToReach = spotting.findEndPointOfALine(pointToReach,startPoint, -distanceToAdd);
                return spotting.findLineIntersection(startPoint,endStartPoint,pointToReach,endPointToReach);
            }
            endStartPoint = spotting.findEndPointOfALine(startPoint, pointToReach, -distanceToAdd);
            endPointToReach = spotting.findEndPointOfALine(pointToReach, startPoint, distanceToAdd);
            if(!spotting.isReefsBetween2Points(startPoint, endStartPoint) && !spotting.isReefsBetween2Points(pointToReach, endPointToReach)){
                distanceToAdd += 5;
                endStartPoint = spotting.findEndPointOfALine(startPoint, pointToReach, -distanceToAdd);
                endPointToReach = spotting.findEndPointOfALine(pointToReach, startPoint, distanceToAdd);
                return spotting.findLineIntersection(startPoint,endStartPoint,pointToReach,endPointToReach);
            }
        }
    }
}
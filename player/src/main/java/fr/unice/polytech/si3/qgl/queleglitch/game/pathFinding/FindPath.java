package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import java.util.List;

public class FindPath {

    private final Spotting spotting;
    private final Point shipPoint;
    private final int shipWight;

    public FindPath(int shipWight, Point shipPoint,List<Reef> visibleReef){
        this.spotting = new Spotting(visibleReef);
        this.shipPoint = shipPoint;
        this.shipWight = shipWight;
    }

    public void createPath(RegattaGoal regattaGoal){
        if(spotting.isReefsOnTheShipWay(shipWight, shipPoint.toPosition(), regattaGoal.getPositionActualOptiCheckpoint())) {
            Point pathPoint = getANewValidStep(shipPoint, regattaGoal.getPositionActualOptiCheckpoint().toPoint());
            regattaGoal.setPathPoint(pathPoint);
        }
        else
            regattaGoal.setPathPoint(null);
    }

    public Point getANewValidStep(Point startPoint, Point pointToReach){
        Point endStartPoint;
        Point endPointToReach;
        double distanceToAdd = 0;
        while (true){
            distanceToAdd += 5;
            endStartPoint = spotting.findEndPointOfALine(startPoint, pointToReach, distanceToAdd);
            endPointToReach = spotting.findEndPointOfALine(pointToReach,startPoint, -distanceToAdd);
            if(!spotting.isReefsOnTheShipWay(shipWight, startPoint.toPosition(), endStartPoint.toPosition()) && !spotting.isReefsOnTheShipWay(shipWight, pointToReach.toPosition(), endPointToReach.toPosition())){
                return spotting.findLineIntersection(startPoint,endStartPoint,pointToReach,endPointToReach);
            }

            endStartPoint = spotting.findEndPointOfALine(startPoint, pointToReach, -distanceToAdd);
            endPointToReach = spotting.findEndPointOfALine(pointToReach, startPoint, distanceToAdd);
            if(!spotting.isReefsOnTheShipWay(shipWight, startPoint.toPosition(), endStartPoint.toPosition()) && !spotting.isReefsOnTheShipWay(shipWight, pointToReach.toPosition(), endPointToReach.toPosition())){
                return spotting.findLineIntersection(startPoint,endStartPoint,pointToReach,endPointToReach);
            }
        }
    }
}
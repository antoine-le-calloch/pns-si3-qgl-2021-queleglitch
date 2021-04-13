package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.Geometry;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import java.util.List;

public class FindPath {

    private final Spotting spotting;
    private final Point shipPoint;
    private Grid grid;
    private int shipWight;

    public FindPath(int shipWight, Point shipPoint,List<Reef> visibleReef){
        this.spotting = new Spotting(visibleReef);
        this.shipPoint = shipPoint;
        this.shipWight = shipWight;
    }

    public FindPath(Point shipPoint,List<Reef> visibleReef,Grid grid){
        this.spotting = new Spotting(visibleReef);
        this.shipPoint = shipPoint;
        this.grid = grid;
    }

    public void createPath(RegattaGoal regattaGoal){
        int[] columnLineOfCheckpoint = grid.getColAndLineOfAPosition(regattaGoal.getPositionActualOptiCheckpoint());
        int col = columnLineOfCheckpoint[0];
        int lin = columnLineOfCheckpoint[1];
        int caseWeight;
        Point virtualCheckpoint = regattaGoal.getPositionActualOptiCheckpoint().toPoint();
        while ((caseWeight = grid.getCase(col,lin).getCaseWeight()) > 0){
            if(grid.getCase(col+1,lin).getCaseWeight() < caseWeight) {
                caseWeight = grid.getCase(col + 1, lin).getCaseWeight();
                virtualCheckpoint = grid.getCase(col+1,lin).getCentralCasePoint();
            }
            if(grid.getCase(col,lin+1).getCaseWeight() < caseWeight) {
                caseWeight = grid.getCase(col + 1, lin).getCaseWeight();
                virtualCheckpoint = grid.getCase(col,lin+1).getCentralCasePoint();
            }
            if(grid.getCase(col-1,lin).getCaseWeight() < caseWeight) {
                caseWeight = grid.getCase(col + 1, lin).getCaseWeight();
                virtualCheckpoint = grid.getCase(col-1,lin).getCentralCasePoint();
            }
            if(grid.getCase(col,lin-1).getCaseWeight() < caseWeight) {
                caseWeight = grid.getCase(col + 1, lin).getCaseWeight();
                virtualCheckpoint = grid.getCase(col,lin-1).getCentralCasePoint();
            }
            if((caseWeight = grid.getCaseOfAPosition(virtualCheckpoint.toPosition()).getCaseWeight()) > 0) {
                regattaGoal.setPathPoints(virtualCheckpoint);
            }
            columnLineOfCheckpoint = grid.getColAndLineOfAPosition(virtualCheckpoint.toPosition());
            col = columnLineOfCheckpoint[0];
            lin = columnLineOfCheckpoint[1];
        }
    }


}

/*public void createPath(RegattaGoal regattaGoal){
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
        }*/
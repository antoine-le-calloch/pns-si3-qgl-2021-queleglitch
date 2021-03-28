package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
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
        stepToReach.add(regattaGoal.getPositionActualOptiCheckpoint().toPoint());
        for (int i = 0; i < stepToReach.size()-1; i++) {
            if(spotting.isReefsBetween2Points(stepToReach.get(i), stepToReach.get(i+1)))
                addANewValidStep(stepToReach.get(i), stepToReach.get(i+1));
        }
    }

    public void addANewValidStep(Point startPoint, Point pointToReach){

    }
}

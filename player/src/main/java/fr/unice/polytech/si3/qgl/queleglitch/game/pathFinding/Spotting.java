package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;

import java.util.List;

public class Spotting {

    List<Reef> visibleReef;

    public Spotting(List<Reef> visibleReef){
        this.visibleReef = visibleReef;
    }

    public boolean isReefsBetween2Points(Point point1, Point point2){
        for (Reef reef : visibleReef) {
            if(isThisReefBetween2Points(reef,point1,point2))
                return true;
        }
        return false;
    }

    public boolean isThisReefBetween2Points(Reef reef, Point point1, Point point2){
        boolean pointInLeft = false;
        boolean pointInRight = false;
        double angleDifferenceP1ToPoint;
        double angleDifferenceP2ToPoint;
        double angleToPosition2FromPosition1 = point1.getAngleToAPoint(point2);
        for (Point point : reef.getReelPointsForm()) {
            angleDifferenceP1ToPoint = point1.getAngleToAPoint(point) - angleToPosition2FromPosition1;
            angleDifferenceP2ToPoint = point2.getAngleToAPoint(point) - angleToPosition2FromPosition1 - Math.PI;

            if(Math.cos(angleDifferenceP1ToPoint) >= 0 && Math.cos(angleDifferenceP2ToPoint) >= 0) {
                pointInLeft = pointInLeft || Math.sin(angleDifferenceP1ToPoint) >= 0;
                pointInRight = pointInRight || Math.sin(angleDifferenceP1ToPoint) <= 0;
            }
            if(pointInLeft && pointInRight)
                return true;
        }
        return false;
    }
}

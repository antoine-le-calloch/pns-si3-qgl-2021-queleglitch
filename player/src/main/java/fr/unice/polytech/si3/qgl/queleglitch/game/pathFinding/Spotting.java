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

    public Point findEndPointOfALine(Point point1, Point point2, double angleToAdd, double lineLength){
        double x = Math.cos(point1.getAngleToAPoint(point2)+angleToAdd) * lineLength;
        double y = Math.sin(point1.getAngleToAPoint(point2)+angleToAdd) * lineLength;
        return new Point(x,y);
    }

    public Point findLineIntersection(Point line1Start, Point line1End, Point line2Start, Point line2End){
        double line1Angle = line1Start.getAngleToAPoint(line1End);
        double x = line1Start.getX() + Math.cos(line1Angle)*line1Start.getNorm(line1End);
        double y = line1Start.getY() + Math.sin(line1Angle)*line1Start.getNorm(line1End);
        Point point1 = new Point(x,y);

        double line2Angle = line2Start.getAngleToAPoint(line2End);
        x = line1Start.getX() + Math.cos(line2Angle)*line2Start.getNorm(line2End);
        y = line1Start.getY() + Math.sin(line2Angle)*line2Start.getNorm(line2End);
        Point point2 = new Point(x,y);

        if(point1.equals(point2)){
            return new Point(x,y);
        }
        return null;
    }
}

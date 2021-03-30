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

    public Point findEndPointOfALine(Point startPoint, Point targetPoint, double distanceToAdd){
        double x = Math.cos(startPoint.getAngleToAPoint(targetPoint)+Math.PI/2) * distanceToAdd;
        double y = Math.sin(startPoint.getAngleToAPoint(targetPoint)+Math.PI/2) * distanceToAdd;
        return new Point(x + targetPoint.getX(),y + targetPoint.getY());
    }

    public Point findLineIntersection(Point line1Start, Point line1End, Point line2Start, Point line2End){
        if(line1Start.getX() == line1End.getX() && line2Start.getX() != line2End.getX()) {
            double aLine2 = (line2End.getY() - line2Start.getY()) / (line2End.getX() - line2Start.getX());
            double bLine2 = line2Start.getY() - aLine2*line2Start.getX();
            return new Point(line1Start.getX(), aLine2*line1Start.getX()+bLine2);
        }
        else if(line1Start.getX() != line1End.getX() && line2Start.getX() == line2End.getX()) {
            double aLine1 = (line1End.getY() - line1Start.getY()) / (line1End.getX() - line1Start.getX());
            double bLine1 = line1Start.getY() - aLine1*line1Start.getX();
            return new Point(line2Start.getX(), aLine1*line2Start.getX()+bLine1);
        }

        double aLine1 = (line1End.getY() - line1Start.getY()) / (line1End.getX() - line1Start.getX());
        double bLine1 = line1Start.getY() - aLine1*line1Start.getX();

        double aLine2 = (line2End.getY() - line2Start.getY()) / (line2End.getX() - line2Start.getX());
        double bLine2 = line2Start.getY() - aLine2*line2Start.getX();

        double x = (bLine2-bLine1)/(aLine1 - aLine2);
        double y = aLine1*x + bLine1;

        return new Point(x,y);
    }
}

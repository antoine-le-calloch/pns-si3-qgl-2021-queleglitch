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

    public boolean isThisReefBetween2Points(Reef reef, Point start, Point end){
        double angleStartToEnd = start.getAngleToAPoint(end);
        double angleEndToStart = end.getAngleToAPoint(start);
        Point[] formPoints = reef.getReelPointsForm();
        for (int i = 0; i < formPoints.length; i++) {
            double angleStartToFormPoint1 = start.getAngleToAPoint(formPoints[i]) - angleStartToEnd;
            double angleStartToFormPoint2 = start.getAngleToAPoint(formPoints[(i+1)%formPoints.length]) - angleStartToEnd;
            double angleEndToFormPoint1 = end.getAngleToAPoint(formPoints[i]) - angleEndToStart;
            double angleEndToFormPoint2 = end.getAngleToAPoint(formPoints[(i+1)%formPoints.length]) - angleEndToStart;
            if(isLineBetween(angleStartToFormPoint1,angleStartToFormPoint2,angleEndToFormPoint1,angleEndToFormPoint2)){
                return true;
            }
        }
        return false;
    }

    public boolean isLineBetween(double angleStartToFormPoint1, double angleStartToFormPoint2, double angleEndToFormPoint1, double angleEndToFormPoint2){
        if(     (Math.cos(angleStartToFormPoint1) >= 0 || Math.cos(angleStartToFormPoint2) >= 0) &&
                (Math.sin(angleStartToFormPoint1) <= 0 && Math.sin(angleStartToFormPoint2) >= 0 ||
                Math.sin(angleStartToFormPoint1) >= 0 && Math.sin(angleStartToFormPoint2) <= 0))
            return Math.cos(angleEndToFormPoint1) >= 0 || Math.cos(angleEndToFormPoint2) >= 0;

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

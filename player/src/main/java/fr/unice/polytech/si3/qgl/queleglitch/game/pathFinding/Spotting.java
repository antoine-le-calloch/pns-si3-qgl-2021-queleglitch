package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.Geometry;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;

import java.util.List;

public class Spotting {

    List<Reef> visibleReef;

    public Spotting(List<Reef> visibleReef){
        this.visibleReef = visibleReef;
    }

    public boolean isReefsOnTheShipWay(int shipWidth, Position shipPosition, Position positionToReach){
        Rectangle widthTakenByShip = new Rectangle(shipWidth+60,0, shipPosition.getAngleToAPosition(positionToReach));
        Point topShipPoint = widthTakenByShip.getRealPoints(shipPosition)[0];
        Point downShipPoint = widthTakenByShip.getRealPoints(shipPosition)[2];
        Point topCheckpointPoint = widthTakenByShip.getRealPoints(positionToReach)[0];
        Point downCheckpointPoint = widthTakenByShip.getRealPoints(positionToReach)[2];
        if(isReefPointsInRectangle(new Point[]{topCheckpointPoint,topShipPoint,downShipPoint,downCheckpointPoint}))
            return true;
        return isReefsBetween2Points(topShipPoint, topCheckpointPoint) || isReefsBetween2Points(downShipPoint, downCheckpointPoint) || isReefsBetween2Points(shipPosition.toPoint(), positionToReach.toPoint());
    }

    public boolean isReefsInaARectangle(Rectangle rectangle, Point rectangleCentralPoint){
        return isReefPointsInRectangle(rectangle.getRealPoints(rectangleCentralPoint)) || isReefSideInRectangle(rectangle.getRealPoints(rectangleCentralPoint));
    }

    public boolean isReefPointsInRectangle(Point[] rectanglePoint){
        for (Reef reef : visibleReef) {
            if(Geometry.isThisPointInARectangle(reef.getPosition().toPoint(),rectanglePoint))
                return true;
        }
        return false;
    }

    public boolean isReefSideInRectangle(Point[] rectanglePoint){
        return isReefsBetween2Points(rectanglePoint[1], rectanglePoint[0]) || isReefsBetween2Points(rectanglePoint[2], rectanglePoint[3]);
    }

    public boolean isReefsBetween2Points(Point point1, Point point2){
        for (Reef reef : visibleReef) {
            if(isThisReefBetween2Points(reef,point1,point2))
                return true;
        }
        return false;
    }

    public boolean isThisReefBetween2Points(Reef reef, Point pointStart, Point pointEnd){
        double angleStartToEnd = pointStart.getAngleToAPoint(pointEnd);
        double angleEndToStart = pointEnd.getAngleToAPoint(pointStart);
        Point[] formPoints = reef.getReelPointsForm();
        int NB_OF_POINTS= formPoints.length;
        int FIRST_POINT_OF_THE_REEF=0;
        int SHIFT_NEXT_POINT=1;
        for (int actualPoint = FIRST_POINT_OF_THE_REEF; actualPoint < NB_OF_POINTS; actualPoint++) {
            double angleStartToFormPoint1 = pointStart.getAngleToAPoint(formPoints[actualPoint]) - angleStartToEnd;
            double angleStartToFormPoint2 = pointStart.getAngleToAPoint(formPoints[(actualPoint+SHIFT_NEXT_POINT)%NB_OF_POINTS]) - angleStartToEnd;
            double angleEndToFormPoint1 = pointEnd.getAngleToAPoint(formPoints[actualPoint]) - angleEndToStart;
            double angleEndToFormPoint2 = pointEnd.getAngleToAPoint(formPoints[(actualPoint+SHIFT_NEXT_POINT)%NB_OF_POINTS]) - angleEndToStart;
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
            Line line2= new Line(line2Start,line2End);
            return new Point(line1Start.getX(), line2.coefficient*line1Start.getX()+line2.orderedAtTheOrigin);
        }
        else if(line1Start.getX() != line1End.getX() && line2Start.getX() == line2End.getX()) {
            Line line1= new Line(line1Start,line1End);
            return new Point(line2Start.getX(), line1.coefficient*line2Start.getX()+line1.orderedAtTheOrigin);
        }
        Line line1= new Line(line1Start,line1End);
        Line line2= new Line(line2Start,line2End);
        double x = (line2.orderedAtTheOrigin-line1.orderedAtTheOrigin)/(line1.coefficient - line2.coefficient);
        double y = line1.coefficient*x + line1.orderedAtTheOrigin;
        return new Point(x,y);
    }
}

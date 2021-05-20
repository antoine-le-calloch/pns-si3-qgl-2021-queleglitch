package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.Geometry;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Stream;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Spotting {

    private final List<Stream> visibleStream;
    private List<Reef> visibleReef;

    public Spotting(List<Reef> visibleReef,List<Stream> visibleStream){
        this.visibleReef = visibleReef;
        this.visibleStream = visibleStream;
        avoidBadStream();
    }

    public void avoidBadStream(){
        if(visibleStream != null) {
            for (Stream stream : visibleStream) {
                if (stream.getStrength() > 165)
                    if (visibleReef == null)
                        this.visibleReef = new ArrayList<>();
                this.visibleReef.add(new Reef(stream.getPosition(), stream.getShape()));
            }
        }
    }

    public boolean isReefsInARectangle(Point[] realRectanglePoints){
        return isReefPointsInRectangle(realRectanglePoints) || isReefSideInRectangle(realRectanglePoints);
    }

    public boolean isReefPointsInRectangle(Point[] rectanglePoint){
        for (Reef reef : visibleReef) {
            if(Geometry.isThisPointInARectangle(reef.getPosition().toPoint(),rectanglePoint))
                return true;
        }
        return false;
    }

    public boolean isReefSideInRectangle(Point[] rectanglePoint){
        return isReefsBetween2Points(rectanglePoint[0], rectanglePoint[1]) || isReefsBetween2Points(rectanglePoint[1], rectanglePoint[2]) ||
                isReefsBetween2Points(rectanglePoint[2], rectanglePoint[3]) || isReefsBetween2Points(rectanglePoint[3], rectanglePoint[0]);
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
        final int NB_OF_POINTS= formPoints.length;
        final int FIRST_POINT_OF_THE_REEF=0;
        final int SHIFT_NEXT_POINT=1;
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
}

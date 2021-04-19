package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;

public class Geometry {

    private final Position boatPosition;

    public Geometry(Position boatPosition) {
        this.boatPosition = boatPosition;
    }

    public double calculateAngleToCheckPoint(Position checkpointPosition){
        double checkPointX = checkpointPosition.getX();
        double checkPointY = checkpointPosition.getY();
        double shipAngle = boatPosition.getOrientation();
        double shipX = boatPosition.getX();
        double shipY = boatPosition.getY();
        double angle = 0;

        if(checkPointY-shipY==0 && checkPointX-shipX < 0){
            angle = Math.PI;
        }
        else if(checkPointX-shipX > 0 && checkPointY-shipY > 0){
            angle = Math.atan((checkPointY-shipY)/(checkPointX-shipX));
        }
        else if(checkPointX-shipX <= 0 && checkPointY-shipY > 0){
            angle = -Math.atan((checkPointX - shipX) / (checkPointY - shipY));
            angle += Math.PI / 2;
        }
        else if(checkPointX-shipX > 0 && checkPointY-shipY < 0){
            angle = -Math.atan((shipY-checkPointY)/(checkPointX-shipX));
        }
        else if(checkPointX-shipX <= 0 && checkPointY-shipY < 0){
            angle = Math.atan((shipX-checkPointX)/(checkPointY-shipY));
            angle -= Math.PI/2;
        }
        angle -= shipAngle;

        if(angle > Math.PI) {
            angle = (-2*Math.PI)+angle;
        }
        else if(angle < -Math.PI) {
            angle = (2*Math.PI)+angle;
        }
        return angle;
    }

    public static boolean isThisPointInARectangle(Point point, Point[] rectanglePoints){
        double rectangleAngle = rectanglePoints[1].getAngleToAPoint(rectanglePoints[0]);
        for (Point rectanglePoint : rectanglePoints) {
            if(rectanglePoint.equals(point))
                return true;
        }
        return  point.getAngleToAPoint(rectanglePoints[0])-rectangleAngle >= 0          && point.getAngleToAPoint(rectanglePoints[0])-rectangleAngle <= Math.PI/2  &&
                point.getAngleToAPoint(rectanglePoints[1])-rectangleAngle >= Math.PI/2  && point.getAngleToAPoint(rectanglePoints[1])-rectangleAngle <= Math.PI    &&
                point.getAngleToAPoint(rectanglePoints[2])-rectangleAngle >= -Math.PI   && point.getAngleToAPoint(rectanglePoints[2])-rectangleAngle <= -Math.PI/2 &&
                point.getAngleToAPoint(rectanglePoints[3])-rectangleAngle >= -Math.PI/2 && point.getAngleToAPoint(rectanglePoints[3])-rectangleAngle <= 0;
    }
}

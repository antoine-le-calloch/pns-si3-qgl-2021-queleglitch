package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

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
}

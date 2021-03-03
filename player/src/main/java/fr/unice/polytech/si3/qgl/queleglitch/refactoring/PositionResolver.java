package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;

public class PositionResolver {

    InformationGame informationGame;
    Position nextCheckPointPosition;
    Position currentBoatPosition;

    public PositionResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        this.nextCheckPointPosition=((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition();
        this.currentBoatPosition=informationGame.getShip().getPosition();
    }


    public boolean isCheckpointReached() {
        return nextCheckPointPosition.getNorme(informationGame.getShip().getPosition()) < ((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius();
    }


    public double calculateAngleToCheckPoint(){
        double checkPointX = nextCheckPointPosition.getX();
        double checkPointY = nextCheckPointPosition.getY();
        double shipAngle = currentBoatPosition.getOrientation();
        double shipX = currentBoatPosition.getX();
        double shipY = currentBoatPosition.getY();
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

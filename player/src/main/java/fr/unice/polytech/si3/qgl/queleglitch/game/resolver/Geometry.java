package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;

public class Geometry {

    InformationGame informationGame;
    Position actualCheckPointPosition;
    Position nextCheckPointPosition;
    Position currentBoatPosition;

    public Geometry(InformationGame informationGame) {
        this.informationGame = informationGame;
        this.nextCheckPointPosition=((RegattaGoal) informationGame.getGoal()).getNextCheckpoint().getPosition();
        this.actualCheckPointPosition = ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition();
        this.currentBoatPosition=informationGame.getShip().getPosition();
    }


    public boolean isCheckpointReached() {
        return nextCheckPointPosition.getNorme(informationGame.getShip().getPosition()) < ((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius();
    }

    // renvoie le max de sailors qui rament pour que ce soit opti
    int slowDown(){
        int NB_OARS = informationGame.getShip().getRames().size();
        double radius = ((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius();

        // il y a un prochain checkpoint au bon angle , et la distance bateau / point le plus proche du checkpoint < 165
        // -> longueur < n * (165/ nbRadius) <=> longueur / 165/nbRadius
        if (!((RegattaGoal) informationGame.getGoal()).isLastCheckpoint() &&
                (calculateAngleToCheckPoint() > (Math.PI / 2) - (5 * Math.PI / 180.0) &&
                calculateAngleToCheckPoint() < (-Math.PI / 2) + (5 * Math.PI / 180.0)) &&
                (actualCheckPointPosition.getNorme(currentBoatPosition) - radius) - 165 < 0)
            return (int) ((actualCheckPointPosition.getNorme(currentBoatPosition) - radius) / (165.0 / NB_OARS));

        // la distance bateau / point le plus eloigné du checkpoint < 165
        // -> longueur < n * (165/ nbRadius) <=> longueur / 165/nbRadius
        if ((actualCheckPointPosition.getNorme(currentBoatPosition) + radius) - 165 < 0)
            return (int) ((actualCheckPointPosition.getNorme(currentBoatPosition) + radius) / (165.0 / NB_OARS));

        // si aucun des cas, osef , on prend le max
        return NB_OARS;

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

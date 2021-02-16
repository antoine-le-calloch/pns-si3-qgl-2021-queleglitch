package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

public class TurnStrat {
    Position shipPosition;
    Position checkPointPosition;
    double checkPointRadius;

    public TurnStrat(Position checkPointPosition, Position shipPosition, double checkPointRadius) {
        this.checkPointPosition = checkPointPosition;
        this.shipPosition = shipPosition;
        this.checkPointRadius = checkPointRadius;
    }

    //calculer angle bateau / checkpoint
    public double calculateAngle(){
        double shipX = shipPosition.getX();
        double shipY = shipPosition.getY();
        double shipAngle = shipPosition.getOrientation();
        double checkPointX = checkPointPosition.getX();
        double checkPointY = checkPointPosition.getY();
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

    /*boolean slowDownForFutureCheckpoint(int nbLeftOar, int nbRightOar){
        if(nbLeftOar != nbRightOar)
            return false;

        if(calculateAngle())
    }*/

    ToolsToUse findToolsToUse(){
        double angle = calculateAngle();
        boolean positiveAngle = true;
        int nbLeftOar = 2;
        int nbRightOar = 2;

        if(angle < 0){
            positiveAngle = false;
            angle *= -1;
        }

        if (angle >= 5 * Math.PI / 12){
            nbLeftOar = 0;
            nbRightOar = 3;
        }
        else if (angle >= 3 * Math.PI / 12){
            nbLeftOar = 1;
            nbRightOar = 3;
        }
        else if (angle >= Math.PI / 12){
            nbLeftOar = 1;
            nbRightOar = 2;
        }

        if(checkPointPosition.getNorme(shipPosition) < 110 - checkPointRadius){// || slowDownForFutureCheckpoint(nbLeftOar,nbRightOar)) {
            nbLeftOar--;
            nbRightOar--;
        }

        if(positiveAngle)
            return new ToolsToUse(nbLeftOar, nbRightOar);
        else
            return new ToolsToUse(nbRightOar, nbLeftOar);
    }

    // retourne les éléments à utliser et la facon de les utiliser (rames, gouvernail...)
    public ToolsToUse getToolsToUse() {
        return findToolsToUse();
    }
}

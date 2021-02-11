package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class TurnStrat {
    Position shipPosition;
    Position checkPointPosition;

    public TurnStrat(InformationGame informationGame, NextRound nextRound) {
        checkPointPosition = ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition();
        shipPosition = nextRound.ship.position;
    }

    //calculer angle bateau / checkpoint
    public double calculateAngle(){
        double shipX = shipPosition.getX();
        double shipY = shipPosition.getY();
        double shipAngle = shipPosition.getOrientation();
        double checkPointX = checkPointPosition.getX();
        double checkPointY = checkPointPosition.getY();

        double angle = 0;
        if(checkPointX-shipX > 0 && checkPointY-shipY >= 0){
            angle = Math.atan((checkPointY-shipY)/(checkPointX-shipX));
        }
        else if(checkPointX-shipX <= 0 && checkPointY-shipY > 0){
            angle = Math.atan((checkPointX-shipX)/(checkPointY-shipY));
            angle += Math.PI/2;
        }
        else if(checkPointX-shipX > 0 && checkPointY-shipY <= 0){
            angle = Math.atan((shipY-checkPointY)/(checkPointX-shipX));
        }
        else if(checkPointX-shipX <= 0 && checkPointY-shipY < 0){
            angle = Math.atan((shipX-checkPointX)/(checkPointY-shipY));
            angle -= Math.PI/2;
        }
        angle -= shipAngle;
        if(angle > Math.PI) {
            angle -= Math.PI;
            angle *= -1;
        }
        if(angle < -Math.PI) {
            angle += Math.PI;
            angle *= -1;
        }
        return angle;
    }

    ToolsToUse angleSmallerThan90(double angle, int signe){
        if(angle >= Math.PI / 24)
            return new ToolsToUse(signe*angle,1,1);

        return new ToolsToUse(0,2,2);
    }

    ToolsToUse angleGreaterThan90(double angle, int signe){
        if(signe > 0) {
            if (angle >= Math.PI / 24)
                return new ToolsToUse(signe * angle, 0, 3);

            return new ToolsToUse(0, 0, 3);
        }
        else{
            if (angle >= Math.PI / 24)
                return new ToolsToUse(signe * angle, 3, 0);

            return new ToolsToUse(0, 3, 0);
        }
    }

    ToolsToUse findToolsToUse(){
        int signe = 1;
        double angleCalculated = calculateAngle();

        if(angleCalculated < 0){
            signe = -1;
            angleCalculated *= signe;
        }

        if(angleCalculated > Math.PI / 2)
            return angleGreaterThan90(angleCalculated - Math.PI / 2,signe);
        else
            return angleSmallerThan90(angleCalculated,signe);
    }

    // retourne les éléments à utliser et la facon de les utiliser (rames, gouvernail...)
    public ToolsToUse getToolsToUse() {
        return findToolsToUse();
    }
}

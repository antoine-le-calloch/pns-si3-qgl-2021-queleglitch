package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class TurnStrat {
    Position shipPosition;
    Position checkPointPosition;

    public TurnStrat(Position checkPointPosition, Position shipPosition) {
        this.checkPointPosition = checkPointPosition;
        this.shipPosition = shipPosition;
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

    ToolsToUse findToolsToUse(){
        double angle = calculateAngle();

        if (angle >= 5*Math.PI / 12)
            return new ToolsToUse(0, 3);
        if (angle >= 3*Math.PI / 12)
            return new ToolsToUse(1, 3);
        if (angle >= Math.PI / 12)
            return new ToolsToUse(1, 2);

        if (angle <= -5*Math.PI / 12)
            return new ToolsToUse(3, 0);
        if (angle <= -3*Math.PI / 12)
            return new ToolsToUse(3, 1);
        if (angle <= -1*Math.PI / 12)
            return new ToolsToUse(2, 1);

        return new ToolsToUse(2,2);
    }

    // retourne les éléments à utliser et la facon de les utiliser (rames, gouvernail...)
    public ToolsToUse getToolsToUse() {
        return findToolsToUse();
    }
}

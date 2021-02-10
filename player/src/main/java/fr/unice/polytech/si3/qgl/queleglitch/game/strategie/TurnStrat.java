package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class TurnStrat {
    Position shipPosition;
    Position checkPointPosition;

    public TurnStrat(InitGame initGame,NextRound nextRound) {
        checkPointPosition = ((RegattaGoal) initGame.getGoal()).getActualCheckpoint().getPosition();
        shipPosition = nextRound.ship.position;
    }

    //calculer angle bateau / checkpoint
    public double calculateAngle(){
        double shipAngle =Math.atan2(shipPosition.y, shipPosition.x);
        double checkpointAngle=Math.atan2(checkPointPosition.y, checkPointPosition.x);
        return checkpointAngle-shipAngle;
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

package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;

public class Strat {
    Ship ship;
    ToolsToUse toolsToUse;
    RegattaGoal regattaGoal;
    Position actualCheckPointPosition;

    int MAX_ROWER = 4; //A changer
    double checkPointRadius;

    public Strat(RegattaGoal regattaGoal, Ship ship, double checkPointRadius) {
        toolsToUse = new ToolsToUse();
        this.ship = ship;
        this.regattaGoal = regattaGoal;
        this.checkPointRadius = checkPointRadius;
        this.actualCheckPointPosition = regattaGoal.getActualCheckpoint().getPosition();
    }

    void turnWIthOar(){
        double angle = ship.calculateAngleToCheckPoint(actualCheckPointPosition);
        boolean positiveAngle = true;
        int nbLeftOar = 2; //A changer
        int nbRightOar = 2; //A changer

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

        if(actualCheckPointPosition.getNorme(ship.getPosition()) < (165.0 * (MAX_ROWER) / 6.0) - checkPointRadius || slowDownForFutureCheckpoint(nbLeftOar,nbRightOar)) {
            nbLeftOar--;
            nbRightOar--;
        }

        if(positiveAngle) {
            toolsToUse.setNbLeftOarToUse(nbLeftOar);
            toolsToUse.setNbRightOarToUse(nbRightOar);
        }
        else {
            toolsToUse.setNbLeftOarToUse(nbRightOar);
            toolsToUse.setNbRightOarToUse(nbLeftOar);
        }
    }

    void turnWIthRudder(double angle, int signe){
        toolsToUse.setRudderAngle(signe*angle);
        toolsToUse.setNbLeftOarToUse(MAX_ROWER/2 - 1);
        toolsToUse.setNbRightOarToUse(MAX_ROWER/2 - 1);
    }

    boolean slowDownForFutureCheckpoint(int nbLeftOar, int nbRightOar){
        if( regattaGoal.isLastCheckpoint() ||
            (ship.calculateAngleToCheckPoint(regattaGoal.getNextCheckpoint().getPosition()) < Math.PI/2 &&
            ship.calculateAngleToCheckPoint(regattaGoal.getNextCheckpoint().getPosition()) > -Math.PI/2))
            return false;

        return actualCheckPointPosition.getNorme(ship.getPosition()) - checkPointRadius < (165.0 * (nbLeftOar + nbRightOar) / 6.0) && actualCheckPointPosition.getNorme(ship.getPosition()) - checkPointRadius < (165.0 * (nbLeftOar + nbRightOar - 2) / 6.0);
    }

    ToolsToUse findToolsToUse(){
        double angle = ship.calculateAngleToCheckPoint(actualCheckPointPosition);
        int signe = 1;

        if(angle < 0) {
            angle *= (signe = -1);
        }

        if(angle >= Math.PI / 2)
            turnWIthOar();
        else if(angle >= Math.PI / 24)
            turnWIthRudder(angle, signe);

        return toolsToUse;
    }

    // retourne les éléments à utliser et la facon de les utiliser (rames, gouvernail...)
    public ToolsToUse getToolsToUse() {
        return findToolsToUse();
    }
}
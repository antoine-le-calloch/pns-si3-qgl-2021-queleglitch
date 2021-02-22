package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;

public class Strat {
    private final Ship ship;
    private final ToolsToUse toolsToUse;
    private final RegattaGoal regattaGoal;
    private final Position actualCheckPointPosition;

    private final int NB_OAR;
    private final int NB_ROWER;
    private final double checkPointRadius;

    public Strat(InformationGame informationGame) {
        this.ship = informationGame.getShip();
        this.NB_OAR = informationGame.getShip().getRames().size();
        this.NB_ROWER = informationGame.getSailors().length;
        this.toolsToUse = new ToolsToUse(0,NB_ROWER/2,NB_ROWER/2);
        this.regattaGoal = (RegattaGoal) informationGame.getGoal();
        this.checkPointRadius = ((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius();
        this.actualCheckPointPosition = regattaGoal.getActualCheckpoint().getPosition();
    }

    boolean slowDownForFutureCheckpoint(int nbLeftOarToUse, int nbRightOarToUse){
        if( regattaGoal.isLastCheckpoint() ||
                (ship.calculateAngleToCheckPoint(regattaGoal.getNextCheckpoint().getPosition()) < Math.PI/2 &&
                        ship.calculateAngleToCheckPoint(regattaGoal.getNextCheckpoint().getPosition()) > -Math.PI/2))
            return false;

        return actualCheckPointPosition.getNorme(ship.getPosition()) - checkPointRadius <= (165.0 * (nbLeftOarToUse + nbRightOarToUse - 2) / NB_OAR);
    }

    boolean slowDown(int nbLeftOarToUse, int nbRightOarToUse){
        return (actualCheckPointPosition.getNorme(ship.getPosition()) < (165.0 * (nbLeftOarToUse + nbRightOarToUse) / NB_OAR) - checkPointRadius
                || slowDownForFutureCheckpoint(nbLeftOarToUse,nbRightOarToUse))
                && nbLeftOarToUse == nbRightOarToUse
                && nbLeftOarToUse-1 != 0;
    }

    void turnWIthOar(double angleToCheckPoint){
        int nbOfBaseAnglesInAngle;
        int nbLeftOarToUse = NB_OAR/2, nbRightOarToUse = NB_OAR/2;
        double actualAngle;

        nbOfBaseAnglesInAngle = (int) (Math.round(angleToCheckPoint/(Math.PI/NB_OAR)));

        if(nbOfBaseAnglesInAngle > 0) {
            nbLeftOarToUse -= nbOfBaseAnglesInAngle;
        }
        else {
            nbRightOarToUse += nbOfBaseAnglesInAngle;
        }

        while (nbLeftOarToUse+nbRightOarToUse >= NB_ROWER && !(nbLeftOarToUse-1<=0 && nbRightOarToUse-1<=0)){
            nbLeftOarToUse = Math.max(nbLeftOarToUse-1,0);
            nbRightOarToUse = Math.max(nbRightOarToUse-1,0);
        }

        actualAngle = (nbRightOarToUse - nbLeftOarToUse)*Math.PI/NB_OAR;

        toolsToUse.setNbLeftOarToUse(nbLeftOarToUse);
        toolsToUse.setNbRightOarToUse(nbRightOarToUse);
        toolsToUse.setRudderAngle(angleToCheckPoint - actualAngle);
    }

    void turnWIthRudder(double angle){
        double actualRudderAngle = toolsToUse.getRudderAngle();

        toolsToUse.setRudderAngle(actualRudderAngle+angle);
    }

    ToolsToUse findToolsToUse(){
        double angleToCheckPoint = ship.calculateAngleToCheckPoint(actualCheckPointPosition);
        int signe = 1;

        if(angleToCheckPoint < 0) {
            angleToCheckPoint *= (signe = -1);
        }

        if(angleToCheckPoint > 3*Math.PI / 4){
            turnWIthOar((Math.PI / 2)*signe);
            turnWIthRudder((Math.PI / 4)*signe);
        }
        else if (angleToCheckPoint > Math.PI / 4) {
            turnWIthOar((Math.PI / 2) * signe);
            turnWIthRudder((angleToCheckPoint - Math.PI / 2) * signe);
        }
        else if (angleToCheckPoint > 1.0 * Math.PI / 180.0) {
            if(NB_ROWER%2 == 0 && angleToCheckPoint-Math.PI / NB_OAR >= -Math.PI/4) {
                turnWIthOar(-Math.PI / NB_OAR * signe);
                turnWIthRudder((angleToCheckPoint-Math.PI / NB_OAR)*signe);
            }
            else {
                turnWIthOar(0.0);
                turnWIthRudder(angleToCheckPoint * signe);
            }
        }

        if(slowDown(toolsToUse.getNbLeftOarToUse(),toolsToUse.getNbRightOarToUse())){
            toolsToUse.decreaseNbSailors();
        }
        return toolsToUse;
    }

    // retourne les éléments à utliser et la facon de les utiliser (rames, gouvernail...)
    public ToolsToUse getToolsToUse() {
        return findToolsToUse();
    }
}
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
                && !(nbLeftOarToUse-1 <= 0 && nbRightOarToUse-1 <= 0);
    }

    void turnWIthOar(double angleToCheckPoint){
        int nbOfBaseAnglesInAngle;
        int nbLeftOar = NB_ROWER/2,nbRightOar = NB_ROWER/2;
        if(NB_ROWER%2==1) {
            nbLeftOar++;
            nbRightOar++;
        }

        nbOfBaseAnglesInAngle = (int) (Math.round(angleToCheckPoint/(Math.PI/NB_OAR)));

        if(nbOfBaseAnglesInAngle > 0) {
            nbLeftOar -= nbOfBaseAnglesInAngle;
            if(nbLeftOar < 0) {
                nbRightOar += -nbLeftOar;
                nbLeftOar = 0;
            }
        }
        else {
            nbRightOar -= -nbOfBaseAnglesInAngle;
            if(nbRightOar < 0) {
                nbLeftOar += -nbRightOar;
                nbRightOar = 0;
            }
        }

        toolsToUse.setNbLeftOarToUse(nbLeftOar);
        toolsToUse.setNbRightOarToUse(nbRightOar);

        if(slowDown(nbLeftOar,nbRightOar)) {
            toolsToUse.decreaseNbSailors();
        }
    }

    void turnWIthRudder(double angle){
        int nbLeftOarToUse = toolsToUse.getNbLeftOarToUse();
        int nbRightOarToUse = toolsToUse.getNbRightOarToUse();

        toolsToUse.setRudderAngle(angle);

        if(nbLeftOarToUse+nbRightOarToUse >= NB_ROWER && nbLeftOarToUse == nbRightOarToUse) {
            toolsToUse.decreaseNbSailors();
        }
    }

    ToolsToUse findToolsToUse(){
        double angleToCheckPoint = ship.calculateAngleToCheckPoint(actualCheckPointPosition);
        int signe = 1;

        if(angleToCheckPoint < 0) {
            angleToCheckPoint *= (signe = -1);
        }

        if(angleToCheckPoint > Math.PI / 4) {
            turnWIthOar((Math.PI / 2)*signe);
            angleToCheckPoint -= Math.PI / 2;
        }

        if(angleToCheckPoint >= 1.0*Math.PI / 180.0 || angleToCheckPoint <= -1.0*Math.PI / 180.0)
            turnWIthRudder(angleToCheckPoint * signe);

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
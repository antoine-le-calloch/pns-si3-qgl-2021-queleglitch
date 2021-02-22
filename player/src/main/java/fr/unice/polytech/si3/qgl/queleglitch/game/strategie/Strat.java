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

    boolean slowDownForFutureCheckpoint(int nbLeftOar, int nbRightOar){
        if( regattaGoal.isLastCheckpoint() ||
                (ship.calculateAngleToCheckPoint(regattaGoal.getNextCheckpoint().getPosition()) < Math.PI/2 &&
                        ship.calculateAngleToCheckPoint(regattaGoal.getNextCheckpoint().getPosition()) > -Math.PI/2))
            return false;

        return actualCheckPointPosition.getNorme(ship.getPosition()) - checkPointRadius <= (165.0 * (nbLeftOar + nbRightOar - 2) / NB_OAR);
    }

    boolean slowDown(int nbLeftOar, int nbRightOar){
        return (actualCheckPointPosition.getNorme(ship.getPosition()) < (165.0 * (NB_ROWER) / NB_OAR) - checkPointRadius || slowDownForFutureCheckpoint(nbLeftOar,nbRightOar)) && !(nbLeftOar-1 == 0 && nbRightOar-1 == 0);
    }

    void turnWIthOar(double angleToCheckPoint){
        int nbOfBaseAnglesInAngle;
        int nbLeftOar = NB_ROWER/2,nbRightOar = NB_ROWER/2; // a tester
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

        if(actualCheckPointPosition.getNorme(ship.getPosition()) < (165.0 * (NB_ROWER) / NB_OAR) - checkPointRadius || slowDownForFutureCheckpoint(nbLeftOar,nbRightOar)) {
            nbLeftOar--;
            nbRightOar--;
        }

        toolsToUse.setToolsToUse(0,nbLeftOar,nbRightOar);
    }

    void turnWIthRudder(double angle){
        int nbLeftOar = toolsToUse.getNbLeftOarToUse();
        int nbRightOar = toolsToUse.getNbRightOarToUse();

        if(nbLeftOar+nbRightOar < NB_ROWER)
            toolsToUse.setToolsToUse(angle,nbLeftOar,nbRightOar);
        else if(nbLeftOar == nbRightOar)
            toolsToUse.setToolsToUse(angle,--nbLeftOar,--nbRightOar);
    }

    ToolsToUse findToolsToUse(){
        double angleToCheckPoint = ship.calculateAngleToCheckPoint(actualCheckPointPosition);
        int signe = 1;

        if(angleToCheckPoint < 0) {
            angleToCheckPoint *= (signe = -1);
        }

        if(angleToCheckPoint >= Math.PI / 2) {
            turnWIthOar((Math.PI / 2)*signe);
            angleToCheckPoint -= Math.PI / 2;
        }

        if(angleToCheckPoint >= 3*Math.PI / 180)
            turnWIthRudder(angleToCheckPoint*signe);

        if(slowDown(toolsToUse.getNbLeftOarToUse(),toolsToUse.getNbRightOarToUse())){
            toolsToUse.setNbLeftOarToUse(toolsToUse.getNbLeftOarToUse()-1);
            toolsToUse.setNbRightOarToUse(toolsToUse.getNbRightOarToUse()-1);
        }

        return toolsToUse;
    }

    // retourne les éléments à utliser et la facon de les utiliser (rames, gouvernail...)
    public ToolsToUse getToolsToUse() {
        return findToolsToUse();
    }
}
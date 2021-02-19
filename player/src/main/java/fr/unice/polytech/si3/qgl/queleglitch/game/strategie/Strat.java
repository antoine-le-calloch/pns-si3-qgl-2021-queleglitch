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

    public Strat(InformationGame informationGame, double checkPointRadius) {
        toolsToUse = new ToolsToUse();
        this.ship = informationGame.getShip();
        this.NB_OAR = informationGame.getShip().getRames().size();
        this.NB_ROWER = informationGame.getSailors().length;
        this.regattaGoal = (RegattaGoal) informationGame.getGoal();
        this.checkPointRadius = checkPointRadius;
        this.actualCheckPointPosition = regattaGoal.getActualCheckpoint().getPosition();
    }

    void turnWIthOar(){
        double angleCheckpoint = ship.calculateAngleToCheckPoint(actualCheckPointPosition);
        int nbMinimumPossibleAngle;
        int nbLeftOar = NB_ROWER/2,nbRightOar = NB_ROWER/2; // a tester
        if(NB_ROWER%2==1) {
            nbLeftOar++;
            nbRightOar++;
        }

        nbMinimumPossibleAngle = (int) (angleCheckpoint/(Math.PI/NB_OAR));

        if(nbMinimumPossibleAngle > 0)
            nbRightOar -= nbMinimumPossibleAngle;
        else
            nbLeftOar -= nbMinimumPossibleAngle;

        if(actualCheckPointPosition.getNorme(ship.getPosition()) < (165.0 * (NB_ROWER) / NB_OAR) - checkPointRadius || slowDownForFutureCheckpoint(nbLeftOar,nbRightOar)) {
            nbLeftOar--;
            nbRightOar--;
        }

        toolsToUse.setToolsToUse(0,nbLeftOar,nbRightOar);
    }

    void turnWIthRudder(double angle, int signe){
        int rowerBySide = NB_ROWER/2;
        if(NB_ROWER%2==0)
            rowerBySide--;
        toolsToUse.setToolsToUse(signe*angle,rowerBySide,rowerBySide);
    }

    boolean slowDownForFutureCheckpoint(int nbLeftOar, int nbRightOar){
        if( regattaGoal.isLastCheckpoint() ||
            (ship.calculateAngleToCheckPoint(regattaGoal.getNextCheckpoint().getPosition()) < Math.PI/2 &&
            ship.calculateAngleToCheckPoint(regattaGoal.getNextCheckpoint().getPosition()) > -Math.PI/2))
            return false;

        return actualCheckPointPosition.getNorme(ship.getPosition()) - checkPointRadius < (165.0 * (nbLeftOar + nbRightOar) / NB_OAR) && actualCheckPointPosition.getNorme(ship.getPosition()) - checkPointRadius < (165.0 * (nbLeftOar + nbRightOar - 2) / NB_OAR);
    }

    ToolsToUse findToolsToUse(){
        double angle = ship.calculateAngleToCheckPoint(actualCheckPointPosition);
        int signe = 1;

        if(angle < 0) {
            angle *= (signe = -1);
        }

        if(angle >= Math.PI / 2) {
            turnWIthOar();
            angle -= Math.PI / 2;
        }

        if(angle >= 3*Math.PI / 180)
            turnWIthRudder(angle, signe);

        return toolsToUse;
    }

    // retourne les éléments à utliser et la facon de les utiliser (rames, gouvernail...)
    public ToolsToUse getToolsToUse() {
        return findToolsToUse();
    }
}
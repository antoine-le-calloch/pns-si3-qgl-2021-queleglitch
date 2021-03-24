package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.SailStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

public class RegattaResolver {

    Geometry geometry;
    OarStrategy oarStrategy;
    RudderStrategy rudderStrategy;
    SailStrategy SailStrategy;
    InformationGame informationGame;
    ShipMovementResolver shipMovementResolver;

    public RegattaResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame.getShip().getPosition());
        oarStrategy = new OarStrategy(informationGame.getSailors().length, informationGame.getShip().getNbOars());
        rudderStrategy = new RudderStrategy(informationGame);
        SailStrategy = new SailStrategy(informationGame);
        shipMovementResolver = new ShipMovementResolver(informationGame.getShip(), informationGame.getWind(), informationGame.getRegattaGoal());
    }


    public RegattaResolver(Geometry geometry, OarStrategy oarStrategy, RudderStrategy rudderStrategy, SailStrategy SailStrategy, ShipMovementResolver shipMovementResolver) {
        this.geometry = geometry;
        this.oarStrategy = oarStrategy;
        this.rudderStrategy = rudderStrategy;
        this.SailStrategy = SailStrategy;
        this.informationGame = new InformationGame();
        this.shipMovementResolver = shipMovementResolver;
    }

    public ToolsToUse resolveToolsToUse(Position positionCheckpointToReach) {
        Double angleToCorrect = geometry.calculateAngleToCheckPoint(positionCheckpointToReach);
        double rudderAngle = rudderStrategy.getRudderAngle(angleToCorrect);
        SailAction actionOnSails = SailStrategy.getSailsAction();
        int differenceOarRightLeft = oarStrategy.getDifferenceOarRightLeft(angleToCorrect);
        NbOarsUsed nbOarsUsed = oarStrategy.getNbOarsUsed(rudderAngle != 0,actionOnSails != SailAction.DO_NOTHING, differenceOarRightLeft);
        int maxLeftOarUse = nbOarsUsed.onLeft();
        int maxRightOarUse = nbOarsUsed.onRight();
        boolean changeSailSetting = false;

        if(Math.abs(angleToCorrect) < Math.PI/4) {
            while (shipMovementResolver.isCheckpointMissed(positionCheckpointToReach, rudderAngle, actionOnSails, nbOarsUsed)) {
                if (nbOarsUsed.onLeft() >= 1 && nbOarsUsed.onRight() >= 1 && (nbOarsUsed.onLeft() != nbOarsUsed.onRight() || nbOarsUsed.onLeft() != 1))
                    nbOarsUsed.decreaseLeftAndRight(1);

                else if (informationGame.getShip().isSailsOpen() && actionOnSails != SailAction.LOWER){
                    actionOnSails = SailAction.LOWER;
                    changeSailSetting = true;
                }
                else
                    return null;
            }
            if(changeSailSetting) {
                while (!shipMovementResolver.isCheckpointMissed(positionCheckpointToReach, rudderAngle, actionOnSails, new NbOarsUsed(nbOarsUsed.onLeft()+1,nbOarsUsed.onRight()+1))) {
                    if (nbOarsUsed.onLeft()+1 > maxLeftOarUse || nbOarsUsed.onRight()+1 > maxRightOarUse)
                        break;
                    nbOarsUsed.increaseLeftAndRight(1);
                }
            }
        }
        return new ToolsToUse(rudderAngle,actionOnSails,nbOarsUsed);
    }
}

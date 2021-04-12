package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.SailStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.WatchStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

public class RegattaResolver {

    private final Geometry geometry;
    private final OarStrategy oarStrategy;
    private final RudderStrategy rudderStrategy;
    private final SailStrategy SailStrategy;
    private final InformationGame informationGame;
    private final ShipMovementResolver shipMovementResolver;
    private final WatchStrategy watchStrategy;

    public RegattaResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame.getShip().getPosition());
        oarStrategy = new OarStrategy(informationGame.getNbSailors(), informationGame.getShip().getNbOars());
        SailStrategy = new SailStrategy(informationGame.getShip(), informationGame.getWind());
        rudderStrategy = new RudderStrategy();
        watchStrategy = new WatchStrategy();
        shipMovementResolver = new ShipMovementResolver(informationGame.getShip(), informationGame.getWind(), informationGame.getRegattaGoal());
    }

    public ToolsToUse resolveToolsToUse(Position positionCheckpointToReach) {
        Double angleToCorrect = geometry.calculateAngleToCheckPoint(positionCheckpointToReach);
        double rudderAngle = rudderStrategy.getRudderAngle(angleToCorrect);
        SailAction actionOnSails = SailStrategy.getSailsAction();
        NbOarsUsed nbOarsUsed = oarStrategy.getNbOarsUsed(rudderAngle != 0,actionOnSails != SailAction.DO_NOTHING, oarStrategy.getDifferenceOarRightLeft(angleToCorrect));
        boolean isWatchnNecessary = watchStrategy.getIsWatchNecessary();

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
                    if (nbOarsUsed.onLeft()+1 > maxLeftOarUse || nbOarsUsed.onRight()+1 > maxRightOarUse){
                        break;
                    }
                    nbOarsUsed.increaseLeftAndRight(1);
                }
            }
        }
        return new ToolsToUse(rudderAngle,actionOnSails,nbOarsUsed,isWatchnNecessary);
    }

    public ToolsToUse resolveToolsToUseForPathPoint(Position positionCheckpointToReach) {
        Double angleToCorrect = geometry.calculateAngleToCheckPoint(positionCheckpointToReach);
        double rudderAngle = rudderStrategy.getRudderAngle(angleToCorrect);
        SailAction actionOnSails = SailStrategy.getSailsAction();
        NbOarsUsed nbOarsUsed = oarStrategy.getNbOarsUsed(rudderAngle != 0,actionOnSails != SailAction.DO_NOTHING, oarStrategy.getDifferenceOarRightLeft(angleToCorrect));
        boolean isWatchnNecessary = watchStrategy.getIsWatchNecessary();

        return new ToolsToUse(rudderAngle,actionOnSails,nbOarsUsed,isWatchnNecessary);
    }
}

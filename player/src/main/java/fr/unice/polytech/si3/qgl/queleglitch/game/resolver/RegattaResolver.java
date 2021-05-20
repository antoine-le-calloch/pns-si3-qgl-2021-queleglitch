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
    private final SailStrategy sailStrategy;
    private final InformationGame informationGame;
    private final ShipMovementResolver shipMovementResolver;
    private final WatchStrategy watchStrategy;

    public RegattaResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame.getShip().getPosition());
        oarStrategy = new OarStrategy(informationGame.getNbSailors(), informationGame.getShip().getNbOars());
        sailStrategy = new SailStrategy(informationGame.getShip(), informationGame.getWind(), informationGame.getShip().getNbSails() > 0);
        rudderStrategy = new RudderStrategy(informationGame.getShip().getRudder() != null);
        watchStrategy = new WatchStrategy(informationGame.getRegattaGoal(), informationGame.getShip().getWatch() != null);
        shipMovementResolver = new ShipMovementResolver(informationGame.getShip(), informationGame.getWind(), informationGame.getRegattaGoal());
    }

    public ToolsToUse resolveToolsToUse(Position positionToReach, boolean isCheckpoint) {
        double angleToCorrect = geometry.calculateAngleToCheckPoint(positionToReach);
        double rudderAngle = rudderStrategy.getRudderAngle(angleToCorrect);
        SailAction actionOnSails = sailStrategy.getSailsAction();
        boolean isWatchNecessary = watchStrategy.isWatchNecessary();
        NbOarsUsed nbOarsUsed = oarStrategy.getNbOarsUsed(isWatchNecessary, rudderAngle != 0,actionOnSails != SailAction.DO_NOTHING, oarStrategy.getDifferenceOarRightLeft(angleToCorrect,rudderAngle));

        if(isCheckpoint && Math.abs(angleToCorrect) < Math.PI/4)
            return proceedAntiAvoidance(positionToReach,nbOarsUsed,actionOnSails,rudderAngle,isWatchNecessary);

        return new ToolsToUse(rudderAngle,actionOnSails,nbOarsUsed,isWatchNecessary);
    }

    public ToolsToUse proceedAntiAvoidance(Position positionToReach, NbOarsUsed nbOarsUsed, SailAction actionOnSails, double rudderAngle, boolean isWatchNecessary) {
        int maxLeftOarUse = nbOarsUsed.onLeft();
        int maxRightOarUse = nbOarsUsed.onRight();
        boolean changeSailSetting = false;

        while (Boolean.TRUE.equals(shipMovementResolver.isCheckpointMissed(positionToReach, rudderAngle, actionOnSails, nbOarsUsed))) {
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
            while (Boolean.FALSE.equals(shipMovementResolver.isCheckpointMissed(positionToReach, rudderAngle, actionOnSails, new NbOarsUsed(nbOarsUsed.onLeft()+1,nbOarsUsed.onRight()+1)))) {
                if (nbOarsUsed.onLeft()+1 > maxLeftOarUse || nbOarsUsed.onRight()+1 > maxRightOarUse){
                    break;
                }
                nbOarsUsed.increaseLeftAndRight(1);
            }
        }
        return new ToolsToUse(rudderAngle,actionOnSails,nbOarsUsed,isWatchNecessary);
    }
}

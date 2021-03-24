package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

public class SailStrategy {
    private final InformationGame informationGame;
    private final Boolean sailsOpen;
    private final Wind wind;

    public SailStrategy(InformationGame informationGame) {
        this.wind = informationGame.getWind();
        this.informationGame = informationGame;
        this.sailsOpen = informationGame.getShip().isSailsOpen();
    }

    public SailAction getSailsAction() {
        if (Math.cos(informationGame.getShip().getPosition().getOrientation() - wind.getOrientation()) > 0 && !sailsOpen)
            return SailAction.LIFT;
        else if (Math.cos(informationGame.getShip().getPosition().getOrientation() - wind.getOrientation()) < 0 && sailsOpen)
            return SailAction.LOWER;
        else
            return SailAction.DO_NOTHING;
    }
}

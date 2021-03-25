package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

public class SailStrategy {
    private final Ship ship;
    private final Wind wind;

    public SailStrategy(Ship ship, Wind wind) {
        this.wind = wind;
        this.ship = ship;
    }

    public SailAction getSailsAction() {
        if (Math.cos(ship.getPosition().getOrientation() - wind.getOrientation()) > 0 && !ship.isSailsOpen())
            return SailAction.LIFT;
        else if (Math.cos(ship.getPosition().getOrientation() - wind.getOrientation()) < 0 && ship.isSailsOpen())
            return SailAction.LOWER;
        else
            return SailAction.DO_NOTHING;
    }
}

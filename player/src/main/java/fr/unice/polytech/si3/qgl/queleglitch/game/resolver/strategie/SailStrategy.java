package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Sail;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

public class SailStrategy {
    InformationGame informationGame;
    Sail sail;
    Wind wind;

    public SailStrategy(InformationGame informationGame) {
        this.wind = informationGame.getWind();
        this.informationGame = informationGame;
        this.sail = informationGame.getShip().getSails().get(0);
    }

    public SailAction getSailsAction() {
        if (Math.cos(informationGame.getShip().getPosition().getOrientation() - wind.getOrientation()) > 0 && !sail.isOpenned())
            return SailAction.LIFT;
        else if (Math.cos(informationGame.getShip().getPosition().getOrientation() - wind.getOrientation()) < 0 && sail.isOpenned())
            return SailAction.LOWER;
        else
            return SailAction.DO_NOTHING;
    }
}

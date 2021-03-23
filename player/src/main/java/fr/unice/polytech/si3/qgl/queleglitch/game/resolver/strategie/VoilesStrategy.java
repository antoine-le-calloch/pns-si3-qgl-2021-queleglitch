package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

import java.util.List;

public class VoilesStrategy {
    InformationGame informationGame;
    Voile voile1;
    Wind wind;

    public VoilesStrategy(InformationGame informationGame) {
        this.wind = informationGame.getWind();
        this.informationGame = informationGame;
        this.voile1 = informationGame.ship.getVoiles().get(0);
    }

    public VoileAction getVoilesAction() {
        if (Math.cos(informationGame.getShip().getPosition().orientation - wind.orientation) > 0 && !voile1.getOpenned())
            return VoileAction.LIFT;
        else if (Math.cos(informationGame.getShip().getPosition().orientation - wind.orientation) < 0 && voile1.getOpenned())
            return VoileAction.LOWER;
        else
            return VoileAction.DO_NOTHING;
    }
}

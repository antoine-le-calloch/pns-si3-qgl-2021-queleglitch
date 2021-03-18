package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

import java.util.List;

public class VoilesStrategy {

    private final int LIFT = 1;
    private final int LOWER = -1;
    private final int NOT_USE = 0;

    InformationGame informationGame;
    Voile voile1;
    int nbVoiles;
    Wind wind;

    public VoilesStrategy(InformationGame informationGame, NextRound nextRound) {
        this.wind = nextRound.getWind();
        this.informationGame = informationGame;
        this.voile1 = informationGame.ship.getVoiles().get(0);
        this.nbVoiles = informationGame.ship.getVoiles().size();
    }

    public int getVoilesAction() {
        if (Math.abs(informationGame.getShip().getPosition().orientation - wind.orientation) < (Math.PI / 2) && !voile1.opened)
            return LIFT*nbVoiles;
        else if (Math.abs(informationGame.getShip().getPosition().orientation - wind.orientation) > (Math.PI / 2) && voile1.opened)
            return LOWER*nbVoiles;
        else
            return NOT_USE;
    }
}

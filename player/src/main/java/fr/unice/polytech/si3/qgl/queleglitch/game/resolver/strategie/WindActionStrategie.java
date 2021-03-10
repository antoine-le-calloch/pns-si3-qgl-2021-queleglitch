package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

public class WindActionStrategie {

    InformationGame informationGame;
    Wind wind;

    public WindActionStrategie(InformationGame informationGame, NextRound nextRound) {
        this.informationGame = informationGame;
        wind = nextRound.getWind();
    }

    public double windResolver() {
        if ( Math.abs(informationGame.getShip().getPosition().orientation - wind.orientation) < (Math.PI))
            return 1;

        return 0;
    }



}

package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public abstract class Strategie {

    InformationGame informationGame;
    final int NB_ROWERS ;
    final int NB_OARS;

    public Strategie(InformationGame informationGame) {
        this.informationGame = informationGame;
        NB_ROWERS = informationGame.getSailors().length;
        NB_OARS = informationGame.getShip().getRames().size();
    }

    public abstract double actionResolver(Double angleToCorrect);


}

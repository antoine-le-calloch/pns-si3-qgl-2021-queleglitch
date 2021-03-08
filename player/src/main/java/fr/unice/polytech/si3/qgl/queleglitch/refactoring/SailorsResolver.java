package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public abstract class SailorsResolver {

    InformationGame informationGame;
    final int NB_ROWERS ;
    final int NB_OARS;

    public SailorsResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        NB_ROWERS = informationGame.getSailors().length;
        NB_OARS = informationGame.getShip().getRames().size();
    }

    public abstract double actionResolver(Double angleToCorrect);


}

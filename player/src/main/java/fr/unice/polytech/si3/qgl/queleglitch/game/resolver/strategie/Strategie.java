package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public abstract class Strategie {

    InformationGame informationGame;


    public Strategie(InformationGame informationGame) {
        this.informationGame = informationGame;
    }

    public abstract double actionResolver(Double angleToCorrect);



}

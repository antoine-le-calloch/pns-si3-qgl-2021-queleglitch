package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;

public abstract class Strategie {
    ObjectMapper objectMapper = new ObjectMapper();

    public Strategie(InitGame initGame) {
    }

}
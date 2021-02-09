package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.MoveSailorsStrat;
import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.TurnStrat;
import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;

/**
 * Classe permettant de définir l'action à faire à chaque tour
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class ActionsToProcess {
    InitGame initGame;
    StringBuilder action;

    public ActionsToProcess(InitGame initGame) {
        this.initGame = initGame;
        action = new StringBuilder();
    }

    public void setDataNewRound(InitGame initGame){
        this.initGame = initGame;
        initGame.setShip(initGame.getShip());
    }

    public String actionForTheRound(){
        TurnStrat turnStrat = new TurnStrat(initGame);
        action.append(turnStrat.useOar());
        return action.toString();
    }

}
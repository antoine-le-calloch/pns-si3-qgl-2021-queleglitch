package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.createActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.TurnStrat;
import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;

import java.util.List;

/**
 * Classe permettant de définir l'action à faire à chaque tour
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class processing {
    InitGame initGame;
    NextRound nextRound;
    StringBuilder action;

    public processing(InitGame initGame) {
        this.initGame = initGame;
        action = new StringBuilder();
    }

    public void setDataNewRound(NextRound nextRound){
        this.nextRound = nextRound;
        initGame.setShip(nextRound.getShip());
    }

    public List<Action> actionForTheRound(){
        TurnStrat turnStrat = new TurnStrat(initGame,nextRound);
        createActions createActions = new createActions(initGame, turnStrat.getToolsToUse());
        return createActions.getActions();
    }

}
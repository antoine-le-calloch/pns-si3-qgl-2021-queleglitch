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
    NextRound nextRound;
    int nbRound;
    StringBuilder action;

    public ActionsToProcess(InitGame initGame) {
        this.initGame = initGame;
        nbRound = 0;
        action = new StringBuilder();
    }

    public void setDataNewRound(NextRound nextRound){
        nbRound++;
        this.nextRound = nextRound;
        initGame.setShip(nextRound.getShip());
    }

    public String actionForTheRound(){
        MoveSailorsStrat moveSailorsStrat = new MoveSailorsStrat(initGame);
        TurnStrat turnStrat = new TurnStrat(initGame);

        if (nbRound == 1)
            action.append(moveSailorsStrat.moveSailorsOnTheRames(2,2));

        action.append(turnStrat.useOar());

        return action.toString();
    }

}
package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.CreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.Strat;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

import java.util.List;

/**
 * Classe permettant de définir l'action à faire à chaque tour
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Processing {
    InformationGame informationGame;

    public Processing(InformationGame informationGame) {
        this.informationGame = informationGame;
    }

    public void setDataNewRound(NextRound nextRound){
        informationGame.setShip(nextRound.getShip());

        if(isCheckpointReached()){
            ((RegattaGoal) informationGame.getGoal()).checkpointReached();
        }
    }

    public boolean isCheckpointReached(){
        return ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition().getNorme(informationGame.getShip().getPosition()) < ((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius();
    }

    public List<Action> actionForTheRound(){
        Strat strat = new Strat(informationGame);
        CreateActions createActions = new CreateActions(informationGame.getShip(), informationGame.getSailors(), strat.getToolsToUse());
        return createActions.getActions();
    }
}
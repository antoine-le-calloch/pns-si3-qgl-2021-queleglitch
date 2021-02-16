package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.CreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.TurnStrat;
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

public class processing {
    InformationGame informationGame;

    public processing(InformationGame informationGame) {
        this.informationGame = informationGame;
    }

    public void setDataNewRound(NextRound nextRound){
        informationGame.setShip(nextRound.getShip());

        if(((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition().getNorme(nextRound.getShip().getPosition()) < ((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius()){
            ((RegattaGoal) informationGame.getGoal()).checkpointReached();
        }
    }

    public List<Action> actionForTheRound(){
        TurnStrat turnStrat = new TurnStrat(((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition(),informationGame.getShip().getPosition(),((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius()*2);
        CreateActions createActions = new CreateActions(informationGame.getShip(), informationGame.getSailors(), turnStrat.getToolsToUse());
        return createActions.getActions();
    }
}
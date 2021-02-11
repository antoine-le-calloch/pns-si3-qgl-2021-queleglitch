package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.createActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.TurnStrat;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
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
    NextRound nextRound;

    public processing(InformationGame informationGame) {
        this.informationGame = informationGame;
    }

    public void setDataNewRound(NextRound nextRound){
        this.nextRound = nextRound;
        informationGame.setShip(nextRound.getShip());

        if(distanceFromCheckpoint() < ((Circle) ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getShape()).getRadius()){
            ((RegattaGoal) informationGame.getGoal()).checkpointReached();
        }
    }

    double distanceFromCheckpoint(){
        double distance;
        Position shipPosition = nextRound.ship.position;
        Position checkpointPosition = ((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition();

        distance = Math.pow(checkpointPosition.getX()-shipPosition.getX(),2);
        distance += Math.pow(checkpointPosition.getY()-shipPosition.getY(),2);
        distance = Math.sqrt(distance);
        return distance;
    }

    public List<Action> actionForTheRound(){
        TurnStrat turnStrat = new TurnStrat(((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition(),nextRound.getShip().getPosition());
        createActions createActions = new createActions(informationGame, turnStrat.getToolsToUse());
        return createActions.getActions();
    }
}
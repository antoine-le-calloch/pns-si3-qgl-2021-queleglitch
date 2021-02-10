package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.createActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.strategie.TurnStrat;
import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Circle;
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

        if(distanceFromCheckpoint() < ((Circle) ((RegattaGoal) initGame.getGoal()).getActualCheckpoint().getShape()).getRadius()){
            ((RegattaGoal) initGame.getGoal()).checkpointReached();
        }
    }

    double distanceFromCheckpoint(){
        double distance;
        Position shipPosition = nextRound.ship.position;
        Position checkpointPosition = ((RegattaGoal) initGame.getGoal()).getActualCheckpoint().getPosition();

        distance = Math.pow(checkpointPosition.getX()-shipPosition.getX(),2);
        distance += Math.pow(checkpointPosition.getY()-shipPosition.getY(),2);
        distance = Math.sqrt(distance);
        return distance;
    }

    public List<Action> actionForTheRound(){
        TurnStrat turnStrat = new TurnStrat(initGame,nextRound);
        createActions createActions = new createActions(initGame, turnStrat.getToolsToUse());
        return createActions.getActions();
    }
}
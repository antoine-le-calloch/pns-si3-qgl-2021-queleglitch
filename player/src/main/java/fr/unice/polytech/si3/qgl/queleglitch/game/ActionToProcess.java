package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.Position;
import fr.unice.polytech.si3.qgl.queleglitch.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.action.Actions;
import fr.unice.polytech.si3.qgl.queleglitch.action.Oar;

/**
 * Classe permettant de définir l'action à faire à chaque tour
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class ActionToProcess {
    public Actions action;
    public Sailor[] sailors;
    public Position position;

    public ActionToProcess(InitGame initGame){
        sailors = initGame.sailors;

    }

    public void setNewRound(NextRound nextRound){
        position = nextRound.getShip().getPosition();
    }

    public Actions getAction(int num_sailor) {
        return action = new Oar(sailors[num_sailor].id);
    }
}
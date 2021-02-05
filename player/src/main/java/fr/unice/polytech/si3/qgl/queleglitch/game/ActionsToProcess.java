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

public class ActionsToProcess {

    StratMovingSailors stratMovingSailors;

    public ActionsToProcess(InitGame initGame) {
        this.stratMovingSailors = new StratMovingSailors(initGame);
    }

    public String actionForTheRound(){
        return stratMovingSailors.balancedTheSailorsOnTheRames();
    }

}
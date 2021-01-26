package fr.unice.polytech.si3.qgl.queleglitch;

/**
 * Classe permettant de définir l'action à faire à chaque tour
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

class ActionToProcess {
    public int sailorId;
    public String type;

    ActionToProcess(Sailor sailor, String action){
        sailorId = sailor.getId();
        type = action;
    }
}
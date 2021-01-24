package fr.unice.polytech.si3.qgl.queleglitch;

class ActionToProcess {
    public int sailorId;
    public String type;

    ActionToProcess(Sailor sailor, String action){
        sailorId = sailor.getId();
        type = action;
    }
}
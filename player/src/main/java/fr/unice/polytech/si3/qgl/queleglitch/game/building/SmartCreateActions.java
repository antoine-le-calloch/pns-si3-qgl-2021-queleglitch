package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.smartmoving.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartCreateActions {
    private final List<Sailor> sailorsAvailable;
    private final List<Entities> entitiesTooFar;
    private final List<Action> actionsList;
    private final Tooling tooling;

    private final MovingToRudder movingToRudder;
    private final MovingToSails movingToSails;
    private final MovingToOars movingToOars;
    private final MovingToWatch movingToWatch;

    public SmartCreateActions(Ship ship, Sailor[] sailors){
        tooling = new Tooling(ship.getCentralPosition(), sailors);
        movingToRudder = new MovingToRudder(ship.getRudder(), tooling);
        movingToSails = new MovingToSails(ship.getSails(), tooling);
        movingToOars = new MovingToOars(ship.getOarsAtLeft(), ship.getOarsAtRight(), tooling);
        movingToWatch = new MovingToWatch(ship.getWatch(), tooling);

        sailorsAvailable = new ArrayList<>();
        sailorsAvailable.addAll(Arrays.asList(sailors));
        entitiesTooFar = new ArrayList<>();
        actionsList = new ArrayList<>();
    }

    public List<Action> createActions(ToolsToUse toolsToUse){
        if(toolsToUse.getRudderAngle() != 0) {
            movingToRudder.movingAndUseRudder(toolsToUse.getRudderAngle(),sailorsAvailable, entitiesTooFar, actionsList);
        }
        if(toolsToUse.getActionOnSail() != SailAction.DO_NOTHING) {
            movingToSails.movingAndUseSails(toolsToUse.getActionOnSail(),sailorsAvailable, entitiesTooFar, actionsList);
        }
        if(toolsToUse.getIsWatchNecessary()){
            movingToWatch.movingAndUseWatch(sailorsAvailable, entitiesTooFar, actionsList);
        }
        movingToOars.movingAndUseOars(toolsToUse.getNbOarsUsed(),sailorsAvailable, entitiesTooFar, actionsList);
        tooling.movingToEntitiesTooFar(sailorsAvailable, entitiesTooFar, actionsList);
        tooling.movingToCenter(sailorsAvailable, actionsList);

        return actionsList;
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class WatchStrategy {

    RegattaGoal regattaGoal;

    public WatchStrategy(RegattaGoal regattaGoal){
        this.regattaGoal = regattaGoal;
    }

    public boolean isWatchNecessary(){
        if(regattaGoal.getCheckpointReach()){
            regattaGoal.setCheckpointReach(false);
            return true;
        }
        return false;
    }

}

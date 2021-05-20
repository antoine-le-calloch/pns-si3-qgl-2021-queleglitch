package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class WatchStrategy {

    private final RegattaGoal regattaGoal;
    private final boolean isWatch;

    public WatchStrategy(RegattaGoal regattaGoal, boolean isWatch){
        this.regattaGoal = regattaGoal;
        this.isWatch = isWatch;
    }

    public boolean isWatchNecessary(){
        return isWatch;
    }
}
package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class Strategy {

    ToolsToUse toolsToUse;
    InformationGame informationGame;

    public Strategy(InformationGame informationGame){
        this.informationGame = informationGame;
    }

    public ToolsToUse getToolsToUse(double rudderAngle,int actionOnVoiles,int nbLeftOarToUse,int nbRightOarToUse) {
        toolsToUse = new ToolsToUse(rudderAngle,actionOnVoiles,nbLeftOarToUse,nbRightOarToUse);
        return toolsToUse;
    }

    public boolean checkpointWillBePassed(ToolsToUse toolsToUse){
        return false;
    }
}

package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public abstract class SailorsResolver {

    InformationGame informationGame;
    final int NB_ROWERS ;
    final int NB_OARS;

    public SailorsResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        NB_ROWERS = informationGame.getSailors().length;
        NB_OARS = informationGame.getShip().getRames().size();
    }

    RudderActionSailorsResolver rudderResolver;
    SailActionSailorsResolver sailActionSailorsResolver;
    OarActionResolver oarActionResolver;

    public int sailResolver() {
        return 0;
    }

    public double oarResolver() {
        return 0;
    }
}

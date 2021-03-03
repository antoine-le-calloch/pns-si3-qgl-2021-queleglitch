package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;

public abstract class SailorsResolver {

    InformationGame informationGame;

    public SailorsResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
    }

    RudderActionResolver rudderResolver;
    SailActionResolver sailActionResolver;
    OarActionResolver oarActionResolver;

    public int sailResolver() {
        return 0;
    }

    public double oarResolver() {
        return 0;
    }
}

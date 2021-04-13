package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Stream;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;

import java.util.ArrayList;
import java.util.List;

public class SeaEntities {
    private VisibleEntities[] visibleEntities;

    public SeaEntities(VisibleEntities[] visibleEntities) {
        this.visibleEntities = visibleEntities;
    }

    public List<Reef> getVisibleReefs() {
        List<Reef> visibleReefs = new ArrayList<>();
        if(visibleEntities == null)
            return visibleReefs;
        for (VisibleEntities visibleEntities : visibleEntities) {
            if(visibleEntities instanceof Reef)
                visibleReefs.add((Reef) visibleEntities);
        }
        return visibleReefs;
    }

    public List<Stream> getVisibleStreams() {
        List<Stream> visibleStreams = new ArrayList<>();
        if(visibleEntities == null)
            return visibleStreams;
        for (VisibleEntities visibleEntities : visibleEntities) {
            if(visibleEntities instanceof Reef)
                visibleStreams.add((Stream) visibleEntities);
        }
        return visibleStreams;
    }

    /**
     * <p>Getter.</p>
     */
    public VisibleEntities[] getVisibleEntities() {
        return visibleEntities;
    }

    /**
     * <p>Setter.</p>
     */
    public void setVisibleEntities(VisibleEntities[] visibleEntities) {
        this.visibleEntities = visibleEntities;
    }
}

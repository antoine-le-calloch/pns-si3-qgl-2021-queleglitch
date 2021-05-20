package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Stream;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeaEntities {

    private List<VisibleEntities> visibleEntities;

    public void addSeaEntities(VisibleEntities[] newVisibleEntities){
        visibleEntities = Arrays.asList(newVisibleEntities.clone());
    }

    public List<Reef> getVisibleReefs() {
        List<Reef> visibleReefs = new ArrayList<>();
        for (VisibleEntities visibleEntitie : visibleEntities) {
            if(visibleEntitie instanceof Reef)
                visibleReefs.add((Reef) visibleEntitie);
        }
        return visibleReefs;
    }

    public List<Stream> getVisibleStreams() {
        List<Stream> visibleStreams = new ArrayList<>();
        for (VisibleEntities visibleEntitie : visibleEntities) {
            if(visibleEntitie instanceof Stream)
                visibleStreams.add((Stream) visibleEntitie);
        }
        return visibleStreams;
    }
}

package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Stream;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeaEntities {

    private final List<VisibleEntities> visibleEntities = new ArrayList<>();

    public SeaEntities() {
    }

    public void addSeaEntities(VisibleEntities[] newVisibleEntities){
        for (VisibleEntities newVisibleEntity : newVisibleEntities) {
            if(!visibleEntities.contains(newVisibleEntity)){
                visibleEntities.add(newVisibleEntity);
            }
        }
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
            if(visibleEntities instanceof Stream)
                visibleStreams.add((Stream) visibleEntities);
        }
        return visibleStreams;
    }
}

package fr.unice.polytech.si3.qgl.queleglitch.json.nextround;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities.Stream;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities.VisibleEntities;

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

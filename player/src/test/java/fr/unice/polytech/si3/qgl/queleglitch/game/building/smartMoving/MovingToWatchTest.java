package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartMoving;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Watch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovingToWatchTest {

    MovingToWatch movingToWatch;
    Tooling mockTooling;
    Watch mockWatch;
    List<Sailor> sailors=new ArrayList<Sailor>() ;
    List<Entities> entities = new ArrayList<Entities>();
    List<Action> actions = new ArrayList<Action>();
    Watch watch;

    @BeforeEach
    void testUp(){
        sailors.add(new Sailor());
        mockTooling = Mockito.mock(Tooling.class);
        watch = new Watch();
        Mockito.when(mockTooling.nearestSailorBehind5(mockWatch,sailors)).thenReturn(null);
        movingToWatch = new MovingToWatch(mockWatch,mockTooling);

    }

    @Test
    void noAvailableSailor(){
        assertTrue(entities.isEmpty());
        movingToWatch.movingAndUseWatch(sailors,entities,actions);
        assertFalse(entities.isEmpty());
    }

}
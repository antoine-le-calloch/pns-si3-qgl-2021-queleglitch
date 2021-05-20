package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartmoving;

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
    Watch watch;
    Sailor sailor =new Sailor(1,1,1);
    List<Sailor> sailorsAvailablle =new ArrayList<Sailor>() ;
    List<Sailor> sailorsAvailablleEmpty =new ArrayList<Sailor>() ;
    List<Entities> entitiesTooFar = new ArrayList<Entities>();
    List<Action> actionsList = new ArrayList<Action>();
    List<Action> actionsListEmpty = new ArrayList<Action>();

    @BeforeEach
    void testUp(){
        sailorsAvailablle.add(sailor);
        mockTooling = Mockito.mock(Tooling.class);
        watch = new Watch();
        Mockito.when(mockTooling.nearestSailorBehind5(watch, sailorsAvailablle)).thenReturn(new Sailor(1,1,1));
        Mockito.when(mockTooling.buildMovingAction(null,watch)).thenReturn(null);
        movingToWatch = new MovingToWatch(watch,mockTooling);
    }

    @Test
    void noAvailableSailor(){
        assertTrue(entitiesTooFar.isEmpty());
        movingToWatch.movingAndUseWatch(sailorsAvailablle, entitiesTooFar, actionsList);
        assertTrue(entitiesTooFar.isEmpty());
    }
      @Test
    void availableSailor(){
        assertTrue(actionsList.isEmpty());
        assertFalse(sailorsAvailablle.isEmpty());
        movingToWatch.movingAndUseWatch(sailorsAvailablle, entitiesTooFar, actionsList);
        assertTrue(sailorsAvailablle.isEmpty());
        assertFalse(actionsList.isEmpty());
    }

    @Test
    void noSailors(){
        assertTrue(actionsList.isEmpty());
        assertTrue(sailorsAvailablleEmpty.isEmpty());
        movingToWatch.movingAndUseWatch(sailorsAvailablleEmpty, entitiesTooFar, actionsList);
        assertTrue(sailorsAvailablleEmpty.isEmpty());
        assertTrue(actionsList.isEmpty());
    }
    @Test
    void noActionsList(){
        assertTrue(actionsListEmpty.isEmpty());
        assertFalse(sailorsAvailablle.isEmpty());
        movingToWatch.movingAndUseWatch(sailorsAvailablle, entitiesTooFar, actionsListEmpty);
        assertTrue(sailorsAvailablle.isEmpty());
        assertFalse(actionsListEmpty.isEmpty());
    }


}
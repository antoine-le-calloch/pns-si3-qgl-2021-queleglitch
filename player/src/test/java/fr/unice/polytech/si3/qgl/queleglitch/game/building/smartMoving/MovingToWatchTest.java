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
    Watch watch;
    Sailor sailor =new Sailor(1,1,1);
    List<Sailor> sailors=new ArrayList<Sailor>() ;
    List<Entities> entities = new ArrayList<Entities>();
    List<Action> actions = new ArrayList<Action>();
    Sailor sailorToMove;

    @BeforeEach
    void testUp(){
        sailors.add(sailor);
        mockTooling = Mockito.mock(Tooling.class);
        watch = new Watch();
        Mockito.when(mockTooling.nearestSailorBehind5(watch,sailors)).thenReturn(new Sailor(1,1,1));
        Mockito.when(mockTooling.buildMovingAction(null,watch)).thenReturn(null);
        movingToWatch = new MovingToWatch(watch,mockTooling);
    }

    @Test
    void noAvailableSailor(){
        assertTrue(entities.isEmpty());
        movingToWatch.movingAndUseWatch(sailors,entities,actions);
        assertFalse(entities.isEmpty());
    }
      @Test
    void availableSailor(){
        assertTrue(actions.isEmpty());
        assertFalse(sailors.isEmpty());
        movingToWatch.movingAndUseWatch(sailors,entities,actions);
        assertTrue(sailors.isEmpty());
        assertFalse(actions.isEmpty());
    }



}
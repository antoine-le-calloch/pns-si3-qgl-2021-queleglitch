package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class createActionsTest {

    Sailor[] sailors = {new Sailor(0, 0,0),new Sailor(0, 0,1),new Sailor(0, 0,2),new Sailor(0, 0,3)};
    Ship mockShip;
    CreateActions createActions;

    @BeforeEach
    void setUp() {
        mockShip = mock(Ship.class);
        List<Rame> rameAtRight = new ArrayList<>();
        rameAtRight.add(new Rame(0,1));
        rameAtRight.add(new Rame(1,1));
        rameAtRight.add(new Rame(2,1));
        List<Rame> rameAtLeft = new ArrayList<>();
        rameAtLeft.add(new Rame(0,0));
        rameAtLeft.add(new Rame(1,0));
        rameAtLeft.add(new Rame(2,0));
        Mockito.when(mockShip.getRamesAtLeft()).thenReturn(rameAtLeft);//donne le nombre de rame à gauche
        Mockito.when(mockShip.getRamesAtRight()).thenReturn(rameAtRight);//donne le nombre de rame à gauche
    }

    @Test
    void creationActionTurnToLeftAt90(){
        createActions = new CreateActions(mockShip, sailors, new ToolsToUse(0,3));

        assertTrue(createActions.getActions().contains(new Oar(0)));
        assertTrue(createActions.getActions().contains(new Oar(1)));
        assertTrue(createActions.getActions().contains(new Oar(2)));
    }
}
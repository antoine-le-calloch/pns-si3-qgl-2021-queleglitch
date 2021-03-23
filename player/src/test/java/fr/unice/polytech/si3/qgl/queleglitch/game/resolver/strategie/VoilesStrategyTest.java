package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class VoilesStrategyTest {

    VoilesStrategy voilesStrategy;
    Ship mockShipSailClose;
    Ship mockShipSailOpen;
    Goal goal;

    @BeforeEach
    void setUp() {
        mockShipSailClose = mock(Ship.class);
        Mockito.when(mockShipSailClose.getPosition()).thenReturn(new Position(2, 4, Math.PI / 2));
        Mockito.when(mockShipSailClose.getVoiles()).thenReturn(Arrays.asList(new Voile[]{new Voile(0, 0, false)}.clone()));

        mockShipSailOpen = mock(Ship.class);
        Mockito.when(mockShipSailOpen.getPosition()).thenReturn(new Position(2, 4, Math.PI / 2));
        Mockito.when(mockShipSailOpen.getVoiles()).thenReturn(Arrays.asList(new Voile[]{new Voile(0, 0, true)}.clone()));
    }

    ////////////////UseWind

    @Test
    void WindResolverUseWind_PIOn3_SailClose() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailClose, new Wind(1,Math.PI / 3)));
        assertEquals(VoileAction.LIFT, voilesStrategy.getVoilesAction());
    }
    @Test
    void WindResolverUseWind_PIOn2_SailClose() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailClose, new Wind(1,Math.PI / 2)));
        assertEquals(VoileAction.LIFT, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverUseWind_2PIOn3_SailClose() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailClose, new Wind(1,2 * Math.PI / 3)));
        assertEquals(VoileAction.LIFT, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverUseWind_3PIOn4_SailClose() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailClose, new Wind(1,3 * Math.PI / 4)));
        assertEquals(VoileAction.LIFT, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverUseWind_PIOn6_SailClose() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailClose, new Wind(1,Math.PI / 6)));
        assertEquals(VoileAction.LIFT, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverUseWind_PIOn6_SailOpen() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailOpen, new Wind(1,Math.PI / 6)));
        assertEquals(VoileAction.DO_NOTHING, voilesStrategy.getVoilesAction());
    }

    ////////////////NotUseWind

    @Test
    void WindResolverNotUseWind_3PIOn2_SailOpen() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailOpen, new Wind(1,3*Math.PI / 2)));
        assertEquals(VoileAction.LOWER, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverNotUseWind_5PIOn4_SailOpen() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailOpen, new Wind(1,5*Math.PI / 4)));
        assertEquals(VoileAction.LOWER, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverNotUseWind_4PIOn3_SailOpen() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailOpen, new Wind(1,4 * Math.PI / 3)));
        assertEquals(VoileAction.LOWER, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverNotUseWind_4PIOn3_SailClose() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailClose, new Wind(1,4 * Math.PI / 3)));
        assertEquals(VoileAction.DO_NOTHING, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverPerpendicularWind_DoNotTouch_PI_SailOpen() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailOpen, new Wind(1, Math.PI )));
        assertEquals(VoileAction.DO_NOTHING, voilesStrategy.getVoilesAction());
    }

    @Test
    void WindResolverPerpendicularWind_DoNotTouch_MinusPI_SailOpen() {
        voilesStrategy = new VoilesStrategy(new InformationGame(goal, mockShipSailOpen, new Wind(1,0.0)));
        assertEquals(VoileAction.DO_NOTHING, voilesStrategy.getVoilesAction());
    }
}
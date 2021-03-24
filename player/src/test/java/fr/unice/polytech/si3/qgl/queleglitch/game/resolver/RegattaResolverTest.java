package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbRamesUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.VoilesStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RegattaResolverTest {

    RegattaResolver regattaResolver;
    Geometry geometryMock;
    RudderStrategy rudderStrategyMock;
    VoilesStrategy voilesStrategyMock;
    OarStrategy oarStrategyMock;
    ShipMovementResolver shipMovementResolver;
    double angleMock = Math.PI/6;

    @BeforeEach
    void setUp(){
        geometryMock = Mockito.mock(Geometry.class);
        rudderStrategyMock = Mockito.mock(RudderStrategy.class);
        voilesStrategyMock=Mockito.mock(VoilesStrategy.class);
        oarStrategyMock=Mockito.mock(OarStrategy.class);
        shipMovementResolver=Mockito.mock(ShipMovementResolver.class);
        Mockito.when(geometryMock.calculateAngleToCheckPoint(new Position())).thenReturn(angleMock);
        Mockito.when(rudderStrategyMock.getRudderAngle(angleMock)).thenReturn(angleMock);
        Mockito.when(voilesStrategyMock.getVoilesAction()).thenReturn( VoileAction.LOWER);
        Mockito.when(oarStrategyMock.getDifferenceOarRightLeft(angleMock)).thenReturn(2);
        Mockito.when(oarStrategyMock.getNbRamesUsed(true,true,2)).thenReturn(new NbRamesUsed(2,2));
        Mockito.when(shipMovementResolver.isCheckpointPassed(new Position(),angleMock,VoileAction.LOWER,new NbRamesUsed(2,2) )).thenReturn(false);
        regattaResolver = new RegattaResolver(geometryMock,oarStrategyMock,rudderStrategyMock,voilesStrategyMock,shipMovementResolver);
    }


    @Test
    void RudderNotNull(){
        assertEquals(new ToolsToUse(angleMock, VoileAction.LOWER, new NbRamesUsed(2,2)),regattaResolver.resolveToolsToUse(new Position()));
    }




}
package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.SailStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RegattaResolverTest {

    RegattaResolver regattaResolver;
    Geometry geometryMock;
    RudderStrategy rudderStrategyMock;
    SailStrategy sailStrategyMock;
    OarStrategy oarStrategyMock;
    ShipMovementResolver shipMovementResolver;
    double angleMock = Math.PI/6;

    @BeforeEach
    void setUp(){
        geometryMock = Mockito.mock(Geometry.class);
        rudderStrategyMock = Mockito.mock(RudderStrategy.class);
        sailStrategyMock =Mockito.mock(SailStrategy.class);
        oarStrategyMock =Mockito.mock(OarStrategy.class);
        shipMovementResolver=Mockito.mock(ShipMovementResolver.class);
        Mockito.when(geometryMock.calculateAngleToCheckPoint(new Position())).thenReturn(angleMock);
        Mockito.when(rudderStrategyMock.getRudderAngle(angleMock)).thenReturn(angleMock);
        Mockito.when(sailStrategyMock.getSailsAction()).thenReturn( SailAction.LOWER);
        Mockito.when(oarStrategyMock.getDifferenceOarRightLeft(angleMock)).thenReturn(2);
        Mockito.when(oarStrategyMock.getNbOarsUsed(true,true,2)).thenReturn(new NbOarsUsed(2,2));
        Mockito.when(shipMovementResolver.isCheckpointMissed(new Position(),angleMock,SailAction.LOWER,new NbOarsUsed(2,2) )).thenReturn(false);
        regattaResolver = new RegattaResolver(geometryMock, oarStrategyMock,rudderStrategyMock, sailStrategyMock,shipMovementResolver);
    }


    @Test
    void RudderNotNull(){
        assertEquals(new ToolsToUse(angleMock, SailAction.LOWER, new NbOarsUsed(2,2)),regattaResolver.resolveToolsToUse(new Position()));
    }




}
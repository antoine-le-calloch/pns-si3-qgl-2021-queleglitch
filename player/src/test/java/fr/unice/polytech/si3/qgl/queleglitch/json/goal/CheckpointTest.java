package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckpointTest {

    Position positionCheckpoint;
    Position positionCheckpoint100_0;

    @BeforeEach
    void setUp() {
        positionCheckpoint = new Position(0, 0, 0);
        positionCheckpoint100_0 = new Position(100, 0, 0);
    }
}
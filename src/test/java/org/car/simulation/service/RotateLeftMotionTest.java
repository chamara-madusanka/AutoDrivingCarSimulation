package org.car.simulation.service;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.Location;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateLeftMotionTest {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(Direction.N, Direction.W),
                Arguments.of(Direction.S, Direction.E),
                Arguments.of(Direction.E, Direction.N),
                Arguments.of(Direction.W, Direction.S)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void getNextMoveTest(Direction initialDirection, Direction expectedDirection) {
        RotateLeftMotion rotateLeftMotion = new RotateLeftMotion();
        Location currentLocation = new Location(0, 0, initialDirection);
        Location result = rotateLeftMotion.getNextMove(currentLocation);
        assertEquals(expectedDirection, result.getDirection());
    }
}

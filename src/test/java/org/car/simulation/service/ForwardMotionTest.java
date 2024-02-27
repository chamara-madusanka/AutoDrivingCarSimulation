package org.car.simulation.service;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.Location;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForwardMotionTest {

    private static Stream<Arguments> inputAndExpectedOutput() {
        return Stream.of(
                Arguments.of(new Location(0, 0, Direction.N), new Location(0, 1, Direction.N)),
                Arguments.of(new Location(0, 0, Direction.S), new Location(0, -1, Direction.S)),
                Arguments.of(new Location(0, 0, Direction.E), new Location(1, 0, Direction.E)),
                Arguments.of(new Location(0, 0, Direction.W), new Location(-1, 0, Direction.W))
        );
    }

    @ParameterizedTest
    @MethodSource("inputAndExpectedOutput")
    void getNextMoveTest(Location initialLocation, Location expectedLocation) {
        ForwardMotion forwardMotion = new ForwardMotion();
        Location result = forwardMotion.getNextMove(initialLocation);
        assertEquals(expectedLocation.getX(), result.getX());
        assertEquals(expectedLocation.getY(), result.getY());
        assertEquals(expectedLocation.getDirection(), result.getDirection());
    }
}

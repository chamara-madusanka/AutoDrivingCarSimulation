package org.car.simulation.service;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.Location;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateRightMotionTest {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(Direction.N, Direction.E),
                Arguments.of(Direction.S, Direction.W),
                Arguments.of(Direction.E, Direction.S),
                Arguments.of(Direction.W, Direction.N)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void getNextMoveTest(Direction initialDirection, Direction expectedDirection) {
        RotateRightMotion rotateRightMotion = new RotateRightMotion();
        Location currentLocation = new Location(0, 0, initialDirection);
        Location result = rotateRightMotion.getNextMove(currentLocation);
        assertEquals(expectedDirection, result.getDirection());
    }

}

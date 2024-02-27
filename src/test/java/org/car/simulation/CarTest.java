package org.car.simulation;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void driveTest() {
        Location location = new Location(1, 2, Direction.N);
        Car car = new Car(location, "A");
        Location currentLocation = car.drive("F");
        assertNotNull(currentLocation);
        assertEquals(Direction.N, currentLocation.getDirection());
        assertEquals(1, currentLocation.getX());
        assertEquals(3, currentLocation.getY());
    }
}
package org.car.simulation;

import org.car.simulation.model.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CoordinatesTest {

    private Coordinates coordinatesA = new Coordinates(1, 2);
    private Coordinates coordinatesB = new Coordinates(1, 2);

    @Test
    public void test() {
        System.out.println(coordinatesA.equals(coordinatesB));

        HashMap<Coordinates, Integer> map = new HashMap<>();
        map.put(coordinatesA, 1);
        map.put(coordinatesB, 2);

        System.out.println(map.size());
    }
}

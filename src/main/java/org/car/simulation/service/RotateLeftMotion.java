package org.car.simulation.service;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.Location;

public class RotateLeftMotion implements Motion {
    @Override
    public Location getNextMove(Location currentLocation) {
        switch (currentLocation.getDirection()) {
            case N -> currentLocation.setDirection(Direction.W);
            case S -> currentLocation.setDirection(Direction.E);
            case E -> currentLocation.setDirection(Direction.N);
            case W -> currentLocation.setDirection(Direction.S);
        }

        return currentLocation;
    }
}

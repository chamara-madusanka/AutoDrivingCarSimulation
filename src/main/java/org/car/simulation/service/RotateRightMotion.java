package org.car.simulation.service;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.Location;

public class RotateRightMotion implements Motion {
    @Override
    public Location getNextMove(Location currentLocation) {
        switch (currentLocation.getDirection()) {
            case N -> currentLocation.setDirection(Direction.E);
            case S -> currentLocation.setDirection(Direction.W);
            case E -> currentLocation.setDirection(Direction.S);
            case W -> currentLocation.setDirection(Direction.N);
        }

        return currentLocation;
    }
}

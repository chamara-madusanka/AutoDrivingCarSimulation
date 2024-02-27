package org.car.simulation.service;

import org.car.simulation.model.Location;

public class ForwardMotion implements Motion {
    @Override
    public Location getNextMove(Location currentLocation) {
        switch (currentLocation.getDirection()) {
            case N -> currentLocation.setY(currentLocation.getY() + 1);
            case S -> currentLocation.setY(currentLocation.getY() - 1);
            case E -> currentLocation.setX(currentLocation.getX() + 1);
            case W -> currentLocation.setX(currentLocation.getX() - 1);
        }

        return currentLocation;
    }
}

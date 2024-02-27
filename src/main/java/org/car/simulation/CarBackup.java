package org.car.simulation;

import org.car.simulation.constant.CommonSimulationConstant;
import org.car.simulation.enums.Direction;
import org.car.simulation.exception.InvalidInstructionException;
import org.car.simulation.model.Location;
import org.car.simulation.service.Motion;

import java.util.Objects;

public class CarBackup {

    private Location location;
    private String carName;

    public CarBackup(Location location, String carName) {
        this.location = location;
        this.carName = carName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Location drive(String instruction) {
        Motion motion = CommonSimulationConstant.motionMap.get(instruction);
        if (Objects.isNull(motion)) {
            throw new InvalidInstructionException("Invalid instruction");
        }
        return motion.getNextMove(location);
    }

    public Location moveForward(Location currentLocation) {
        switch (currentLocation.getDirection()) {
            case N -> currentLocation.setY(currentLocation.getY() + 1);
            case S -> currentLocation.setY(currentLocation.getY() - 1);
            case E -> currentLocation.setX(currentLocation.getX() + 1);
            case W -> currentLocation.setX(currentLocation.getX() - 1);
        }

        return currentLocation;
    }

    public Location rotateRight(Location currentLocation) {
        switch (currentLocation.getDirection()) {
            case N -> currentLocation.setDirection(Direction.E);
            case S -> currentLocation.setDirection(Direction.W);
            case E -> currentLocation.setDirection(Direction.S);
            case W -> currentLocation.setDirection(Direction.N);
        }

        return currentLocation;
    }

    public Location rotateLeft(Location currentLocation) {
        switch (currentLocation.getDirection()) {
            case N -> currentLocation.setDirection(Direction.W);
            case S -> currentLocation.setDirection(Direction.E);
            case E -> currentLocation.setDirection(Direction.N);
            case W -> currentLocation.setDirection(Direction.S);
        }

        return currentLocation;
    }
}

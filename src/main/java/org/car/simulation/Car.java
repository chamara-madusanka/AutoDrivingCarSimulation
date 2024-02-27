package org.car.simulation;

import org.car.simulation.constant.CommonSimulationConstant;
import org.car.simulation.exception.InvalidInstructionException;
import org.car.simulation.model.Location;
import org.car.simulation.service.Motion;

import java.util.Objects;

public class Car {
    private Location location;
    private String carName;

    public Car(Location location, String carName) {
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
            throw new InvalidInstructionException(CommonSimulationConstant.INVALID_INSTRUCTION);
        }
        return motion.getNextMove(location);
    }
}

package org.car.simulation.model;

import org.car.simulation.Car;

public class LocatedCar {

    private Car car;
    private String[] instructionsInput;

    public LocatedCar(Car car, String[] instructionsInput) {
        this.car = car;
        this.instructionsInput = instructionsInput;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String[] getInstructionsInput() {
        return instructionsInput;
    }

    public void setInstructionsInput(String[] instructionsInput) {
        this.instructionsInput = instructionsInput;
    }
}

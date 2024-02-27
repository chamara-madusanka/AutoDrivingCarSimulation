package org.car.simulation;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.Location;

public class SimulationApplication {

    private String[] fieldSizeInput;
    private String[] locationInput;
    private String[] instructionsInput;

    public SimulationApplication(String[] fieldSizeInput, String[] locationInput, String[] instructionsInput) {
        this.fieldSizeInput = fieldSizeInput;
        this.locationInput = locationInput;
        this.instructionsInput = instructionsInput;
    }

    public void run() {
        Location location = new Location(Integer.parseInt(locationInput[0]), Integer.parseInt(locationInput[1]), Direction.valueOf(locationInput[2]));

        Car car = new Car(location, "Single");

        int currentIndex = 0;
        for (String instruction : instructionsInput) {
            car.drive(instruction);
            if (currentIndex == instructionsInput.length - 1) {
                System.out.println(location);
            }
            currentIndex++;
        }
    }
}

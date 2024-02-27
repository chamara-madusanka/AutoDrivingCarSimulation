package org.car.simulation.model;

public class CarParticipant {

    private String carName;
    private String[] locationInput;
    private String[] instructionsInput;

    public CarParticipant(String carName, String[] locationInput, String[] instructionsInput) {
        this.carName = carName;
        this.locationInput = locationInput;
        this.instructionsInput = instructionsInput;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String[] getLocationInput() {
        return locationInput;
    }

    public void setLocationInput(String[] locationInput) {
        this.locationInput = locationInput;
    }

    public String[] getInstructionsInput() {
        return instructionsInput;
    }

    public void setInstructionsInput(String[] instructionsInput) {
        this.instructionsInput = instructionsInput;
    }
}

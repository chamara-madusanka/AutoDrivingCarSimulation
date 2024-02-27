package org.car.simulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationApplicationTest {

    private String[] fieldSizeInput = {"10", "10"};
    private String[] locationInput = {"1", "2", "N"};
    private String[] instructionsInput = {"F", "F", "R", "F", "F", "F", "R", "R", "L", "F"};
    private SimulationApplication simulationApplication = new SimulationApplication(fieldSizeInput, locationInput, instructionsInput);

    @Test
    public void driveTest() {
        simulationApplication.run();
    }
}

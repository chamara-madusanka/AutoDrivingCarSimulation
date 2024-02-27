package org.car.simulation;

import org.car.simulation.model.CarParticipant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MultipleCarSimulationTest {

    List<CarParticipant> carParticipants = new ArrayList<>();

    private String[] fieldSizeInput = {"10", "10"};
    private String[] locationInputA = {"1", "2", "N"};
    private String[] instructionsInputA = {"F", "F", "R", "F", "F", "F", "F", "R", "R", "L"};
    private String[] locationInputB = {"7", "8", "W"};
    private String[] instructionsInputB = {"F", "F", "L", "F", "F", "F", "F", "F", "F", "F"};
    private int largestInstructionSet = Math.max(instructionsInputA.length, instructionsInputB.length);

    @Test
    public void checkCollisionTest() {
        carParticipants.add(new CarParticipant("A", locationInputA, instructionsInputA));
        carParticipants.add(new CarParticipant("B", locationInputB, instructionsInputB));
        MultipleCarSimulation multipleCarSimulation = new MultipleCarSimulation(carParticipants);
        multipleCarSimulation.checkCollision();
    }

}

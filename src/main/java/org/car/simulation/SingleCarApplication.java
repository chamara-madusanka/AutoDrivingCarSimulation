package org.car.simulation;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.Field;
import org.car.simulation.model.Location;
import org.car.simulation.service.UserInputValidator;

import java.util.Scanner;

public class SingleCarApplication {

    public static void main(String[] args) {
        UserInputValidator userInputValidator = new UserInputValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the field size: ");
        String fieldSize = scanner.nextLine();

        System.out.println("Enter the location: ");
        String location = scanner.nextLine();

        // Read the third line of input
        System.out.println("Enter instructions: ");
        String instruction = scanner.nextLine();

        String[] fieldSizeInput = fieldSize.split(" ");
        String[] locationInput = location.split(" ");
        String[] instructionInput = instruction.split("");

        userInputValidator.validateUserInputLength(fieldSizeInput, locationInput);
        userInputValidator.validateUserInputDataTypes(fieldSizeInput, locationInput);
        userInputValidator.validateUserInputDataTypes(instructionInput);

        Field field = new Field(Integer.parseInt(fieldSizeInput[0]), Integer.parseInt(fieldSizeInput[1]));
        Location carLocation = new Location(Integer.parseInt(locationInput[0]), Integer.parseInt(locationInput[1]), Direction.valueOf(locationInput[2]));

        userInputValidator.validateFieldSize(field);
        userInputValidator.validateLocation(carLocation, field);

        SimulationApplication simulationApplication = new SimulationApplication(fieldSizeInput, locationInput, instructionInput);
        simulationApplication.run();
    }

}

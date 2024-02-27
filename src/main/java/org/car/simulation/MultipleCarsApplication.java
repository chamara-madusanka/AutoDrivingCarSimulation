package org.car.simulation;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.CarParticipant;
import org.car.simulation.model.Field;
import org.car.simulation.model.Location;
import org.car.simulation.service.UserInputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleCarsApplication {

    public static void main(String[] args) {
        UserInputValidator userInputValidator = new UserInputValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the field size: ");
        String fieldSize = scanner.nextLine();

        String[] fieldSizeInput = fieldSize.split(" ");

        System.out.println("How many cars: ");
        int cars = Integer.parseInt(scanner.nextLine());

        List<CarParticipant> carParticipants = new ArrayList<>();

        for (int i=0; i<cars; i++) {
            System.out.println("Enter car Name: ");
            String carName = scanner.nextLine();

            System.out.println("Enter the location: ");
            String location = scanner.nextLine();

            // Read the third line of input
            System.out.println("Enter instructions: ");
            String instruction = scanner.nextLine();

            String[] locationInput = location.split(" ");
            String[] instructionInput = instruction.split("");

            CarParticipant carParticipant = new CarParticipant(carName, locationInput, instructionInput);
            carParticipants.add(carParticipant);

            userInputValidator.validateUserInputLength(fieldSizeInput, locationInput);
            userInputValidator.validateUserInputDataTypes(fieldSizeInput, locationInput);
            userInputValidator.validateUserInputDataTypes(instructionInput);

            Field field = new Field(Integer.parseInt(fieldSizeInput[0]), Integer.parseInt(fieldSizeInput[1]));
            Location carLocation = new Location(Integer.parseInt(locationInput[0]), Integer.parseInt(locationInput[1]), Direction.valueOf(locationInput[2]));

            userInputValidator.validateFieldSize(field);
            userInputValidator.validateLocation(carLocation, field);
        }

        MultipleCarSimulation multipleCarSimulation = new MultipleCarSimulation(carParticipants);
        multipleCarSimulation.checkCollision();
    }

}

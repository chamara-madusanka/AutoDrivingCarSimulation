package org.car.simulation.service;

import org.car.simulation.enums.Direction;
import org.car.simulation.enums.Instructions;
import org.car.simulation.exception.InvalidCoordinatesException;
import org.car.simulation.exception.InvalidFieldSizeException;
import org.car.simulation.exception.InvalidInstructionException;
import org.car.simulation.exception.InvalidUserInputException;
import org.car.simulation.model.Field;
import org.car.simulation.model.Location;

import java.util.Arrays;

public class UserInputValidator {

    public boolean validateUserInputLength(String[] fieldSize, String[] location) {
        if (fieldSize.length != 2) {
            throw new InvalidUserInputException("Field size input is invalid.");
        }

        if (location.length != 3) {
            throw new InvalidUserInputException("Location input is invalid.");
        }

        return true;
    }

    public boolean validateUserInputDataTypes(String[] fieldSize, String[] location) {
        Arrays.stream(fieldSize).forEach(v -> {
            try {
                Integer.parseInt(v);
            } catch (NumberFormatException exception) {
                throw new InvalidUserInputException("Field size input should be a valid number.");
            }
        });

        try {
            Integer.parseInt(location[0]);
            Integer.parseInt(location[1]);
        } catch (NumberFormatException exception) {
            throw new InvalidUserInputException("Location coordinates should be valid numbers.");
        }

        String direction = location[2];

        if (Arrays.stream(Direction.values()).noneMatch(v -> v.getDirection().equals(direction))) {
            throw new InvalidUserInputException("Direction should be N, S, E, W.");
        }

        return true;
    }

    public boolean validateFieldSize(Field field) {
        if (field.getLength() <= 0) {
            throw new InvalidFieldSizeException(String.format("Invalid field length %d: ", field.getLength()));
        }

        if (field.getWidth() <= 0) {
            throw new InvalidFieldSizeException(String.format("Invalid field width %d: ", field.getWidth()));
        }

        return true;
    }

    public boolean validateLocation(Location location, Field field) {
        if (location.getX() < 0 || location.getX() >= field.getLength() ||
                location.getY() < 0 || location.getY() >= field.getWidth()) {
            throw new InvalidCoordinatesException(String.format("Invalid location X: %d ,Y: %d ", location.getX(), location.getY()));
        }

        return true;
    }

    public boolean validateUserInputDataTypes(String[] instructionsInput) {
        for (String i: instructionsInput) {
            if (Arrays.stream(Instructions.values()).noneMatch(v -> v.getInstruction().equals(i))) {
                throw new InvalidInstructionException(String.format("Invalid instruction input %s", i));
            }
        }

        return true;
    }
}

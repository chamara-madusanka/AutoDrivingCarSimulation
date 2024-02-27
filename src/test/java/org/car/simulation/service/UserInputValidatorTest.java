package org.car.simulation.service;

import org.car.simulation.enums.Direction;
import org.car.simulation.exception.InvalidCoordinatesException;
import org.car.simulation.exception.InvalidFieldSizeException;
import org.car.simulation.exception.InvalidInstructionException;
import org.car.simulation.exception.InvalidUserInputException;
import org.car.simulation.model.Field;
import org.car.simulation.model.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInputValidatorTest {

    private UserInputValidator userInputValidator = new UserInputValidator();

    @Test
    public void validateUserInputLengthTest() {
        String[] invalidFieldSize = {"10"};
        String[] location = {"1", "2", "N"};

        assertThrows(InvalidUserInputException.class, () -> userInputValidator.validateUserInputLength(invalidFieldSize, location));

        String[] fieldSize = {"10", "10"};
        String[] invalidLocation = {"1", "2"};

        assertThrows(InvalidUserInputException.class, () -> userInputValidator.validateUserInputLength(fieldSize, invalidLocation));

        assertTrue(userInputValidator.validateUserInputLength(fieldSize, location));
    }

    @Test
    public void validateUserInputDataTypesTest() {
        String[] invalidFieldSize = {"10", "A"};
        String[] location = {"1", "2", "N"};

        assertThrows(InvalidUserInputException.class, () -> userInputValidator.validateUserInputDataTypes(invalidFieldSize, location));

        String[] fieldSize = {"10", "10"};
        String[] invalidLocation = {"A", "2", "N"};

        assertThrows(InvalidUserInputException.class, () -> userInputValidator.validateUserInputDataTypes(fieldSize, invalidLocation));

        String[] locationWithInvalidDirection = {"1", "2", "R"};

        assertThrows(InvalidUserInputException.class, () -> userInputValidator.validateUserInputDataTypes(fieldSize, locationWithInvalidDirection));

        String[] validLocation = {"1", "2", "N"};
        assertTrue(userInputValidator.validateUserInputDataTypes(fieldSize, validLocation));

        String[] invalidInstructions = {"F", "S", "R", "F", "F", "F", "R", "R", "L", "F"};
        assertThrows(InvalidInstructionException.class, () -> userInputValidator.validateUserInputDataTypes(invalidInstructions));

        String[] validInstructions = {"F", "F", "R", "F", "F", "F", "R", "R", "L", "F"};
        assertTrue(userInputValidator.validateUserInputDataTypes(validInstructions));
    }

    @Test
    public void validateFieldSizeTest() {
        Field fieldWithZeroCoordinates = new Field(0, 0);
        assertThrows(InvalidFieldSizeException.class, () -> userInputValidator.validateFieldSize(fieldWithZeroCoordinates));

        Field fieldWithNegativeCoordinates = new Field(12, -1);
        assertThrows(InvalidFieldSizeException.class, () -> userInputValidator.validateFieldSize(fieldWithNegativeCoordinates));

        Field fieldWithValidCoordinates = new Field(12, 12);
        assertTrue(userInputValidator.validateFieldSize(fieldWithValidCoordinates));
    }

    @Test
    public void validateLocationTest() {
        Location invalidXLocation = new Location(-1, 0, Direction.N);
        Field field = new Field(12, 12);
        assertThrows(InvalidCoordinatesException.class, () -> userInputValidator.validateLocation(invalidXLocation, field));

        Location invalidYLocation = new Location(1, 13, Direction.N);
        assertThrows(InvalidCoordinatesException.class, () -> userInputValidator.validateLocation(invalidYLocation, field));

        Location validLocation = new Location(1, 0, Direction.N);
        assertTrue(userInputValidator.validateLocation(validLocation, field));
    }
}

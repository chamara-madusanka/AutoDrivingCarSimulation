package org.car.simulation;

import org.car.simulation.enums.Direction;
import org.car.simulation.model.CarParticipant;
import org.car.simulation.model.Coordinates;
import org.car.simulation.model.LocatedCar;
import org.car.simulation.model.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MultipleCarSimulation {

    List<CarParticipant> carParticipants;

    public MultipleCarSimulation(List<CarParticipant> carParticipants) {
        this.carParticipants = carParticipants;
    }

    public void checkCollision() {
        boolean anyCollision = false;

        Optional<Integer> max = carParticipants.stream().map(c -> c.getInstructionsInput().length).max(Integer::compareTo);
        int largestInstructionSet = max.isPresent() ? max.get() : 0;

        List<LocatedCar> locatedCars = carParticipants.stream().map(c -> {
            Location location = new Location(Integer.parseInt(c.getLocationInput()[0]), Integer.parseInt(c.getLocationInput()[1]), Direction.valueOf(c.getLocationInput()[2]));
            Car car = new Car(location, c.getCarName());
            return new LocatedCar(car, c.getInstructionsInput());
        }).toList();

        for (int i = 0; i < largestInstructionSet; i++) {
            Map<Coordinates, String> locationMap = new HashMap<>();
            for (LocatedCar locatedCar : locatedCars) {
                Location currentLocation = locatedCar.getCar().drive(locatedCar.getInstructionsInput()[i]);
                Coordinates coordinates = new Coordinates(currentLocation.getX(), currentLocation.getY());
                if (locationMap.containsKey(coordinates)) {
                    System.out.println(locationMap.get(coordinates) + " " + locatedCar.getCar().getCarName());
                    System.out.println(coordinates.getX() + " " + coordinates.getY());
                    System.out.println(i + 1);
                    anyCollision = true;
                } else {
                    locationMap.put(coordinates, locatedCar.getCar().getCarName());
                }

                if (anyCollision) {
                    break;
                }
            }
            if (anyCollision) {
                break;
            }
        }

        if (!anyCollision) {
            System.out.println("no collision");
        }
    }

}

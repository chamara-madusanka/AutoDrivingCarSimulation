package org.car.simulation.service;

import org.car.simulation.model.Location;

/**
 * Implement this interface to get the relevant movement.
 */
public interface Motion {

    Location getNextMove(Location currentLocation);

}

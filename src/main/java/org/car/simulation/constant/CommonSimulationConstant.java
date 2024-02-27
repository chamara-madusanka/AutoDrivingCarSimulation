package org.car.simulation.constant;

import org.car.simulation.service.ForwardMotion;
import org.car.simulation.service.Motion;
import org.car.simulation.service.RotateLeftMotion;
import org.car.simulation.service.RotateRightMotion;

import java.util.Map;

public class CommonSimulationConstant {

    private static final String FORWARD = "F";
    private static final String ROTATE_RIGHT = "R";
    private static final String ROTATE_LEFT = "L";
    public static Map<String, Motion> motionMap = Map.of(FORWARD, new ForwardMotion(), ROTATE_RIGHT, new RotateRightMotion(), ROTATE_LEFT, new RotateLeftMotion());

    public static final String INVALID_INSTRUCTION = "Invalid instruction";
}

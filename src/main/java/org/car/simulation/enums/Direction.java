package org.car.simulation.enums;

public enum Direction {
    N("N", "North"),
    S("S", "South"),
    E("E", "East"),
    W("W", "West");

    private final String direction;
    private final String description;

    Direction(String direction, String description) {
        this.direction = direction;
        this.description = description;
    }

    public String getDirection() {
        return direction;
    }

    public String getDescription() {
        return description;
    }
}

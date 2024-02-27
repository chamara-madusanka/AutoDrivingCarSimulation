package org.car.simulation.enums;

public enum Instructions {
    L("L", "Move left by 90 degrees"),
    R("R", "Move right by 90 degrees"),
    F("F", "Move forward by 1 point");

    private final String instruction;
    private final String description;

    Instructions(String instruction, String description) {
        this.instruction = instruction;
        this.description = description;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getDescription() {
        return description;
    }
}

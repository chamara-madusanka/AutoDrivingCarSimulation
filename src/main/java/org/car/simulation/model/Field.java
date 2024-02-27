package org.car.simulation.model;

public class Field {

    private int length;
    private int width;

    public Field(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Field{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}

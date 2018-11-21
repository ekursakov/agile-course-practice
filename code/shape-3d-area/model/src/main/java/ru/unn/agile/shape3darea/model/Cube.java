package ru.unn.agile.shape3darea.model;


public class Cube implements Shape {

    private static final int SQUARES_COUNT = 6;
    private double side;

    public Cube(final double sideSize) {
        if (sideSize <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        side = sideSize;
    }

    @Override
    public double getArea() {
        return SQUARES_COUNT * side * side;
    }
}

package ru.unn.agile.shape3darea.model;


public class Hexagon implements Shape {

    private static final double HEXAGON_AREA_COEF = 3 * Math.sqrt(3) / 2;
    private double side;

    public Hexagon(final double sideSize) {
        if (sideSize <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        side = sideSize;
    }

    @Override
    public double getArea() {
        return HEXAGON_AREA_COEF * side * side;
    }
}

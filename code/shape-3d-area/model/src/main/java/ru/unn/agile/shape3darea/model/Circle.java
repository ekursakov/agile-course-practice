package ru.unn.agile.shape3darea.model;

public class Circle implements Shape {

    private double radius;

    public Circle(final double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

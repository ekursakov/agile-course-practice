package ru.unn.agile.shape3darea.model;


public class Cylinder implements Shape {

    private static final double CYLINDER_AREA_COEF = 2 * Math.PI;
    private final double radius;
    private final double height;

    public Cylinder(final double radius, final double height) {
        if (height <= 0 || radius <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getArea() {
        return CYLINDER_AREA_COEF * radius * (radius + height);
    }
}

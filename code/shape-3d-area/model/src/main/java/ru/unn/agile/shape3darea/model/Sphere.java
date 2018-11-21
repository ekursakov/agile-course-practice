package ru.unn.agile.shape3darea.model;


public class Sphere implements Shape {

    private static final double SPHERE_AREA_COEF = 4 * Math.PI;
    private double radius;

    public Sphere(final double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return SPHERE_AREA_COEF * radius * radius;
    }
}

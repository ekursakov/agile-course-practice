package ru.unn.agile.shape3darea.model;


public class Cone implements Shape {

    private Circle base;
    private double height;

    public Cone(final double radius, final double height) {
        if (height <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        base = new Circle(radius);
        this.height = height;
    }

    @Override
    public double getArea() {
        return base.getArea() + Math.PI * height * base.getRadius();
    }
}

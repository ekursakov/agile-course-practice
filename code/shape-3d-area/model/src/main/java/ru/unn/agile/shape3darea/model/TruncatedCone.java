package ru.unn.agile.shape3darea.model;


public class TruncatedCone implements Shape {

    private Circle upperBase;
    private Circle bottomBase;
    private double l;

    public TruncatedCone(final double r1, final double r2, final double l) {
        if (l <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        upperBase = new Circle(r1);
        bottomBase = new Circle(r2);
        this.l = l;
    }

    @Override
    public double getArea() {
        return Math.PI * (upperBase.getRadius() + bottomBase.getRadius()) * l
                + upperBase.getArea()
                + bottomBase.getArea();
    }
}

package ru.unn.agile.shape3darea.model;


public class TrianglePrism implements Shape {

    private static final int BASE_COUNT = 2;
    private final Triangle base;
    private final double height;

    public TrianglePrism(final Triangle base, final double height) {
        if (height <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return BASE_COUNT * base.getArea()
                + height * base.getA()
                + height * base.getB()
                + height * base.getC();
    }
}

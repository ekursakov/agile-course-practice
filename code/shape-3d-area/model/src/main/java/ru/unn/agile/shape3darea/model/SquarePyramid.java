package ru.unn.agile.shape3darea.model;


public class SquarePyramid implements Shape {

    private static final int TRIANGLES_COUNT = 4;
    private final double squareSide;
    private final Triangle triangleSide;

    public SquarePyramid(final double squareSide, final double triangleSide) {
        if (squareSide <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        this.squareSide = squareSide;
        this.triangleSide = new Triangle(squareSide, triangleSide, triangleSide);
    }

    @Override
    public double getArea() {
        double baseArea = squareSide * squareSide;
        double trianglesArea = TRIANGLES_COUNT * triangleSide.getArea();
        return baseArea + trianglesArea;
    }
}

package ru.unn.agile.shape3darea.model;


public class TrianglePyramid implements Shape {

    private static final int SIDES_COUNT = 3;
    private Triangle base;
    private Triangle side;

    public TrianglePyramid(final double baseSize, final double sideSize) {
        base = new Triangle(baseSize, baseSize, baseSize);
        side = new Triangle(sideSize, sideSize, baseSize);
    }

    @Override
    public double getArea() {
        return base.getArea() + SIDES_COUNT * side.getArea();
    }
}

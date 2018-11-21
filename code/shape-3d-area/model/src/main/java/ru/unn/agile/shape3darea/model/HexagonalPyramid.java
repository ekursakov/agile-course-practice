package ru.unn.agile.shape3darea.model;


public class HexagonalPyramid implements Shape {

    private static final int TRIANGLES_COUNT = 6;
    private Triangle triangleSide;
    private Hexagon hexagonSide;

    public HexagonalPyramid(final double hexagonSide, final double triangleSide) {
        this.hexagonSide = new Hexagon(hexagonSide);
        this.triangleSide = new Triangle(hexagonSide, triangleSide, triangleSide);
    }

    @Override
    public double getArea() {
        return hexagonSide.getArea() + TRIANGLES_COUNT * triangleSide.getArea();
    }
}

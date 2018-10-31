package ru.unn.agile.shapevolume.shapes2d;

public class RegularPolygon implements Shape2D {
    private final int sidesCount;
    private final double radius;

    public RegularPolygon(int sidesCount, double innerRadius) {
        this.sidesCount = sidesCount;
        this.radius = innerRadius;
    }

    @Override
    public double getArea() {
        return sidesCount * radius*radius*Math.sin();
    }
}

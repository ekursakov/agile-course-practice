package ru.unn.agile.shape3darea.model;

import java.util.Map;

public final class AreaCalculator {
    public double calculate(ShapeType shape, Map<String, Object> parameters) {
        double squareSide = (double) parameters.get("squareSide");
        double triangleSide = (double) parameters.get("triangleSide");
        double baseArea = squareSide * squareSide;

        double trianglesArea = 4 * 3 * triangleSide / 2;
        return baseArea + trianglesArea;
    }
}

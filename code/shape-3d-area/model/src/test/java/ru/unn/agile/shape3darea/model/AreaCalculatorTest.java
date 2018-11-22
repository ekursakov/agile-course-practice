package ru.unn.agile.shape3darea.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AreaCalculatorTest {

    private static final double DELTA = 0.00001;

    private AreaCalculator calculator = new AreaCalculator();

    @Test
    public void canCreateCircle() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("squareSide", 1);
        parameters.put("triangleSide", 1);

        double area = calculator.calculate(ShapeType.SQUARE_PYRAMID, parameters);

        double expectedArea = 1 + 2 * Math.sqrt(0.75);
        assertEquals(expectedArea, area, DELTA);
    }
}
package ru.unn.agile.shape3darea.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ShapeFactoryTest {
    @Test
    public void canCreateCircle() {
        int radius = 2;
        ShapeFactory factory = new ShapeFactory();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("radius", radius);

        Shape circle = factory.create(ShapeType.CIRCLE, parameters);

        assertEquals(circle, new Circle(radius));
    }
}
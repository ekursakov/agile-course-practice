package ru.unn.agile.shapevolume.shapes2d;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.unn.agile.shapevolume.TestConstants.EPSILON;

public class RegularPolygonTest {

    @Test
    public void whenDimensionThreeThenCalculateArea() {
        RegularPolygon polygon = new RegularPolygon(3, 1.0);

        double area = polygon.getArea();

        assertEquals(1.0, area, EPSILON);
    }
}
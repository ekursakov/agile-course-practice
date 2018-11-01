package ru.unn.agile.shapevolume;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.unn.agile.shapevolume.TestConstants.EPSILON;

public class ConeTest {
    @Test
    public void whenZeroRadiusThenZeroVolume() {
        Cone cuboid = new Cone(0.0, 5.0);

        double volume = cuboid.getVolume();

        assertEquals(0.0, volume, EPSILON);
    }

    @Test
    public void whenZeroHeightThenZeroVolume() {
        Cone cuboid = new Cone(5.0, 0.0);

        double volume = cuboid.getVolume();

        assertEquals(0.0, volume, EPSILON);
    }

    @Test
    public void whenPositiveRadiusAndHeightThenCalculateVolume() {
        Cone cuboid = new Cone(2.0, 3.0);

        double volume = cuboid.getVolume();

        assertEquals(4 * Math.PI, volume, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeRadiusThenThrows() {
        new Cone(-1.0, 1.0);
    }
}

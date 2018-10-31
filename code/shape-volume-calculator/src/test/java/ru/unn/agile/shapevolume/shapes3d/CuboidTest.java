package ru.unn.agile.shapevolume.shapes3d;

import org.junit.Test;
import ru.unn.agile.shapevolume.shapes3d.Cuboid;

import static org.junit.Assert.*;
import static ru.unn.agile.shapevolume.TestConstants.EPSILON;

public class CuboidTest {

    @Test
    public void whenZeroSideThenZeroVolume() {
        Cuboid cuboid = new Cuboid(0.0, 6.0, 1.0);

        double volume = cuboid.getVolume();

        assertEquals(0.0, volume, EPSILON);
    }

    @Test
    public void whenPositiveSidesThenCalculateVolume() {
        Cuboid cuboid = new Cuboid(2.0, 3.0, 4.0);

        double volume = cuboid.getVolume();

        assertEquals(24.0, volume, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeSideThenThrows() {
        new Cuboid(-5.0, 6.0, 1.0);
    }
}

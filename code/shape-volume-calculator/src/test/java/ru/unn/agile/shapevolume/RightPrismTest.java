package ru.unn.agile.shapevolume;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.unn.agile.shapevolume.TestConstants.EPSILON;

public class RightPrismTest {

    @Test
    public void whenZeroHeightThenZeroVolume() {
        RightPrism rightPrism = new RightPrism(3, 2.0, 0.0);

        double volume = rightPrism.getVolume();

        assertEquals(0.0, volume, EPSILON);
    }

    @Test
    public void whenEquilateralTriangleBaseThenCalculateVolume() {
        RightPrism prism = new RightPrism(3, 2.0, 5.0);

        double volume = prism.getVolume();

        assertEquals(8.660254, volume, EPSILON);
    }
    @Test
    public void whenHexagonBaseThenCalculateVolume() {
        RightPrism prism = new RightPrism(6, 1.0, 2.0);

        double volume = prism.getVolume();

        assertEquals(5.196152, volume, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeHeightThenThrows() {
        new RightPrism(3, 1.0, -1.0);
    }
}

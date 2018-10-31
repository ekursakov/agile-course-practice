package ru.unn.agile.shapevolume.shapes3d;

import org.junit.Test;
import ru.unn.agile.shapevolume.shapes2d.RegularPolygon;
import ru.unn.agile.shapevolume.shapes2d.Shape2D;

import static org.junit.Assert.assertEquals;
import static ru.unn.agile.shapevolume.TestConstants.EPSILON;

public class PrismTest {

    @Test
    public void whenZeroHeightThenZeroVolume() {
        Shape2D base = new RegularPolygon(4, 1.0);
        Prism prism = new Prism(base, 0.0);

        double volume = prism.getVolume();

        assertEquals(0.0, volume, EPSILON);
    }

    @Test
    public void whenPositiveSideAndHeightThenCalculateVolume() {
        Shape2D base = new RegularPolygon(4, 1.0);
        Prism prism = new Prism(base, 4.0);

        double volume = prism.getVolume();

        assertEquals(4.0, volume, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeHeightThenThrows() {
        Shape2D base = new RegularPolygon(4, 1.0);
        new Prism(base, -1.0);
    }
}

package ru.unn.agile.shape3darea.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.shape3darea.model.Shape;
import ru.unn.agile.shape3darea.model.SquarePyramid;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShapeCreatorTest {
    private static final double DELTA = 0.00001;

    private ShapeCreator creator;

    @Before
    public void setUp() {
        creator = new ShapeCreator();
    }

    @After
    public void tearDown() {
        creator = null;
    }

    @Test
    public void canCreateShapeWithoutParameters() {

        Shape shape = creator.create(EmptyShape.class, emptyList());

        assertTrue(shape instanceof EmptyShape);
    }

    @Test
    public void canCreateShapeWithDoubleParameter() {
        ShapeParameter param = new ShapeParameter(double.class, "param");
        param.setValue("42");

        Shape shape = creator.create(DoubleParamShape.class, singletonList(param));

        assertTrue(shape instanceof DoubleParamShape);
        assertEquals(42, ((DoubleParamShape) shape).getParam(), DELTA);
    }

    @Test
    public void canCreateShapeWithIntParameter() {
        ShapeParameter param = new ShapeParameter(int.class, "param");
        param.setValue("10");

        Shape shape = creator.create(IntParamShape.class, singletonList(param));

        assertTrue(shape instanceof IntParamShape);
        assertEquals(10, ((IntParamShape) shape).getParam());
    }

    @Test
    public void canCreateSquarePyramid() {
        ShapeParameter squareSide = new ShapeParameter(double.class, "squareSide");
        ShapeParameter triangleSide = new ShapeParameter(double.class, "triangleSide");
        squareSide.setValue("1");
        triangleSide.setValue("1");
        List<ShapeParameter> parameters = Arrays.asList(squareSide, triangleSide);

        Shape shape = creator.create(SquarePyramid.class, parameters);

        assertTrue(shape instanceof SquarePyramid);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void canNotCreateShapeWithStringParameter() {
        ShapeParameter param = new ShapeParameter(String.class, "param");
        param.setValue("10");

        creator.create(StringParamShape.class, singletonList(param));
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateShapeWithInvalidNumber() {
        ShapeParameter param = new ShapeParameter(double.class, "param");
        param.setValue("10test");

        creator.create(DoubleParamShape.class, singletonList(param));
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateShapeWithInvalidArgumentsCount() {
        ShapeParameter param = new ShapeParameter(double.class, "param");
        ShapeParameter param2 = new ShapeParameter(double.class, "param2");

        creator.create(DoubleParamShape.class, Arrays.asList(param, param2));
    }

    abstract static class TestShape implements Shape {
        @Override
        public double getArea() {
            return 0;
        }
    }

    static class EmptyShape extends TestShape {
        EmptyShape() {
        }
    }

    static class DoubleParamShape extends TestShape {
        private final double param;

        DoubleParamShape(final double param) {
            this.param = param;
        }

        double getParam() {
            return param;
        }
    }

    static class IntParamShape extends TestShape {
        private final int param;

        IntParamShape(final int param) {
            this.param = param;
        }

        int getParam() {
            return param;
        }
    }

    static class StringParamShape extends TestShape {
        private final String param;

        StringParamShape(final String param) {
            this.param = param;
        }
    }
}

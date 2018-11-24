package ru.unn.agile.shape3darea.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.shape3darea.model.ShapeType;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void whenCreateViewModelThenSetDefaultValues() {
        assertEquals(ShapeType.SQUARE_PYRAMID, viewModel.getSelectedShape());

        assertEquals(2, viewModel.getParameters().size());

        assertEquals(double.class, viewModel.getParameters().get(0).getType());
        assertEquals("squareSide", viewModel.getParameters().get(0).getName());
        assertEquals("0", viewModel.getParameters().get(0).getValue());

        assertEquals(double.class, viewModel.getParameters().get(1).getType());
        assertEquals("triangleSide", viewModel.getParameters().get(1).getName());
        assertEquals("0", viewModel.getParameters().get(1).getValue());

        assertEquals("", viewModel.getResult());
        assertEquals("Ready", viewModel.getStatus());
    }

    @Test
    public void whenCalculateWithEmptyFieldsThenShowError() {
        viewModel.calculate();

        assertEquals("", viewModel.getResult());
        assertEquals(Status.INVALID_INPUT.toString(), viewModel.getStatus());
    }

    @Test
    public void whenCalculateWithInvalidInputThenShowError() {
        viewModel.getParameters().get(0).setValue("1.2.3");
        viewModel.getParameters().get(0).setValue("52a");
        viewModel.calculate();

        assertEquals("", viewModel.getResult());
        assertEquals(Status.INVALID_INPUT.toString(), viewModel.getStatus());
    }

    @Test
    public void whenCalculateSquarePyramidThenShowResult() {
        viewModel.getParameters().get(0).setValue("1");
        viewModel.getParameters().get(1).setValue("1");
        viewModel.calculate();

        assertEquals(Status.OK.toString(), viewModel.getStatus());
        assertEquals(String.valueOf(1 + 2 * Math.sqrt(0.75)), viewModel.getResult());
    }

    @Test
    public void whenChangeShapeThenUpdateParameters() {
        viewModel.setSelectedShape(ShapeType.SPHERE);

        assertEquals(ShapeType.SPHERE, viewModel.getSelectedShape());

        assertEquals(1, viewModel.getParameters().size());

        assertEquals(double.class, viewModel.getParameters().get(0).getType());
        assertEquals("radius", viewModel.getParameters().get(0).getName());
        assertEquals("0", viewModel.getParameters().get(0).getValue());
    }

    @Test
    public void whenCalculateSphereThenShowResult() {
        viewModel.setSelectedShape(ShapeType.SPHERE);
        viewModel.getParameters().get(0).setValue("1");
        viewModel.calculate();

        assertEquals(Status.OK.toString(), viewModel.getStatus());
        assertEquals("12.566370614359172", viewModel.getResult());
    }

    @Test
    public void whenCalculateInvalidInputAndChangeShapeAndValidInputThenShowResult() {
        viewModel.calculate();
        viewModel.setSelectedShape(ShapeType.SPHERE);
        viewModel.getParameters().get(0).setValue("1");
        viewModel.calculate();

        assertEquals(Status.OK.toString(), viewModel.getStatus());
        assertEquals("12.566370614359172", viewModel.getResult());
    }
}

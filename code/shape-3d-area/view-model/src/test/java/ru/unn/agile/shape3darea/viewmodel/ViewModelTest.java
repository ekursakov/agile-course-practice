package ru.unn.agile.shape3darea.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.shape3darea.model.ShapeType;

import java.util.List;
import java.util.stream.Collectors;

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
    public void testDefaultValues() {
        List<ParameterRow> exceptedParameters = ShapeType.SQUARE_PYRAMID.getParameters()
                .stream()
                .map(ParameterRow::new)
                .collect(Collectors.toList());

        assertEquals(ShapeType.SQUARE_PYRAMID, viewModel.getSelectedShape());
        assertEquals(exceptedParameters, viewModel.getParameters());
        assertEquals("", viewModel.getResult());
        assertEquals(Status.EMPTY_DATA.toString(), viewModel.getStatus());
    }

    @Test
    public void name() {
        List<ParameterRow> exceptedParameters = ShapeType.SQUARE_PYRAMID.getParameters()
                .stream()
                .map(ParameterRow::new)
                .collect(Collectors.toList());

        assertEquals(ShapeType.SQUARE_PYRAMID, viewModel.getSelectedShape());
        assertEquals(exceptedParameters, viewModel.getParameters());
        assertEquals("", viewModel.getResult());
        assertEquals(Status.EMPTY_DATA.toString(), viewModel.getStatus());
    }
}

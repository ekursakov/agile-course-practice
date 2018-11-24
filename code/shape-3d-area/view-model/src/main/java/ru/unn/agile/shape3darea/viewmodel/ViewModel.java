package ru.unn.agile.shape3darea.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.shape3darea.model.Shape;
import ru.unn.agile.shape3darea.model.ShapeType;
import ru.unn.agile.shape3darea.model.Sphere;
import ru.unn.agile.shape3darea.model.SquarePyramid;

import java.util.Arrays;

import static java.util.Collections.singletonList;

public final class ViewModel {
    private static final String SQUARE_SIDE = "squareSide";
    private static final String TRIANGLE_SIDE = "triangleSide";
    private static final String RADIUS = "radius";

    private final ShapeCreator shapeCreator = new ShapeCreator();

    private final ObservableList<ShapeType> shapes = FXCollections.observableList(
            Arrays.asList(ShapeType.values())
    );

    private final ObjectProperty<ShapeType> selectedShape = new SimpleObjectProperty<>();
    private final ObservableList<ShapeParameter> parameters = FXCollections.observableArrayList();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    public ViewModel() {
        selectedShape.addListener((observable, oldValue, newValue) -> updateParameters(newValue));

        selectedShape.set(ShapeType.SQUARE_PYRAMID);
        result.set("");
        status.set(Status.OK.toString());
    }

    private void updateParameters(final ShapeType shapeType) {
        switch (shapeType) {
            case SQUARE_PYRAMID:
                parameters.setAll(Arrays.asList(
                        new ShapeParameter(double.class, SQUARE_SIDE),
                        new ShapeParameter(double.class, TRIANGLE_SIDE)
                ));
                break;
            case SPHERE:
                parameters.setAll(singletonList(new ShapeParameter(double.class, RADIUS)));
                break;
            default:
                throw new IllegalStateException("Invalid shape type: " + selectedShape.get());
        }
    }

    public ObservableList<ShapeType> getShapes() {
        return shapes;
    }

    public ShapeType getSelectedShape() {
        return selectedShape.get();
    }

    public void setSelectedShape(final ShapeType selectedShape) {
        this.selectedShape.set(selectedShape);
    }

    public ObjectProperty<ShapeType> selectedShapeProperty() {
        return selectedShape;
    }

    public ObservableList<ShapeParameter> getParameters() {
        return parameters;
    }

    public String getResult() {
        return result.get();
    }

    public StringProperty resultProperty() {
        return result;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void calculate() {
        try {
            Class<? extends Shape> shapeClass = null;
            switch (selectedShape.get()) {
                case SQUARE_PYRAMID:
                    shapeClass = SquarePyramid.class;
                    break;
                case SPHERE:
                    shapeClass = Sphere.class;
                    break;
                default:
                    throw new IllegalStateException("Invalid shape type: " + selectedShape.get());
            }
            Shape shape = shapeCreator.create(shapeClass, parameters);
            result.set(String.valueOf(shape.getArea()));
            status.set(Status.OK.toString());
        } catch (Exception e) {
            result.set("");
            status.set(Status.INVALID_INPUT.toString());
        }
    }
}

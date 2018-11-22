package ru.unn.agile.shape3darea.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.shape3darea.model.ShapeType;

import java.util.Arrays;
import java.util.stream.Collectors;

enum Status {
    OK("Ok"),
    EMPTY_DATA("No data"),
    BAD_FORMAT("Invalid format");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

public final class ViewModel {
    private final ObservableList<ShapeType> shapes = FXCollections.observableList(Arrays.asList(ShapeType.values()));

    private final ObjectProperty<ShapeType> selectedShape = new SimpleObjectProperty<>();
    private final ObservableList<ParameterRow> parameters = FXCollections.observableArrayList();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    public ViewModel() {
        selectedShape.addListener((observable, oldValue, newValue) -> updateParameters(newValue));

        selectedShape.set(ShapeType.SQUARE_PYRAMID);
        result.setValue("");
        status.setValue(Status.EMPTY_DATA.toString());
    }

    private void updateParameters(ShapeType shapeType) {
        parameters.setAll(shapeType.getFactory().getParameters()
                .stream().map(ParameterRow::new).collect(Collectors.toList()));
    }

    public ObservableList<ShapeType> getShapes() {
        return shapes;
    }

    public ShapeType getSelectedShape() {
        return selectedShape.get();
    }

    public ObjectProperty<ShapeType> selectedShapeProperty() {
        return selectedShape;
    }

    public ObservableList<ParameterRow> getParameters() {
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

    }
}

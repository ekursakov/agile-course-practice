package ru.unn.agile.shape3darea.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.shape3darea.model.ShapeParameter;

import java.util.Objects;

public class ParameterRow {
    private final ShapeParameter shapeParameter;
    private final StringProperty value = new SimpleStringProperty("");

    public ParameterRow(ShapeParameter shapeParameter) {
        this.shapeParameter = shapeParameter;
    }

    public Class<?> getType() {
        return shapeParameter.getType();
    }

    public String getName() {
        return shapeParameter.getName();
    }

    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterRow that = (ParameterRow) o;
        return Objects.equals(shapeParameter, that.shapeParameter) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapeParameter, value);
    }
}

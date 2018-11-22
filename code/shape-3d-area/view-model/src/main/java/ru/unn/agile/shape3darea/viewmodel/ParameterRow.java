package ru.unn.agile.shape3darea.viewmodel;

import ru.unn.agile.shape3darea.model.ShapeParameter;

import java.util.Objects;

public class ParameterRow {
    private final ShapeParameter shapeParameter;
    private Object value;

    public ParameterRow(ShapeParameter shapeParameter) {
        this.shapeParameter = shapeParameter;
    }

    public ShapeParameter getShapeParameter() {
        return shapeParameter;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
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

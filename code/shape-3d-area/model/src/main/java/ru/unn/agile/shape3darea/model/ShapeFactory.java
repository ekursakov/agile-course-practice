package ru.unn.agile.shape3darea.model;

import java.util.List;
import java.util.Map;

public interface ShapeFactory {
    List<ShapeParameter> getParameters();

    Shape create(Map<String, Object> arguments);
}

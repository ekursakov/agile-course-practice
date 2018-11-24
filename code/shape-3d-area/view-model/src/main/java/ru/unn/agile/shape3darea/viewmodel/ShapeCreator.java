package ru.unn.agile.shape3darea.viewmodel;

import ru.unn.agile.shape3darea.model.Shape;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

class ShapeCreator {

    Shape create(final Class<? extends Shape> shapeClass, final List<ShapeParameter> parameters) {
        Class<?>[] parameterTypes = new Class[parameters.size()];
        Object[] parameterValues = new Object[parameters.size()];
        for (int i = 0; i < parameters.size(); i++) {
            ShapeParameter parameter = parameters.get(i);
            Class<?> type = parameter.getType();
            String value = parameter.getValue();

            parameterTypes[i] = type;

            if (type.equals(double.class)) {
                parameterValues[i] = Double.parseDouble(value);
            } else if (type.equals(int.class)) {
                parameterValues[i] = Integer.parseInt(value);
            } else {
                throw new UnsupportedOperationException("Unknown type " + type);
            }
        }

        try {
            Constructor<? extends Shape> constructor
                    = shapeClass.getDeclaredConstructor(parameterTypes);
            return constructor.newInstance(parameterValues);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new IllegalArgumentException("Can't find constructor for supplied parameters", e);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof RuntimeException) {
                throw (RuntimeException) e.getCause();
            } else {
                throw new IllegalArgumentException(e);
            }
        }
    }
}

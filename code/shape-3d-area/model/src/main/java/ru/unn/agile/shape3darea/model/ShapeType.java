package ru.unn.agile.shape3darea.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum ShapeType implements ShapeFactory {
    SQUARE_PYRAMID {
        private static final String SQUARE_SIDE = "squareSide";
        private static final String TRIANGLE_SIDE = "triangleSide";

        @Override
        public List<ShapeParameter> getParameters() {
            return Arrays.asList(
                    new ShapeParameter(double.class, SQUARE_SIDE),
                    new ShapeParameter(double.class, TRIANGLE_SIDE)
            );
        }

        @Override
        public Shape create(Map<String, Object> arguments) {
            return new SquarePyramid((double) arguments.get(SQUARE_SIDE), (double) arguments.get(TRIANGLE_SIDE));
        }
    };


    public ShapeFactory getFactory() {
        return this;
    }
}

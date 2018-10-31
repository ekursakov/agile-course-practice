package ru.unn.agile.shapevolume;

import static ru.unn.agile.shapevolume.ShapeVolumeConstants.ERROR_SIZE_MUST_BE_NOT_NEGATIVE;

public class Cone {
    private static final int CONE_VOLUME_COEFF = 3;

    private final double raduis;
    private final double height;

    public Cone(final double radius, final double height) {
        if (radius < 0 || height < 0) {
            throw new IllegalArgumentException(ERROR_SIZE_MUST_BE_NOT_NEGATIVE);
        }
        this.raduis = radius;
        this.height = height;
    }

    public double getVolume() {
        double baseArea = 2 * Math.PI * raduis;
        return (baseArea * height) / CONE_VOLUME_COEFF;
    }
}

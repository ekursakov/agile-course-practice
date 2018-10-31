package ru.unn.agile.shapevolume;

import static ru.unn.agile.shapevolume.ShapeVolumeConstants.ERROR_SIZE_MUST_BE_NOT_NEGATIVE;

public class Cone {
    private final double raduis;
    private final double height;

    public Cone(final double raduis, final double height) {
        if (raduis < 0 || height < 0) {
            throw new IllegalArgumentException(ERROR_SIZE_MUST_BE_NOT_NEGATIVE);
        }
        this.raduis = raduis;
        this.height = height;
    }

    public double getVolume() {
        return (2 * Math.PI * raduis * height) / 3;
    }
}

package ru.unn.agile.shapevolume;

import static ru.unn.agile.shapevolume.ShapeVolumeConstants.ERROR_SIZE_MUST_BE_NOT_NEGATIVE;

public class Cuboid {
    private final double a;
    private final double b;
    private final double c;

    public Cuboid(final double a, final double b, final double c) {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException(ERROR_SIZE_MUST_BE_NOT_NEGATIVE);
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getVolume() {
        return a * b * c;
    }
}

package ru.unn.agile.shapevolume.shapes3d;

import ru.unn.agile.shapevolume.shapes2d.Shape2D;

import static ru.unn.agile.shapevolume.ShapeVolumeConstants.ERROR_SIZE_MUST_BE_NOT_NEGATIVE;

public class Prism {
    private static final int PYRAMID_VOLUME_COEFF = 3;

    private final double height;
    private Shape2D base;

    public Prism(final Shape2D base, final double height) {
        if (height < 0) {
            throw new IllegalArgumentException(ERROR_SIZE_MUST_BE_NOT_NEGATIVE);
        }
        this.base = base;
        this.height = height;
    }

    public double getVolume() {
        return base.getArea() * height / PYRAMID_VOLUME_COEFF;
    }
}

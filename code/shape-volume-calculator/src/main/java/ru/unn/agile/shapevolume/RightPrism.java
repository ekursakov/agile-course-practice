package ru.unn.agile.shapevolume;

import static ru.unn.agile.shapevolume.ShapeVolumeConstants.ERROR_SIZE_MUST_BE_NOT_NEGATIVE;

public class RightPrism {
    public static final int REGULAR_POLYNOM_AREA_COEFF = 4;
    private final int sidesCount;
    private final double sideLength;
    private final double height;

    public RightPrism(final int baseSidesCount, final double baseSideLength, final double height) {
        if (baseSideLength < 0 || height < 0) {
            throw new IllegalArgumentException(ERROR_SIZE_MUST_BE_NOT_NEGATIVE);
        }
        this.sidesCount = baseSidesCount;
        this.sideLength = baseSideLength;
        this.height = height;
    }

    public double getVolume() {
        double baseArea = sidesCount * sideLength * sideLength
                * Math.cos(Math.PI / sidesCount) / Math.sin(Math.PI / sidesCount)
                / REGULAR_POLYNOM_AREA_COEFF;
        return baseArea * height;
    }
}

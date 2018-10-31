package ru.unn.agile.shapevolume;

public class Cuboid {
    private final double a;
    private final double b;
    private final double c;

    public Cuboid(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Shape's side must be non-negative");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getVolume() {
        return a * b * c;
    }
}

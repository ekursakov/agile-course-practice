package ru.unn.agile.shape3darea.model;


public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(final double a, final double b, final double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException(ShapesAreaConstants.PARAMETERS_CAN_NOT_BE_NEGATIVE);
        }
        if (a > b + c || b > a + c || c > a + b) {
            throw new IllegalArgumentException(ShapesAreaConstants.TRIANGLE_INEQUALITY_VIOLATED);
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}

package ru.unn.agile.shape3darea.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShapesAreaTest {

    private static final double DELTA = 0.00001;

    @Test
    public void canGetCubeArea() {
        // Arrange
        Shape cube = new Cube(1);
        // Act
        double area = cube.getArea();
        // Assert
        double expectedArea = 6;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetCubeAreaWithTwoSide() {
        // Arrange
        Shape cube = new Cube(2);
        // Act
        double area = cube.getArea();
        // Assert
        double expectedArea = 24;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetSphereArea() {
        // Arrange
        Shape sphere = new Sphere(1);
        // Act
        double area = sphere.getArea();
        // Assert
        double expectedArea = 4 * Math.PI;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetSphereWithRadiusTwoArea() {
        // Arrange
        Shape sphere = new Sphere(2);
        // Act
        double area = sphere.getArea();
        // Assert
        double expectedArea = 16 * Math.PI;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetUnitCuboidArea() {
        // Arrange
        Shape cuboid = new Cuboid(1, 1, 1);
        // Act
        double area = cuboid.getArea();
        // Assert
        double expectedArea = 6;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetCuboidArea() {
        // Arrange
        Shape cuboid = new Cuboid(1, 3, 5);
        // Act
        double area = cuboid.getArea();
        // Assert
        double expectedArea = 46;
        assertEquals(expectedArea, area, DELTA);
    }


    @Test
    public void canGetUnitCylinderArea() {
        // Arrange
        Shape cylinder = new Cylinder(1, 1);
        // Act
        double area = cylinder.getArea();
        // Assert
        double expectedArea = 4 * Math.PI;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetCylinderArea() {
        // Arrange
        Shape cylinder = new Cylinder(3, 5);
        // Act
        double area = cylinder.getArea();
        // Assert
        double expectedArea = 2 * Math.PI * 3 * 8;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetUnitSquarePyramidArea() {
        // Arrange
        Shape squarePyramid = new SquarePyramid(1, 1);
        // Act
        double area = squarePyramid.getArea();
        // Assert
        double expectedArea = 1 + 2 * Math.sqrt(0.75);
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetSquarePyramidArea() {
        // Arrange
        Shape squarePyramid = new SquarePyramid(2, 5);
        // Act
        double area = squarePyramid.getArea();
        // Assert
        double expectedArea = 4 + 2 * 2 * Math.sqrt(5 * 5 - 2 * 2 / 4);
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetUnitHexagonalPyramidArea() {
        // Arrange
        Shape pyramid = new HexagonalPyramid(1, 1);
        // Act
        double area = pyramid.getArea();
        // Assert
        double expectedArea = 3 * (Math.sqrt(0.75) + Math.sqrt(3) / 2);
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetUnitTriangleArea() {
        // Arrange
        Shape triangle = new Triangle(1, 1, 1);
        // Act
        double area = triangle.getArea();
        // Assert
        double expectedArea = Math.sqrt(3) / 4;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetUnitHexagonArea() {
        // Arrange
        Shape hexagon = new Hexagon(1);
        // Act
        double area = hexagon.getArea();
        // Assert
        double expectedArea = 3 * Math.sqrt(3) / 2;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetTrianglePrismArea() {
        // Arrange
        Shape prism = new TrianglePrism(new Triangle(1, 1, 1), 5);
        // Act
        double area = prism.getArea();
        // Assert
        double expectedArea = Math.sqrt(3) / 2 + 3 * 5;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetCircleArea() {
        // Arrange
        Shape circle = new Circle(4);
        // Act
        double area = circle.getArea();
        // Assert
        double expectedArea = Math.PI * 16;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetConesArea() {
        // Arrange
        Shape cones = new Cone(4, 5);
        // Act
        double area = cones.getArea();
        // Assert
        double expectedArea = Math.PI * 20 + Math.PI * 16;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCircleWithNegativeRadius() {
        new Circle(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateConeWithNegativeParams() {
        new Cone(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCubeWithNegativeParams() {
        new Cube(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCylinderWithNegativeParams() {
        new Cylinder(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateHexagonWithNegativeParams() {
        new Hexagon(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateHexagonalPyramidWithNegativeParams() {
        new HexagonalPyramid(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateCuboidWithNegativeParams() {
        new Cuboid(1, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateSphereWithNegativeParams() {
        new Sphere(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateSquarePyramidWithNegativeParams() {
        new SquarePyramid(-3, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateTrianglePrismWithNegativeParams() {
        new TrianglePrism(new Triangle(0, 0, 0), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateTriangleWithNegativeParams() {
        new Triangle(-1, -1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateTriangleWithViolatedTriangleInequality() {
        new Triangle(100, 1, 1);
    }

    @Test
    public void canGetTruncatedConeArea() {
        // Arrange
        Shape cone = new TruncatedCone(2, 4, 1);
        // Act
        double area = cone.getArea();
        // Assert
        double expectedArea = Math.PI * (2 + 4) * 1 + Math.PI * 4 + Math.PI * 16;
        assertEquals(expectedArea, area, DELTA);
    }

    @Test
    public void canGetTrianglePyramidArea() {
        // Arrange
        Shape pyramid = new TrianglePyramid(5, 6);
        // Act
        double area = pyramid.getArea();
        // Assert
        double expectedArea = Math.sqrt(3) / 4.0 * 5 * 5
                + 3.0 / 2.0 * 5 * Math.sqrt(6 * 6 - 5 * 5 / 4.0);
        assertEquals(expectedArea, area, DELTA);
    }
}

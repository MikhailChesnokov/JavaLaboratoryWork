package Lab_I.ClassPackage;

import Lab_I.InterfacePackage.AreaCalculable;

public class Point implements AreaCalculable {
    private double coordinateX, coordinateY;

    public Point() {
        this.coordinateX = this.coordinateY = 0;
    }

    public Point(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getArea() {
        return 0;
    }

    static boolean isPositiveRealNumber(double value) {
        return Double.isFinite(value) && (value > 0);
    }
}
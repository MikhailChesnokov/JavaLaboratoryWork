package Lab_I.ClassPackage;

public class Circle extends Point {
    private double radius = 1;

    public Circle(double centerCoordinateX, double centerCoordinateY, double radius) {
        super(centerCoordinateX, centerCoordinateY);

        try {
            setRadius(radius);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument exception: " + e.getMessage());
        }
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws IllegalArgumentException{
        if (isPositiveRealNumber(radius)) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
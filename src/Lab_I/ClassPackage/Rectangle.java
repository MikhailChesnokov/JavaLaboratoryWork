package Lab_I.ClassPackage;

public class Rectangle extends Point {
    private double width, height;

    {
        width = 1;
        height = 1;
    }

    public Rectangle(double centerCoordinateX, double centerCoordinateY, double width, double height) {
        super(centerCoordinateX, centerCoordinateY);

        try {
            setWidth(width);
            setHeight(height);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument exception: " + e.getMessage());
        }
    }

    @Override
    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws IllegalArgumentException {
        if (isPositiveRealNumber(width)) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("The width argument is incorrect.");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws IllegalArgumentException {
        if (isPositiveRealNumber(height)) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("The height argument is incorrect.");
        }
    }
}
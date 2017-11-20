package Lab_I;

import Lab_I.ClassPackage.*;
import Lab_I.InterfacePackage.*;
import java.util.*;

public class Solver {
    public static void main() {
        List<AreaCalculable> someShapes = Arrays.asList(
                new Point(),
                new Point(0,0),
                new Circle(0, 0, 1),
                new Circle(1.5, 3, 27),
                new Rectangle(0, 0, 1, 1),
                new Rectangle(0.5, 0.75, 10, 20));

        someShapes.forEach(shape -> System.out.println(shape.getArea()));
    }
}
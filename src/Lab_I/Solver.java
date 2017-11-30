package Lab_I;

// 4. Using two packages
import Lab_I.ClassPackage.*;
import Lab_I.InterfacePackage.*;
import java.util.*;

public class Solver {
    public static void main() {
        // 3. Link to interface "AreaCalculable" and use interface method "getArea"
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
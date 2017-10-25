package III._2_Primes;

public class Solver {
    public static void main() {
        new PrimesGenerator(0,100).forEach(x -> System.out.print(x + " "));
        System.out.println();
        new PrimesGenerator(75,25).forEach(x -> System.out.print(x + " "));
        System.out.println('\n');
    }
}
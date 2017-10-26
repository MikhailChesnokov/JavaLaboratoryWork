package Lab_III._2_Primes;

import java.util.Iterator;

public class PrimesGenerator implements Iterable<Integer> {
    int from, to;

    public PrimesGenerator(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int current = from;

            public boolean hasNext() {
                return from < to ? current < to : current > to;
            }

            public Integer next() {
                while (!isPrime(from < to ? current++ : current--));
                return from < to ? current - 1 : current + 1;
            }

            private boolean isPrime(int number)
            {
                number = Math.abs(number);
                if (number < 2) return false;
                if (number < 4) return true;
                if (number % 2 == 0) return false;
                for (int i = 3; i < Math.sqrt(number) + 1; i+=2)
                    if (number % i == 0) return false;
                return true;
            }
        };
    }
}

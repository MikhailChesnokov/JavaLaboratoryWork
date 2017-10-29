package Lab_III._2_Primes;

import java.util.Iterator;
import java.util.stream.IntStream;

public class PrimesGenerator implements Iterable<Integer> {
    private final int from, to;

    public PrimesGenerator(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int current = from;

            public boolean hasNext() {
                return from < to ? ++current < to : --current > to;
            }

            public Integer next() {
                return current = IntStream
                        .iterate(current, i -> from < to ? ++i : --i)
                        .filter(number -> number > 1 && IntStream.range(2, (int)Math.sqrt(number) + 1).noneMatch(x -> number % x == 0))
                        .findFirst().getAsInt();
            }
        };
    }
}
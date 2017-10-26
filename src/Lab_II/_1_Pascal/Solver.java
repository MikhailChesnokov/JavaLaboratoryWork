package Lab_II._1_Pascal;

import javafx.util.Pair;
import java.util.HashMap;

public class Solver {
    static HashMap<Pair<Integer,Integer>, Integer> combinationsCache = new HashMap<>();
    static int n = 6;

    public static void main() {
        for (int i = 1; i <= n; i++,System.out.println())
            for (int j = 1; j <= i; j++)
                System.out.print(combinations(new Pair(i,j)) + " ");
    }

    public static int combinations(Pair<Integer, Integer> pair) {
        if (pair.getKey() < 2 || pair.getValue() < 2 || pair.getKey() <= pair.getValue()) return 1;
        if (combinationsCache.containsKey(pair)) return combinationsCache.get(pair);
        combinationsCache.put(pair, combinations(new Pair<>(pair.getKey() - 1, pair.getValue() - 1)) +
                                    combinations(new Pair<>(pair.getKey() - 1, pair.getValue())));
        return combinationsCache.get(pair);
    }
}
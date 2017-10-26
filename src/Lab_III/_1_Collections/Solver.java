package Lab_III._1_Collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solver {

    public static void main() {

        // Task A - create an array
        Integer[] array = new Integer[] {5,2,1,4,2,3};

        // Task B - create List, based on the array created above
        List<Integer> list = Arrays.asList(array);
        printList("Initial list:",list);

        // C - sort ascending
        Collections.sort(list);
        printList("Sorted ascending:",list);

        // D - sort descending
        Collections.sort(list, (x, y) -> y - x);
        printList("Sorted descending:",list);

        // Task E - shuffle
        Collections.shuffle(list);
        printList("Shuffled:",list);

        // Task F - cyclic shirt
        Collections.rotate(list,1);
        printList("Shifted:",list);

        // Task G - unique only
        list = list.stream().distinct().collect(Collectors.toList());
        printList("Distinct:",list);

        // Task H - duplicates only
        // Firstly, Add few duplicates
        Collections.addAll(list,2,2,2,3,3,5);
        // Secondly, remove unique
        List<Integer> finalList = list;
        list = list.stream().filter(x -> finalList.lastIndexOf(x) != finalList.indexOf(x)).collect(Collectors.toList());
        printList("Duplicates only:",list);

        // Task I - convert list to array
        Integer[] finalArray = list.stream().toArray(Integer[]::new);
        System.out.print("The final array: ");
        for (Integer num : finalArray)
            System.out.print(num + " ");
        System.out.println('\n');
    }

    private static void printList(String message, Collection<Integer> list) {
        System.out.print(message + " ");
        for(Integer number : list)
            System.out.print(number + " ");
        System.out.println();
    }
}
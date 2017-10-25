import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        // Task A - create an array
        int[] array = new int[] {5,2,1,4,2,3};

        // Task B - create List, based on the array created above
        List<Integer> list = new LinkedList<>();
        for (int num: array)
            Collections.addAll(list,num);
        printList("Initial list:",list);

        // C - sort ascending
        Collections.sort(list);
        printList("Sorted ascending:",list);

        // D - sort descending
        Collections.sort(list,(Integer n1, Integer n2) -> n1 > n2? -1 : 1);
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
        list = list.stream().filter(elem -> finalList.lastIndexOf(elem) > finalList.indexOf(elem)).collect(Collectors.toList());
        printList("Duplicates only:",list);

        // Task I - convert list to array
        Integer[] finalArray = list.stream().toArray(Integer[]::new);
        out.print("The final array: ");
        for (Integer num : finalArray)
            out.print(num + " ");
    }

    private static void printList(String task, List<Integer> list) {
        out.print(task + " ");
        for(Integer number : list)
            out.print(number + " ");
        out.println();
    }
}
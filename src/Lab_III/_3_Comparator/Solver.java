package Lab_III._3_Comparator;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solver {
    public static void main() {
        // Task B - create a HashSet
        HashSet<Human> people = Stream.of(
                new Human("Ivanov","Ivan",20),
                new Human("Petrov","Petr",25),
                new Human("Sidorov","Sidor",23),
                new Human("Zoeva","Zoya",36),
                new Human("Azanov","Azan",19),
                new Human("Stepanov","Stepan",27)).collect(Collectors.toCollection(HashSet::new));
        printPeople("People from HashSet", people);

        // Task C - create LinkedHashSet based on HashSet made before
        printPeople("People from LinkedHashSet",new LinkedHashSet<>(people));

        // Task D - create TreeSet based on HashSet made before
        printPeople("People from TreeSet",new TreeSet<>(people));

        // Task E - create a TreeSet with humanComparatorBySurname based on HashSet
        TreeSet<Human> treePeopleBySurname = new TreeSet<>(Human.getComparatorBySurname());
        treePeopleBySurname.addAll(people);
        printPeople("People from TreeSet with surname comparator",treePeopleBySurname);

        // Task F - create a TreeSet with anonymous comparator by age
        TreeSet<Human> treePeopleByAge = new TreeSet<>((human1,human2) -> human1.age - human2.age);
        treePeopleByAge.addAll(people);
        printPeople("People from TreeSet with age comparator",treePeopleByAge);
    }

    public static void printPeople(String message, Collection<Human> people) {
        System.out.println(message + ':');
        people.forEach(human -> System.out.println(human.firstName + ' ' + human.surName + ' ' + human.age));
        System.out.println();
    }
}

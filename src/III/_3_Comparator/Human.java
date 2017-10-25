package III._3_Comparator;

import java.util.Comparator;

public class Human implements Comparable<Human>{
    String firstName, surName;
    int age;

    public Human(String firstName, String surName, int age)
    {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }

    public int compareTo(Human other) {
        int res;
        return this == other ? 0 : (res = (firstName + surName).compareToIgnoreCase(other.firstName + other.surName)) != 0? res: age - other.age;
    }

    public static Comparator<Human> getComparatorBySurname() {
        return new Comparator<Human>() {
            public int compare(Human human1, Human human2) {
                return human1.surName.compareToIgnoreCase(human2.surName);
            }
        };
    }
}

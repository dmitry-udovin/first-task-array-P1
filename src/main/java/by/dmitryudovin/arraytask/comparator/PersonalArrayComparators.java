package by.dmitryudovin.arraytask.comparator;

import by.dmitryudovin.arraytask.entity.PersonalArray;

import java.util.Comparator;

public class PersonalArrayComparators {

    public static <T extends Number> Comparator<PersonalArray<T>> byId() {
        return Comparator.comparingLong(PersonalArray::getId);
    }

//    public static <T extends Number> Comparator<PersonalArray<T>> byFirstElement() {
//        return Comparator.comparingLong()
//    }

}

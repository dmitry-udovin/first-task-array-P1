package by.dmitryudovin.arraytask.specification;

import by.dmitryudovin.arraytask.entity.PersonalArray;

public interface ArraySpecification<T extends PersonalArray<?>> {
    boolean match(T array);
}

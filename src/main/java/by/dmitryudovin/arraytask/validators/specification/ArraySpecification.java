package by.dmitryudovin.arraytask.validators.specification;

import by.dmitryudovin.arraytask.validators.entity.PersonalArray;

public interface ArraySpecification<T extends PersonalArray<?>> {
    boolean match(T array);
}

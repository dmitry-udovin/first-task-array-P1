package by.dmitryudovin.arraytask.specification;

import by.dmitryudovin.arraytask.entity.PersonalArray;

public class NameEqualsSpecification<T extends PersonalArray<?>> implements ArraySpecification<T> {

    private final String name;

    public NameEqualsSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean match(T array) {
        return name != null && name.equals(array.getName());
    }

}

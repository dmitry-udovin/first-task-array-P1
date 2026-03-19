package by.dmitryudovin.arraytask.specification;

import by.dmitryudovin.arraytask.entity.PersonalArray;

public class IdEqualsSpecification<T extends PersonalArray<?>> implements ArraySpecification<T> {

    private final long id;

    public IdEqualsSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean match(T array) {
        return array.getId() == id;
    }

}

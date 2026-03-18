package by.dmitryudovin.arraytask.validators.specification;

import by.dmitryudovin.arraytask.validators.entity.PersonalArray;

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

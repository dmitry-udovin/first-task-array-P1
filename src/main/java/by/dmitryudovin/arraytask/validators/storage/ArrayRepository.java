package by.dmitryudovin.arraytask.validators.storage;

import by.dmitryudovin.arraytask.validators.entity.PersonalArray;
import by.dmitryudovin.arraytask.validators.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.validators.specification.ArraySpecification;

import java.util.List;

public interface ArrayRepository<T extends PersonalArray<?>> {

    void save(T array);

    T findById(long id) throws ArrayOwnException;

    boolean deleteById(long id);

    List<T> findAll();

    List<T> query(ArraySpecification<T> specification);

}

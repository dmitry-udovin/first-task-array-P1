package by.dmitryudovin.arraytask.storage;

import by.dmitryudovin.arraytask.entity.PersonalArray;
import by.dmitryudovin.arraytask.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.specification.ArraySpecification;

import java.util.List;

public interface ArrayRepository<T extends PersonalArray<?>> {

    void save(T array);

    T findById(long id) throws ArrayOwnException;

    boolean deleteById(long id);

    List<T> findAll();

    List<T> query(ArraySpecification<T> specification);

}

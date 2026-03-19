package by.dmitryudovin.arraytask.validators.warehouse;

import by.dmitryudovin.arraytask.validators.entity.PersonalArray;
import by.dmitryudovin.arraytask.validators.exception.ArrayOwnException;

import java.util.Optional;

public interface Warehouse<T extends Number & Comparable<T>> {

    void put(long arrayId, ArrayStatistics statistics);

    Optional<ArrayStatistics> get(long arrayId);

    void remove(long arrayId) throws ArrayOwnException;

    void update(PersonalArray<T> array);
}

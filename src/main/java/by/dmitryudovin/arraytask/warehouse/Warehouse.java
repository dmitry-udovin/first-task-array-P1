package by.dmitryudovin.arraytask.warehouse;

import by.dmitryudovin.arraytask.exception.ArrayOwnException;

import java.util.Optional;

public interface Warehouse<T extends Number & Comparable<T>> {

    void put(long arrayId, ArrayStatistics statistics);

    Optional<ArrayStatistics> get(long arrayId);

    void remove(long arrayId) throws ArrayOwnException;

}
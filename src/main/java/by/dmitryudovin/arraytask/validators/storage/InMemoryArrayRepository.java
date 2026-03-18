package by.dmitryudovin.arraytask.validators.storage;

import by.dmitryudovin.arraytask.validators.entity.PersonalArray;
import by.dmitryudovin.arraytask.validators.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.validators.specification.ArraySpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryArrayRepository<T extends PersonalArray<?>> implements ArrayRepository<T> {

    private final Map<Long, T> storage = new HashMap<>();

    @Override
    public void save(T array) {
        storage.put(array.getId(), array);
    }

    @Override
    public T findById(long id) throws ArrayOwnException {
        T array = storage.get(id);
        if (array == null) {
            throw new ArrayOwnException("Массив с id " + id + " не найден");
        }
        return array;
    }

    @Override
    public boolean deleteById(long id) {
        return storage.remove(id) != null;
    }

    @Override
    public List<T> findAll() {
        return storage.values().stream().toList();
    }

    @Override
    public List<T> query(ArraySpecification<T> specification) {
        if (specification == null) {
            throw new IllegalArgumentException("specification must not be null");
        }

        List<T> result = new ArrayList<>();
        for (T array : storage.values()) {
            if (specification.match(array)) {
                result.add(array);
            }
        }
        return result;
    }


}

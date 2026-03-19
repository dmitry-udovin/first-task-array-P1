package by.dmitryudovin.arraytask.validators.warehouse;

import by.dmitryudovin.arraytask.validators.entity.PersonalArray;
import by.dmitryudovin.arraytask.validators.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.validators.services.ArrayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DoubleWarehouseImpl implements Warehouse<Double> {

    private final static Logger logger = LoggerFactory.getLogger(DoubleWarehouseImpl.class);
    private static DoubleWarehouseImpl instance;

    private final Map<Long, ArrayStatistics> storage = new HashMap<>();
    private final ArrayService<Double> arrayService;

    private DoubleWarehouseImpl(ArrayService<Double> arrayService) {
        this.arrayService = arrayService;
    }

    public static DoubleWarehouseImpl getInstance(ArrayService<Double> service) {
        if (instance == null) {
            instance = new DoubleWarehouseImpl(service);
        }
        return instance;
    }

    @Override
    public void put(long arrayId, ArrayStatistics statistics) {
        storage.put(arrayId, statistics);
    }

    @Override
    public Optional<ArrayStatistics> get(long arrayId) {
        return Optional.ofNullable(storage.get(arrayId));
    }

    @Override
    public void remove(long arrayId) throws ArrayOwnException {
        if (storage.containsKey(arrayId)) {
            ArrayStatistics statistics = storage.remove(arrayId);
        } else {
            throw new ArrayOwnException("Отсутствует элемент хранилища с номером #" + arrayId + " для удаления");
        }
    }

    @Override
    public void update(PersonalArray<Double> array) {
        Double[] data = array.getData();
        if (data == null || data.length == 0) {
            storage.remove(array.getId());
            return;
        }

        try {
            Double sum = arrayService.findSumOfArray(data);
            Double avg = arrayService.findAverageValue(data);
            Double min = arrayService.findMinValue(data);
            Double max = arrayService.findMaxValue(data);
            int count = data.length;

            ArrayStatistics stats = new ArrayStatistics(
                    sum,
                    avg,
                    min,
                    max,
                    count
            );
            storage.put(array.getId(), stats);
        } catch (ArrayOwnException e) {
            logger.error(e.getMessage());
        }

    }
}

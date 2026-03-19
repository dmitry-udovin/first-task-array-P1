package by.dmitryudovin.arraytask.warehouse;

import by.dmitryudovin.arraytask.entity.PersonalArray;
import by.dmitryudovin.arraytask.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.services.ArrayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class IntegerWarehouseImpl implements Warehouse<Integer> {

    private final static Logger logger = LoggerFactory.getLogger(IntegerWarehouseImpl.class);
    private static IntegerWarehouseImpl instance;

    private final Map<Long, ArrayStatistics> storage = new HashMap<>();
    private final ArrayService<Integer> arrayService;


    private IntegerWarehouseImpl(ArrayService<Integer> arrayService) {
        this.arrayService = arrayService;
    }

    public static IntegerWarehouseImpl getInstance(ArrayService<Integer> arrayService) {
        if (instance == null) {
            instance = new IntegerWarehouseImpl(arrayService);
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
    public void update(PersonalArray<Integer> array) {
        Integer[] data = array.getData();
        if (data == null || data.length == 0) {
            storage.remove(array.getId());
            return;
        }

        try {
            Integer sum = arrayService.findSumOfArray(data);
            double averageValue = arrayService.findAverageValue(data);
            Integer min = arrayService.findMinValue(data);
            Integer max = arrayService.findMaxValue(data);
            int count = data.length;

            ArrayStatistics stats = new ArrayStatistics(
                    sum,
                    averageValue,
                    min.doubleValue(),
                    max.doubleValue(),
                    count
            );
            storage.put(array.getId(), stats);
        } catch (ArrayOwnException e) {
            logger.error(e.getMessage());
        }
    }
}

package by.dmitryudovin.arraytask.warehouse;

import by.dmitryudovin.arraytask.entity.PersonalArray;
import by.dmitryudovin.arraytask.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.observer.Observer;
import by.dmitryudovin.arraytask.services.ArrayService;
import by.dmitryudovin.arraytask.services.IntegerArrayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class IntegerWarehouseImpl implements Warehouse<Integer>, Observer {

    private final static Logger logger = LoggerFactory.getLogger(IntegerWarehouseImpl.class);
    private static IntegerWarehouseImpl instance;

    private final Map<Long, ArrayStatistics> storage = new HashMap<>();
    private final ArrayService<Integer> arrayService = new IntegerArrayService();


    private IntegerWarehouseImpl() {}

    public static IntegerWarehouseImpl getInstance() {
        if (instance == null) {
            instance = new IntegerWarehouseImpl();
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
            storage.remove(arrayId);
        } else {
            throw new ArrayOwnException("Отсутствует элемент хранилища с номером #" + arrayId + " для удаления");
        }
    }

    @Override
    public void update(PersonalArray<?> array) {
        PersonalArray<Integer> intArray = (PersonalArray<Integer>) array;
        recalcStatistics(intArray);
    }

    private void recalcStatistics(PersonalArray<Integer> array) {
        Integer[] data = array.getData();
        if (data == null || data.length == 0) {
            storage.remove(array.getId());
            return;
        }

        try {
            Integer sum = arrayService.findSumOfArray(data);
            Integer min = arrayService.findMinValue(data);
            Integer max = arrayService.findMaxValue(data);
            int count = data.length;
            double sumD = sum.doubleValue();
            double avg = sumD / count;

            ArrayStatistics stats = new ArrayStatistics(
                    sumD,
                    avg,
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

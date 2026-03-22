package by.dmitryudovin.arraytask.warehouse;

import by.dmitryudovin.arraytask.entity.PersonalArray;
import by.dmitryudovin.arraytask.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.observer.Observer;
import by.dmitryudovin.arraytask.services.ArrayService;
import by.dmitryudovin.arraytask.services.DoubleArrayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DoubleWarehouseImpl implements Warehouse<Double>, Observer {

    private final static Logger logger = LoggerFactory.getLogger(DoubleWarehouseImpl.class);
    private static DoubleWarehouseImpl instance;

    private final Map<Long, ArrayStatistics> storage = new HashMap<>();
    private final ArrayService<Double> arrayService = new DoubleArrayService();


    private DoubleWarehouseImpl() {}

    public static DoubleWarehouseImpl getInstance() {
        if (instance == null) {
            instance = new DoubleWarehouseImpl();
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
        PersonalArray<Double> doubleArray = (PersonalArray<Double>) array;
        recalcStatistics(doubleArray);
    }

    private void recalcStatistics(PersonalArray<Double> array) {
        Double[] data = array.getData();
        if (data == null || data.length == 0) {
            storage.remove(array.getId());
            return;
        }

        try {
            Double sum = arrayService.findSumOfArray(data);
            Double min = arrayService.findMinValue(data);
            Double max = arrayService.findMaxValue(data);
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

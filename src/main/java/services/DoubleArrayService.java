package services;

import exception.ArrayOwnException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoubleArrayService implements ArrayService<Double> {
    private static final Logger logger = LoggerFactory.getLogger(DoubleArrayService.class);

    @Override
    public Double findSumOfArray(Double[] array) throws ArrayOwnException {
        logger.debug("выполняется findSumOfArray массива размера {}", array == null ? "null" : array.length);

        if (array == null || array.length == 0) {
            logger.warn("массив null или пустой");
            throw new ArrayOwnException("Массив не проинициализирован или пустой");
        }

        double sum = 0.0;
        int nullCount = 0;

        for (Double value : array) {
            if (value != null) {
                sum += value;
            } else {
                nullCount++;
                logger.debug("Пропущен null элемент");
            }
        }

        if (Double.isInfinite(sum)) {
            logger.error("Сумма вышла за пределы double");
            throw new ArrayOwnException("Выход суммы за пределы double");
        }

        logger.debug("Сумма: {}, null элементов: {}", sum, nullCount);
        return sum;
    }

    @Override
    public Double findMinValue(Double[] array) throws ArrayOwnException {
        logger.debug("поиск минимума в массиве размером {}", array == null ? "null" : array.length);

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("Массив не проинициализирован или null");
        }

        Double minValue = null;
        boolean hasValidValue = false;

        for (Double value : array) {
            if (value != null) {
                if (!hasValidValue || value < minValue) {
                    minValue = value;
                }
                hasValidValue = true;
            }
        }

        if (!hasValidValue) {
            logger.error("Все элементы null");
            throw new ArrayOwnException("отсутствуют ненулевые значения");
        }

        logger.debug("Найден минимум: {}", minValue);
        return minValue;
    }

    @Override
    public Double findMaxValue(Double[] array) throws ArrayOwnException {
        logger.debug("поиск максимума в массиве размером {}", array == null ? "null" : array.length);

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("массив не проинициализирован или null");
        }

        Double maxValue = null;
        boolean hasValidValue = false;

        for (Double value : array) {
            if (value != null) {
                if (!hasValidValue || value > maxValue) {
                    maxValue = value;
                }
                hasValidValue = true;
            }
        }

        if (!hasValidValue) {
            logger.error("Все элементы null");
            throw new ArrayOwnException("отсутствуют ненулевые значения");
        }

        logger.debug("Найден максимум: {}", maxValue);
        return maxValue;
    }

    @Override
    public void bubbleSort(Double[] array) throws ArrayOwnException {

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("массив не проинициализирован или null");
        }

        logger.debug("Начинаем сортировку bubbleSort");

        for (int i = 0; i < array.length - 1; i++) {
            for (int k = 1; k < (array.length - i); k++) {
                double temp;
                if (array[k - 1] > array[k]) {
                    temp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = temp;
                }
            }
        }

    }

    @Override
    public void selectionSort(Double[] array) throws ArrayOwnException {

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("массив не проинициализирован или null");
        }

        logger.debug("Начинаем сортировку selectionSort");

        double minValue;
        for (int i = 0; i < array.length - 1; i++) {
            minValue = array[i];
            int index = -1;
            for (int k = (i + 1); k < array.length; k++) {
                if (array[k] < minValue) {
                    minValue = array[k];
                    index = k;
                }
            }
            if (index > 0) {
                double temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

    }
}

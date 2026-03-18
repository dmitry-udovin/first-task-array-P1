package by.dmitryudovin.arraytask.validators.services;

import by.dmitryudovin.arraytask.validators.exception.ArrayOwnException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IntegerArrayService implements ArrayService<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(IntegerArrayService.class);

    @Override
    public Integer findSumOfArray(Integer[] array) throws ArrayOwnException {
        logger.debug("выполняется findSumOfArray массива размера {}", array == null ? "null" : array.length);

        if (array == null || array.length == 0) {
            logger.warn("массив null или пустой");
            return 0;
        }

        long sum = 0;
        int nullCount = 0;

        for (Integer value : array) {
            if (value != null) {
                sum += value;
            } else {
                nullCount++;
                logger.debug("Пропущен null элемент");
            }
        }

        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            logger.error("Результат не помещается в Integer: {}", sum);
            throw new ArrayOwnException("Сумма превышает пределы Integer");
        }

        logger.debug("Сумма: {}, null элементов: {}", sum, nullCount);
        return Math.toIntExact(sum);
    }

    @Override
    public Integer findAverageValue(Integer[] array) throws ArrayOwnException {
        logger.debug("поиск среднего значения в массиве размером {}", array == null ? "null" : array.length);

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("Массив не проинициализирован или null");
        }

        long sum = findSumOfArray(array);

        return Math.toIntExact(sum / array.length);
    }

    @Override
    public Integer findMinValue(Integer[] array) throws ArrayOwnException {
        logger.debug("поиск минимума в массиве размером {}", array == null ? "null" : array.length);

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("Массив не проинициализирован или null");
        }

        Integer minValue = null;
        boolean hasValidValue = false;

        for (Integer value : array) {
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
    public Integer findMaxValue(Integer[] array) throws ArrayOwnException {
        logger.debug("поиск максимума в массиве размером {}", array == null ? "null" : array.length);

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("массив не проинициализирован или null");
        }

        Integer maxValue = null;
        boolean hasValidValue = false;

        for (Integer value : array) {
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
    public void bubbleSort(Integer[] array) throws ArrayOwnException {

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("массив не проинициализирован или null");
        }

        logger.debug("Начинаем сортировку bubbleSort");

        for (int i = 0; i < array.length - 1; i++) {
            for (int k = 1; k < (array.length - i); k++) {
                int temp;
                if (array[k] < array[k - 1]) {
                    temp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = temp;
                }
            }
        }

    }

    @Override
    public void selectionSort(Integer[] array) throws ArrayOwnException {

        if (array == null || array.length == 0) {
            throw new ArrayOwnException("массив не проинициализирован или null");
        }

        logger.debug("Начинаем сортировку selectionSort");

        int minValue;
        for (int i = 0; i < array.length - 1; i++) {
            minValue = array[i];
            int index = -1;
            for (int k = (i + 1); k < array.length; k++) {
                if (array[k] < minValue) {
                    index = k;
                    minValue = array[k];
                }
            }
            if (index > 0) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

    }


}

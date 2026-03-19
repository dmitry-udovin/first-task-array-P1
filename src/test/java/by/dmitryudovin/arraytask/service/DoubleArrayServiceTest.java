package by.dmitryudovin.arraytask.service;

import by.dmitryudovin.arraytask.exception.ArrayOwnException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import by.dmitryudovin.arraytask.services.ArrayService;
import by.dmitryudovin.arraytask.services.DoubleArrayService;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleArrayServiceTest {

    static ArrayService<Double> service;

    @BeforeAll
    static void createService() {
        service = new DoubleArrayService();
    }

    @Test
    void shouldCorrectCheckSum() throws ArrayOwnException {

        Double[] array = new Double[]{1.5, 2.5, 10.0};

        double sum = service.findSumOfArray(array);

        assertEquals(14, sum);

    }

    @Test
    void shouldCorrectFindMinValue() throws ArrayOwnException {

        Double[] array = new Double[]{5.5, -1.5, 10.0};

        double minValue = service.findMinValue(array);

        assertEquals(-1.5, minValue);

    }

    @Test
    void shouldCorrectFindMaxValue() throws ArrayOwnException {

        Double[] array = new Double[]{99.9, -100.1, 58.5};

        double maxValue = service.findMaxValue(array);

        assertEquals(99.9, maxValue);

    }

    @Test
    void shouldCorrectSortArray() throws ArrayOwnException {

        Double[] array1 = new Double[]{87.6, 9.0, 58.5, 46.2};
        Double[] array2 = new Double[]{87.6, 9.0, 58.5, 46.2};

        service.bubbleSort(array1);
        service.selectionSort(array2);

        assertArrayEquals(new Double[]{9.0, 46.2, 58.5, 87.6}, array1);
        assertArrayEquals(new Double[]{9.0, 46.2, 58.5, 87.6}, array2);

    }

    @Test
    void shouldCorrectProcessArrayWithOneElement() throws ArrayOwnException {

        Double[] array = new Double[]{15.5};

        Double[] sameArray1 = new Double[]{15.5};
        Double[] sameArray2 = new Double[]{15.5};

        double minValue = service.findMinValue(array);
        double maxValue = service.findMaxValue(array);
        double sum = service.findSumOfArray(array);

        service.bubbleSort(sameArray1);
        service.selectionSort(sameArray2);

        assertEquals(15.5, minValue);
        assertEquals(15.5, maxValue);
        assertEquals(15.5, sum);

        assertArrayEquals(new Double[]{15.5}, sameArray1);
        assertArrayEquals(new Double[]{15.5}, sameArray2);

    }

}

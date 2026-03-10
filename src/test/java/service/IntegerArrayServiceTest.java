package service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.ArrayService;
import services.IntegerArrayService;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerArrayServiceTest {

    static ArrayService<Integer> service;

    @BeforeAll
    static void createService() {
        service = new IntegerArrayService();
    }

    @Test
    void shouldCorrectCheckSum() {

        Integer[] array = new Integer[]{1, 2, 3};

        int sum = service.findSumOfArray(array);

        assertEquals(6, sum);

    }

    @Test
    void shouldCorrectFindMinValue() {

        Integer[] array = new Integer[]{5, -3, 1000};

        int minValue = service.findMinValue(array);

        assertEquals(-3, minValue);

    }

    @Test
    void shouldCorrectFindMaxValue() {

        Integer[] array = new Integer[]{99, -100, 58};

        int maxValue = service.findMaxValue(array);

        assertEquals(99, maxValue);

    }

    @Test
    void shouldCorrectSortArray() {

        Integer[] array1 = new Integer[]{87, 9, 58, 46};
        Integer[] array2 = new Integer[]{87, 9, 58, 46};

        service.bubbleSort(array1);
        service.selectionSort(array2);

        assertArrayEquals(new Integer[]{9, 46, 58, 87}, array1);
        assertArrayEquals(new Integer[]{9, 46, 58, 87}, array2);

    }

    @Test
    void shouldCorrectProcessArrayWithOneElement() {

        Integer[] array = new Integer[]{15};

        Integer[] sameArray1 = new Integer[]{15};
        Integer[] sameArray2 = new Integer[]{15};

        int minValue = service.findMinValue(array);
        int maxValue = service.findMaxValue(array);
        int sum = service.findSumOfArray(array);

        service.bubbleSort(sameArray1);
        service.selectionSort(sameArray2);

        assertEquals(15, minValue);
        assertEquals(15, maxValue);
        assertEquals(15, sum);

        assertArrayEquals(new Integer[]{15}, sameArray1);
        assertArrayEquals(new Integer[]{15}, sameArray2);

    }

}

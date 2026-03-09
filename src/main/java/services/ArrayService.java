package services;

public interface ArrayService<T extends Number & Comparable<T>> {

    T findSumOfArray(T[] array);

    T findMinValue(T[] array);

    T findMaxValue(T[] array);

    void bubbleSort(T[] array);

    void selectionSort(T[] array);

}

package services;

import exception.ArrayOwnException;

public interface ArrayService<T extends Number & Comparable<T>> {

    T findSumOfArray(T[] array) throws ArrayOwnException;

    T findMinValue(T[] array) throws ArrayOwnException;

    T findMaxValue(T[] array) throws ArrayOwnException;

    void bubbleSort(T[] array) throws ArrayOwnException;

    void selectionSort(T[] array) throws ArrayOwnException;

}

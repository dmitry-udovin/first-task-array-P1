package by.dmitryudovin.arraytask.specification;

import by.dmitryudovin.arraytask.entity.PersonalArray;
import by.dmitryudovin.arraytask.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.services.ArrayService;

public class SumCompareSpecification<T extends Number & Comparable<T>> implements ArraySpecification<PersonalArray<T>> {

    private final double limitValue;
    private final CompareType compareType;
    private final ArrayService<T> service;

    public SumCompareSpecification(double limitValue,
                                   CompareType compareType,
                                   ArrayService<T> service) {
        this.limitValue = limitValue;
        this.compareType = compareType;
        this.service = service;
    }

    @Override
    public boolean match(PersonalArray<T> array) {
        T[] data = array.getData();

        if (data == null || data.length == 0) {
            return false;
        }

        double sum;

        try {
            sum = service.findSumOfArray(data).doubleValue();
        } catch (ArrayOwnException e) {
            return false;
        }

        return switch (compareType) {
            case GREATER -> sum > limitValue;
            case LESS -> sum < limitValue;
            case EQUAL -> Double.compare(sum, limitValue) == 0;
        };

    }

}

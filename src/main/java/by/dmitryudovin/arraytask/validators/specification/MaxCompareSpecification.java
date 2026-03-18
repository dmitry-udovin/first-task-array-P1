package by.dmitryudovin.arraytask.validators.specification;

import by.dmitryudovin.arraytask.validators.entity.PersonalArray;
import by.dmitryudovin.arraytask.validators.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.validators.services.ArrayService;

public class MaxCompareSpecification<T extends Number & Comparable<T>> implements ArraySpecification<PersonalArray<T>> {

    private final double limitValue;
    private final CompareType compareType;
    private final ArrayService<T> service;

    public MaxCompareSpecification(double limitValue,
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

        double maxElement;

        try {
            maxElement = service.findMaxValue(data).doubleValue();
        } catch (ArrayOwnException e) {
            return false;
        }

        return switch (compareType) {
            case GREATER -> maxElement > limitValue;
            case LESS -> maxElement < limitValue;
            case EQUAL -> Double.compare(maxElement, limitValue) == 0;
        };

    }

}

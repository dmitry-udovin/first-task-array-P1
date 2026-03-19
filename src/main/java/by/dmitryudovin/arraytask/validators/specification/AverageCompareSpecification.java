package by.dmitryudovin.arraytask.validators.specification;

import by.dmitryudovin.arraytask.validators.entity.PersonalArray;
import by.dmitryudovin.arraytask.validators.exception.ArrayOwnException;
import by.dmitryudovin.arraytask.validators.services.ArrayService;

public class AverageCompareSpecification<T extends Number & Comparable<T>> implements ArraySpecification<PersonalArray<T>> {

    private final double limitValue;
    private final CompareType compareType;
    private final ArrayService<T> service;

    public AverageCompareSpecification(double limitValue,
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

        double avg;

        try {
            T avgValue = service.findAverageValue(data);
            avg = avgValue.doubleValue();
        } catch (ArrayOwnException e) {
            return false;
        }

        return switch (compareType) {
            case GREATER -> avg > limitValue;
            case LESS -> avg < limitValue;
            case EQUAL -> Double.compare(avg, limitValue) == 0;
        };

    }

}

package factory;

import entity.DoubleArrayImpl;
import entity.PersonalArray;

public class DoubleArrayFactory extends ArrayAbstractFactory {

    @Override
    protected PersonalArray createArray(int length) {
        return new DoubleArrayImpl(length);
    }

}

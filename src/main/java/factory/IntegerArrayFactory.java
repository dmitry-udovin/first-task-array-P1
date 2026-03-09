package factory;

import entity.IntegerArrayImpl;
import entity.PersonalArray;

public class IntegerArrayFactory extends ArrayAbstractFactory {

    @Override
    protected PersonalArray createArray(int length) {
        return new IntegerArrayImpl(length);
    }

}

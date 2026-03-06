package factory;

import entity.DoubleArrayImpl;
import entity.PersonalArray;

public class DoubleArrayFactory extends ArrayAbstractFactory {

    @Override
    protected PersonalArray createArray() {
        return new DoubleArrayImpl();
    }

}

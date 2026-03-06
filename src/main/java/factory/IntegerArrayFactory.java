package factory;

import entity.IntegerArrayImpl;
import entity.PersonalArray;

public class IntegerArrayFactory extends ArrayAbstractFactory {

    @Override
    protected PersonalArray createArray() {
        return new IntegerArrayImpl();
    }

}

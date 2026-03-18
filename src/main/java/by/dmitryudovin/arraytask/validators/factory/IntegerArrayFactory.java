package by.dmitryudovin.arraytask.validators.factory;

import by.dmitryudovin.arraytask.validators.entity.IntegerArrayImpl;
import by.dmitryudovin.arraytask.validators.entity.PersonalArray;

public class IntegerArrayFactory extends ArrayAbstractFactory {

    @Override
    protected PersonalArray createArray(int length) {
        return new IntegerArrayImpl(length);
    }

}

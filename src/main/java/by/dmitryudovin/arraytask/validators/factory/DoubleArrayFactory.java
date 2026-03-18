package by.dmitryudovin.arraytask.validators.factory;

import by.dmitryudovin.arraytask.validators.entity.DoubleArrayImpl;
import by.dmitryudovin.arraytask.validators.entity.PersonalArray;

public class DoubleArrayFactory extends ArrayAbstractFactory {

    @Override
    protected PersonalArray createArray(int length) {
        return new DoubleArrayImpl(length);
    }

}

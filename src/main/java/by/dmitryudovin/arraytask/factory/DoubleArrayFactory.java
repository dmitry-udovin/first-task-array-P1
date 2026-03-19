package by.dmitryudovin.arraytask.factory;

import by.dmitryudovin.arraytask.entity.DoubleArrayImpl;
import by.dmitryudovin.arraytask.entity.PersonalArray;

public class DoubleArrayFactory extends ArrayAbstractFactory {

    @Override
    protected PersonalArray createArray(int length) {
        return new DoubleArrayImpl(length);
    }

}

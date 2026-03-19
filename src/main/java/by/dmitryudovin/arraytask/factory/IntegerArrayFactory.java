package by.dmitryudovin.arraytask.factory;

import by.dmitryudovin.arraytask.entity.IntegerArrayImpl;
import by.dmitryudovin.arraytask.entity.PersonalArray;

public class IntegerArrayFactory extends ArrayAbstractFactory {

    @Override
    protected PersonalArray createArray(int length) {
        return new IntegerArrayImpl(length);
    }

}

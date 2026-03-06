package factory;

import entity.PersonalArray;

abstract class ArrayAbstractFactory {
    protected abstract PersonalArray createArray();
    public PersonalArray orderArray(int rows, int cols) {
        PersonalArray array = createArray();
        array.init(rows, cols);
        return array;
    }

}

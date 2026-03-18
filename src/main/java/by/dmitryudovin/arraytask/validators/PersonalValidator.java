package by.dmitryudovin.arraytask.validators;

public interface PersonalValidator {

    // корректность строки для создания массива
    boolean isValid();

    // тип данных
    String getType();

    // размер будущего массива
    int getLength();

}

package by.dmitryudovin.arraytask.validators.entity;

public interface PersonalArray<T extends Number> {

    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    void print();

    void setData(T[] data);

    T[] getData();
}

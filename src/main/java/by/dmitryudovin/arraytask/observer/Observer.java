package by.dmitryudovin.arraytask.observer;

import by.dmitryudovin.arraytask.entity.PersonalArray;

public interface Observer {
    void update(PersonalArray<?> array);
}

package by.dmitryudovin.arraytask.entity;

import by.dmitryudovin.arraytask.observer.Observable;
import by.dmitryudovin.arraytask.observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IntegerArrayImpl implements PersonalArray<Integer>, Observable {

    private static long idCounter = 0;

    private long id = 0;
    private String name;

    private Integer[] data;
    private static final Logger logger = LoggerFactory.getLogger(IntegerArrayImpl.class);

    private final List<Observer> observers = new ArrayList<>();


    public IntegerArrayImpl(int length) {
        this.data = new Integer[length];
    }

    public IntegerArrayImpl(long id, String name, Integer[] data) {
        this.id = ++idCounter;
        this.name = name;
        this.data = data;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        logger.info("IntegerArray: [id#{}] {}", id, Arrays.toString(data));
    }

    @Override
    public void setData(Integer[] data) {
        if (data == null || data.length != this.data.length) {
            throw new IllegalArgumentException("некорректный размер массива");
        }
        this.data = data;
        notifyObservers();
    }

    @Override
    public Integer[] getData() {
        return data;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
package by.dmitryudovin.arraytask.validators.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class DoubleArrayImpl implements PersonalArray<Double> {

    private static long idCounter = 0;

    private long id = 0;
    private String name;

    private Double[] data;
    private static final Logger logger = LoggerFactory.getLogger(DoubleArrayImpl.class);

    public DoubleArrayImpl(int length) {
        this.id = ++idCounter;
        this.data = new Double[length];
    }

    @Override
    public long getId() {
        return ++id;
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
        logger.info("DoubleArray: [id#{}] {}", id, Arrays.toString(data));
    }

    @Override
    public void setData(Double[] data) {
        if (data == null || data.length != this.data.length) {
            throw new IllegalArgumentException("некорректный размер массива");
        }
        this.data = data;
    }

    @Override
    public Double[] getData() {
        return data;
    }

}
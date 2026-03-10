package entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class DoubleArrayImpl implements PersonalArray<Double> {

    private Double[] data;
    private static final Logger logger = LoggerFactory.getLogger(DoubleArrayImpl.class);

    public DoubleArrayImpl(int length) {
        this.data = new Double[length];
    }

    @Override
    public void print() {
        logger.info("DoubleArray: {}", Arrays.toString(data));
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
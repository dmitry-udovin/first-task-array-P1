package entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class IntegerArrayImpl implements PersonalArray<Integer> {

    private Integer[] data;
    private static final Logger logger = LoggerFactory.getLogger(IntegerArrayImpl.class);

    public IntegerArrayImpl(int length) {
        this.data = new Integer[length];
    }

    @Override
    public void print() {
        logger.info("IntegerArray: {}", Arrays.toString(data));
    }

    @Override
    public void setData(Integer[] data) {
        if (data == null || data.length != this.data.length) {
            throw new IllegalArgumentException("некорректный размер массива");
        }
        this.data = data;
    }

    @Override
    public Integer[] getData() {
        return data;
    }

}
package entity;

public class DoubleArrayImpl implements PersonalArray {

    private double [][] data;

    @Override
    public void init(int rows, int cols) {
        this.data = new double[rows][cols];
    }

    @Override
    public void print() {

    }
}

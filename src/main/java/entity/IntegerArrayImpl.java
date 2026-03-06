package entity;

public class IntegerArrayImpl implements PersonalArray {

    private int [][] data;

    @Override
    public void init(int rows, int cols) {
        this.data = new int[rows][cols];
    }

    @Override
    public void print() {

    }

    // геттеры

}

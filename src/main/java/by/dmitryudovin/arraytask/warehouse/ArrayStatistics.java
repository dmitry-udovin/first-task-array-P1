package by.dmitryudovin.arraytask.warehouse;

public class ArrayStatistics {
    private double sum;
    private double average;
    private double min;
    private double max;
    private int count;

    public ArrayStatistics(
            double sum,
            double average,
            double min,
            double max,
            int count
    ) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
        this.count = count;
    }

}

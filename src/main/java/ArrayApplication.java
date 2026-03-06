import entity.PersonalArray;
import factory.DoubleArrayFactory;

public class ArrayApplication {
    public static void main(String[] args) {
        DoubleArrayFactory doubleArrayFactory = new DoubleArrayFactory();
        PersonalArray array = doubleArrayFactory.orderArray(10,20);

    }
}

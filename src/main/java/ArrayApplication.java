import by.dmitryudovin.arraytask.entity.IntegerArrayImpl;
import by.dmitryudovin.arraytask.observer.Observer;
import by.dmitryudovin.arraytask.warehouse.IntegerWarehouseImpl;
import by.dmitryudovin.arraytask.warehouse.Warehouse;

public class ArrayApplication {

    public static void main(String[] args) {

        Warehouse<Integer> integerWarehouse = IntegerWarehouseImpl.getInstance();

        IntegerArrayImpl array = new IntegerArrayImpl(1L, "Test", new Integer[]{15, 7, 10, null, 4});

        array.attach((Observer) integerWarehouse);

        System.out.println("stats before update: " + integerWarehouse.get(array.getId()));

        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println();

        Integer[] newData = {10, 20, 30, -5, null};
        array.setData(newData);

        System.out.println("Updated stats: " + integerWarehouse.get(array.getId()));


    }
}
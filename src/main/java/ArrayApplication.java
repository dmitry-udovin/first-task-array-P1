import by.dmitryudovin.arraytask.validators.entity.IntegerArrayImpl;
import by.dmitryudovin.arraytask.validators.entity.PersonalArray;
import by.dmitryudovin.arraytask.validators.services.ArrayService;
import by.dmitryudovin.arraytask.validators.services.IntegerArrayService;
import by.dmitryudovin.arraytask.validators.warehouse.IntegerWarehouseImpl;

public class ArrayApplication {

    public static void main(String[] args) {

        ArrayService<Integer> integerArrayService = new IntegerArrayService();
        IntegerWarehouseImpl integerWarehouse = IntegerWarehouseImpl.getInstance(integerArrayService);

        PersonalArray<Integer> array = new IntegerArrayImpl(1L, "Test", new Integer[]{15, 7, 10, null, 4});

        integerWarehouse.update(array);

        System.out.println(integerWarehouse.get(1L).isPresent());

//        FileArrayLoader fileArrayLoader = new FileArrayLoader();
//        List<PersonalArray> arraysFromFile = fileArrayLoader.loadArraysFromFile();
//
//        for (PersonalArray persArr : arraysFromFile) {
//            persArr.print();
//        }
//
//    }

//        static void testValidator (String line){
//            PersonalValidator validator = new ArrayDataValidator(line);
//            if (validator.isValid()) {
//                int length = validator.getLength();
//                String[] tokens = ((ArrayDataValidator) validator).getTokens();
//                logger.debug("строка: [{}] , type: {} , size: {}", line, validator.getType(), length);
//            } else {
//                logger.debug("невалидные данные: [{}]", line);
//            }
//        }

    }
}
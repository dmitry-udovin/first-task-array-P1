import by.dmitryudovin.arraytask.validators.entity.PersonalArray;
import by.dmitryudovin.arraytask.validators.loader.FileArrayLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import by.dmitryudovin.arraytask.validators.ArrayDataValidator;
import by.dmitryudovin.arraytask.validators.PersonalValidator;

import java.util.List;

public class ArrayApplication {

    private static final Logger logger = LoggerFactory.getLogger(ArrayApplication.class);

    public static void main(String[] args) {
//        DoubleArrayFactory doubleArrayFactory = new DoubleArrayFactory();
//        PersonalArray array = doubleArrayFactory.orderArray(10);
//
//        testValidator("1.4 2.3 3.7");
//        testValidator("1; 2; 3; 6.5; 77");
//
//        array.print();

        FileArrayLoader fileArrayLoader = new FileArrayLoader();
        List<PersonalArray> arraysFromFile = fileArrayLoader.loadArraysFromFile();

        for (PersonalArray persArr : arraysFromFile) {
            persArr.print();
        }

    }

    static void testValidator(String line) {
        PersonalValidator validator = new ArrayDataValidator(line);
        if (validator.isValid()) {
            int length = validator.getLength();
            String[] tokens = ((ArrayDataValidator) validator).getTokens();
            logger.debug("строка: [{}] , type: {} , size: {}", line, validator.getType(), length);
        } else {
            logger.debug("невалидные данные: [{}]", line);
        }

    }
}
package loader;

import entity.PersonalArray;
import factory.DoubleArrayFactory;
import factory.IntegerArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import validators.ArrayDataValidator;
import validators.PersonalValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileArrayLoader {

    private static final Logger logger = LoggerFactory.getLogger(FileArrayLoader.class);
    private String DATA_FILE = "data/array-data.txt";

    public void setDataFile(String dataFile) {
        DATA_FILE = dataFile;
    }

    public List<PersonalArray> loadArraysFromFile() {
        List<PersonalArray> result = new ArrayList<>();
        Path path = Paths.get(DATA_FILE);

        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            logger.error("Ошибка чтения файла по пути {}: {}", path, e.getMessage());
            return result;
        }

        int lineNumber = 0;
        for (String line : lines) {
            lineNumber++;

            if (line == null || line.trim().isEmpty()) {
                continue;
            }

            PersonalValidator validator = new ArrayDataValidator(line);

            if (!validator.isValid()) {
                logger.debug("Некорректная строка: #{}, содержимое: [{}]", lineNumber, line);
                continue;
            }

            PersonalArray arrayFromLineByValidator = createArrayFromValidator(validator);

            if (arrayFromLineByValidator != null) {
                result.add(arrayFromLineByValidator);
            }

        }

        return result;

    }

    private PersonalArray createArrayFromValidator(PersonalValidator validator) {

        if (!(validator instanceof ArrayDataValidator)) {
            return null;
        }

        String type = validator.getType();
        String[] tokens = ((ArrayDataValidator) validator).getTokens();
        int length = validator.getLength();

        switch (type) {

            case "INTEGER" -> {
                Integer[] array = new Integer[length];

                for (int i = 0; i < length; i++) {
                    array[i] = Integer.parseInt(tokens[i]);
                }

                IntegerArrayFactory integerArrayFactory = new IntegerArrayFactory();
                PersonalArray integerPersonalArray = integerArrayFactory.orderArray(length);

                integerPersonalArray.setData(array);

                return integerPersonalArray;
            }

            case "DOUBLE" -> {
                Double[] array = new Double[length];

                for (int i = 0; i < length; i++) {
                    array[i] = Double.parseDouble(tokens[i]);
                }

                DoubleArrayFactory doubleArrayFactory = new DoubleArrayFactory();
                PersonalArray doublePersonalArray = doubleArrayFactory.orderArray(length);

                doublePersonalArray.setData(array);

                return doublePersonalArray;
            }

            default -> {
                return null;
            }

        }


    }

}

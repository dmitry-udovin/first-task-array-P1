package by.dmitryudovin.arraytask.loader;

import by.dmitryudovin.arraytask.entity.PersonalArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class FileArrayLoaderTest {

    static FileArrayLoader loader;

    @BeforeEach
    void createLoader() {
        loader = new FileArrayLoader();
    }

    @Test
    void shouldLoadCorrectDataFromFile() {

        List<PersonalArray> dataFromFile = loader.loadArraysFromFile();

        assertEquals(3, dataFromFile.size());

        // 1-ый элемент списка
        assertEquals(3, dataFromFile.get(0).getData().length);

        // 2-ой элемент
        assertEquals(2, dataFromFile.get(1).getData().length);

        // 3-ий
        assertEquals(3, dataFromFile.get(2).getData().length);


    }

    @Test
    void shouldReturnEmptyListWhenFileIsEmpty() {

        loader.setDataFile("data/array-empty-test.txt");

        List<PersonalArray> dataFromFile = loader.loadArraysFromFile();

        assertEquals(0, dataFromFile.size());


    }

    @Test
    void shouldReturnEmptyListWhenFileHasWrongPath() {

        loader.setDataFile("data/nothing.txt");

        List<PersonalArray> dataFromFile = loader.loadArraysFromFile();

        assertEquals(0, dataFromFile.size());

    }

    @Test
    void shouldNotThrowExceptionWhenFileHasWrongPath() {

        loader.setDataFile("data/nothing.txt");

        assertDoesNotThrow(() -> loader.loadArraysFromFile());

    }

}

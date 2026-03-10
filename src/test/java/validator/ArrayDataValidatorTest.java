package validator;

import org.junit.jupiter.api.Test;
import validators.ArrayDataValidator;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayDataValidatorTest {

    @Test
    void shouldCorrectValidateIntegerString() {

        ArrayDataValidator validator = new ArrayDataValidator("1, 2, 3");

        boolean isValid = validator.isValid();
        String type = validator.getType();
        int length = validator.getLength();
        String[] tokens = validator.getTokens();

        assertTrue(isValid);
        assertEquals("INTEGER", type);
        assertEquals(3, length);

        assertEquals(3, tokens.length);
        assertArrayEquals(new String[]{"1", "2", "3"}, tokens);
    }

    @Test
    void shouldCorrectValidateDoubleString() {

        ArrayDataValidator validator = new ArrayDataValidator("1.5, 2.3, 3.7");

        boolean isValid = validator.isValid();
        String type = validator.getType();
        int length = validator.getLength();
        String[] tokens = validator.getTokens();

        assertTrue(isValid);
        assertEquals("DOUBLE", type);
        assertEquals(3, length);

        assertEquals(3, tokens.length);
        assertArrayEquals(new String[]{"1.5", "2.3", "3.7"}, tokens);
    }

    @Test
    void shouldCorrectValidateWrongData() {

        ArrayDataValidator validator = new ArrayDataValidator("1; 2; x3; 6..5; 77");

        boolean isValid = validator.isValid();
        String type = validator.getType();
        int length = validator.getLength();
        String[] tokens = validator.getTokens();

        assertFalse(isValid);
        assertEquals("INTEGER", type);
        assertEquals(5, length);
        assertArrayEquals(new String[]{"1", "2", null, null, null}, tokens);


    }

    @Test
    void shouldCorrectValidateEmptyOrWhiteSpaceString() {

        ArrayDataValidator validator1 = new ArrayDataValidator("");
        ArrayDataValidator validator2 = new ArrayDataValidator("   ");

        boolean isValid1 = validator1.isValid();
        String type1 = validator1.getType();
        int length1 = validator1.getLength();
        String[] tokens1 = validator1.getTokens();

        boolean isValid2 = validator2.isValid();
        String type2 = validator2.getType();
        int length2 = validator2.getLength();
        String[] tokens2 = validator2.getTokens();

        assertFalse(isValid1);
        assertNull(type1);
        assertEquals(0, length1);
        assertNull(tokens1);

        assertFalse(isValid2);
        assertNull(type2);
        assertEquals(0, length2);
        assertNull(tokens2);

    }

    @Test
    void shouldCorrectSplitAndValidateWithDifferentSEPARATORS() {

        ArrayDataValidator validator = new ArrayDataValidator("11; 2, 3 4");

        boolean isValid = validator.isValid();
        String type = validator.getType();
        int length = validator.getLength();
        String[] tokens = validator.getTokens();

        assertTrue(isValid);
        assertEquals("INTEGER", type);
        assertEquals(4, length);
        assertArrayEquals(new String[]{"11", "2", "3", "4"}, tokens);

    }


}

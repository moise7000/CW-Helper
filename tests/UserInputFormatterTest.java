package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.UserInputFormatter;
import src.UserInputValidator;


public class UserInputFormatterTest {

    @Test
    public void testToUpperCase() {
        String userInput = "abc123";
        String userInput2 = "ABC123";
        assertEquals(userInput2, UserInputFormatter.toUpperCase(userInput));

        String userInput3 = " abc123 ";
        String userInput4 = "ABC123";
        assertEquals(userInput4, UserInputFormatter.toUpperCase(userInput3));
    }

    @Test
    public void testToLowerCase() {
        String userInput = "aBc123";
        String userInput2 = "abc123";
        assertEquals(userInput2, UserInputFormatter.toLowerCase(userInput));

        String userInput3 = " ABC123 ";
        String userInput4 = "abc123";
        assertEquals(userInput4, UserInputFormatter.toLowerCase(userInput3));
    }


    @Test
    public void testCapitalizeWords() {
        String userInput = "abc123";
        String userInput2 = "Abc123";
        assertEquals(userInput2, UserInputFormatter.capitalizeWords(userInput));

        String userInput3 = " abc123 ";
        String userInput4 = "Abc123";
        assertEquals(userInput4, UserInputFormatter.capitalizeWords(userInput3));

        String userInput5 = "bruce wayne Gotham city";
        String userInput6 = "Bruce Wayne Gotham City";
        assertEquals(userInput6, UserInputFormatter.capitalizeWords(userInput5));
    }

    @Test
    public void testGetInitials() {
        String userInput = "Bruce Wayne";
        String userInput2 = "BW";
        assertEquals(userInput2, UserInputFormatter.getInitials(userInput));
    }


    @Test
    public void removeAccents() {
        String userInput = "Chaîne de caractères avec des accents";
        String userInput2 = "Chaine de caracteres avec des accents";
        assertEquals(userInput2, UserInputFormatter.removeAccents(userInput));
    }

    @Test
    public void formatEmail() {
        String userInput = "Bruce.Wayne@telecomnancy.eu";
        String userInput2 = "bruce.wayne@telecomnancy.eu";
        assertEquals(userInput2, UserInputFormatter.formatEmail(userInput));
    }
}

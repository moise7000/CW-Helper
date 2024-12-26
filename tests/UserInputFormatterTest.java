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
        assertEquals(UserInputFormatter.toUpperCase(userInput), userInput2);

        String userInput3 = " abc123 ";
        String userInput4 = "ABC123";
        assertEquals(UserInputFormatter.toUpperCase(userInput3), userInput4);
    }

    @Test
    public void testToLowerCase() {
        String userInput = "aBc123";
        String userInput2 = "abc123";
        assertEquals(UserInputFormatter.toLowerCase(userInput), userInput2);

        String userInput3 = " ABC123 ";
        String userInput4 = "abc123";
        assertEquals(UserInputFormatter.toLowerCase(userInput3), userInput4);
    }
}

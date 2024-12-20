package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import src.UserInputManager;


public class UserInputManagerTest {

    @Test
    public void testIsValidString_1() {
        String userInput = "Bruce Wayne";

        assertTrue(UserInputManager.isValidString(userInput));
    }

    @Test
    public void testIsValidString_2() {
        String userInput = "  ";

        assertFalse(UserInputManager.isValidString(userInput));
    }

    @Test
    public void testIsValidInteger() {
        String userInput = "123";
        assertTrue(UserInputManager.isValidInteger(userInput));

        String falseUserInput = "a121";
        assertFalse(UserInputManager.isValidInteger(falseUserInput));
    }

    @Test
    public void testIsAlpha() {
        String userInput1 = "ABC";
        assertTrue(UserInputManager.isAlpha(userInput1));

        String userInput2 = "ABCaB";
        assertTrue(UserInputManager.isAlpha(userInput2));



        String falseUserInput1 = "ABC1";
        assertFalse(UserInputManager.isAlpha(falseUserInput1));

        String falseUserInput2 = "A@&C";
        assertFalse(UserInputManager.isAlpha(falseUserInput2));

        String falseUserInput3 = "AagsB hs";
        assertFalse(UserInputManager.isAlpha(falseUserInput3));
    }

    @Test
    public void testIsAlphaNumeric() {
        String userInput = "ABC123Azza";

        assertTrue(UserInputManager.isAlphaNumeric(userInput));

        String falseUserInput1 = "ABC123 er";
        assertFalse(UserInputManager.isAlphaNumeric(falseUserInput1));

        String falseUserInput2 = "Aabc155!@a";
        assertFalse(UserInputManager.isAlphaNumeric(falseUserInput2));


    }


    @Test
    public void testHasMinimumLength() {
        String userInput = "I am a very strong password : 1234";
        int minLength1 = 3;
        assertTrue(UserInputManager.hasMinimumLength(userInput, minLength1));


        String falseUserInput = "password";
        int minLength2 = 9;
        assertFalse(UserInputManager.hasMinimumLength(falseUserInput, minLength2));

        String limitUserInput = "Everybody know the rules";
        int minLength3 = 24;
        assertTrue(UserInputManager.hasMinimumLength(userInput, minLength3));
    }

    @Test
    public void testHasMaximumLength() {
        String falseUserInput = "I am a very strong password : 1234";
        int maxLength1 = 3;
        assertFalse(UserInputManager.hasMaximumLength(falseUserInput, maxLength1));

        String limitUserInput = "Everybody know the rules";
        int maxLength2 = 24;
        assertTrue(UserInputManager.hasMaximumLength(limitUserInput, maxLength2));

        String userInput = "Bruce Wayne";
        int maxLength3 = 15;
        assertTrue(UserInputManager.hasMaximumLength(userInput, maxLength3));

    }

    @Test
    public void testContainsOnly() {
        String userInput1 = "aaa bb abbb ";
        assertTrue(UserInputManager.containsOnly(userInput1, "ab "));

        String userInput2 = "aaabbabbb";
        assertTrue(UserInputManager.containsOnly(userInput2, "ab"));

        String userInput3 = "aaabbabbb";
        assertTrue(UserInputManager.containsOnly(userInput3, "abc"));

        String falseUserInput = "aaabcbabbb";
        assertFalse(UserInputManager.containsOnly(falseUserInput, "ab"));
    }

    @Test
    public void testIsValidDouble() {
        assertTrue(UserInputManager.isValidDouble("123.45"));
        assertTrue(UserInputManager.isValidDouble("-123.45"));
        assertTrue(UserInputManager.isValidDouble("0.0"));
        assertFalse(UserInputManager.isValidDouble("abc"));
        assertFalse(UserInputManager.isValidDouble("123,45"));
        assertFalse(UserInputManager.isValidDouble(null));
        assertFalse(UserInputManager.isValidDouble(""));
        assertTrue(UserInputManager.isValidDouble(" 123.45 "));
    }


    @Test
    public void testCompareInteger() {
        assertTrue(UserInputManager.isIntegerGreaterThan("12", 11));
        assertFalse(UserInputManager.isIntegerGreaterThan("12", 13));

        assertTrue(UserInputManager.isIntegerGreaterEqualThan("12", 11));
        assertTrue(UserInputManager.isIntegerGreaterEqualThan("12", 12));
        assertFalse(UserInputManager.isIntegerGreaterEqualThan("10", 11));

        assertTrue(UserInputManager.isIntegerLessEqualThan("10", 11));
        assertTrue(UserInputManager.isIntegerLessEqualThan("11", 11));
        assertFalse(UserInputManager.isIntegerLessEqualThan("12", 11));

        assertTrue(UserInputManager.isIntegerLessThan("10", 12));
        assertFalse(UserInputManager.isIntegerLessThan("13", 12));
    }

    @Test
    public void testisValidDate() {
        String validDate = "20/12/2024";
        String invalidDate = "32/01/2023";
        String format = "dd/MM/yyyy";

        assertTrue(UserInputManager.isValidDate(validDate, format));
        assertFalse(UserInputManager.isValidDate(invalidDate, format));

        String validUSDate = "12-20-2024";
        String usFormat = "MM-dd-yyyy";

        assertTrue(UserInputManager.isValidDate(validUSDate, usFormat));
        assertFalse(UserInputManager.isValidDate(validDate, usFormat));
    }


    @Test
    public void testIsDateWithinRange() {
        String input = "15/12/2024";
        String format = "dd/MM/yyyy";
        String startDate = "01/01/2024";
        String endDate = "31/12/2024";

        assertTrue(UserInputManager.isDateWithinRange(input, format, startDate, endDate));

        String startDate2 = "12/01/2024";
        String endDate2 = "31/11/2024";
        String falseInput1 = "15/12/2023";
        String falseInput2 = "15/12/2024";
        String falseInput3 = "01/01/2024";
        assertFalse(UserInputManager.isDateWithinRange(falseInput1, format, startDate2, endDate2));
        assertFalse(UserInputManager.isDateWithinRange(falseInput2, format, startDate2, endDate2));
        assertFalse(UserInputManager.isDateWithinRange(falseInput3, format, startDate2, endDate2));
    }

    @Test
    public void testIsValidEmail() {
        assertTrue(UserInputManager.isValidEmail("ewan.decima@telecomnancy.eu"));
        assertTrue(UserInputManager.isValidEmail("ewan.decima@telecomnancy.fr"));
        assertTrue(UserInputManager.isValidEmail("ewan.decima@telecomnancy.com"));
        assertTrue(UserInputManager.isValidEmail("ewandecima@telecomnancy.eu"));

        assertFalse(UserInputManager.isValidEmail("ewan.decima@telecomnancy."));
        assertFalse(UserInputManager.isValidEmail("ewan.decima@telecomnancy"));
        assertFalse(UserInputManager.isValidEmail("ewan.decimatelecomnancy.eu"));
    }

    @Test
    public void testIsValidPhoneNumber() {
        //assertTrue(UserInputManager.isValidPhoneNumber("+33 6 12 34 56 78"));
        assertTrue(UserInputManager.isValidPhoneNumber("123-456-7890"));
        assertFalse(UserInputManager.isValidPhoneNumber("abc123"));
    }

    @Test
    public void testIsValidUrl() {
        assertTrue(UserInputManager.isValidUrl("https://example.com"));
        assertTrue(UserInputManager.isValidUrl("ftp://files.server.net"));
        assertFalse(UserInputManager.isValidUrl("invalid.url"));
    }

    @Test
    public void testIsValidPostalCode() {
        assertTrue(UserInputManager.isValidPostalCode("75001"));
        assertTrue(UserInputManager.isValidPostalCode("1234567890"));
        assertFalse(UserInputManager.isValidPostalCode("ABC123"));
    }

    @Test
    public void testIsValidCreditCardNumber() {
        String validCard = "4539 1488 0343 6467";
        String invalidCard = "1234 5678 9012 3456";

        assertTrue(UserInputManager.isValidCreditCardNumber(validCard));
        assertFalse(UserInputManager.isValidCreditCardNumber(invalidCard));
    }
}

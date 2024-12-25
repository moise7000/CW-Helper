package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import src.UserInputValidator;


public class UserInputValidatorTest {

    @Test
    public void testIsValidString_1() {
        String userInput = "Bruce Wayne";

        assertTrue(UserInputValidator.isValidString(userInput));
    }

    @Test
    public void testIsValidString_2() {
        String userInput = "  ";

        assertFalse(UserInputValidator.isValidString(userInput));
    }

    @Test
    public void testIsValidInteger() {
        String userInput = "123";
        assertTrue(UserInputValidator.isValidInteger(userInput));

        String falseUserInput = "a121";
        assertFalse(UserInputValidator.isValidInteger(falseUserInput));
    }

    @Test
    public void testIsAlpha() {
        String userInput1 = "ABC";
        assertTrue(UserInputValidator.isAlpha(userInput1));

        String userInput2 = "ABCaB";
        assertTrue(UserInputValidator.isAlpha(userInput2));



        String falseUserInput1 = "ABC1";
        assertFalse(UserInputValidator.isAlpha(falseUserInput1));

        String falseUserInput2 = "A@&C";
        assertFalse(UserInputValidator.isAlpha(falseUserInput2));

        String falseUserInput3 = "AagsB hs";
        assertFalse(UserInputValidator.isAlpha(falseUserInput3));
    }

    @Test
    public void testIsAlphaNumeric() {
        String userInput = "ABC123Azza";

        assertTrue(UserInputValidator.isAlphaNumeric(userInput));

        String falseUserInput1 = "ABC123 er";
        assertFalse(UserInputValidator.isAlphaNumeric(falseUserInput1));

        String falseUserInput2 = "Aabc155!@a";
        assertFalse(UserInputValidator.isAlphaNumeric(falseUserInput2));


    }


    @Test
    public void testHasMinimumLength() {
        String userInput = "I am a very strong password : 1234";
        int minLength1 = 3;
        assertTrue(UserInputValidator.hasMinimumLength(userInput, minLength1));


        String falseUserInput = "password";
        int minLength2 = 9;
        assertFalse(UserInputValidator.hasMinimumLength(falseUserInput, minLength2));

        String limitUserInput = "Everybody know the rules";
        int minLength3 = 24;
        assertTrue(UserInputValidator.hasMinimumLength(userInput, minLength3));
    }

    @Test
    public void testHasMaximumLength() {
        String falseUserInput = "I am a very strong password : 1234";
        int maxLength1 = 3;
        assertFalse(UserInputValidator.hasMaximumLength(falseUserInput, maxLength1));

        String limitUserInput = "Everybody know the rules";
        int maxLength2 = 24;
        assertTrue(UserInputValidator.hasMaximumLength(limitUserInput, maxLength2));

        String userInput = "Bruce Wayne";
        int maxLength3 = 15;
        assertTrue(UserInputValidator.hasMaximumLength(userInput, maxLength3));

    }

    @Test
    public void testContainsOnly() {
        String userInput1 = "aaa bb abbb ";
        assertTrue(UserInputValidator.containsOnly(userInput1, "ab "));

        String userInput2 = "aaabbabbb";
        assertTrue(UserInputValidator.containsOnly(userInput2, "ab"));

        String userInput3 = "aaabbabbb";
        assertTrue(UserInputValidator.containsOnly(userInput3, "abc"));

        String falseUserInput = "aaabcbabbb";
        assertFalse(UserInputValidator.containsOnly(falseUserInput, "ab"));
    }

    @Test
    public void testIsValidDouble() {
        assertTrue(UserInputValidator.isValidDouble("123.45"));
        assertTrue(UserInputValidator.isValidDouble("-123.45"));
        assertTrue(UserInputValidator.isValidDouble("0.0"));
        assertFalse(UserInputValidator.isValidDouble("abc"));
        assertFalse(UserInputValidator.isValidDouble("123,45"));
        assertFalse(UserInputValidator.isValidDouble(null));
        assertFalse(UserInputValidator.isValidDouble(""));
        assertTrue(UserInputValidator.isValidDouble(" 123.45 "));
    }


    @Test
    public void testCompareInteger() {
        assertTrue(UserInputValidator.isIntegerGreaterThan("12", 11));
        assertFalse(UserInputValidator.isIntegerGreaterThan("12", 13));

        assertTrue(UserInputValidator.isIntegerGreaterEqualThan("12", 11));
        assertTrue(UserInputValidator.isIntegerGreaterEqualThan("12", 12));
        assertFalse(UserInputValidator.isIntegerGreaterEqualThan("10", 11));

        assertTrue(UserInputValidator.isIntegerLessEqualThan("10", 11));
        assertTrue(UserInputValidator.isIntegerLessEqualThan("11", 11));
        assertFalse(UserInputValidator.isIntegerLessEqualThan("12", 11));

        assertTrue(UserInputValidator.isIntegerLessThan("10", 12));
        assertFalse(UserInputValidator.isIntegerLessThan("13", 12));
    }

    @Test
    public void testisValidDate() {
        String validDate = "20/12/2024";
        String invalidDate = "32/01/2023";
        String format = "dd/MM/yyyy";

        assertTrue(UserInputValidator.isValidDate(validDate, format));
        assertFalse(UserInputValidator.isValidDate(invalidDate, format));

        String validUSDate = "12-20-2024";
        String usFormat = "MM-dd-yyyy";

        assertTrue(UserInputValidator.isValidDate(validUSDate, usFormat));
        assertFalse(UserInputValidator.isValidDate(validDate, usFormat));
    }


    @Test
    public void testIsDateWithinRange() {
        String input = "15/12/2024";
        String format = "dd/MM/yyyy";
        String startDate = "01/01/2024";
        String endDate = "31/12/2024";

        assertTrue(UserInputValidator.isDateWithinRange(input, format, startDate, endDate));

        String startDate2 = "12/01/2024";
        String endDate2 = "31/11/2024";
        String falseInput1 = "15/12/2023";
        String falseInput2 = "15/12/2024";
        String falseInput3 = "01/01/2024";
        assertFalse(UserInputValidator.isDateWithinRange(falseInput1, format, startDate2, endDate2));
        assertFalse(UserInputValidator.isDateWithinRange(falseInput2, format, startDate2, endDate2));
        assertFalse(UserInputValidator.isDateWithinRange(falseInput3, format, startDate2, endDate2));
    }

    @Test
    public void testIsValidEmail() {
        assertTrue(UserInputValidator.isValidEmail("ewan.decima@telecomnancy.eu"));
        assertTrue(UserInputValidator.isValidEmail("ewan.decima@telecomnancy.fr"));
        assertTrue(UserInputValidator.isValidEmail("ewan.decima@telecomnancy.com"));
        assertTrue(UserInputValidator.isValidEmail("ewandecima@telecomnancy.eu"));

        assertFalse(UserInputValidator.isValidEmail("ewan.decima@telecomnancy."));
        assertFalse(UserInputValidator.isValidEmail("ewan.decima@telecomnancy"));
        assertFalse(UserInputValidator.isValidEmail("ewan.decimatelecomnancy.eu"));
    }

    @Test
    public void testIsValidPhoneNumber() {
        //assertTrue(UserInputValidator.isValidPhoneNumber("+33 6 12 34 56 78"));
        assertTrue(UserInputValidator.isValidPhoneNumber("123-456-7890"));
        assertFalse(UserInputValidator.isValidPhoneNumber("abc123"));
    }

    @Test
    public void testIsValidUrl() {
        assertTrue(UserInputValidator.isValidUrl("https://example.com"));
        assertTrue(UserInputValidator.isValidUrl("ftp://files.server.net"));
        assertFalse(UserInputValidator.isValidUrl("invalid.url"));
    }

    @Test
    public void testIsValidPostalCode() {
        assertTrue(UserInputValidator.isValidPostalCode("75001"));
        assertTrue(UserInputValidator.isValidPostalCode("1234567890"));
        assertFalse(UserInputValidator.isValidPostalCode("ABC123"));
    }

    @Test
    public void testIsValidCreditCardNumber() {
        String validCard = "4539 1488 0343 6467";
        String invalidCard = "1234 5678 9012 3456";

        assertTrue(UserInputValidator.isValidCreditCardNumber(validCard));
        assertFalse(UserInputValidator.isValidCreditCardNumber(invalidCard));
    }
}

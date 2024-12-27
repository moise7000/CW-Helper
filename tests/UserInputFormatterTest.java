package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.UserInputFormatter;


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
    public void testRemoveAccents() {
        String userInput = "Chaîne de caractères avec des accents";
        String userInput2 = "Chaine de caracteres avec des accents";
        assertEquals(userInput2, UserInputFormatter.removeAccents(userInput));
    }

    @Test
    public void testFormatEmail() {
        String userInput = "Bruce.Wayne@telecomnancy.eu";
        String userInput2 = "bruce.wayne@telecomnancy.eu";
        assertEquals(userInput2, UserInputFormatter.formatEmail(userInput));
    }

    @Test
    public void testTruncateText() {
        String userInput = "This is a very long text that should be truncated";
        String userInput2 = "This is a very long text...";
        assertEquals(userInput2.length(), 27);
        assertEquals(userInput2, UserInputFormatter.truncateText(userInput, 27));
    }

    @Test
    public void testFormatAmount() {
        double userInput = 123456789.123456789;
        String userInput2 = "123456789,12";
        assertEquals(userInput2, UserInputFormatter.formatAmount(userInput));

        double userInput3 = 123.789;
        String userInput4 = "123,79";
        assertEquals(userInput4, UserInputFormatter.formatAmount(userInput3));

        double userInput5 = 123.00;
        String userInput6 = "123,00";
        assertEquals(userInput6, UserInputFormatter.formatAmount(userInput5));

        double userInput7 = 0.00;
        String userInput8 = "0,00";
        assertEquals(userInput8, UserInputFormatter.formatAmount(userInput7));
    }

    @Test
    public void testMaskCreditCard() {
        String userInput = "4539 1488 0343 6467";
        String userInput2 = "**** **** **** 6467";
        assertEquals(userInput2, UserInputFormatter.maskCreditCard(userInput));
    }

    @Test
    public void testFormatPrice() {
        Double userInput = 2000.00;
        String currency = "€";
        String userInput2 = "2000,00 " + currency;
        assertEquals(userInput2, UserInputFormatter.formatPrice(userInput, currency));
    }




}

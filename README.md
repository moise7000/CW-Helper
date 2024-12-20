# #InfusingTeam

The main purpose of this repository is to help our team during a coding week project. This project focuses on user input validation in Java, providing reusable utility methods to ensure data integrity and avoid runtime errors.

## Overview

This project contains a class named `UserInputManager`, which centralizes various methods for validating user input. The class includes methods to validate strings, numbers, dates, and other common input types.

The primary goals of this utility are:
- Ensure input adheres to specific formats or constraints.
- Simplify input validation across multiple parts of a project.
- Provide reusable and extensible validation logic.

## Features

The `UserInputManager` provides a wide range of validation methods for different types of input, ensuring clean, secure, and robust data processing. Below is the list of all the validation methods available in the class:

### General Validation
- **`isValidString(String input)`**  
  Verifies that a string is not null or empty.

- **`matchesPattern(String input, String regex)`**  
  Checks if a string matches a given regular expression.

- **`containsOnly(String input, String allowedChars)`**  
  Ensures that a string contains only specified allowed characters.

### Number Validation
- **`isValidInteger(String input)`**  
  Validates that a string can be converted to a valid integer.

- **`isValidDouble(String input)`**  
  Validates that a string can be converted to a valid double (floating-point number).

- **`isPositiveInteger(String input)`**  
  Checks if an integer is strictly greater than zero.

- **`isPositiveIntegerOrZero(String input)`**  
  Validates that an integer is greater than or equal to zero.

- **`isWithinRange(int value, int min, int max)`**  
  Checks if an integer falls within a specific range (inclusive).

- **`isIntegerGreaterEqualThan(String input, int target)`**  
  Checks if an integer is greater than or equal to a specific target.

- **`isIntegerGreaterThan(String input, int target)`**  
  Checks if an integer is strictly greater than a specific target.

- **`isIntegerLessEqualThan(String input, int target)`**  
  Validates that an integer is less than or equal to a specific target.

- **`isIntegerLessThan(String input, int target)`**  
  Validates that an integer is strictly less than a specific target.

### String Content Validation
- **`isAlpha(String input)`**  
  Validates that a string contains only alphabetic characters (a–z, A–Z).

- **`isAlphaNumeric(String input)`**  
  Validates that a string contains only alphabetic and numeric characters (a–z, A–Z, 0–9).

- **`hasMinimumLength(String input, int minLength)`**  
  Ensures that a string has a minimum length.

- **`hasMaximumLength(String input, int maxLength)`**  
  Ensures that a string does not exceed a maximum length.

### Date Validation
- **`isValidDate(String input, String format)`**  
  Validates that a string represents a valid date in a given format.

- **`isDateWithinRange(String input, String format, String startDate, String endDate)`**  
  Checks if a date falls within a specified range.

### Format-Specific Validation
- **`isValidEmail(String input)`**  
  Validates that a string matches the format of a valid email address.

- **`isValidPhoneNumber(String input)`**  
  Validates that a string matches the format of a valid phone number.

- **`isValidUrl(String input)`**  
  Ensures that a string is a valid URL format.

- **`isValidPostalCode(String input)`**  
  Validates that a string represents a valid postal code (5–10 digits).

- **`isValidCreditCardNumber(String input)`**  
  Validates a credit card number using the Luhn algorithm.

## How to Use

1. Add the `UserInputManager` class to your Java project.
2. Call the static methods directly without needing to instantiate the class.
   Example:
   ```java
   String email = "example@domain.com";
   boolean isValid = UserInputManager.isValidEmail(email);
   if (isValid) {
       System.out.println("Valid email!");
   } else {
       System.out.println("Invalid email!");
   }

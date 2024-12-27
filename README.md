# Input Utils - InfusingWeek

The main purpose of this repository is to help our team during a coding week project. This project focuses on user input validation and formatting in Java, providing reusable utility methods to ensure data integrity and avoid runtime errors.

## Overview

This project contains two main utility classes:
1. `UserInputValidator`: Centralizes various methods for validating user input
2. `UserInputFormatter`: Provides formatting and normalization methods for user input

The primary goals of these utilities are:
* Ensure input adheres to specific formats or constraints
* Standardize data formatting across the application
* Simplify input validation across multiple parts of a project
* Provide reusable and extensible validation and formatting logic

## Features

### Input Validation (`UserInputValidator`)

The `UserInputValidator` provides a wide range of validation methods for different types of input, ensuring clean, secure, and robust data processing.

#### General Validation
* `isValidString(String input)`: Verifies that a string is not null or empty
* `matchesPattern(String input, String regex)`: Checks if a string matches a given regular expression
* `containsOnly(String input, String allowedChars)`: Ensures a string contains only specified allowed characters

#### Number Validation
* `isValidInteger(String input)`: Validates that a string can be converted to a valid integer
* `isValidDouble(String input)`: Validates that a string can be converted to a valid floating-point number
* `isPositiveInteger(String input)`: Checks if an integer is strictly greater than zero
* `isPositiveIntegerOrZero(String input)`: Validates that an integer is greater than or equal to zero
* `isWithinRange(int value, int min, int max)`: Checks if an integer falls within a specific range (inclusive)
* `isIntegerGreaterEqualThan(String input, int target)`: Checks if an integer is greater than or equal to a target
* `isIntegerGreaterThan(String input, int target)`: Checks if an integer is strictly greater than a target
* `isIntegerLessEqualThan(String input, int target)`: Validates that an integer is less than or equal to a target
* `isIntegerLessThan(String input, int target)`: Validates that an integer is strictly less than a target

#### String Content Validation
* `isAlpha(String input)`: Validates that a string contains only alphabetic characters (a-z, A-Z)
* `isAlphaNumeric(String input)`: Validates that a string contains only alphabetic and numeric characters
* `hasMinimumLength(String input, int minLength)`: Ensures a string has a minimum length
* `hasMaximumLength(String input, int maxLength)`: Ensures a string does not exceed a maximum length

#### Date Validation
* `isValidDate(String input, String format)`: Validates that a string represents a valid date in a given format
* `isDateWithinRange(String input, String format, String startDate, String endDate)`: Checks if a date falls within a specified range

#### Format-Specific Validation
* `isValidEmail(String input)`: Validates that a string matches a valid email address format
* `isValidPhoneNumber(String input)`: Validates that a string matches a valid phone number format
* `isValidUrl(String input)`: Ensures that a string is a valid URL format
* `isValidPostalCode(String input)`: Validates that a string represents a valid postal code (5-10 digits)
* `isValidCreditCardNumber(String input)`: Validates a credit card number using the Luhn algorithm

### Input Formatting (`UserInputFormatter`)

The `UserInputFormatter` provides methods for standardizing and normalizing user input. Here are the available formatting methods:

#### Text Transformation
* `toUpperCase(String input)`: Converts string to uppercase and removes unnecessary spaces
* `toLowerCase(String input)`: Converts string to lowercase and removes unnecessary spaces
* `capitalizeWords(String input)`: Capitalizes the first letter of each word
* `getInitials(String fullName)`: Extracts initials from a full name
* `removeAccents(String input)`: Removes diacritical marks from characters
* `truncateText(String text, int maxLength)`: Truncates text with ellipsis if needed

#### Financial Data Formatting
* `formatAmount(double amount)`: Formats decimal numbers with two decimal places
* `formatPrice(double price, String currency)`: Formats prices with currency symbols

#### Personal Information Formatting
* `formatEmail(String email)`: Standardizes email addresses to lowercase
* `maskCreditCard(String creditCard)`: Masks credit card numbers, showing only last 4 digits

## How to Use

1. Add both utility classes to your Java project
2. Call the static methods directly without needing to instantiate the classes

### Validation Examples
```java
// Email validation
String email = "example@domain.com";
boolean isValid = UserInputValidator.isValidEmail(email);
if (isValid) {
    System.out.println("Valid email!");
} else {
    System.out.println("Invalid email!");
}

// Number range validation
int age = 25;
if (UserInputValidator.isWithinRange(age, 18, 65)) {
    System.out.println("Age is within valid range!");
}
```

### Formatting Examples
```java
// Text formatting
String fullName = "john david smith";
String formatted = UserInputFormatter.capitalizeWords(fullName);
System.out.println(formatted); // Output: "John David Smith"

// Financial formatting
double price = 42.999;
String formatted = UserInputFormatter.formatPrice(price, "EUR");
System.out.println(formatted); // Output: "43.00 EUR"

// Credit card masking
String creditCard = "4532123456789012";
String masked = UserInputFormatter.maskCreditCard(creditCard);
System.out.println(masked); // Output: "**** **** **** 9012"
```

## Best Practices

1. Always validate input before formatting
2. Chain validation and formatting methods for complete input processing
3. Use appropriate error handling when working with nullable inputs
4. Consider performance implications when processing large amounts of data

## Contributing

Feel free to suggest new validation or formatting methods by creating issues or submitting pull requests.


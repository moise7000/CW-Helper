# Input & Date Utils - InfusingWeek

This repository provides a collection of utility classes for handling user input validation, formatting, and date manipulation in Java. The goal is to ensure robust data handling and consistent formatting across applications while reducing code duplication and potential errors.

## Overview

This project contains three main utility classes:
1. `UserInputValidator`: Methods for input validation
2. `UserInputFormatter`: Methods for formatting and normalizing user input
3. `DateUtils`: Methods for date manipulation and validation

## Table of Contents
- [Features](#features)
    - [Input Validation](#input-validation)
    - [Input Formatting](#input-formatting)
    - [Date Utilities](#date-utilities)
- [Installation](#installation)
- [Usage Examples](#usage-examples)
- [Best Practices](#best-practices)

## Features

### Input Validation

The `UserInputValidator` class provides methods to ensure data integrity:

#### General Validation
* `isValidString(String input)`: Verifies that a string is not null or empty
* `matchesPattern(String input, String regex)`: Tests if a string matches a regex pattern
* `containsOnly(String input, String allowedChars)`: Ensures a string only contains allowed characters

#### Numeric Validation
* `isValidInteger(String input)`: Validates integer strings
* `isValidDouble(String input)`: Validates decimal number strings
* `isPositiveInteger(String input)`: Checks for positive integers
* `isPositiveIntegerOrZero(String input)`: Validates non-negative integers
* `isWithinRange(int value, int min, int max)`: Checks if a number is within bounds
* `isIntegerGreaterEqualThan(String input, int target)`: Validates minimum values
* `isIntegerGreaterThan(String input, int target)`: Checks for values above a threshold
* `isIntegerLessEqualThan(String input, int target)`: Validates maximum values
* `isIntegerLessThan(String input, int target)`: Checks for values below a threshold

#### String Content Validation
* `isAlpha(String input)`: Validates alphabetic-only strings
* `isAlphaNumeric(String input)`: Validates alphanumeric strings
* `hasMinimumLength(String input, int minLength)`: Checks minimum string length
* `hasMaximumLength(String input, int maxLength)`: Checks maximum string length

#### Format Validation
* `isValidEmail(String input)`: Validates email addresses
* `isValidPhoneNumber(String input)`: Validates phone numbers
* `isValidUrl(String input)`: Validates URLs
* `isValidPostalCode(String input)`: Validates postal codes
* `isValidCreditCardNumber(String input)`: Validates credit card numbers using Luhn algorithm
* `isValidDate(String input, String format)`: Validates date strings
* `isDateWithinRange(String input, String format, String startDate, String endDate)`: Validates dates within ranges

### Input Formatting

The `UserInputFormatter` class standardizes data presentation:

#### Text Formatting
* `toUpperCase(String input)`: Converts to uppercase with trimming
* `toLowerCase(String input)`: Converts to lowercase with trimming
* `capitalizeWords(String input)`: Capitalizes first letter of each word
* `getInitials(String fullName)`: Extracts initials from names
* `removeAccents(String input)`: Removes diacritical marks
* `truncateText(String text, int maxLength)`: Truncates text with ellipsis

#### Financial Formatting
* `formatAmount(double amount)`: Formats to two decimal places
* `formatPrice(double price, String currency)`: Formats with currency symbol
* `maskCreditCard(String creditCard)`: Masks all but last 4 digits

#### Contact Information
* `formatEmail(String email)`: Standardizes email format

### Date Utilities

The `DateUtils` class handles date-related operations:

#### Date Validation
* `isFutureDate(LocalDate date)`: Checks future dates
* `isPastDate(LocalDate date)`: Validates past dates
* `isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate)`: Validates date ranges
* `isLeapYear(int year)`: Checks leap years

#### Calendar Operations
* `calculateAge(LocalDate birthDate)`: Computes age from birth date
* `isHoliday(LocalDate date)`: Identifies holidays
* `isWorkingDay(LocalDate date)`: Identifies business days
* `isWeekend(LocalDate date)`: Checks for weekends
* `getLastDayOfMonth(LocalDate date)`: Finds month end dates

#### Period Calculations
* `countWorkingDays(LocalDate startDate, LocalDate endDate)`: Counts business days
* `periodsOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2)`: Checks period overlaps
* `getDaysBetween(LocalDate startDate, LocalDate endDate)`: Calculates day intervals
* `getMonthsBetween(LocalDate startDate, LocalDate endDate)`: Calculates month intervals

#### Event Management
* `generateRecurringDates(LocalDate startDate, LocalDate endDate, int frequencyInDays)`: Generates recurring dates
* `getNextDayOfWeek(DayOfWeek dayOfWeek)`: Finds next occurrence of weekday
* `isBirthday(LocalDate birthDate, LocalDate checkDate)`: Validates birthday matches

#### Date Collections
* `getMostRecentDate(List<LocalDate> dates)`: Finds latest date
* `getOldestDate(List<LocalDate> dates)`: Finds earliest date
* `formatDate(LocalDate date, String pattern)`: Formats dates to strings

## Installation

Add the three utility classes to your Java project:
```java
src/
  ├── UserInputValidator.java
  ├── UserInputFormatter.java
  └── DateUtils.java
```

## Usage Examples

### Input Validation
```java
// Email validation
String email = "user@domain.com";
if (UserInputValidator.isValidEmail(email)) {
    System.out.println("Valid email address");
}

// Number validation
String age = "25";
if (UserInputValidator.isValidInteger(age) && 
    UserInputValidator.isWithinRange(Integer.parseInt(age), 0, 120)) {
    System.out.println("Valid age");
}
```

### Input Formatting
```java
// Name formatting
String name = "john david smith";
String formatted = UserInputFormatter.capitalizeWords(name);
System.out.println(formatted); // "John David Smith"

// Credit card masking
String cardNumber = "4532123456789012";
String masked = UserInputFormatter.maskCreditCard(cardNumber);
System.out.println(masked); // "**** **** **** 9012"
```

### Date Operations
```java
// Age calculation
LocalDate birthDate = LocalDate.of(1990, 5, 15);
int age = DateUtils.calculateAge(birthDate);
System.out.println("Age: " + age);

// Working days in a period
LocalDate start = LocalDate.now();
LocalDate end = start.plusMonths(1);
long workDays = DateUtils.countWorkingDays(start, end);
System.out.println("Working days: " + workDays);

// Generate weekly dates
List<LocalDate> weeklyDates = DateUtils.generateRecurringDates(
    start, 
    end,
    7
);
weeklyDates.forEach(System.out::println);

// Check date overlaps
boolean overlaps = DateUtils.periodsOverlap(
    LocalDate.of(2024, 1, 1),
    LocalDate.of(2024, 1, 15),
    LocalDate.of(2024, 1, 10),
    LocalDate.of(2024, 1, 20)
);
System.out.println("Periods overlap: " + overlaps);
```

## Best Practices

1. Input Validation
    - Always validate input before processing
    - Chain multiple validations when needed
    - Handle null inputs appropriately
    - Use specific validation methods rather than generic ones

2. Formatting
    - Format data only after validation
    - Consider locale requirements
    - Handle special characters properly
    - Be consistent with formatting patterns

3. Date Handling
    - Use modern `java.time` API
    - Consider time zones when relevant
    - Validate date ranges before processing
    - Account for holidays in business calculations
    - Handle leap years appropriately
    - Use date formatting patterns consistently

4. General
    - Handle exceptions appropriately
    - Log validation failures when needed
    - Document custom validation rules
    - Consider performance with large datasets
    - Use appropriate error messages
    - Keep validation rules maintainable



## License

This project is available under the MIT License. Feel free to use and modify as needed.
package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class UserInputValidator {

    private UserInputValidator() {
        throw new UnsupportedOperationException("Cette classe ne peut pas être instanciée.");
    }

    /**
     * Vérifie qu'une chaîne n'est pas vide ou null.
     *
     * @param input La chaîne à vérifier.
     * @return true si la chaîne est valide, false sinon.
     */
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }


    /**
     * Vérifie qu'une chaîne peut être convertie en entier.
     *
     * @param input La chaîne à vérifier.
     * @return true si la chaîne représente un entier valide, false sinon.
     */
    public static boolean isValidInteger(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    /**
     * Vérifie qu'une chaîne correspond à un motif regex.
     *
     * @param input La chaîne à vérifier.
     * @param regex Le motif regex à respecter.
     * @return true si la chaîne correspond au motif, false sinon.
     */
    public static boolean matchesPattern(String input, String regex) {
        if (input == null || regex == null) return false;
        return input.matches(regex);
    }

    /**
     * Vérifie qu'un entier est dans une plage donnée.
     *
     * @param value La valeur entière à vérifier.
     * @param min   La valeur minimale (incluse).
     * @param max   La valeur maximale (incluse).
     * @return true si la valeur est dans la plage, false sinon.
     */
    public static boolean isWithinRange(int value, int min, int max) {
        return value >= min && value <= max;
    }


    /**
     * Vérifie si une chaîne contient uniquement des lettres.
     *
     * @param input La chaîne à vérifier.
     * @return true si la chaîne est uniquement composée de lettres, false sinon.
     */
    public static boolean isAlpha(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        } else {
            return input.matches("[a-zA-Z]*");
        }
    }


    /**
     * Vérifie si une chaîne contient uniquement des lettres et des chiffres.
     *
     * @param input La chaîne à vérifier.
     * @return true si la chaîne est uniquement composée de lettres et de chiffres, false sinon.
     */
    public static boolean isAlphaNumeric(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        } else {
            return input.matches("[a-zA-Z0-9]*");
        }
    }


    /**
     * Vérifie si une chaîne a une longueur minimale.
     * @param input La chaîne à vérifier.
     * @param minLength La longueur minimale acceptée.
     * @return true si la longueur de la chaîne est supérieure ou égale à la longueur minimale.
     */
    public static boolean hasMinimumLength(String input, int minLength) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return input.length() >= minLength;
    }

    /**
     * Vérifie si une chaîne ne dépasse pas une longueur maximale.
     * @param input La chaîne à vérifier.
     * @param maxLength La longueur maximale acceptée.
     * @return true si la longueur de la chaîne est inférieure à la longueur maximale autorisée.
     */
    public static boolean hasMaximumLength(String input, int maxLength) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return input.length() <= maxLength;
    }


    /**
     * Vérifie si une chaîne contient uniquement des caractères d'un ensemble autorisé.
     *
     * @param input       La chaîne à vérifier.
     * @param allowedChars Une chaîne contenant les caractères autorisés.
     * @return true si la chaîne ne contient que des caractères autorisés, false sinon.
     */
    public static boolean containsOnly(String input, String allowedChars) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (allowedChars.indexOf(c) == -1) {
                return false;
            }
        }
        return true;

    }


    /**
     * Vérifie si une chaîne représente un nombre à virgule flottante valide.
     *
     * @param input La chaîne à vérifier.
     * @return true si la chaîne peut être convertie en double, false sinon.
     */
    public static boolean isValidDouble(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Vérifie si une chaîne représente un entier positif
     * @param input L'entier à vérifier.
     * @return true si l'entier est supérieur strictement à 0.
     */
    public static boolean isPositiveInteger(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return Integer.parseInt(input.trim()) > 0;
    }

    /**
     * Vérifie si une chaîne représente un entier positif ou nul.
     * @param input L'entier à vérifier.
     * @return true si l'entier est supérieur ou égale à 0.
     */
    public static boolean isPositiveIntegerOrZero(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return Integer.parseInt(input.trim()) >= 0;
    }

    /**
     * Vérifie si une chaîne représente un entier supérieur ou égal à un autre.
     * @param input L'entier à vérifier.
     * @param target Entier pour le test.
     * @return true si l'entier est supérieur ou égale à .
     */
    public static boolean isIntegerGreaterEqualThan(String input, int target) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return Integer.parseInt(input.trim()) >= target;
    }

    /**
     * Vérifie si une chaîne représente un entier supérieur strictement à un autre.
     * @param input L'entier à vérifier.
     * @param target Entier pour le test.
     * @return true si l'entier est supérieur ou égale à .
     */
    public static boolean isIntegerGreaterThan(String input, int target) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return Integer.parseInt(input.trim()) > target;
    }



    /**
     * Vérifie si une chaîne représente un entier inférieur ou égal à un autre.
     * @param input L'entier à vérifier.
     * @param target Entier pour le test.
     * @return true si l'entier est supérieur ou égale à .
     */
    public static boolean isIntegerLessEqualThan(String input, int target) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return Integer.parseInt(input.trim()) <= target;
    }

    /**
     * Vérifie si une chaîne représente un entier inférieur strictement à un autre.
     * @param input L'entier à vérifier.
     * @param target Entier pour le test.
     * @return true si l'entier est supérieur ou égale à .
     */
    public static boolean isIntegerLessThan(String input, int target) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return Integer.parseInt(input.trim()) < target;
    }


    /**
     * Vérifie si une chaîne représente une date valide selon un format donné.
     *
     * @param input  La chaîne à vérifier.
     * @param format Le format attendu de la date (par exemple, "dd/MM/yyyy").
     * @return true si la chaîne représente une date valide selon le format, false sinon.
     */
    public static boolean isValidDate(String input, String format) {
        if (input == null || format == null || input.trim().isEmpty() || format.trim().isEmpty()) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            sdf.parse(input.trim());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }



    /**
     * Vérifie si une date donnée se situe dans une plage de dates spécifiée.
     *
     * @param input     La date à vérifier sous forme de chaîne.
     * @param format    Le format attendu pour la date (par exemple, "dd/MM/yyyy").
     * @param startDate La date de début de la plage sous forme de chaîne.
     * @param endDate   La date de fin de la plage sous forme de chaîne.
     * @return true si la date est valide et se situe entre les dates de début et de fin inclusivement,
     *         false sinon (date invalide, hors plage ou format incorrect).
     *
     */

    public static boolean isDateWithinRange(String input, String format, String startDate, String endDate) {
        if (!isValidDate(input, format) || !isValidDate(startDate, format) || !isValidDate(endDate, format)) {
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date inputDate = sdf.parse(input.trim());
            Date start = sdf.parse(startDate.trim());
            Date end = sdf.parse(endDate.trim());
            return !inputDate.before(start) && !inputDate.after(end);
        } catch (ParseException e) {
            return false;
        }
    }


    /**
     * Vérifie si une chaîne correspond au format d'une adresse email.
     * @param input La chaîne à vérifier.
     * @return true si la chaîne est un email, false sinon.
     */
    public static boolean isValidEmail(String input) {
        if (input == null) {
            return false;
        }
        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return input.matches(emailRegex);
    }


    /**
     * Vérifie si une chaîne représente un numéro de téléphone valide.
     *
     * @param input La chaîne à vérifier.
     * @return true si la chaîne représente un numéro de téléphone valide, false sinon.
     */
    public static boolean isValidPhoneNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        // Ex: Format 10 chiffres, autorise espaces, tirets ou parenthèses.
        String phoneRegex = "^\\+?[0-9 .()-]{7,15}$";
        return input.trim().matches(phoneRegex);
    }


    /**
     * Vérifie si une chaîne représente une URL valide.
     *
     * @param input La chaîne à vérifier.
     * @return true si la chaîne représente une URL valide, false sinon.
     */
    public static boolean isValidUrl(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        // Validation basique d'URL
        String urlRegex = "^(https?|ftp)://[\\w.-]+(?:\\.[\\w.-]+)+[/\\w\\d#?&=.-]*$";
        return input.trim().matches(urlRegex);
    }


    /**
     * Vérifie si une chaîne représente un code postal valide.
     *
     * @param input La chaîne à vérifier.
     * @return true si la chaîne représente un code postal valide, false sinon.
     */
    public static boolean isValidPostalCode(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        // Exemple : 5 chiffres pour un code postal générique
        String postalCodeRegex = "^[0-9]{5,10}$";
        return input.trim().matches(postalCodeRegex);
    }


    /**
     * Vérifie si un numéro de carte de crédit est valide en utilisant l'algorithme de Luhn.
     *
     * @param input Le numéro de carte de crédit à vérifier.
     * @return true si le numéro est valide selon l'algorithme de Luhn, false sinon.
     */
    public static boolean isValidCreditCardNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }


        String sanitizedInput = input.replaceAll("\\s|-", "");
        if (!sanitizedInput.matches("\\d+")) {
            return false; // Doit contenir uniquement des chiffres
        }

        int sum = 0;
        boolean alternate = false;


        for (int i = sanitizedInput.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(sanitizedInput.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }


        return sum % 10 == 0;
    }














}

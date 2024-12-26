package src;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;


public final class UserInputFormatter {

    private UserInputFormatter() {
        throw new UnsupportedOperationException("Cette classe utilitaire ne peut pas être instanciée.");
    }


    /**
     * Convertit une chaîne en majuscules en supprimant les espaces inutiles.
     *
     * @param input La chaîne à transformer
     * @return La chaîne transformée : uniquement en majuscule et sans espace inutile en début et fin de chaîne.
     */
    public static String toUpperCase(String input) {
        return input == null ? "" : input.trim().toUpperCase();
    }

    /**
     * Convertit une chaîne en minuscules en supprimant les espaces inutiles.
     *
     * @param input La chaîne à transformer
     * @return La chaîne transformée : uniquement en minuscules et sans espace inutile en début et fin de chaîne.
     */
    public static String toLowerCase(String input) {
        return input == null ? "" : input.trim().toLowerCase();
    }


    /**
     * Met en majuscule la première lettre de chaque mot d'une chaîne de caractères.
     *
     * @param input La chaîne à transformer
     * @return La chaîne transformée.
     */
    public static String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) return "";

        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return result.toString().trim();
    }



    /**
     * Obtiens les initiales d'un nom complet.
     *
     * @param fullName La chaîne dont on va extraire les initiales.
     * @return Les initiales.
     */
    public static String getInitials(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) return "";

        StringBuilder initials = new StringBuilder();
        String[] nameParts = fullName.trim().split("\\s+");

        for (String part : nameParts) {
            if (!part.isEmpty()) {
                initials.append(Character.toUpperCase(part.charAt(0)));
            }
        }

        return initials.toString();
    }


    /**
     * Supprime les accents d'une chaîne de caractères.
     *
     * @param input La chaîne à transformer.
     * @return La chaîne transformée : sans les accents.
     */
    public static String removeAccents(String input) {
        if (input == null) return "";
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }


    /**
     * Formate une adresse email en minuscules.
     *
     * @param email La chaîne de caractère représentant un email.
     * @return L'email en minuscule.
     */
    public static String formatEmail(String email) {
        return email == null ? "" : email.trim().toLowerCase();
    }


    /**
     * Tronque un texte à une longueur maximale en ajoutant "..." si nécessaire.
     *
     * @param text Le texte que l'on va tronquer si nécessaire
     * @param maxLength La longueur maximale acceptable du texte. On rajoute "..." à la fin de la chaîne.
     * @return Le texte tronqué (ou non)
     */
    public static String truncateText(String text, int maxLength) {
        if (text == null || text.length() <= maxLength) return text;
        return text.substring(0, maxLength - 3) + "...";
    }


    /**
     * Formate un montant avec 2 décimales.
     *
     * @param amount Montant décimale à formater.
     * @return Montant fomarter avec uniquement deux décimales
     */
    public static String formatAmount(double amount) {
        return String.format("%.2f", amount);
    }


    /**
     * Masque partiellement un numéro de carte de crédit.
     *
     * @param creditCard La chaîne de caractères représentant la carte de crédit.
     * @return La chaîne de caractère partiellement masquée.
     */
    public static String maskCreditCard(String creditCard) {
        if (creditCard == null || creditCard.length() < 4) return "";
        String cleaned = creditCard.replaceAll("[^0-9]", "");
        return "**** **** **** " + cleaned.substring(cleaned.length() - 4);
    }


    /**
     * Formate un prix avec le symbole de la devise.
     *
     * @param price Le prix à formater.
     * @param currency La devise à ajouter.
     * @return La chaîne de caractère avec le prix et la devise.
     */
    public static String formatPrice(double price, String currency) {
        return String.format("%.2f %s", price, currency);
    }




}

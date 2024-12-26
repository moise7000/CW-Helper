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

}

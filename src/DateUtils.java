package src;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {

    private DateUtils() {
        throw new UnsupportedOperationException("Cette classe utilitaire ne peut pas être instanciée.");
    }


    /**
     * Vérifie si une date est dans le futur
     * @param date La date à vérifier
     * @return true si la date est dans le futur
     */
    public static boolean isFutureDate(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }


    /**
     * Vérifie si une date est dans le passé
     * @param date La date à vérifier
     * @return true si la date est dans le passé
     */
    public static boolean isPastDate(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }

}

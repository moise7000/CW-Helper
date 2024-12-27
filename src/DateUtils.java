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


    /**
     * Calcule l'âge à partir d'une date de naissance
     * @param birthDate La date de naissance
     * @return L'âge en années
     */
    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }



    /**
     * Vérifie si une date est un jour férié (à adapter selon les besoins)
     * @param date La date à vérifier
     * @return true si c'est un jour férié
     */
    public static boolean isHoliday(LocalDate date) {
        if (date == null) return false;

        // List to complete
        return date.getDayOfMonth() == 1 && date.getMonthValue() == 1 || // Jour de l'an
                date.getDayOfMonth() == 1 && date.getMonthValue() == 5 || // Fête du travail
                date.getDayOfMonth() == 8 && date.getMonthValue() == 5 || // Victoire 1945
                date.getDayOfMonth() == 14 && date.getMonthValue() == 7 || // Fête nationale
                date.getDayOfMonth() == 15 && date.getMonthValue() == 8 || // Assomption
                date.getDayOfMonth() == 1 && date.getMonthValue() == 11 || // Toussaint
                date.getDayOfMonth() == 11 && date.getMonthValue() == 11 || // Armistice
                date.getDayOfMonth() == 25 && date.getMonthValue() == 12;  // Noël
    }


    /**
     * Vérifie si une date est un jour ouvré (lundi-vendredi, hors jours fériés)
     * @param date La date à vérifier
     * @return true si c'est un jour ouvré
     */
    public static boolean isWorkingDay(LocalDate date) {
        if (date == null) return false;
        return !isWeekend(date) && !isHoliday(date);
    }


    /**
     * Vérifie si une date tombe un weekend
     * @param date La date à vérifier
     * @return true si c'est un weekend
     */
    public static boolean isWeekend(LocalDate date) {
        if (date == null) return false;
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }


    /**
     * Calcule le nombre de jours ouvrés entre deux dates
     * @param startDate Date de début
     * @param endDate Date de fin
     * @return Nombre de jours ouvrés
     */
    public static long countWorkingDays(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) return 0;
        return startDate.datesUntil(endDate.plusDays(1))
                .filter(DateUtils::isWorkingDay)
                .count();
    }

    /**
     * Vérifie si deux périodes se chevauchent
     * @param start1 Début de la première période
     * @param end1 Fin de la première période
     * @param start2 Début de la deuxième période
     * @param end2 Fin de la deuxième période
     * @return true si les périodes se chevauchent
     */
    public static boolean periodsOverlap(LocalDate start1, LocalDate end1,
                                         LocalDate start2, LocalDate end2) {
        if (start1 == null || end1 == null || start2 == null || end2 == null) return false;
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }


    /**
     * Génère une liste de dates récurrentes selon une fréquence
     * @param startDate Date de début
     * @param endDate Date de fin
     * @param frequencyInDays Fréquence en jours
     * @return Liste des dates récurrentes
     */
    public static List<LocalDate> generateRecurringDates(LocalDate startDate,
                                                         LocalDate endDate,
                                                         int frequencyInDays) {
        List<LocalDate> dates = new ArrayList<>();
        if (startDate == null || endDate == null || frequencyInDays <= 0) return dates;

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(frequencyInDays);
        }

        return dates;
    }


    /**
     * Calcule la prochaine occurrence d'un jour de la semaine
     * @param dayOfWeek Jour de la semaine souhaité
     * @return Date de la prochaine occurrence
     */
    public static LocalDate getNextDayOfWeek(DayOfWeek dayOfWeek) {
        if (dayOfWeek == null) return null;
        LocalDate now = LocalDate.now();
        return now.with(java.time.temporal.TemporalAdjusters.next(dayOfWeek));
    }

    /**
     * Trouve le dernier jour du mois pour une date donnée
     * @param date Date de référence
     * @return Dernier jour du mois
     */
    public static LocalDate getLastDayOfMonth(LocalDate date) {
        if (date == null) return null;
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     * Vérifie si une année est bissextile
     * @param year L'année à vérifier
     * @return true si l'année est bissextile
     */
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    /**
     * Calcule le nombre de jours entre deux dates
     * @param startDate Date de début
     * @param endDate Date de fin
     * @return Nombre de jours entre les deux dates
     */
    public static long getDaysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) return 0;
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Formate une date selon un pattern donné
     * @param date Date à formater
     * @param pattern Pattern de formatage
     * @return La date formatée en String
     */
    public static String formatDate(LocalDate date, String pattern) {
        if (date == null || pattern == null) return "";
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Vérifie si une date correspond à une date anniversaire
     * @param birthDate Date de naissance
     * @param checkDate Date à vérifier
     * @return true si c'est la date anniversaire
     */
    public static boolean isBirthday(LocalDate birthDate, LocalDate checkDate) {
        if (birthDate == null || checkDate == null) return false;
        return birthDate.getMonth() == checkDate.getMonth()
                && birthDate.getDayOfMonth() == checkDate.getDayOfMonth();
    }

    /**
     * Calcule la différence entre deux dates en mois
     * @param startDate Date de début
     * @param endDate Date de fin
     * @return Nombre de mois entre les deux dates
     */
    public static long getMonthsBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) return 0;
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }

    /**
     * Trouve la date la plus récente parmi une liste de dates
     * @param dates Liste de dates
     * @return La date la plus récente
     */
    public static LocalDate getMostRecentDate(List<LocalDate> dates) {
        if (dates == null || dates.isEmpty()) return null;
        return dates.stream()
                .filter(date -> date != null)
                .max(LocalDate::compareTo)
                .orElse(null);
    }

    /**
     * Trouve la date la plus ancienne parmi une liste de dates
     * @param dates Liste de dates
     * @return La date la plus ancienne
     */
    public static LocalDate getOldestDate(List<LocalDate> dates) {
        if (dates == null || dates.isEmpty()) return null;
        return dates.stream()
                .filter(date -> date != null)
                .min(LocalDate::compareTo)
                .orElse(null);
    }

    /**
     * Vérifie si une date est comprise dans un intervalle
     * @param date Date à vérifier
     * @param startDate Début de l'intervalle
     * @param endDate Fin de l'intervalle
     * @return true si la date est dans l'intervalle
     */
    public static boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        if (date == null || startDate == null || endDate == null) return false;
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }



}

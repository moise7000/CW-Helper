package tests;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.DateUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class DateUtilsTest {

    @Test
    public void testIsFutureDate() {
        LocalDate futureDate = LocalDate.of(2025, 12, 31);
        LocalDate pastDate = LocalDate.of(2020, 1, 1);
        LocalDate today = LocalDate.now();
        assertTrue(DateUtils.isFutureDate(futureDate));
        assertFalse(DateUtils.isFutureDate(pastDate));
        assertFalse(DateUtils.isFutureDate(today));

    }

    @Test
    public void testIsPastDate() {
        LocalDate futureDate = LocalDate.of(2025, 12, 31);
        LocalDate pastDate = LocalDate.of(2020, 1, 1);
        LocalDate today = LocalDate.now();
        assertTrue(DateUtils.isPastDate(pastDate));
        assertFalse(DateUtils.isPastDate(futureDate));
        assertFalse(DateUtils.isPastDate(today));
    }

    @Test
    public void testCalculateAge() {
        LocalDate birthDate = LocalDate.of(2002, 6, 5);
        assertEquals(22, DateUtils.calculateAge(birthDate));
    }

    @Test
    public void testIsHoliday() {
        LocalDate holiday = LocalDate.of(2024, 12, 25);
        LocalDate notHoliday = LocalDate.of(2024, 12, 26);
        assertTrue(DateUtils.isHoliday(holiday));
        assertFalse(DateUtils.isHoliday(notHoliday));
    }

    @Test
    public void testIsWeekend() {
        assertTrue(DateUtils.isWeekend(LocalDate.of(2024, 12, 28))); // Samedi
        assertTrue(DateUtils.isWeekend(LocalDate.of(2024, 12, 29))); // Dimanche
        assertFalse(DateUtils.isWeekend(LocalDate.of(2024, 12, 27))); //Vendredi
    }

    @Test
    public void testIsWorkingDay() {
        assertFalse(DateUtils.isWorkingDay(LocalDate.of(2024, 12, 28))); // Samedi
        assertTrue(DateUtils.isWorkingDay(LocalDate.of(2024, 12, 26)));  // Jeudi
        assertFalse(DateUtils.isWorkingDay(LocalDate.of(2024, 1, 1)));   // Jour férié
    }


    @Test
    public void testCountWorkingDays () {
        LocalDate startDate1 = LocalDate.of(2024, 12, 27);
        LocalDate endDate1 = LocalDate.of(2025, 1, 3);

        assertEquals(5, DateUtils.countWorkingDays(startDate1, endDate1));

        LocalDate startDate2 = LocalDate.of(2025, 1, 6);
        LocalDate endDate2 = LocalDate.of(2025, 1, 17);

        assertEquals(10, DateUtils.countWorkingDays(startDate2, endDate2));

    }

    @Test
    public void testPeriodOverLap() {
        LocalDate startDate1 = LocalDate.of(2024, 12, 27);
        LocalDate endDate1 = LocalDate.of(2025, 1, 3);

        LocalDate startDate2 = LocalDate.of(2025, 1, 6);
        LocalDate endDate2 = LocalDate.of(2025, 1, 17);

        LocalDate startDate3 = LocalDate.of(2025, 1, 1);
        LocalDate endDate3 = LocalDate.of(2025, 1, 10);

        assertFalse(DateUtils.periodsOverlap(startDate1, endDate1, startDate2, endDate2));
        assertTrue(DateUtils.periodsOverlap(startDate2, endDate2, startDate3, endDate3));
    }


    @Test
    void testValidDates() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 10);
        int frequency = 2;

        List<LocalDate> dates = DateUtils.generateRecurringDates(startDate, endDate, frequency);

        assertEquals(5, dates.size());
        assertEquals(LocalDate.of(2024, 1, 1), dates.get(0));
        assertEquals(LocalDate.of(2024, 1, 9), dates.get(4));
        System.out.println("Dates récurrentes :");
        for (LocalDate date : dates) {
            System.out.println(date);
        }
    }

    @Test
    void testInvalidFrequency() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 10);

        List<LocalDate> dates = DateUtils.generateRecurringDates(startDate, endDate, -1);

        assertTrue(dates.isEmpty());
    }

    @Test
    void testStartDateAfterEndDate() {
        LocalDate startDate = LocalDate.of(2024, 1, 10);
        LocalDate endDate = LocalDate.of(2024, 1, 1);

        List<LocalDate> dates = DateUtils.generateRecurringDates(startDate, endDate, 2);

        assertTrue(dates.isEmpty());
    }

}

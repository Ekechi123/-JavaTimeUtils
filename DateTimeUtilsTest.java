import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeUtilsTest {

    public static void main(String[] args) {
        // Run all tests
        testGetCurrentDateTime();
        testConvertToISO8601UTC();
        testDaysBetweenDates();
        testDaysBetweenSameDate();
        testDaysBetweenEndBeforeStart();
        testDaysBetweenLongDuration();
        testConvertToISO8601UTCLeapYear();
        testConvertToISO8601UTCMidnight();
    }

    // Test 1: Verify that getCurrentDateTime() returns a non-null value
    public static void testGetCurrentDateTime() {
        LocalDateTime currentDateTime = DateTimeUtils.getCurrentDateTime();
        // Assert that the current date and time is not null
        assert currentDateTime != null : "Test failed: Current date and time is null.";
        System.out.println("getCurrentDateTime() test passed.");
    }

    // Test 2: Verify that convertToISO8601UTC() correctly converts the date to ISO 8601 UTC format
    public static void testConvertToISO8601UTC() {
        LocalDateTime testDate = LocalDateTime.of(2024, 12, 3, 14, 10, 31); // Example date
        String isoDate = DateTimeUtils.convertToISO8601UTC(testDate);
        // Expected format: "2024-12-03T14:10:31Z"
        assert isoDate.equals("2024-12-03T14:10:31Z") : "Test failed: ISO 8601 conversion is incorrect.";
        System.out.println("convertToISO8601UTC() test passed.");
    }

    // Test 3: Verify that daysBetweenDates() correctly calculates the number of days between two dates
    public static void testDaysBetweenDates() {
        LocalDate startDate = LocalDate.of(2024, 12, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 3);
        long daysBetween = DateTimeUtils.daysBetweenDates(startDate, endDate);
        // Assert that the result is correct (2 days)
        assert daysBetween == 2 : "Test failed: Days between dates is incorrect.";
        System.out.println("daysBetweenDates() test passed.");
    }

    // Test 4: Verify that daysBetweenDates() correctly handles the case where the start date and end date are the same
    public static void testDaysBetweenSameDate() {
        LocalDate sameDate = LocalDate.of(2024, 12, 3);
        long daysBetween = DateTimeUtils.daysBetweenDates(sameDate, sameDate);
        // Assert that the result is 0 (same date)
        assert daysBetween == 0 : "Test failed: Days between same dates should be 0.";
        System.out.println("daysBetweenSameDate() test passed.");
    }

    // Test 5: Verify that daysBetweenDates() correctly handles the case where the end date is before the start date
    public static void testDaysBetweenEndBeforeStart() {
        LocalDate startDate = LocalDate.of(2024, 12, 3);
        LocalDate endDate = LocalDate.of(2024, 12, 1);
        long daysBetween = DateTimeUtils.daysBetweenDates(startDate, endDate);
        // Assert that the result is -2 (start date is after end date)
        assert daysBetween == -2 : "Test failed: Days between dates should be negative.";
        System.out.println("daysBetweenEndBeforeStart() test passed.");
    }

    // Test 6: Verify that daysBetweenDates() handles a very long duration
    public static void testDaysBetweenLongDuration() {
        LocalDate startDate = LocalDate.of(2000, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 3);
        long daysBetween = DateTimeUtils.daysBetweenDates(startDate, endDate);
        // Assert that the result is correct (long duration, in this case, it should be 9131 days)
        assert daysBetween == 9131 : "Test failed: Days between long duration is incorrect.";
        System.out.println("daysBetweenLongDuration() test passed.");
    }

    // Test 7: Verify that convertToISO8601UTC() works for leap year dates
    public static void testConvertToISO8601UTCLeapYear() {
        LocalDateTime testDate = LocalDateTime.of(2024, Month.FEBRUARY, 29, 12, 0, 0); // Leap year date
        String isoDate = DateTimeUtils.convertToISO8601UTC(testDate);
        // Expected format: "2024-02-29T12:00:00Z"
        assert isoDate.equals("2024-02-29T12:00:00Z") : "Test failed: ISO 8601 conversion for leap year is incorrect.";
        System.out.println("convertToISO8601UTCLeapYear() test passed.");
    }

    // Test 8: Verify that convertToISO8601UTC() works for midnight times
    public static void testConvertToISO8601UTCMidnight() {
        LocalDateTime testDate = LocalDateTime.of(2024, 12, 3, 0, 0, 0); // Midnight time
        String isoDate = DateTimeUtils.convertToISO8601UTC(testDate);
        // Expected format: "2024-12-03T00:00:00Z"
        assert isoDate.equals("2024-12-03T00:00:00Z") : "Test failed: ISO 8601 conversion for midnight is incorrect.";
        System.out.println("convertToISO8601UTCMidnight() test passed.");
    }
}


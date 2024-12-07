import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Main class to test the utility methods in the DateTimeUtils class.
 * 
 * <p>This class includes tests for:</p>
 * <ul>
 *   <li>Getting the current date and time</li>
 *   <li>Converting a LocalDateTime to an ISO 8601 UTC string</li>
 *   <li>Calculating the number of days between two dates</li>
 * </ul>
 * 
 * <p>Note: The source code for this class is also decompiled from a .class file using the FernFlower decompiler.</p>
 */
public class Main {
    public static void main(String[] args) {
        // Test 1: Test if the current date and time is returned correctly
        LocalDateTime currentDateTime = DateTimeUtils.getCurrentDateTime();
        System.out.println("Testing getCurrentDateTime()");
        // Assert that currentDateTime is not null (since it should return the current date and time)
        assert currentDateTime != null : "Test failed: Current date and time is null.";

        // Test 2: Test if a date is correctly converted to an ISO 8601 UTC string
        LocalDateTime testDate = LocalDateTime.of(2024, 12, 3, 14, 10, 31);  // Example date
        String isoDate = DateTimeUtils.convertToISO8601UTC(testDate);
        System.out.println("Testing convertToISO8601UTC()");
        // Assert that the result matches the expected ISO 8601 format (ending with 'Z')
        assert isoDate.equals("2024-12-03T14:10:31Z") : "Test failed: ISO 8601 conversion is incorrect.";

        // Test 3: Test if the correct number of days between two dates is calculated
        LocalDate startDate = LocalDate.of(2024, 12, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 3);
        long daysBetween = DateTimeUtils.daysBetweenDates(startDate, endDate);
        System.out.println("Testing daysBetweenDates()");
        // Assert that the difference between the two dates is exactly 2 days
        assert daysBetween == 2 : "Test failed: Days between dates is incorrect.";

        // If no assertions failed, print success
        System.out.println("All tests passed!");
    }
}

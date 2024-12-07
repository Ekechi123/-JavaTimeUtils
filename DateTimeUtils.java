import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Utility class for working with date and time using the java.time API.
 * 
 * <p>This class provides methods to get the current date and time, convert a LocalDateTime
 * to an ISO 8601 UTC string, and calculate the number of days between two LocalDate objects.</p>
 * 
 * <p>Note: The source code of this class is decompiled from a .class file using the FernFlower decompiler.</p>
 */
public class DateTimeUtils {

    /**
     * Default constructor for DateTimeUtils class. Not necessary but included for completeness.
     */
    public DateTimeUtils() {
    }

    /**
     * Returns the current local date and time as a LocalDateTime object.
     * 
     * @return The current date and time as a LocalDateTime object.
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Converts a given LocalDateTime to an ISO 8601 UTC formatted string.
     * 
     * @param date The LocalDateTime to be converted.
     * @return The ISO 8601 UTC string representation of the input date in the format "yyyy-MM-dd'T'HH:mm:ss'Z'".
     */
    public static String convertToISO8601UTC(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return date.atOffset(ZoneOffset.UTC).format(formatter) + "Z";  // Add 'Z' for UTC time zone
    }

    /**
     * Calculates the number of days between two LocalDate objects.
     * 
     * @param start The start date.
     * @param end The end date.
     * @return The number of days between the two dates.
     */
    public static long daysBetweenDates(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }
}

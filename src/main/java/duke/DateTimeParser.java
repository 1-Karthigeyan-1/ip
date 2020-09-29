package duke;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Parses Date and Time
 */
public class DateTimeParser {
    private static String[] inputFormats = {"dd/MM/yyyy HHmm", "MMM dd yyy HH:mm"};

    /**
     * Parses the date time format from String to DateTime type
     *
     * @param dateTime
     * @return date in date time format
     * @throws DukeException for invalid date and time
     */
    public static LocalDateTime parseDateTime(String dateTime) throws DukeException {
        for (String Format : inputFormats) {
            try {
                LocalDateTime date = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(Format));
                return date;
            } catch (DateTimeException e) {
                //Ignore to cycle through the formats
            }
        }
        throw new DukeException(DukeException.INVALID_DATETIME);
    }

    /**
     * converts date from datetime type to String
     *
     * @param dateTime
     * @return
     */
    public static String convertDateTime(LocalDateTime dateTime) {
        String date = dateTime.format(DateTimeFormatter.ofPattern("MMM dd yyy HH:mm"));
        return date;
    }
}

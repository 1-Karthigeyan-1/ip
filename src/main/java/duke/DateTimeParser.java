package duke;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {
    private static final String[] inputFormats = {"dd/MM/yyyy HHmm", "MMM dd yyy HH:mm"};

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

    public static String convertDateTime(LocalDateTime dateTime) {
        String date = dateTime.format(DateTimeFormatter.ofPattern("MMM dd yyy HH:mm"));
        return date;
    }
}

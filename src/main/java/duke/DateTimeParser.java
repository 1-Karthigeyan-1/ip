package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {

    public static LocalDateTime parseDateTime(String dateTime) {
        LocalDateTime date = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return date;
    }

    public static String convertDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("MM dd yyyy"));
    }


}

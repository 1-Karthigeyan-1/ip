package duke.task;

import duke.DateTimeParser;
import duke.Duke;
import duke.DukeException;
import duke.Parser;

import java.time.LocalDateTime;

public class Event extends Task {
    protected LocalDateTime date;
    private static final String taskType = "E";

    public Event(String description, String at) throws DukeException {
        super(description);
        this.date = DateTimeParser.parseDateTime(at);

    }

    @Override
    public String printDescription() {
        return "["+ getTaskType() + "]" + super.printDescription() + " (at: " + getDate() + ")";
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    public String getDate() {
        return DateTimeParser.convertDateTime(date);
    }

    public static void addEvent(String argument) {
        try {
            String[] arguments = Parser.parseArgument(argument, " /at ", 0);
            Task eventObject = new Event(arguments[0], arguments[1]);
            Duke.getTaskList().addTask(eventObject, false);
        } catch (DukeException e) {
            //Error already printed out
        } catch (IndexOutOfBoundsException e) {
            Duke.getUi().printBorder("Missing \"/at\" argument.\n");
        }
    }
}

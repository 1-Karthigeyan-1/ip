package duke.task;

import duke.DateTimeParser;
import duke.Duke;
import duke.Parser;

import java.time.LocalDateTime;

public class Event extends Task {
    protected LocalDateTime date;
    private static final String taskType = "E";

    public Event(String description, String at) throws IndexOutOfBoundsException {
        super(description);
        if (at.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        this.date = DateTimeParser.parseDateTime(at);
    }

    @Override
    public String printDescription() {
        return "["+ getTaskType() + "]" + super.printDescription() + " (at:" + getDate() + ")";
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    public String getDate() {
        return DateTimeParser.convertDateTime(date);
    }

    public static void addEvent(String argument) throws IndexOutOfBoundsException{
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        String[] arguments = Parser.parseArgument(argument, " /at ", 0);
        Task eventObject = new Event(arguments[0], arguments[1]);
        if (arguments[1].isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Duke.getTaskList().addTask(eventObject, false);
    }
}

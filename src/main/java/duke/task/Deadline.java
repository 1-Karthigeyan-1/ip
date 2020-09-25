package duke.task;

import duke.DateTimeParser;
import duke.Duke;
import duke.Parser;

import java.time.LocalDateTime;

public class Deadline extends Task {
    protected LocalDateTime date;
    private static final String taskType = "D";

    public Deadline(String description, String by) throws IndexOutOfBoundsException {
        super(description);
        if (by.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        this.date = DateTimeParser.parseDateTime(by);
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    @Override
    public String printDescription() {
        return "["+ getTaskType() + "]" + super.printDescription() + " (by:" + getDate() + ")";
    }

    public String getDate(){
        return DateTimeParser.convertDateTime(date);
    }

    public static void addDeadline(String argument) throws IndexOutOfBoundsException{
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        String[] arguments = Parser.parseArgument(argument, " /by ", 0);
        Task deadlineObject = new Deadline(arguments[0], arguments[1]);
        if (arguments[1].isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Duke.getTaskList().addTask(deadlineObject, false);
    }


}

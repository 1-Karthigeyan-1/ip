package duke.task;

import duke.Duke;
import duke.Parser;

public class Event extends Task {
    protected String date;
    private static final String taskType = "E";

    public Event(String description, String date) throws IndexOutOfBoundsException {
        super(description);
        if (date.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        this.date = date;
    }

    @Override
    public String printDescription() {
        return "["+ getTaskType() + "]" + super.printDescription() + " (at:" + date + ")";
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    public String getDate() {
        return date;
    }

    public static void addEvent(String argument) throws IndexOutOfBoundsException{
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        String[] arguments = Parser.parseArgument(argument, "/at", 0);
        Task eventObject = new Event(arguments[0], arguments[1]);
        if (arguments[1].isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Duke.getTaskList().addTask(eventObject, false);
    }
}

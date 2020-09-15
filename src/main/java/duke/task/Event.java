package duke.task;

import duke.command.Command;
import java.util.ArrayList;

public class Event extends Task {
    protected String date;
    private static final String ICON = "[E]";

    public Event(String description, String date) throws IndexOutOfBoundsException {
        super(description);
        if (date.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        this.date = date;
    }

    @Override
    public String printDescription() {
        return ICON + super.printDescription() + " (at:" + date + ")";
    }

    public static void addEvent(ArrayList<Task> Tasks, String argument) throws IndexOutOfBoundsException{
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        String[] arguments = Command.parseArgument(argument, "/at", 0);
        Task eventObject = new Event(arguments[0], arguments[1]);
        if (arguments[1].isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Task.addTask(Tasks, eventObject);
    }
}

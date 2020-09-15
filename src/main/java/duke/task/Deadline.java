package duke.task;

import duke.command.Command;
import java.util.ArrayList;

public class Deadline extends Task {
    protected String by;
    private static final String ICON = "[D]";

    public Deadline(String description, String by) throws IndexOutOfBoundsException {
        super(description);
        if (by.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        this.by = by;
    }

    @Override
    public String printDescription() {
        return ICON + super.printDescription() + " (by:" + by + ")";
    }

    public static void addDeadline(ArrayList<Task> Tasks, String argument) throws IndexOutOfBoundsException{
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        String[] arguments = Command.parseArgument(argument, "/by", 0);
        Task deadlineObject = new Deadline(arguments[0], arguments[1]);
        if (arguments[1].isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Task.addTask(Tasks, deadlineObject);
    }

}

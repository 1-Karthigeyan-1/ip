package duke.task;

import duke.command.Command;

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

    public static void addDeadline(Task[] storeTask, String argument) throws IndexOutOfBoundsException{
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        String[] arguments = Command.parseArgument(argument, "/by", 0);
        storeTask[Task.taskCount] = new Deadline(arguments[0], arguments[1]);
        if (arguments[1].isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Task.addTask(storeTask[Task.taskCount]);
    }

}

package duke.task;

import duke.command.Parser;
import java.util.ArrayList;

public class Deadline extends Task {
    protected String by;
    private static final String taskType = "D";

    public Deadline(String description, String by) throws IndexOutOfBoundsException {
        super(description);
        if (by.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        this.by = by;
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    @Override
    public String printDescription() {
        return "["+ getTaskType() + "]" + super.printDescription() + " (by:" + by + ")";
    }

    public String getBy(){
        return by;
    }

    public static void addDeadline(ArrayList<Task> Tasks, String argument) throws IndexOutOfBoundsException{
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        String[] arguments = Parser.parseArgument(argument, "/by", 0);
        Task deadlineObject = new Deadline(arguments[0], arguments[1]);
        if (arguments[1].isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        TaskList.addTask(Tasks, deadlineObject);
    }


}

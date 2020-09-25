package duke.task;

import duke.Duke;
import duke.Parser;

/**
 * Represents the properties of deadline task.
 */
public class Deadline extends Task {
    protected String by;
    private static final String taskType = "D";

    /**
     * Stores details of deadline in the instance
     *
     * @param description description of deadline task
     * @param by date and time
     * @throws IndexOutOfBoundsException if blank arguments is given
     */
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

    /**
     * gets the date and time of object
     *
     * @return date and time of object
     */
    public String getBy(){
        return by;
    }

    /**
     * Add deadline task to the tasklist by parsing the arguments
     *
     * @param argument raw description of deadline
     * @throws IndexOutOfBoundsException if argument is blank
     */
    public static void addDeadline(String argument) throws IndexOutOfBoundsException{
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        String[] arguments = Parser.parseArgument(argument, "/by", 0);
        Task deadlineObject = new Deadline(arguments[0], arguments[1]);
        if (arguments[1].isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Duke.getTaskList().addTask(deadlineObject, false);
    }


}

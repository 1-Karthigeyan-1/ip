package duke.task;

import duke.Duke;
import duke.Parser;

/**
 * Represents the properties of event task.
 */
public class Event extends Task {
    protected String date;
    private static final String taskType = "E";

    /**
     * Stores details of event in the instance.
     *
     * @param description description of deadline task
     * @param date date and time
     * @throws IndexOutOfBoundsException if blank arguments is given
     */
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

    /**
     * gets the date and time of object.
     *
     * @return date and time of object
     */
    public String getDate() {
        return date;
    }

    /**
     * Add event task to the tasklist by parsing the arguments.
     *
     * @param argument raw description of event
     * @throws IndexOutOfBoundsException if argument is blank
     */
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

package duke.task;

import duke.parse.DateTimeParser;
import duke.Duke;
import duke.DukeException;
import duke.parse.Parser;

import java.time.LocalDateTime;

/**
 * Represents the properties of event task.
 */
public class Event extends Task {
    protected LocalDateTime date;
    private static final String TASK_TYPE = "E";


    /**
     * Stores details of event in the instance.
     *
     * @param description description of deadline task
     * @param at date and time
     * @throws IndexOutOfBoundsException if blank arguments is given
     */
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
        return TASK_TYPE;
    }

    /**
     * gets the date and time of object.
     *
     * @return date and time of object
     */
    public String getDate() {
        return DateTimeParser.convertDateTime(date);
    }


    /**
     * Add event task to the tasklist by parsing the arguments.
     *
     * @param argument raw description of event
     */
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

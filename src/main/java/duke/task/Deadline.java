package duke.task;

import duke.DateTimeParser;
import duke.Duke;
import duke.DukeException;
import duke.Parser;

import java.time.LocalDateTime;

/**
 * Represents the properties of deadline task.
 */
public class Deadline extends Task {
    protected LocalDateTime date;
    private static final String taskType = "D";

    /**
     * Stores details of deadline in the instance
     *
     * @param description description of deadline task
     * @param by date and time
     * @throws DukeException if blank arguments is given
     */
    public Deadline(String description, String by) throws DukeException{
        super(description);
        this.date = DateTimeParser.parseDateTime(by);
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    @Override
    public String printDescription() {
        return "["+ getTaskType() + "]" + super.printDescription() + " (by: " + getDate() + ")";
    }

    /**
     * gets the date and time of object
     *
     * @return date and time of object
     */
    public String getDate(){
        return DateTimeParser.convertDateTime(date);
    }

    /**
     * Add deadline task to the tasklist by parsing the arguments
     *
     * @param argument raw description of deadline
     */
    public static void addDeadline(String argument) {
        try {
            String[] arguments = Parser.parseArgument(argument, " /by ", 0);
            Task deadlineObject = new Deadline(arguments[0], arguments[1]);
            Duke.getTaskList().addTask(deadlineObject, false);
        } catch (DukeException e) {
            //Error printed in Duke exception
        } catch (IndexOutOfBoundsException e) {
            Duke.getUi().printBorder("Missing \"/by\" argument.\n");
        }
    }


}

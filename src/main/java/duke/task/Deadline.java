package duke.task;

import duke.DateTimeParser;
import duke.Duke;
import duke.DukeException;
import duke.Parser;

import java.time.LocalDateTime;

public class Deadline extends Task {
    protected LocalDateTime date;
    private static final String taskType = "D";

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

    public String getDate(){
        return DateTimeParser.convertDateTime(date);
    }

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

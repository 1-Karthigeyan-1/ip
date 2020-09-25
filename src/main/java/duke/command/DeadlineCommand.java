package duke.command;

import duke.DukeException;
import duke.task.Deadline;

/**
 * Represents the deadline command used in the user input
 */
public class DeadlineCommand extends CommandArgument{
    public static final String COMMAND_WORD = "deadline";
    private static final int MAX_LIMIT = 2;

    public DeadlineCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the deadline command by adding Deadlines to the program
     *
     * @param arguments parsed arguments for deadline command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Deadline.addDeadline(arguments[1]);
        } catch (DukeException e) {
            //Error shown in DukeException
        }
    }

    @Override
    public int getLimit() {
        return MAX_LIMIT;
    }

}

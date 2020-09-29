package duke.command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the list command used in the user input
 */
public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    private static final int MAX_LIMIT = 1;

    public ListCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the list command by showing the list of tasks in program.
     *
     * @param arguments parsed arguments for list command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getTaskList().showList();
        } catch (DukeException e) {
            //The DukeException class prints out the error
        }
    }

    @Override
    public int getLimit() {
        return MAX_LIMIT;
    }

}

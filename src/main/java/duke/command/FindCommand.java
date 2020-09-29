package duke.command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the find command used in the user input
 */
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    private static final int MAX_LIMIT = 2;

    public FindCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the find command by showing the list of matching tasks in program.
     *
     * @param arguments parsed arguments for find command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getTaskList().lookupTask(arguments[1]);
        } catch (DukeException e) {
            //Error shown in DukeException
        }
    }

    @Override
    public int getLimit() {
        return MAX_LIMIT;
    }
}

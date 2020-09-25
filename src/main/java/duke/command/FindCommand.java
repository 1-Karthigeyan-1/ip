package duke.command;

import duke.Duke;

/**
 * Represents the find command used in the user input
 */
public class FindCommand extends CommandArgument{
    public static final String COMMAND_WORD = "find";

    public FindCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the find command by showing the list of matching tasks in program.
     *
     * @param description keyword used to search for task
     */
    @Override
    public void execute(String[] arguments) {
        Duke.getTaskList().lookupTask(arguments[1]);
    }
}

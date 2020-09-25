package duke.command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the delete command used in the user input
 */
public class DeleteCommand extends CommandArgument{
    public static final String COMMAND_WORD = "delete";
    private static final int MAX_LIMIT = 2;

    public DeleteCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the deadline command by deleting specific task in the program
     *
     * @param arguments parsed arguments for delete command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getTaskList().deleteTask(arguments[1]);
        } catch (DukeException e) {
            //Error shown in DukeException
        }
    }

    @Override
    public int getLimit() {
        return MAX_LIMIT;
    }


}

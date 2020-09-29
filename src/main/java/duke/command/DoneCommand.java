package duke.command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the done command used in the user input
 */
public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";
    private static final int MAX_LIMIT = 2;

    public DoneCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the done command by marking the specific task
     *
     * @param arguments parsed arguments for done command.
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getTaskList().markTaskinList(arguments[1]);
        } catch (DukeException e) {
            //The DukeException class prints out the error
        } catch (NumberFormatException e) {
            Duke.getUi().printNumberFormatError(arguments[1]);
        }
    }

    @Override
    public int getLimit() {
        return MAX_LIMIT;
    }

}

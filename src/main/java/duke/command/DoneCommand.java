package duke.command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the done command used in the user input
 */
public class DoneCommand extends CommandArgument{
    public static final String COMMAND_WORD = "done";

    public DoneCommand(String description) {
        super(description);
    }

    /**
     * Executes the done command by marking the specific task
     *
     * @param description  Additional argument that comes after the done command.
     */
    @Override
    public void execute(String description) {
        try {
            Duke.getTaskList().markTaskinList(description);
        } catch (DukeException e) {
            //The DukeException class prints out the error
        } catch (NumberFormatException e) {
            Duke.getUi().printNumberFormatError(description);
        }
    }

    }

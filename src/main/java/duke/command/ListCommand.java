package duke.command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the list command used in the user input
 */
public class ListCommand extends CommandArgument{
    public static final String COMMAND_WORD = "list";

    public ListCommand(String[] arguments) {
        super(arguments);

    }

    /**
     * Executes the list command by showing the list of tasks in program.
     */
    @Override
    public void execute(String[] arguments) {
        try {
            Duke.getTaskList().showList();
        } catch (DukeException e) {
            //The DukeException class prints out the error
        }
    }

}

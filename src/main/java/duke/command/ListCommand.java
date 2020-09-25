package duke.command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the list command used in the user input
 */
public class ListCommand extends Command{
    public static final String COMMAND_WORD = "list";

    public ListCommand() {
        super();

    }

    /**
     * Executes the list command by showing the list of tasks in program.
     */
    @Override
    public void execute() {
        try {
            Duke.getTaskList().showList();
        } catch (DukeException e) {
            //The DukeException class prints out the error
        }
    }

}

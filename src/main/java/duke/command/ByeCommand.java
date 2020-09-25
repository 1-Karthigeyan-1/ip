package duke.command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the bye command used in the user input
 */
public class ByeCommand extends CommandArgument{
    public static final String COMMAND_WORD= "bye";
    private static final int MAX_LIMIT = 1;

    public ByeCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the bye command by exiting the program with error 0.
     *
     * @param arguments parsed arguments for bye command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getUi().printExit();
            System.exit(0);
        } catch (DukeException e) {
            //Error shown in DukeException
        }
    }

    @Override
    public int getLimit() {
        return MAX_LIMIT;
    }
}

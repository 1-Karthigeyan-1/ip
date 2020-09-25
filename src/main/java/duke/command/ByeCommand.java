package duke.command;

import duke.Duke;

/**
 * Represents the bye command used in the user input
 */
public class ByeCommand extends CommandArgument{
    public static final String COMMAND_WORD= "bye";

    public ByeCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the bye command by exiting the program with error 0.
     *
     * @param arguments parsed arguments for commands
     */
    @Override
    public void execute(String[] arguments) {
        Duke.getUi().printExit();
        System.exit(0);
    }
}

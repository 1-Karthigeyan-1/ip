package duke.command;

import duke.Duke;

/**
 * Represents the bye command used in the user input
 */
public class ByeCommand extends Command{
    public static final String COMMAND_WORD= "bye";

    public ByeCommand(){
        execute();
    }

    /**
     * Executes the bye command by exiting the program with error 0.
     */
    @Override
    public void execute() {
        Duke.getUi().printExit();
        System.exit(0);
    }

}

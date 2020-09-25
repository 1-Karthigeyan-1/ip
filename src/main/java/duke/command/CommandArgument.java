package duke.command;

/**
 * Represents the Command keyword that is used in the user input.
 * This class assumes that the command has arguments
 */
public abstract class CommandArgument {

    public CommandArgument(String[] arguments) {
        execute(arguments);
    }

    /**
     * Executes the command by doing an action with respect to the commands in its subclass.
     *
     * @param arguments parsed arguments for commands
     */
    public abstract void execute(String[] arguments);

    

}

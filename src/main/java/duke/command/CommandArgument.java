package duke.command;

/**
 * Represents the Command keyword that is used in the user input.
 * This class assumes that the command has arguments
 */
public abstract class CommandArgument extends Command{

    public CommandArgument(String description) {
        execute(description);
    }

    /**
     * Executes the command by doing an action with respect to the commands in its subclass.
     *
     * @param description Additional argument for specific commands that require one.
     */
    public abstract void execute(String description);

    @Override
    public void execute(){
    }
}

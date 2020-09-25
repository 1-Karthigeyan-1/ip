package duke.command;

/**
 * Represents the Command keyword that is used in the user input.
 * This class assumes that the command has no arguments
 */
public abstract class Command {

    public Command() {
        execute();
    }

    /**
     * Executes the command by doing an action with respect to the commands in its subclass.
     */
    public abstract void execute();

}

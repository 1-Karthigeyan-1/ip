package duke.command;

import duke.DukeException;

/**
 * Represents the Command keyword that is used in the user input.
 */
public abstract class CommandArgument {

    public CommandArgument(String[] arguments) {
        try {
            execute(arguments);
        } catch (DukeException e) {
            //Error shown in DukeException
        }
    }

    /**
     * Executes the command by doing an action with respect to the commands in its subclass.
     *
     * @param arguments parsed arguments for commands
     */
    public void execute(String[] arguments) throws DukeException {
            checkSize(arguments);
    };

    /**
     * Checks the size limit of arguments for every command
     *
     * @param arguments parsed arguments
     * @throws DukeException if number of arguments is not equal to intended number of arguments
     */
    public void checkSize(String[] arguments) throws DukeException {
        if (arguments.length != getLimit()) {
            throw new DukeException(DukeException.ARGUMENT_SIZE);
        }
    }

    /**
     * Gets the limit of arguments for specific command
     * @return the inteded argument a command is supposed to have
     */
    public abstract int getLimit();

}

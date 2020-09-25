package duke.command;

import duke.Duke;

/**
 * Represents the delete command used in the user input
 */
public class DeleteCommand extends CommandArgument{
    public static final String COMMAND_WORD = "delete";

    public DeleteCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the deadline command by deleting specific task in the program
     *
     * @param description Additional argument that comes after the delete command.
     */
    @Override
    public void execute(String[] arguments) {
        Duke.getTaskList().deleteTask(arguments[1]);
    }


}

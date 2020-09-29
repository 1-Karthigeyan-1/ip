package duke.command;

import duke.DukeException;
import duke.task.Todo;

/**
 * Represents the todo command used in the user input
 */
public class TodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private static final int MAX_LIMIT = 2;

    public TodoCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the todo command by adding the todo task to the program.
     *
     * @param arguments parsed arguments for todo command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Todo.addTodo(arguments[1]);
        } catch (DukeException e) {
            //Error shown in DukeException
        }
    }

    @Override
    public int getLimit() {
        return MAX_LIMIT;
    }

}

package duke.command;

import duke.task.Todo;

/**
 * Represents the todo command used in the user input
 */
public class TodoCommand extends CommandArgument{
    public static final String COMMAND_WORD = "todo";

    public TodoCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the todo command by adding the todo task to the program.
     *
     * @param description  Additional argument that comes after the todo command.
     */
    @Override
    public void execute(String[] arguments) {
        Todo.addTodo(arguments[1]);
    }

}

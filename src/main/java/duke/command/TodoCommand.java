package duke.command;

import duke.task.TaskList;
import duke.task.Todo;

public class TodoCommand extends CommandArgument{
    public static final String CommandWord = "todo";

    public TodoCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        Todo.addTodo(description);
    }

}

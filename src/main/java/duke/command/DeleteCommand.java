package duke.command;

import duke.Duke;
import duke.task.TaskList;

public class DeleteCommand extends CommandArgument{
    public static final String CommandWord = "delete";

    public DeleteCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        Duke.getTaskList().deleteTask(description);
    }


}

package duke.command;

import duke.Duke;

public class DeleteCommand extends CommandArgument{
    public static final String COMMAND_WORD = "delete";

    public DeleteCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        Duke.getTaskList().deleteTask(description);
    }


}

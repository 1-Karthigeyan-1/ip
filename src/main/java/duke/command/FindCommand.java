package duke.command;

import duke.Duke;

public class FindCommand extends CommandArgument{
    public static final String COMMAND_WORD = "find";
    public FindCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        Duke.getTaskList().lookupTask(description);
    }
}

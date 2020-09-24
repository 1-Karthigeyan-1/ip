package duke.command;

import duke.task.Deadline;

public class DeadlineCommand extends CommandArgument{
    public static final String COMMAND_WORD = "deadline";

    public DeadlineCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        Deadline.addDeadline(description);
    }

}

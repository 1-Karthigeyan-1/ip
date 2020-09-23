package duke.command;

import duke.task.Deadline;
import duke.task.TaskList;

public class DeadlineCommand extends CommandArgument{
    public static final String CommandWord = "deadline";

    public DeadlineCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        Deadline.addDeadline(TaskList.Tasks, description);
    }

}

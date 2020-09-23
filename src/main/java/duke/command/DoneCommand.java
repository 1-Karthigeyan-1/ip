package duke.command;

import duke.DukeException;
import duke.task.Task;
import duke.task.TaskList;

public class DoneCommand extends CommandArgument{
    public static final String CommandWord = "done";

    public DoneCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        try {
            Task.completeTask(description);
        } catch (DukeException e) {
            //TODO sth abt this
        }
    }

}

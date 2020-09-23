package duke.command;

import duke.DukeException;
import duke.task.Task;
import duke.task.TaskList;

public class DoneCommand extends Command{
    public static final String CommandWord = "done";

    public DoneCommand(String description) {
        super(description);
    }


    @Override
    public void execute(String description) {
        try {
            Task.completeTask(TaskList.Tasks, description);
        } catch (DukeException e) {
            //TODO sth abt this
        }
    }
}

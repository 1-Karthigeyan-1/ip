package duke.command;

import duke.DukeException;
import duke.task.TaskList;

public class ListCommand extends Command{
    public static final String CommandWord = "list";

    public ListCommand(String description) {
        super(description);

    }

    @Override
    public void execute(String description) {
        try {
            TaskList.showList(TaskList.Tasks);
        } catch (DukeException e) {
            //TODO
        }
    }
}

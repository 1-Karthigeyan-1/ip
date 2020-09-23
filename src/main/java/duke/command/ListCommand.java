package duke.command;

import duke.Duke;
import duke.DukeException;
import duke.task.TaskList;

public class ListCommand extends Command{
    public static final String CommandWord = "list";

    public ListCommand() {
        super();

    }

    @Override
    public void execute() {
        try {
            Duke.getTaskList().showList();
        } catch (DukeException e) {
            //TODO
        }
    }

}

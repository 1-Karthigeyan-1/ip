package duke.command;

import duke.Duke;
import duke.DukeException;

public class DoneCommand extends CommandArgument{
    public static final String CommandWord = "done";
    public DoneCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        try {
            Duke.getTaskList().MarkTask(description);
        } catch (DukeException e) {
            //TODO sth abt this
        }
    }

}

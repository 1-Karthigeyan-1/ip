package duke.command;

import duke.Duke;
import duke.DukeException;

public class ListCommand extends Command{
    public static final String COMMAND_WORD = "list";

    public ListCommand() {
        super();

    }

    @Override
    public void execute() {
        try {
            Duke.getTaskList().showList();
        } catch (DukeException e) {
            //The DukeException class prints out the error
        }
    }

}

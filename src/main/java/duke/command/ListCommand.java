package duke.command;

import duke.Duke;
import duke.DukeException;

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

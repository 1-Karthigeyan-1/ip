package duke.command;

import duke.Duke;
import duke.DukeException;

public class DoneCommand extends CommandArgument{
    public static final String COMMAND_WORD = "done";

    public DoneCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        try {
            Duke.getTaskList().markTaskinList(description);
        } catch (DukeException e) {
            //The DukeException class prints out the error
        } catch (NumberFormatException e) {
            Duke.getUi().printNumberFormatError(description);
        }
    }

    }

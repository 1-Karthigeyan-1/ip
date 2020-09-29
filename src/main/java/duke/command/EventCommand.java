package duke.command;

import duke.DukeException;
import duke.task.Event;

/**
 * Represents the event command used in the user input
 */
public class EventCommand extends Command {
    public static final String COMMAND_WORD = "event";
    private static final int MAX_LIMIT = 2;

    public EventCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the event command by adding the event task to the program.
     *
     * @param arguments parsed arguments for event command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Event.addEvent(arguments[1]);
        } catch (DukeException e) {
            //Error shown in DukeException
        }
    }

    @Override
    public int getLimit() {
        return MAX_LIMIT;
    }

}

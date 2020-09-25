package duke.command;

import duke.task.Event;

/**
 * Represents the event command used in the user input
 */
public class EventCommand extends CommandArgument{
    public static final String COMMAND_WORD = "event";

    public EventCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the event command by adding the event task to the program.
     *
     * @param description  Additional argument that comes after the event command.
     */
    @Override
    public void execute(String[] arguments) {
        Event.addEvent(arguments[1]);
    }

}

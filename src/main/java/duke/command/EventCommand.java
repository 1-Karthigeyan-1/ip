package duke.command;

import duke.task.Event;

public class EventCommand extends CommandArgument{
    public static final String CommandWord = "event";

    public EventCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        Event.addEvent(description);
    }

}

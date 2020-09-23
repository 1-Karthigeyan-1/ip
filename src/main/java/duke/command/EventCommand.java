package duke.command;

import duke.task.Event;
import duke.task.TaskList;

public class EventCommand extends Command{
    public static final String CommandWord = "event";

    public EventCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String description) {
        Event.addEvent(TaskList.Tasks, description);
    }
}

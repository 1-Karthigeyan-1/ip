package duke.dataStorage;

import duke.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;

public class CompilableData {
    private Task item;
    private String description;
    private String taskType;
    private String done;

    public CompilableData(Task item) {
        this.item = item;
        this.description = item.getDescription();
        this.taskType = item.getTaskType();
        this.done = item.getStatusIcon();
    }

    public String CompileData() throws DukeException {
        String formattedData = String.format("%s , %s , %s", taskType, done, description);
        switch (taskType) {
        case DataType.TODO_TYPE:
            formattedData += "\n";
            break;
        case DataType.EVENT_TYPE:
            String date = ((Event) item).getDate();
            formattedData = String.format("%s , %s\n", formattedData, date);
            break;
        case DataType.DEADLINE_TYPE:
            String by = ((Deadline) item).getDate();
            formattedData = String.format("%s , %s\n", formattedData, by);
            break;
        default:
            throw new DukeException(DukeException.INVALID_TYPE);
        }

        return formattedData;
    }
}

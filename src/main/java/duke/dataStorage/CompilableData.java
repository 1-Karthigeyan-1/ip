package duke.dataStorage;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;

public class CompilableData {

    public static String CompileData(Task item) {
        String description = item.getDescription();
        String taskType = item.getTaskType();
        String done = item.getStatusIcon();
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
            String by = ((Deadline) item).getBy();
            formattedData = String.format("%s , %s\n", formattedData, by);
            break;
        default:
            System.out.println("Save Error!");
            break;
        }

        return formattedData;
    }
}

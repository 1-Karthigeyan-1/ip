package duke.dataStorage;

import duke.Duke;
import duke.Parser;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;

public class ExtractableData {
    private static String divider = " , ";
    private static int divider_limit = 0;
    public ExtractableData() {
        super();
    }

    public static void ExtractData(String Data) {
        String[] arguments = Parser.parseArgument(Data, divider, divider_limit);
        TaskList Tasks = Duke.getTaskList();
        Task item = null;
        switch (arguments[0]) {
        case DataType.TODO_TYPE:
            item = new Todo(arguments[2]);
            break;
        case DataType.EVENT_TYPE:
            item = new Event(arguments[2], arguments[3]);
            break;
        case DataType.DEADLINE_TYPE:
            item= new Deadline(arguments[2], arguments[3]);
            break;
        default:
            //TODO throw exception
            System.out.println("Unable to load this set of data...Data corrupted");
            break;
        }

        try {
            if (arguments[1].equals("\u2713")) {
                item.completeTask();
            }
        } catch (NullPointerException e) {
            Duke.getUi().printBorder("Wronh Type");
        }

        Tasks.addTask(item, true);
    }
}

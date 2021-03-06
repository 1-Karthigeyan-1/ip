package duke.dataStorage;

import duke.Duke;
import duke.DukeException;
import duke.parse.Parser;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;

/**
 * Handles data that is to be extracted from the storage file into the program
 */
public class ExtractableData {
    private static final String DIVIDER = " , ";
    private static final int DIVIDER_LIMIT = 0;
    private TaskList Tasks;
    private String Data;
    private Task item;

    /**
     *Stores item in the class
     *
     * @param Data Information of a task in storage
     */
    ExtractableData(String Data) {
        this.Tasks = Duke.getTaskList();
        this.Data = Data;
    }

    /**
     * Extracts data from the compiled version and adds it to tasklist
     * in the program.
     *
     * @throws DukeException if type of task is invalid
     */
    public void ExtractData() throws DukeException {
        String[] arguments = Parser.parseArgument(Data, DIVIDER, DIVIDER_LIMIT);

        switch (arguments[0]) {
        case DataType.TODO_TYPE:
            item = new Todo(arguments[2]);
            break;
        case DataType.EVENT_TYPE:
            item = new Event(arguments[2], arguments[3]);
            break;
        case DataType.DEADLINE_TYPE:
            item = new Deadline(arguments[2], arguments[3]);
            break;
        default:
            throw new DukeException(DukeException.INVALID_TYPE);
        }

        try {
            if (arguments[1].equals("\u2713")) {
                item.completeTask();
            }
        } catch (NullPointerException e) {
            Duke.getUi().printNullError();
        }

        Tasks.addTask(item, true);
    }
}

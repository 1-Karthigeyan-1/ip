package duke.task;

import duke.Duke;

/**
 * Represents the properties of todo task.
 */
public class Todo extends Task{
    private static final String taskType = "T";

    /**
     * Stores details of todo in the instance
     *
     * @param description description of task
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String printDescription() {
        return "["+ getTaskType() + "]" + super.printDescription();
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    /**
     * Add tpdo task to the tasklist by parsing the arguments.
     *
     * @param argument raw description of event
     * @throws IndexOutOfBoundsException if argument is blank
     */
    public static void addTodo(String argument) throws IndexOutOfBoundsException {
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Task item = new Todo(argument);
        Duke.getTaskList().addTask(item, false);
    }

}

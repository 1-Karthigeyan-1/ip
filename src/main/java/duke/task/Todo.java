package duke.task;

import duke.Duke;

public class Todo extends Task{
    private static final String taskType = "T";

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

    public static void addTodo(String argument) throws IndexOutOfBoundsException {
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Task item = new Todo(argument);
        Duke.getTaskList().addTask(item, false);
    }

}

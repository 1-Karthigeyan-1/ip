package duke.task;

import java.util.ArrayList;

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

    public static void addTodo(ArrayList<Task> Tasks, String argument) throws IndexOutOfBoundsException {
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Task todoObject = new Todo(argument);
        TaskList.addTask(Tasks, todoObject);
    }

}

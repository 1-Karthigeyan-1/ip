package duke.task;

import java.util.ArrayList;

public class Todo extends Task{
    private static final String ICON = "[T]";

    public Todo(String description) {
        super(description);
    }

    @Override
    public String printDescription() {
        return ICON + super.printDescription();
    }

    public static void addTodo(ArrayList<Task> Tasks, String argument) throws IndexOutOfBoundsException {
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        Task todoObject = new Todo(argument);
        Task.addTask(Tasks, todoObject);
    }
}

package duke.task;

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

    public static void addTodo(Task[] storeTask, String argument) throws IndexOutOfBoundsException {
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        storeTask[Task.taskCount] = new Todo(argument);
        Task.addTask(storeTask[Task.taskCount]);
    }

}

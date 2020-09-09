public class Todo extends Task{
    private static final String ICON = "[T]";

    public Todo(String description) {
        super(description);
    }

    @Override
    public String printDescription() {
        return ICON + super.printDescription();
    }

    public static void addTodo(Task[] storeTask, String argument) throws IndexOutOfBoundsException {
        if (argument.isBlank()) {
            throw new IndexOutOfBoundsException();
        }
        storeTask[Task.taskCount] = new Todo(argument);
        Task.addTask(storeTask[Task.taskCount]);
    }
}

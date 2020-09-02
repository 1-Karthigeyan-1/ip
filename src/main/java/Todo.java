public class Todo extends Task{
    private static final String ICON = "[T]";

    public Todo(String description) {
        super(description);
    }

    @Override
    public String printDescription() {
        return ICON + super.printDescription();
    }
}

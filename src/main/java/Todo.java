public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    @Override
    public String printDescription() {
        return "[T]" + super.printDescription();
    }
}

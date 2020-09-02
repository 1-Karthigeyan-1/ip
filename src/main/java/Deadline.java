public class Deadline extends Task {
    protected String by;
    private static final String ICON = "[D]";

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String printDescription() {
        return ICON + super.printDescription() + " (by:" + by + ")";
    }

}

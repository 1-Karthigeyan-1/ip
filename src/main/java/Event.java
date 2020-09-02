public class Event extends Task {
    protected String date;
    private static final String ICON = "[E]";

    public Event(String description, String date) {
        super(description);
        this.date = date;
    }

    @Override
    public String printDescription() {

        return ICON + super.printDescription() + " (at:" + date + ")";
    }

}

public class Event extends Task {
    protected String date;

    public Event(String description, String date) {
        super(description);
        this.date = date;
    }

    @Override
    public String printDescription() {

        return "[E]" + super.printDescription() + " (at:" + date + ")";
    }

}

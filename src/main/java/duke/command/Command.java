package duke.command;

public abstract class Command {

    public Command(String description) {
        execute(description);
    }
    public abstract void execute(String description);
}

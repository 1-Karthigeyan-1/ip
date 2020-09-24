package duke.command;

public abstract class Command {

    public Command() {
        execute();
    }

    public abstract void execute();

}

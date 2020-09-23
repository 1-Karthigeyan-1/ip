package duke.command;

public abstract class CommandArgument extends Command{

    public CommandArgument(String description) {
        execute(description);
    }

    public abstract void execute(String description);

    @Override
    public void execute(){
    }
}

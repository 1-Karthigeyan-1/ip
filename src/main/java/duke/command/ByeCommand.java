package duke.command;

import duke.Duke;

public class ByeCommand extends Command{
    public static final String CommandWord = "bye";

    public ByeCommand(){
        execute();
    }

    @Override
    public void execute() {
        Duke.getUi().printExit();
        System.exit(0);
    }

}

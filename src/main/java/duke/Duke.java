package duke;

import duke.command.Parser;
import duke.task.TaskList;

public class Duke {

    public static void main(String[] args) {
        Storage.loadFile(TaskList.Tasks);
        Ui.printGreeting();
        Parser.filterInput();
        Ui.printExit();
    }

}

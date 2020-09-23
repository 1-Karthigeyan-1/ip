package duke;

import duke.command.Parser;
import duke.task.TaskList;

public class Duke {

    private static Storage storage;
    private static Parser parse;
    private static Ui ui;

    public Duke(String filePath) {
        storage = new Storage(filePath);
        parse = new Parser();
        ui = new Ui();
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }

    public void run() {
        storage.loadFile(TaskList.Tasks);
        ui.printGreeting();
        parse.filterInput();
        ui.printExit();
    }

    public static Storage getStorage(){
        return storage;
    }

    public static Ui getUi() {
        return ui;
    }
}

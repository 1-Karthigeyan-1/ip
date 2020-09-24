package duke;

import duke.dataStorage.Storage;
import duke.task.TaskList;

public class Duke {

    private static Storage storage;
    private static Ui ui;
    private static TaskList tasks;

    public Duke(String filePath) {
        storage = new Storage(filePath);
        ui = new Ui();
        tasks = new TaskList();
        storage.loadFile();
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }

    public void run() {
        ui.printGreeting();
        while (true) {
            String userInput = Duke.getUi().readCommand();
            Parser.filterInput(userInput);
        }
    }

    public static Storage getStorage() {
        return storage;
    }

    public static Ui getUi() {
        return ui;
    }

    public static TaskList getTaskList() {
        return tasks;
    }
}

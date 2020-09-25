package duke;

import duke.dataStorage.Storage;
import duke.task.TaskList;

/**
 * Represents the main program of Duke
 */
public class Duke {

    private static Storage storage;
    private static Ui ui;
    private static TaskList tasks;

    /**
     * Creates instances of classes needed for the program to run.
     *
     * @param filePath filepath of storage file in hard drive
     */
    public Duke(String filePath) {
        storage = new Storage(filePath);
        ui = new Ui();
        tasks = new TaskList();
        storage.loadFile();
    }

    /**
     * Runs an instance of Duke.
     */
    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }

    /**
     * Prints greeting and runs the user inputs.
     */
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

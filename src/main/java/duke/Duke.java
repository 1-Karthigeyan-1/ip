package duke;

import duke.command.Command;
import duke.task.Task;

public class Duke {
    public static final int MAX_TASKS = 100;
    public static Task[] storeTask = new Task[MAX_TASKS];

    public static void main(String[] args) {
        Save.loadFile(storeTask);
        printGreeting();
        Command.filterInput();
        printExit();
    }

    public static void printBorder(String displayText) {
        String line = "____________________________________________________________\n";
        System.out.print(line + displayText + line);
    }

    public static void printGreeting() {
        String greet = "Hello! I'm duke.Duke\nWhat can I do for you?\n";
        printBorder(greet);
    }

    public static void printExit() {
        String exit = "Bye. Hope to see you again soon!\n";
        printBorder(exit);
    }

}

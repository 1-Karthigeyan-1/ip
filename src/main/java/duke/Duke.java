package duke;

import duke.command.Parser;
import duke.task.Task;

import java.util.ArrayList;

public class Duke {
    public static ArrayList<Task> Tasks = new ArrayList<Task>();

    public static void main(String[] args) {
        Storage.loadFile(Tasks);
        printGreeting();
        Parser.filterInput();
        printExit();
    }

    public static void printBorder(String displayText) {
        String line = "____________________________________________________________\n";
        System.out.print(line + displayText + line);
    }

    public static void printGreeting() {
        String greet = "Hello! I'm Duke\nWhat can I do for you?\n";
        printBorder(greet);
    }

    public static void printExit() {
        String exit = "Bye. Hope to see you again soon!\n";
        printBorder(exit);
    }

}

import java.util.Scanner;
import java.util.Arrays;

public class Duke {

    public static void main(String[] args) {
        startGreeting();
        Command.filterInput();
        exitCommand();
    }

    public static void textSeparator(String displayText) {
        String line = "____________________________________________________________\n";
        System.out.print(line + displayText + line);
    }

    public static void startGreeting() {
        String greet = "Hello! I'm Duke\nWhat can I do for you?\n";
        textSeparator(greet);
    }

    public static void exitCommand() {
        String exit = "Bye. Hope to see you again soon!\n";
        textSeparator(exit);
    }

    public static void completeTask(Task[] storeTask,String command) {
        String[] splitString = command.split(" ");
        int taskNumber = Integer.parseInt(splitString[1]) - 1;
        Task taskItem = storeTask[taskNumber];
        taskItem.isCompleted();
        textSeparator("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }

}

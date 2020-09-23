package duke;

public class Ui {
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

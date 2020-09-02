public class Duke {

    public static void main(String[] args) {
        printGreeting();
        Command.filterInput();
        printExit();
    }

    public static void textBorder(String displayText) {
        String line = "____________________________________________________________\n";
        System.out.print(line + displayText + line);
    }

    public static void printGreeting() {
        String greet = "Hello! I'm Duke\nWhat can I do for you?\n";
        textBorder(greet);
    }

    public static void printExit() {
        String exit = "Bye. Hope to see you again soon!\n";
        textBorder(exit);
    }

}

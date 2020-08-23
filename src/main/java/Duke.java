import java.util.Scanner;

public class Duke {

    private static String line = "____________________________________________________________\n";

    public static void startGreeting() {
        String greet = "Hello! I'm Duke\nWhat can I do for you?\n";
        System.out.println(line + greet + line);
    }

    public static void echoCommand(String command) {
        System.out.println(line + command + "\n" + line);
    }

    public static void exitCommand(String command) {
        String exit = "Bye. Hope to see you again soon!\n";
        System.out.println(line + exit + line);
    }

    public static void main(String[] args) {
        startGreeting();
        String command;
        Scanner in = new Scanner(System.in);

        while (!((command = in.nextLine()).equals("bye"))) {
            echoCommand(command);
        }

        exitCommand(command);
    }
}

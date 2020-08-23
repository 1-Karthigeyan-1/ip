import java.util.Scanner;
import java.util.Arrays;

public class Duke {

    private static String line = "____________________________________________________________\n";

    public static void startGreeting() {
        String greet = "Hello! I'm Duke\nWhat can I do for you?\n";
        System.out.println(line + greet + line);
    }

    public static void exitCommand(String command) {
        String exit = "Bye. Hope to see you again soon!\n";
        System.out.println(line + exit + line);
    }
    public static void showList(String[] storeText) {
        System.out.println(line);
        int itemCount = 1;
        for (String item : storeText) {
            System.out.println(itemCount + ". " + item );
            itemCount++;
        }
        System.out.println(line);
    }

    public static void main(String[] args) {
        startGreeting();
        String command;
        String[] storeText = new String[100];
        int textCount = 0;
        Scanner in = new Scanner(System.in);
        //Check for exit command
        while (!((command = in.nextLine()).equals("bye"))) {
            if (command.equals("list")) {
                showList(Arrays.copyOf(storeText, textCount));
            } else {
                storeText[textCount] = command;
                textCount++;
                System.out.println(line + "added: " + command + "\n" + line);
            }
        }

        exitCommand(command);
    }
}

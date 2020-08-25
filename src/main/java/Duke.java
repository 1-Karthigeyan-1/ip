import java.util.Scanner;
import java.util.Arrays;

public class Duke {

    private static String line = "____________________________________________________________";

    public static void main(String[] args) {
        startGreeting();
        String command;
        Task[] storeTask = new Task[100];
        int textCount = 0;
        Scanner in = new Scanner(System.in);
        //Check for exit command
        while (!((command = in.nextLine()).equals("bye"))) {
            if (command.equals("list")) {
                showList(Arrays.copyOf(storeTask, textCount));
            }
            else if (command.contains("done")) {
                String[] splitString = command.split(" ");
                int taskNumber = Integer.parseInt(splitString[1]);
                storeTask[taskNumber - 1].isCompleted();
                System.out.println(line);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + storeTask[taskNumber - 1].getStatusIcon() + "] " + storeTask[taskNumber - 1].getDescription() );
                System.out.println(line);

            } else {
                storeTask[textCount] = new Task(command);
                System.out.println(line);
                System.out.println("added: " + storeTask[textCount].getDescription());
                System.out.println(line);
                textCount++;
            }
        }

        exitCommand(command);
    }

    public static void startGreeting() {
        String greet = "Hello! I'm Duke\nWhat can I do for you?";
        System.out.println(line);
        System.out.println(greet);
        System.out.println(line);
    }

    public static void exitCommand(String command) {
        String exit = "Bye. Hope to see you again soon!\n";
        System.out.println(line);
        System.out.println(exit);
        System.out.println(line);
    }

    public static void showList(Task[] storeText) {
        int itemCount = 1;
        System.out.println(line);
        System.out.println("Here are the tasks in your list:");
        for (Task item : storeText) {
            System.out.println(itemCount + ".[" + item.getStatusIcon() + "]" + item.getDescription() );
            itemCount++;
        }
        System.out.println(line);
    }
}

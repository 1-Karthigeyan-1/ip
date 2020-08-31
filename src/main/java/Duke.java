import java.util.Scanner;
import java.util.Arrays;

public class Duke {

    public static void main(String[] args) {
        String command;
        Task[] storeTask = new Task[100];
        int textCount = 0;
        Scanner in = new Scanner(System.in);

        startGreeting();

        while (!((command = in.nextLine()).equals("bye"))) {
            if (command.equals("list")) {
                showList(Arrays.copyOf(storeTask, textCount));
            } else if (command.contains("done")) {
                completeTask(storeTask, command);
            } else if (command.contains("todo")){
                String[] splittodo = command.split("todo ");
                storeTask[textCount] = new Todo(splittodo[1]);
                textSeparator(storeTask[textCount].printDescription() + "\n");
                textCount++;
            } else if (command.contains("deadline")) {
                String[] splitdeadline = command.split("deadline |/");
                storeTask[textCount] = new Deadline(splitdeadline[1], splitdeadline[2]);
                textSeparator(storeTask[textCount].printDescription() + "\n");
                textCount++;
            }

        }
        exitCommand(command);
    }

    public static void textSeparator(String displayText) {
        String line = "____________________________________________________________\n";
        System.out.print(line + displayText + line);
    }

    public static void startGreeting() {
        String greet = "Hello! I'm Duke\nWhat can I do for you?\n";
        textSeparator(greet);
    }

    public static void exitCommand(String command) {
        String exit = "Bye. Hope to see you again soon!\n";
        textSeparator(exit);
    }

    public static void showList(Task[] storeText) {
        int itemCount = 1;
        String itemList = "";
        for (Task item : storeText) {
            itemList += Integer.toString(itemCount) + ". "  +  item.printDescription() + "\n";
            itemCount++;
        }
        textSeparator("Here are the tasks in your list:\n" + itemList);
    }

    public static void completeTask(Task[] storeTask,String command) {
        String[] splitString = command.split(" ");
        int taskNumber = Integer.parseInt(splitString[1]) - 1;
        Task taskItem = storeTask[taskNumber];
        taskItem.isCompleted();
        textSeparator("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }

}

import java.util.Scanner;
import java.util.Arrays;

public class Duke {

    public static void main(String[] args) {
        String command;
        String firstArgument;
        Task[] storeTask = new Task[100];
        Scanner in = new Scanner(System.in);

        startGreeting();

        while (!((command = in.nextLine()).equals("bye"))) {
            firstArgument = Command.parseArgument(command);
            switch(firstArgument) {
            case Command.LIST:
                List.showList(Arrays.copyOf(storeTask, Task.taskCount));
                break;
            case Command.DONE:
                completeTask(storeTask, command);
                break;
            case Command.TODO:
                String[] splittodo = command.split("todo ");
                storeTask[Task.taskCount] = new Todo(splittodo[1]);
                textSeparator("Got it. I've added this task:\n"
                        + storeTask[Task.taskCount].printDescription() + "\n");
                Task.taskCount++;
                break;
            case Command.DEADLINE:
                String[] splitdeadline = command.split("deadline |/by");
                storeTask[Task.taskCount] = new Deadline(splitdeadline[1], splitdeadline[2]);
                textSeparator("Got it. I've added this task:\n"
                        + storeTask[Task.taskCount].printDescription() + "\n");
                Task.taskCount++;
                break;
            case Command.EVENT:
                String[] splitevent = command.split("event |/at");
                storeTask[Task.taskCount] = new Event(splitevent[1], splitevent[2]);
                textSeparator("Got it. I've added this task:\n"
                        + storeTask[Task.taskCount].printDescription() + "\n");
                Task.taskCount++;
                break;
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

    public static void completeTask(Task[] storeTask,String command) {
        String[] splitString = command.split(" ");
        int taskNumber = Integer.parseInt(splitString[1]) - 1;
        Task taskItem = storeTask[taskNumber];
        taskItem.isCompleted();
        textSeparator("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }

}

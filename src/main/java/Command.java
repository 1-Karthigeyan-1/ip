import java.util.Arrays;
import java.util.Scanner;

public class Command {
    public static final String LIST = "list";
    public static final String BYE = "bye";
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DONE = "done";


    public static void filterInput() {
        Task[] storeTask = new Task[100];
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine();
            String firstArgument = Command.parseArgument(command);
            switch(firstArgument) {
            case Command.LIST:
                    ListCommand.showList(Arrays.copyOf(storeTask, Task.taskCount));
                    break;
            case Command.DONE:
                    Duke.completeTask(storeTask, command);
                    break;
            case Command.TODO:
                    String[] splittodo = command.split("todo ");
                    storeTask[Task.taskCount] = new Todo(splittodo[1]);
                    Duke.textSeparator("Got it. I've added this task:\n"
                            + storeTask[Task.taskCount].printDescription() + "\n");
                    Task.taskCount++;
                    break;
            case Command.DEADLINE:
                    String[] splitdeadline = command.split("deadline |/by");
                    storeTask[Task.taskCount] = new Deadline(splitdeadline[1], splitdeadline[2]);
                    Duke.textSeparator("Got it. I've added this task:\n"
                            + storeTask[Task.taskCount].printDescription() + "\n");
                    Task.taskCount++;
                    break;
            case Command.EVENT:
                    String[] splitevent = command.split("event |/at");
                    storeTask[Task.taskCount] = new Event(splitevent[1], splitevent[2]);
                    Duke.textSeparator("Got it. I've added this task:\n"
                            + storeTask[Task.taskCount].printDescription() + "\n");
                    Task.taskCount++;
                    break;
            case Command.BYE:
                    return;
            }

        }
    }


    public static String parseArgument (String argument) {
        String[] argumentList = argument.split(" ",2);
        return argumentList[0];
    }


}

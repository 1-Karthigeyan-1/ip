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
            String[] arguments = Command.parseArgument(command, " ", 2);
            switch(arguments[0]) {
            case LIST:
                Task.showList(Arrays.copyOf(storeTask, Task.taskCount));
                break;
            case DONE:
                Task.completeTask(storeTask, arguments[1]);
                break;
            case TODO:
                storeTask[Task.taskCount] = new Todo(arguments[1]);
                Task.addTask(storeTask[Task.taskCount]);
                break;
            case DEADLINE:
                arguments  = parseArgument(arguments[1],"/by", 0);
                storeTask[Task.taskCount] = new Deadline(arguments[0], arguments[1]);
                Task.addTask(storeTask[Task.taskCount]);
                break;
            case EVENT:
                arguments  = parseArgument(arguments[1],"/at", 2);
                storeTask[Task.taskCount] = new Event(arguments[0], arguments[1]);
                Task.addTask(storeTask[Task.taskCount]);
                break;
            case BYE:
                    return;
                    //Fallthrough
            }

        }
    }


    public static String[] parseArgument (String argument, String divider, int limit) {
        return argument.split(divider, limit );
    }


}

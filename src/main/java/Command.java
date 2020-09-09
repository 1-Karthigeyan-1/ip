import java.util.Arrays;
import java.util.Scanner;

public class Command {
    public static final String LIST = "list";
    public static final String BYE = "bye";
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DONE = "done";
    public static final int MAX_TASKS = 100;

    public static void filterInput() {
        Task[] storeTask = new Task[MAX_TASKS];
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine();
            String[] arguments = parseArgument(command, " ", 2);
            try {
                switch (arguments[0].toLowerCase()) {
                case LIST:
                    Task.showList(Arrays.copyOf(storeTask, Task.taskCount));
                    break;
                case DONE:
                    Task.completeTask(storeTask, arguments[1]);
                    break;
                case TODO:
                    Todo.addTodo(storeTask, arguments[1]);
                    break;
                case DEADLINE:
                    Deadline.addDeadline(storeTask, arguments[1]);
                    break;
                case EVENT:
                    Event.addEvent(storeTask, arguments[1]);
                    break;
                case BYE:
                    return;
                    //fall through
                default:
                    printInvalidCommand();
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                Duke.printBorder("The description of " + arguments[0] + " cannot be empty\n");
            } catch (NumberFormatException e) {
                Duke.printBorder("Please input a number for " + arguments[0] + "\n");
            } catch (DukeException e) {

            }
        }
    }

    public static String[] parseArgument (String argument, String divider, int limit) {
        String[] arguments = argument.split(divider, limit);
        return arguments;
    }

    public static void printInvalidCommand() {
        Duke.printBorder("Invalid command. Please try again.\n");
    }

}

package duke.command;

import duke.Duke;
import duke.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.Scanner;
import java.util.ArrayList;

public class Command {
    public static final String LIST = "list";
    public static final String BYE = "bye";
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DONE = "done";

    public static void filterInput() {
        ArrayList<Task> Tasks = new ArrayList<Task>();
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine();
            String[] arguments = parseArgument(command, " ", 2);
            try {
                switch (arguments[0].toLowerCase()) {
                case LIST:
                    Task.showList(Tasks);
                    break;
                case DONE:
                    Task.completeTask(Tasks, arguments[1]);
                    break;
                case TODO:
                    Todo.addTodo(Tasks, arguments[1]);
                    break;
                case DEADLINE:
                    Deadline.addDeadline(Tasks, arguments[1]);
                    break;
                case EVENT:
                    Event.addEvent(Tasks, arguments[1]);
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

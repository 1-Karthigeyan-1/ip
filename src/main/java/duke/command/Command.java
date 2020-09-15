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
    public static final String DELETE = "delete";

    public static void filterInput() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine();
            String[] arguments = parseArgument(command, " ", 2);
            try {
                switch (arguments[0].toLowerCase()) {
                case LIST:
                    Task.showList(Duke.Tasks);
                    break;
                case DONE:
                    Task.completeTask(Duke.Tasks, arguments[1]);
                    break;
                case TODO:
                    Todo.addTodo(Duke.Tasks, arguments[1]);
                    break;
                case DEADLINE:
                    Deadline.addDeadline(Duke.Tasks, arguments[1]);
                    break;
                case EVENT:
                    Event.addEvent(Duke.Tasks, arguments[1]);
                    break;
                case DELETE:
                    Task.deleteTask(Duke.Tasks, arguments[1]);
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
                //TODO do sth abt this
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

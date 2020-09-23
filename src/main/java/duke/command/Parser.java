package duke.command;

import duke.Duke;
import duke.DukeException;
import duke.Ui;
import duke.task.*;

import java.util.Scanner;

public class Parser {
    public static final String LIST = "list";
    public static final String BYE = "bye";
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DONE = "done";
    public static final String DELETE = "delete";

    public void filterInput() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine();
            String[] arguments = parseArgument(command, " ", 2);
            try {
                switch (arguments[0].toLowerCase()) {
                case LIST:
                    TaskList.showList(TaskList.Tasks);
                    break;
                case DONE:
                    Task.completeTask(TaskList.Tasks, arguments[1]);
                    break;
                case TODO:
                    Todo.addTodo(TaskList.Tasks, arguments[1]);
                    break;
                case DEADLINE:
                    Deadline.addDeadline(TaskList.Tasks, arguments[1]);
                    break;
                case EVENT:
                    Event.addEvent(TaskList.Tasks, arguments[1]);
                    break;
                case DELETE:
                    TaskList.deleteTask(TaskList.Tasks, arguments[1]);
                    break;
                case BYE:
                    return;
                    //fall through
                default:
                    printInvalidCommand();
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                Duke.getUi().printBorder("The description of " + arguments[0] + " cannot be empty\n");
            } catch (NumberFormatException e) {
                Duke.getUi().printBorder("Please input a number for " + arguments[0] + "\n");
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
        Duke.getUi().printBorder("Invalid command. Please try again.\n");
    }

}

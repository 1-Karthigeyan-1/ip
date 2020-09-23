package duke.command;

import duke.Duke;
import duke.DukeException;
import duke.Ui;
import duke.task.*;

import java.util.Scanner;

public class Parser {

    public void filterInput() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            command = in.nextLine();
            String[] arguments = parseArgument(command, " ", 2);
            try {
                switch (arguments[0].toLowerCase()) {
                case ListCommand.CommandWord:
                    new ListCommand(arguments[1]);
                    break;
                case DoneCommand.CommandWord:
                    new DoneCommand(arguments[1]);
                    break;
                case TodoCommand.CommandWord:
                    new TodoCommand(arguments[1]);
                    break;
                case DeadlineCommand.CommandWord:
                    new DeadlineCommand(arguments[1]);
                    break;
                case EventCommand.CommandWord:
                    new EventCommand(arguments[1]);
                    break;
                case DeleteCommand.CommandWord:
                    new DeleteCommand(arguments[1]);
                    break;
                case ByeCommand.CommandWord:
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

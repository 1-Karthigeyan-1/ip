package duke.command;

import duke.Duke;
import duke.DukeException;
import duke.Ui;
import duke.task.*;

import java.util.Scanner;

public class Parser {

    public void filterInput() {
        Scanner in = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            String userInput = in.nextLine();
            String[] arguments = parseArgument(userInput, " ", 2);
                switch (arguments[0].toLowerCase()) {
                case ListCommand.CommandWord:
                    new ListCommand();
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

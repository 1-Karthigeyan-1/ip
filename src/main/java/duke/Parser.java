package duke;

import duke.command.ByeCommand;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;

public class Parser {

    public static void filterInput(String userInput) {
        String[] arguments = parseArgument(userInput, " ", 2);
        switch (arguments[0].toLowerCase()) {
        case ListCommand.COMMAND_WORD:
            new ListCommand();
            break;
        case DoneCommand.COMMAND_WORD:
            new DoneCommand(arguments[1]);
            break;
        case TodoCommand.COMMAND_WORD:
            new TodoCommand(arguments[1]);
            break;
        case DeadlineCommand.COMMAND_WORD:
            new DeadlineCommand(arguments[1]);
            break;
        case EventCommand.COMMAND_WORD:
            new EventCommand(arguments[1]);
            break;
        case DeleteCommand.COMMAND_WORD:
            new DeleteCommand(arguments[1]);
            break;
        case ByeCommand.COMMAND_WORD:
            new ByeCommand();
            break;
        default:
            Duke.getUi().printBorder("Invalid command. Please try again.\n");
            break;
        }
    }

    public static String[] parseArgument (String argument, String divider, int limit) {
        String[] arguments = argument.split(divider, limit);
        return arguments;
    }

}

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
            new ByeCommand();
            break;
        default:
            Duke.getUi().printInvalidCommand();
            break;
        }
    }

    public static String[] parseArgument (String argument, String divider, int limit) {
        String[] arguments = argument.split(divider, limit);
        return arguments;
    }

}

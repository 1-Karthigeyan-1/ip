package duke.command;

import duke.task.Deadline;

/**
 * Represents the deadline command used in the user input
 */
public class DeadlineCommand extends CommandArgument{
    public static final String COMMAND_WORD = "deadline";

    public DeadlineCommand(String description) {
        super(description);
    }

    /**
     * Executes the deadline command by adding Deadlines to the program
     *
     * @param description Additional argument that comes after the deadline command.
     */
    @Override
    public void execute(String description) {
        Deadline.addDeadline(description);
    }

}

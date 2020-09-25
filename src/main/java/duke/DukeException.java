package duke;

/**
 * Handles error exception in Duke.
 */
public class DukeException extends Exception {
    public static final String EMPTY_LIST = "empty list";
    public static final String ILLEGAL_NUMBER = "illegal number";
    public static final String INVALID_TYPE = "invalid type";
    public static final String INVALID_DATETIME = "invalid DateTime";
    public static final String ARGUMENT_SIZE = "invalid number of arguments";
    public static final String INVALID_DESCRIPTION = "invalid description";

    /**
     * prints out the appropriate error based on the state of error.
     *
     * @param error State of the error
     */
    public DukeException(String error) {
        switch(error) {
        case EMPTY_LIST:
            Duke.getUi().printBorder("List is empty!!\n");
            break;
        case ILLEGAL_NUMBER:
            Duke.getUi().printBorder("Please input a valid number\n");
            break;
        case INVALID_TYPE:
            Duke.getUi().printBorder("Invalid Task type!\n");
            break;
        case INVALID_DATETIME:
            Duke.getUi().printBorder("Invalid Date or Time.\n Please enter in the following format:\n" +
                    "dd/MM/yyyy HHmm\n");
            break;
        case ARGUMENT_SIZE:
            Duke.getUi().printBorder("Check the number of arguments!\n");
            break;
        case INVALID_DESCRIPTION:
            Duke.getUi().printBorder("Description should not be blank!\n");
            break;
        default:
            Duke.getUi().printBorder("Error Unknown\n");
        }
    }
}

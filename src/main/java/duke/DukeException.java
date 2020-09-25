package duke;

/**
 * Handles error exception in Duke.
 */
public class DukeException extends Exception {
    public static final String EMPTY_LIST = "empty list";
    public static final String ILLEGAL_NUMBER = "illegal number";
    public static final String INVALID_TYPE = "invalid type";
    public static final String INVALID_DATETIME = "invalid DateTime";

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
        default:
            Duke.getUi().printBorder("Error Unknown\n");
        }
    }
}

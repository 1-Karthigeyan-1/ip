package duke;

public class DukeException extends Exception {
    public static final String EMPTY_LIST = "empty list";
    public static final String ILLEGAL_NUMBER = "illegal number";
    public static final String INVALID_TYPE = "invalid type";

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
        default:
            Duke.getUi().printBorder("Error Unknown\n");
        }
    }
}

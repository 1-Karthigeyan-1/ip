package duke;

public class DukeException extends Exception {
    protected static final String EMPTY_LIST = "empty list";
    protected static final String ILLEGAL_NUMBER = "illegal number";

    public DukeException(String error) {
        switch(error) {
        case EMPTY_LIST:
            Ui.printBorder("List is empty!!\n");
            break;
        case ILLEGAL_NUMBER:
            Ui.printBorder("Please input a valid number\n");
            break;
        }
    }
}

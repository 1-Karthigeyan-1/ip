package duke;

import java.util.Scanner;

public class Ui {

    public String readCommand(){
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        return userInput;
    }

    public void printBorder(String displayText) {
        String line = "____________________________________________________________\n";
        System.out.print(line + displayText + line);
    }

    public void printGreeting() {
        String welcomeMessage = "Hello! I'm Duke\nWhat can I do for you?\n";
        printBorder(welcomeMessage);
    }

    public void printExit() {
        String exitMessage = "Bye. Hope to see you again soon!\n";
        printBorder(exitMessage);
    }

    public void printNumberFormatError(String Argument) {
        String invalidNumber = Argument + " is not a valid number!\n";
        printBorder(invalidNumber);
    }
    public void printIndexError() {
        String invalidNumber = "Please enter a number in range!\n";
        printBorder(invalidNumber);
    }

    public void printNullError() {
        String nullErrorMessage = "Object is empty!\n";
        printBorder(nullErrorMessage);
    }

}

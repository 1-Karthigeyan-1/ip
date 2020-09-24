package duke;

import java.util.Scanner;

public class Ui {

    public void printBorder(String displayText) {
        String line = "____________________________________________________________\n";
        System.out.print(line + displayText + line);
    }

    public void printGreeting() {
        String welcomeMessage = "Hello! I'm Duke\nWhat can I do for you?\n";
        printBorder(welcomeMessage);
    }

    public void printExit() {
        String exit = "Bye. Hope to see you again soon!\n";
        printBorder(exit);
    }

    public void printInvalidCommand() {
        printBorder("Invalid command. Please try again.\n");
    }

    public String readCommand(){
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        return userInput;
    }
}

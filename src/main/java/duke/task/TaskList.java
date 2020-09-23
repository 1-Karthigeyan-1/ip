package duke.task;

import duke.DukeException;
import duke.Storage;
import duke.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    public static ArrayList<Task> Tasks = new ArrayList<Task>();

    public TaskList(){};

    public static void showList(ArrayList<Task> Tasks) throws DukeException {
        if (Tasks.size() == 0) {
            throw new DukeException("empty list");
        }
        String itemList = "";
        for (int item = 0 ; item < Tasks.size() ; item++) {
            itemList += (item + 1) + ". "  +  Tasks.get(item).printDescription() + "\n";
        }
        Ui.printBorder("Here are the tasks in your list:\n" + itemList);
    }

    public static void addTask(ArrayList<Task> Tasks, Task item) {
        Tasks.add(item);
        Storage.appendFile(item);
        Ui.printBorder("Got it. I've added this task:\n" + item.printDescription() + "\n");
    }

    public static void deleteTask(ArrayList<Task> Tasks, String argument) {
        String removalNotice = "Noted. I've removed this task:\n";
        //TODO throw number format exception && check for valid number
        int taskNumber = Integer.parseInt(argument);
        Task deletedObject = Tasks.get(taskNumber - 1);
        Tasks.remove(taskNumber - 1);
        try {
            Storage.writeFile(Tasks);
        }catch(IOException e){
            System.out.println("Unable to save changes\n");
        }
        String remainingTask = "Now you have " + Tasks.size() + " tasks in the list\n";
        //TODO abstract print number of Tasks
        Ui.printBorder(removalNotice + "  " + deletedObject.printDescription() + "\n" + remainingTask);
    }
}

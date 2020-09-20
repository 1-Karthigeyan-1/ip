package duke.task;

import duke.Duke;
import duke.DukeException;
import duke.Storage;

import java.util.ArrayList;
import java.io.IOException;


public class Task {
    protected String description;
    protected boolean isDone;
    private static final String taskType = "Dummy";


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void isCompleted() {
        this.isDone = true;
    }

    public String getDescription() {
        return this.description;
    }

    public String printDescription() {
        String output = "[" + getStatusIcon() + "] " + getDescription();
        return output;
    }

    public static void addTask(ArrayList<Task> Tasks, Task item) {
        Tasks.add(item);
        Storage.appendFile(item);
        Duke.printBorder("Got it. I've added this task:\n" + item.printDescription() + "\n");
    }

    public static void completeTask(ArrayList<Task> Tasks,String argument) throws DukeException {
        int taskNumber = Integer.parseInt(argument) ;
        if ((taskNumber > Tasks.size()) || (taskNumber <= 0)) {
            throw new DukeException("illegal number");
        }
        Task taskItem = Tasks.get(taskNumber-1);
        taskItem.isCompleted();
        try {
            Storage.writeFile(Tasks);
        }catch(IOException e){
            System.out.println("Unable to save changes\n");
        }
        Duke.printBorder("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }

    public static void showList(ArrayList<Task> Tasks) throws DukeException {
        if (Tasks.size() == 0) {
            throw new DukeException("empty list");
        }
        String itemList = "";
        for (int item = 0 ; item < Tasks.size() ; item++) {
            itemList += Integer.toString(item+1) + ". "  +  Tasks.get(item).printDescription() + "\n";
        }
        Duke.printBorder("Here are the tasks in your list:\n" + itemList);
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
        Duke.printBorder(removalNotice + "  " + deletedObject.printDescription() + "\n" + remainingTask);
    }

    public String getTaskType() {
        return taskType;
    }


}

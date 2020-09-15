package duke.task;

import duke.Duke;
import duke.DukeException;
import duke.Save;

import java.io.IOException;

public class Task {
    protected String description;
    protected boolean isDone;
    public static int taskCount = 0;
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

    public static void addTask(Task item) {
        Save.appendFile(item);
        Task.taskCount++;
        Duke.printBorder("Got it. I've added this task:\n" + item.printDescription() + "\n");

    }

    public static void completeTask(Task[] storeTask,String argument) throws DukeException {
        int taskNumber = Integer.parseInt(argument) ;
        if ((taskNumber > taskCount) || (taskNumber <= 0)) {
            throw new DukeException("illegal number");
        }
        Task taskItem = storeTask[taskNumber-1];
        taskItem.isCompleted();
        try {
            Save.writeFile(storeTask);
        }catch(IOException e){
            System.out.println("Unable to save changes\n");
        }
        Duke.printBorder("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }

    public static void showList(Task[] storeText) throws DukeException {
        if (taskCount == 0) {
            throw new DukeException("empty list");
        }
        String itemList = "";
        for (int item = 0 ; item < taskCount ; item++) {
            itemList += Integer.toString(item+1) + ". "  +  storeText[item].printDescription() + "\n";
        }
        Duke.printBorder("Here are the tasks in your list:\n" + itemList);
    }

    public String getTaskType() {
        return taskType;
    }


}

package duke.task;

import duke.Duke;
import duke.DukeException;
import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;
    public static int taskCount = 0;

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
        Task.taskCount++;
        Duke.printBorder("Got it. I've added this task:\n" + item.printDescription() + "\n");
    }

    public static void completeTask(ArrayList<Task> Tasks,String argument) throws DukeException {
        int taskNumber = Integer.parseInt(argument) ;
        if ((taskNumber > taskCount) || (taskNumber <= 0)) {
            throw new DukeException("illegal number");
        }
        Task taskItem = Tasks.get(taskNumber-1);
        taskItem.isCompleted();
        Duke.printBorder("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }

    public static void showList(ArrayList<Task> Tasks) throws DukeException {
        if (taskCount == 0) {
            throw new DukeException("empty list");
        }
        String itemList = "";
        for (int item = 0 ; item < taskCount ; item++) {
            itemList += Integer.toString(item+1) + ". "  +  Tasks.get(item).printDescription() + "\n";
        }
        Duke.printBorder("Here are the tasks in your list:\n" + itemList);
    }


}

package duke.task;

import duke.DukeException;
import duke.Storage;
import duke.Ui;

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

    public void completeTask() {
        this.isDone = true;
    }

    public String getDescription() {
        return this.description;
    }

    public String printDescription() {
        String output = "[" + getStatusIcon() + "] " + getDescription();
        return output;
    }

    public static void completeTask(ArrayList<Task> Tasks,String argument) throws DukeException {
        int taskNumber = Integer.parseInt(argument) ;
        if ((taskNumber > Tasks.size()) || (taskNumber <= 0)) {
            throw new DukeException("illegal number");
        }
        Task taskItem = Tasks.get(taskNumber-1);
        taskItem.completeTask();
        try {
            Storage.writeFile(Tasks);
        }catch(IOException e){
            System.out.println("Unable to save changes\n");
        }
        Ui.printBorder("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }

    public String getTaskType() {
        return taskType;
    }


}

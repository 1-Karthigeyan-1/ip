package duke.task;

import duke.Duke;
import duke.DukeException;

import java.io.IOException;


public abstract class Task {
    protected String description;
    protected boolean isDone;

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

    public static void completeTask(String argument) throws DukeException {
        TaskList Tasks = Duke.getTaskList();
        int taskNumber = Integer.parseInt(argument) ;
        if ((taskNumber > Tasks.getSize()) || (taskNumber <= 0)) {
            throw new DukeException("illegal number");
        }
        Task taskItem = Tasks.getTask(taskNumber-1);
        taskItem.completeTask();
        Duke.getStorage().writeFile();
        Duke.getUi().printBorder("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }

    public abstract String getTaskType();

}

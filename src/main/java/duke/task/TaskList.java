package duke.task;

import duke.Duke;
import duke.DukeException;


import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> Tasks;

    public TaskList(){
        Tasks = new ArrayList<Task>();
    };


    public void showList() throws DukeException {
        if (Tasks.size() == 0) {
            throw new DukeException("empty list");
        }
        String itemList = "";
        for (int item = 0 ; item < this.getSize() ; item++) {
            itemList += (item + 1) + ". "  +  Tasks.get(item).printDescription() + "\n";
        }
        Duke.getUi().printBorder("Here are the tasks in your list:\n" + itemList);
    }

    public void addTask(Task item, boolean isReadOnly) {
        Tasks.add(item);
        if(!isReadOnly) {
            Duke.getStorage().saveData(item);
            Duke.getUi().printBorder("Got it. I've added this task:\n" + item.printDescription() + "\n");
        }
    }

    public void deleteTask(String argument) {
        String removalNotice = "Noted. I've removed this task:\n";
        //TODO throw number format exception && check for valid number
        int taskNumber = Integer.parseInt(argument);
        Task deletedObject = Tasks.get(taskNumber - 1);
        Tasks.remove(taskNumber - 1);
        try {
            Duke.getStorage().writeFile();
        }catch(IOException e){
            System.out.println("Unable to save changes\n");
        }
        String remainingTask = "Now you have " + Tasks.size() + " tasks in the list\n";
        //TODO abstract print number of Tasks
        Duke.getUi().printBorder(removalNotice + "  " + deletedObject.printDescription() + "\n" + remainingTask);
    }

    public Task getTask(int index){
        return Tasks.get(index);
    }

    public int getSize(){
        return Tasks.size();
    }

}

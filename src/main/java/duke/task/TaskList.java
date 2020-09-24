package duke.task;

import duke.Duke;
import duke.DukeException;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> Tasks;

    public TaskList(){
        Tasks = new ArrayList<Task>();
    }

    public void markTaskinList(String argument) throws DukeException {
        int taskNumber = Integer.parseInt(argument);
        if ((taskNumber > this.getSize()) || (taskNumber <= 0)) {
            throw new DukeException("illegal number");
        }
        Task taskItem = this.getTask(taskNumber-1);
        taskItem.completeTask();
        Duke.getStorage().writeFile();
        Duke.getUi().printBorder("Nice! I've marked this task as done:\n" + taskItem.printDescription() + "\n");
    }


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
        try {
            String removalNotice = "Noted. I've removed this task:\n";
            int taskNumber = Integer.parseInt(argument);
            Task deletedObject = this.getTask(taskNumber - 1);
            Tasks.remove(taskNumber - 1);
            Duke.getStorage().writeFile();
            String remainingTask = "Now you have " + this.getSize() + " tasks in the list\n";
            Duke.getUi().printBorder(removalNotice + "  " + deletedObject.printDescription() + "\n" + remainingTask);
        } catch (NumberFormatException e) {
            Duke.getUi().printNumberFormatError(argument);
        } catch (IndexOutOfBoundsException e) {
            Duke.getUi().printIndexError();
        }
    }

    public Task getTask(int index){
        return Tasks.get(index);
    }

    public int getSize(){
        return Tasks.size();
    }

}

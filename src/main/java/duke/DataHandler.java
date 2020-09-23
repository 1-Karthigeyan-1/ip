package duke;

import duke.command.Parser;
import duke.task.*;

import java.io.FileWriter;
import java.io.IOException;

public class DataHandler {

    public static void decompileData(String Data, int index){
        Task item;
        String[] arguments = Parser.parseArgument(Data, " , ", 0);
        TaskList Tasks = Duke.getTaskList();
        switch (arguments[0]) {
        case "T":
            item = new Todo(arguments[2]);
            break;
        case "E":
            item = new Event(arguments[2], arguments[3]);
            break;
        case "D":
            item = new Deadline(arguments[2], arguments[3]);
            break;
        default:
            item = null;
            System.out.println("Unable to load this set of data...Data corrupted");
            break;
        }
        //TODO add exception
        if (arguments[1].equals("\u2713")) {
            item.completeTask();
        }
        Tasks.addTask(item, true);
    }

    public static void CompileData(Task item, String description, String taskType, String done, FileWriter appendWrite) throws IOException {
        switch (taskType) {
        case "T":
            appendWrite.write(String.format("%s , %s , %s\n", taskType, done, description));
            break;
        case "E":
            String date = ((Event) item).getDate();
            appendWrite.write(String.format("%s , %s , %s , %s\n", taskType, done, description, date));
            break;
        case "D":
            String by = ((Deadline) item).getBy();
            appendWrite.write(String.format("%s , %s , %s , %s\n", taskType, done, description, by));
            break;
        default:
            System.out.println("Save Error!");
            break;
        }
    }
}

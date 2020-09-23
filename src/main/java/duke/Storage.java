package duke;

import duke.task.*;
import duke.command.Parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public File findFile() {
        File storage = new File(filePath);

        if (!storage.exists()) {
            Duke.getUi().printBorder("File does not exist, Attempting to create one....\n");
            storage = createFile();

        }
        Duke.getUi().printBorder("File found! Accessing Data...\n");
        return storage;

    }

    public File createFile() {
        File storage = new File(filePath);
        try {
            if (!storage.getParentFile().exists()) {
                storage.getParentFile().mkdirs();
            }
            storage.createNewFile();
        } catch (java.io.IOException e) {
            Duke.getUi().printBorder("Unable to create file...Cri\n");
        }
        Duke.getUi().printBorder("File created in " + storage.getAbsolutePath() + "\n");
        return storage;
    }

    public void loadFile() {
        File storage = findFile();
        Scanner storageData;
        try {
            storageData = new Scanner(storage);
        } catch (FileNotFoundException e) {
            Duke.getUi().printBorder("Error has occurred! File not found!\n");
            return;
        }
        String Data;
        int i = 0;

        while (storageData.hasNext()) {
            Data = storageData.nextLine();
            String[] arguments = Parser.parseArgument(Data, " , ", 0);
            TaskList Tasks = Duke.getTaskList();
            switch (arguments[0]) {
            case "T":
                Tasks.addTask(new Todo(arguments[2]), true);
                break;
            case "E":
                Tasks.addTask(new Event(arguments[2], arguments[3]), true);
                break;
            case "D":
                Tasks.addTask(new Deadline(arguments[2], arguments[3]), true);
                break;
            default:
                System.out.println("Unable to load this set of data...Data corrupted");
                break;
            }
            if (arguments[1].equals("\u2713")) {
                Tasks.getTask(i).completeTask();
            }
            i++;
        }
        Duke.getUi().printBorder("Finished loading.\n");
    }

    public void appendFile(Task item) {
        String description = item.getDescription();
        String taskType = item.getTaskType();
        String done = item.getStatusIcon();
        try {
            FileWriter appendWrite = new FileWriter(filePath, true);
            filterTask(item, description, taskType, done, appendWrite);
            appendWrite.close();
        } catch (java.io.IOException e) {
            System.out.println("Oh no! IOException has occurred!");
        }
        System.out.println("Save complete");
    }

    public void filterTask(Task item, String description, String taskType, String done, FileWriter appendWrite) throws IOException {
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

    public void writeFile() throws IOException {
        FileWriter overWrite = new FileWriter(filePath, false);
        for (int i = 0; i < Duke.getTaskList().getSize(); i++){
            Task item = Duke.getTaskList().getTask(i);
            String description = item.getDescription();
            String taskType = item.getTaskType();
            String done = item.getStatusIcon();
            filterTask(item, description, taskType, done, overWrite);
        }
        overWrite.close();
        System.out.println("Save complete");
    }

}

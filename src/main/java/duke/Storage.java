package duke;

import duke.task.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Storage {
    private String filePath;
    private File storageText;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.storageText = new File(filePath);
    }

    public File findFile() {
        if (!storageText.exists()) {
            Duke.getUi().printBorder("File does not exist, Attempting to create one....\n");
            storageText = createFile();

        }
        Duke.getUi().printBorder("File found! Accessing Data...\n");
        return storageText;

    }

    public File createFile() {
        try {
            if (!storageText.getParentFile().exists()) {
                storageText.getParentFile().mkdirs();
            }
            storageText.createNewFile();
        } catch (IOException e) {
            Duke.getUi().printBorder("Unable to create file...Cri\n");
        }
        Duke.getUi().printBorder("File created in " + storageText.getAbsolutePath() + "\n");
        return storageText;
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
        String data;
        int index = 0;

        while (storageData.hasNext()) {
            data = storageData.nextLine();
            DataHandler.decompileData(data, index);
            index++;
        }
        Duke.getUi().printBorder("Finished loading.\n");
    }

    public void saveData(Task item) {
        String description = item.getDescription();
        String taskType = item.getTaskType();
        String done = item.getStatusIcon();
        try {
            FileWriter appendWrite = new FileWriter(filePath, true);
            DataHandler.CompileData(item, description, taskType, done, appendWrite);
            appendWrite.close();
        } catch (java.io.IOException e) {
            System.out.println("Oh no! IOException has occurred!");
        }
        System.out.println("Save complete");
    }

    //TODO solve io exception
    public void writeFile() throws IOException {
        FileWriter overWrite = new FileWriter(filePath, false);
        for (int i = 0; i < Duke.getTaskList().getSize(); i++){
            Task item = Duke.getTaskList().getTask(i);
            String description = item.getDescription();
            String taskType = item.getTaskType();
            String done = item.getStatusIcon();
            DataHandler.CompileData(item, description, taskType, done, overWrite);
        }
        overWrite.close();
        System.out.println("Save complete");
    }

}

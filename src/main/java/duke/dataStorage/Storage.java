package duke.dataStorage;

import duke.Duke;
import duke.task.Task;

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

        while (storageData.hasNext()) {
            String data = storageData.nextLine();
            ExtractableData.ExtractData(data);
        }
        Duke.getUi().printBorder("Finished loading.\n");
    }

    public void saveData(Task item) {
        try {
            FileWriter appendWrite = new FileWriter(filePath, true);
            String data = CompilableData.CompileData(item);
            appendWrite.write(data);
            appendWrite.close();
            } catch (IOException e) {
                Duke.getUi().printBorder("Unable to Save!");
            }
        System.out.println("Save complete");
    }

    //TODO solve io exception
    public void writeFile() {
        try {
            FileWriter overWrite = new FileWriter(filePath, false);
            String data = "";
            for (int i = 0; i < Duke.getTaskList().getSize(); i++) {
                Task item = Duke.getTaskList().getTask(i);
                data += CompilableData.CompileData(item);
            }
            overWrite.write(data);
            overWrite.close();
        } catch (IOException e) {
            Duke.getUi().printBorder("Unable to Save!");
        }
        System.out.println("Save complete");
    }

}

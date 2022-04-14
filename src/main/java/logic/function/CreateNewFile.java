package logic.function;

import java.io.File;
import java.io.IOException;


public class CreateNewFile {

    public CreateNewFile(/*String fileName, String currentFolder*/) {
    }

    public void createFile(String fileName, String currentFolder) { //создать файл
        File file = new File(currentFolder + "\\" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Невозможно создать файл!");
        }
        //listOfFiles();
    }
}

package logic.function;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class DeleteDirectory {

    public DeleteDirectory(/*String sourceDirectory, String currentFolder*/) {
    }

    public void deleteDirectory(String sourceDirectory, String currentFolder) {
        File source  = new File(currentFolder + "\\" + sourceDirectory);
        try {
            FileUtils.deleteDirectory(source);
        } catch (IOException e) {
            System.out.println("Невозможно удалить каталог.");
        }
        //listOfFiles();
    }
}

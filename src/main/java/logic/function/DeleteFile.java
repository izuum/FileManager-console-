package logic.function;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static logic.function.ListOfFilesWithSize.listOfFiles;

public class DeleteFile {

    public DeleteFile(/*String sourceFile, String currentFolder*/) {
    }

    public static void deleteFile(String sourceFile, String currentFolder) {
        File srcFile = new File(currentFolder + "\\" + sourceFile);
        try {
            FileUtils.delete(srcFile);
        } catch (IOException e) {
            System.out.println("Невозможно удалить файл.");
        }
        listOfFiles();
    }
}

package logic.function;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static logic.function.ListOfFilesWithSize.listOfFiles;

public class CopyFile {

    public CopyFile(/*String sourceFile, String destFile, String currentFolder*/) {
    }

    public static Object copyFile(String sourceFile, String destFile, String currentFolder) { // копирует файл из одного в другой
        File source = new File(currentFolder + "\\" + sourceFile);
        File dest = new File(currentFolder + "\\" + destFile);
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно скопировать файл!");
        }
        listOfFiles();
        return null;
    }
}

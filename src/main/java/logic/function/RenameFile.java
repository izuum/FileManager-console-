package logic.function;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static logic.function.ListOfFilesWithSize.listOfFiles;

public class RenameFile {

    public RenameFile(/*String fileSource, String fileDest, String currentFolder*/) {
    }

    public static void renameFile(String fileSource, String fileDest, String currentFolder) { //переименовать файл
        File source = new File(currentFolder + "\\" + fileSource);
        File dest = new File(currentFolder + "\\" + fileDest);
        try {
            FileUtils.moveFile(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно переименовать файл!");
        }
        listOfFiles();
    }
}

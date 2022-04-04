package logic.function;

import java.io.File;

import static logic.function.ListOfFilesWithSize.listOfFiles;

public class MakeDirectory {

    public MakeDirectory(/*String newFolderName, String currentFolder*/) {
    }

    public static void makeDirectory(String newFolderName, String currentFolder) { // создать папку
        File file = new File(currentFolder + "\\" + newFolderName);
        file.mkdir();
        listOfFiles();
    }
}

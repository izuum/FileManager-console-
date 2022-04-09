package logic.function;

import java.io.File;


public class MakeDirectory {

    public MakeDirectory(/*String newFolderName, String currentFolder*/) {
    }

    public void makeDirectory(String newFolderName, String currentFolder) { // создать папку
        File file = new File(currentFolder + "\\" + newFolderName);
        file.mkdir();
        //listOfFiles();
    }
}

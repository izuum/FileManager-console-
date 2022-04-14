package logic.function;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;




public class RenameDirectory {

    public RenameDirectory(/*String sourceDirectory, String destDirectory, String currentFolder*/) {
    }

    public void renameDirectory(String sourceDirectory, String destDirectory, String currentFolder) { //переименовать папку
        File source = new File(currentFolder + "\\" + sourceDirectory);
        File dest = new File(currentFolder + "\\" + destDirectory);
        try {
            FileUtils.moveDirectory(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно переименовать папку");
        }
//        listOfFiles(true);
    }
}

package logic.function;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class MoveToDirectory {

    public MoveToDirectory(/*String srcFile, String destDir, String currentFolder*/) {
    }

    public void moveToDirectory(String srcFile, String destDir, String currentFolder) {
        boolean createDir;
        File sourceFile = new File(currentFolder + "\\" + srcFile);
        File destDirectory = new File(currentFolder + "\\" + destDir);
        try {
            if(destDir==null){
                createDir = true;
            }else{
                createDir = false;
            }
            FileUtils.moveToDirectory(sourceFile, destDirectory, createDir);
        } catch (IOException e) {
            System.out.println("Перемещение невозможно.");
        }
        //listOfFiles();
    }

}

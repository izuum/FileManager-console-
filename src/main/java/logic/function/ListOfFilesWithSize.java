package logic.function;

import org.apache.commons.io.FileUtils;

import java.io.File;

import static logic.uttils.StartPoint.getCurrentFolder;

public class ListOfFilesWithSize {

    public static Object listOfFiles() { //выводит список файлов, если true - выводит с размером файла/папки
        File currentFolderAsFile = new File(getCurrentFolder());
        File[] files = currentFolderAsFile.listFiles();
        System.out.println("------------------------");
        System.out.println("Path: " + getCurrentFolder());
        System.out.println("------------------------");
        for (File file : files) {
            if(file.isDirectory()){
                System.out.print(file.getName() + "\\ " + FileUtils.byteCountToDisplaySize(FileUtils.sizeOfDirectory(file)));
            }else{
                System.out.print(file.getName() + " " + FileUtils.byteCountToDisplaySize(file.length()));
            }
            System.out.println();
        }
        System.out.println("------------------------");
        System.out.print(">: ");
        return null;
    }
}

package logic.function;

import org.apache.commons.io.FileUtils;

import java.io.File;

import static logic.uttils.StartPoint.getCurrentFolder;

public class ListOfFiles {

    public static void listOfFiles() { //выводит список файлов, если true - выводит с размером файла/папки
        File currentFolderAsFile = new File(getCurrentFolder());
        File[] files = currentFolderAsFile.listFiles();
        System.out.println("------------------------");
        System.out.println("Path: " + getCurrentFolder());
        System.out.println("------------------------");
        for (File file : files) {
            if(file.isDirectory()){
                    System.out.print(file.getName() + "\\ ");
            }else{
                    System.out.print(file.getName() + " ");
                }
            System.out.println();
        }
        System.out.println("------------------------");
        System.out.print(">: ");
    }
}

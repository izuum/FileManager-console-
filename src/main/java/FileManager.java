import org.apache.commons.io.FileUtils;

import java.io.*;

public class FileManager {
    private String currentFolder;
    private String root;

    public FileManager(String currentFolder) {
        this.currentFolder = currentFolder;
        this.root = currentFolder;
    }

    public void listOfFiles(boolean sizeOfFiles) { //выводит список файлов, если true - выводит с размером файла/папки
        File currentFolderAsFile = new File(currentFolder);
        File[] files = currentFolderAsFile.listFiles();
        System.out.println("Path: " + currentFolder);
        System.out.println();
        for (File file : files) {
            if(file.isDirectory()){
                if(sizeOfFiles){
                    System.out.print(file.getName() + "\\ " + FileUtils.byteCountToDisplaySize(FileUtils.sizeOfDirectory(file)));
                }else{
                    System.out.print(file.getName() + "\\ ");
                }
            }else{
                if(sizeOfFiles){
                    System.out.print(file.getName() + " " + FileUtils.byteCountToDisplaySize(file.length()));
                }else{
                    System.out.print(file.getName() + " ");
                }
            }
            System.out.println();
        }
    }

    public void copyFile(String sourceFile, String destFile) { // копирует файл из одного в другой
        File source = new File(currentFolder + "\\" + sourceFile);
        File dest = new File(currentFolder + "\\" + destFile);
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно скопировать файл!");
        }
    }

    public void changeDirectory(String folderName) { //сменить папку. если "/" - перейти в корень
        if (folderName.equals("/")){                 // если ".." - выйти на уровень выше
            this.currentFolder = this.root;         // иначе перейти в нужную папку
        }else if (folderName.equals("..")){
            int indexOfLastPosition = this.currentFolder.lastIndexOf("\\");
            this.currentFolder = this.currentFolder.substring(0, indexOfLastPosition);
        }else{
            this.currentFolder = this.currentFolder + "\\" + folderName;
        }
    }

    public void createFile(String fileName) { //создать файл
        File file = new File(currentFolder + "\\" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Невозможно создать файл!");
        }
    }

    public void makeDirectory(String newFolderName) { // создать папку
        File file = new File(currentFolder + "\\" + newFolderName);
        file.mkdir();
    }

    public void contentFile(String thisFileName) { //открыть файл
        File file = new File(currentFolder + "\\" + thisFileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Невозможно открыть файл!");
        }
    }

    public void renameFile(String fileSource, String fileDest) { //переименовать файл
        File source = new File(currentFolder + "\\" + fileSource);
        File dest = new File(currentFolder + "\\" + fileDest);
        try {
            FileUtils.moveFile(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно переименовать файл!");
        }
    }

    public void renameDirectory(String sourceDirectory, String destDirectory) { //переименовать папку
        File source = new File(currentFolder + "\\" + sourceDirectory);
        File dest = new File(currentFolder + "\\" + destDirectory);
        try {
            FileUtils.moveDirectory(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно переименовать папку");
        }
    }
}

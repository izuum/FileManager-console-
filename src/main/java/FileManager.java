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
        System.out.println("------------------------");
        System.out.println("Path: " + currentFolder);
        System.out.println("------------------------");
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
        System.out.println("------------------------");
        System.out.print(">: ");
    }

    public void copyFile(String sourceFile, String destFile) { // копирует файл из одного в другой
        File source = new File(currentFolder + "\\" + sourceFile);
        File dest = new File(currentFolder + "\\" + destFile);
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно скопировать файл!");
        }
        listOfFiles(true);
    }

    public void changeDirectory(String folderName) { //сменить папку. если "/" - перейти в корень
        try {
            if (folderName.equals("/")) {                 // если ".." - выйти на уровень выше
                this.currentFolder = this.root;         // иначе перейти в нужную папку
            } else if (folderName.equals("..")) {
                int indexOfLastPosition = this.currentFolder.lastIndexOf("\\");
                this.currentFolder = this.currentFolder.substring(0, indexOfLastPosition);
            } else {
                this.currentFolder = this.currentFolder + "\\" + folderName;
            }
            listOfFiles(true);
        }catch (NullPointerException e){
            System.out.println("Невозможно перейти во вложенный или несуществующий каталог. Вернитесь на уровень выше! (cd ..)");
        }
    }

    public void createFile(String fileName) { //создать файл
        File file = new File(currentFolder + "\\" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Невозможно создать файл!");
        }
        listOfFiles(true);
    }

    public void makeDirectory(String newFolderName) { // создать папку
        File file = new File(currentFolder + "\\" + newFolderName);
        file.mkdir();
        listOfFiles(true);
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
        System.out.print(">: ");
    }

    public void renameFile(String fileSource, String fileDest) { //переименовать файл
        File source = new File(currentFolder + "\\" + fileSource);
        File dest = new File(currentFolder + "\\" + fileDest);
        try {
            FileUtils.moveFile(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно переименовать файл!");
        }
        listOfFiles(true);
    }

    public void renameDirectory(String sourceDirectory, String destDirectory) { //переименовать папку
        File source = new File(currentFolder + "\\" + sourceDirectory);
        File dest = new File(currentFolder + "\\" + destDirectory);
        try {
            FileUtils.moveDirectory(source, dest);
        } catch (IOException e) {
            System.out.println("Невозможно переименовать папку");
        }
        listOfFiles(true);
    }

    public void deleteDirectory(String sourceDirectory) {
        File source  = new File(currentFolder + "\\" + sourceDirectory);
        try {
            FileUtils.deleteDirectory(source);
        } catch (IOException e) {
            System.out.println("Невозможно удалить каталог.");
        }
        listOfFiles(true);
    }

    public void moveToDirectory(String srcFile, String destDir) {
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
        listOfFiles(true);
    }

    public void deleteFile(String sourceFile) {
        File srcFile = new File(currentFolder + "\\" + sourceFile);
        try {
            FileUtils.delete(srcFile);
        } catch (IOException e) {
            System.out.println("Невозможно удалить файл.");
        }
        listOfFiles(true);
    }
}

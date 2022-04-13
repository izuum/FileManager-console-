package logic.uttils;

import logic.constants.Commands;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.Map;
import static logic.uttils.StartPoint.*;

public class FileManager  {

    public void listOfFiles(boolean sizeOfFiles) { //выводит список файлов, если true - выводит с размером файла/папки
        File currentFolderAsFile = new File(getCurrentFolder());
        File[] files = currentFolderAsFile.listFiles();
        System.out.println("------------------------");
        System.out.println("Path: " + getCurrentFolder());
        System.out.println("------------------------");
        for (File file : files) {
            if(file.isDirectory()){
                if(sizeOfFiles){
                    System.out.print(file.getName() + File.separator + " " + FileUtils.byteCountToDisplaySize(FileUtils.sizeOfDirectory(file)));
                }else{
                    System.out.print(file.getName() + File.separator + " ");
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

    public void copyFile(String sourceFile, String destFile, String currentFolder) { // копирует файл из одного в другой
        File source = new File(currentFolder + File.separator + sourceFile);
        File dest = new File(currentFolder + File.separator + destFile);
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно скопировать файл!");
        }
        listOfFiles(true);
    }

    public void changeDirectory(String folderName, String currentFolder) { //сменить папку. если "/" - перейти в корень
        try {
            if (folderName.equals("/")) {                 // если ".." - выйти на уровень выше
                setCurrentFolder(getRoot());//) = getRoot();         // иначе перейти в нужную папку
            } else if (folderName.equals("..")) {
                int indexOfLastPosition = getCurrentFolder().lastIndexOf(File.separator);
                setCurrentFolder(getCurrentFolder().substring(0, indexOfLastPosition));// = getCurrentFolder().substring(0, indexOfLastPosition);
            } else {
                setCurrentFolder(getCurrentFolder() + File.separator + folderName);// = getCurrentFolder() + "\\" + folderName;
            }
            listOfFiles(true);
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Невозможно перейти во вложенный или несуществующий каталог. Вернитесь на уровень выше! (cd ..)");
        }
    }

    public void createFile(String fileName, String currentFolder) { //создать файл
        File file = new File(currentFolder + File.separator + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно создать файл!");
        }
        listOfFiles(true);
    }

    public void makeDirectory(String newFolderName, String currentFolder) { // создать папку
        File file = new File(currentFolder + File.separator + newFolderName);
        file.mkdir();
        listOfFiles(true);
    }

    public void contentFile(String thisFileName, String currentFolder) { //открыть файл
        File file = new File(currentFolder + File.separator + thisFileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно открыть файл!");
        }
        System.out.print(">: ");
    }

    public void renameFile(String fileSource, String fileDest, String currentFolder) { //переименовать файл
        File source = new File(currentFolder + File.separator + fileSource);
        File dest = new File(currentFolder + File.separator + fileDest);
        try {
            FileUtils.moveFile(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно переименовать файл!");
        }
        listOfFiles(true);
    }

    public void renameDirectory(String sourceDirectory, String destDirectory, String currentFolder) { //переименовать папку
        File source = new File(currentFolder + File.separator + sourceDirectory);
        File dest = new File(currentFolder + File.separator + destDirectory);
        try {
            FileUtils.moveDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно переименовать папку");
        }
        listOfFiles(true);
    }

    public void deleteDirectory(String sourceDirectory, String currentFolder) {
        File source  = new File(currentFolder + File.separator + sourceDirectory);
        try {
            FileUtils.deleteDirectory(source);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно удалить каталог.");
        }
        listOfFiles(true);
    }

    public void moveToDirectory(String srcFile, String destDir, String currentFolder) {
        boolean createDir;
        File sourceFile = new File(currentFolder + File.separator + srcFile);
        File destDirectory = new File(currentFolder + File.separator + destDir);
        try {
            if(destDir==null){
                createDir = true;
            }else{
                createDir = false;
            }
            FileUtils.moveToDirectory(sourceFile, destDirectory, createDir);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Перемещение невозможно.");
        }
        listOfFiles(true);
    }

    public void deleteFile(String sourceFile, String currentFolder) {
        File srcFile = new File(currentFolder + File.separator + sourceFile);
        try {
            FileUtils.delete(srcFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно удалить файл.");
        }
        listOfFiles(true);
    }

    public void helpList() {
        Map<String, String> listEnum = Commands.getListEnum();
        for (Map.Entry<String, String> entry : listEnum.entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }

    public static String universalPathFile(String filePath) {
        String separator = File.separator;
        String path = filePath.replaceAll("\\s\\.", separator);
        return path;
    }
}

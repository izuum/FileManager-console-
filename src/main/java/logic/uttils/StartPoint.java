package logic.uttils;

import java.util.Scanner;
import static logic.constants.Commands.*;

public class StartPoint {
    private static String currentFolder;
    private static String root;

    public static String getCurrentFolder() {
        return currentFolder;
    }
    public static void setCurrentFolder(String currentFolder) {
        StartPoint.currentFolder = currentFolder;
    }

    public static String getRoot() {
        return root;
    }

    public StartPoint(String currentFolder){
        this.currentFolder = currentFolder;
        this.root = currentFolder;
    }

    public void startProgram(){
        FileManager fm = new FileManager();
        Scanner scanner = new Scanner(System.in);
        fm.listOfFiles(true);
        String input = scanner.nextLine();

        while(!input.equals(EXIT.getText())) {
            String firstParam;
            String secondParam;
            String[] tokens = input.split(" ");
            String command = tokens[0];
            if(tokens.length == 1){
                switch (command){
                    case "help" -> fm.helpList();
                    case "ll" -> fm.listOfFiles(false);
                    case "ls" -> fm.listOfFiles(true);
                    default -> System.out.println("Такой команды не существует, введите 'help' для просмотра списка команд.");
                }
            }else if(tokens.length == 2){
                firstParam = tokens[1];
                switch (command){
                    case "cd" -> fm.changeDirectory(firstParam, currentFolder);
                    case "cat" -> fm.contentFile(firstParam, currentFolder);
                    case "touch" -> fm.createFile(firstParam, currentFolder);
                    case "mkdir" -> fm.makeDirectory(firstParam, currentFolder);
                    case "rmdir" -> fm.deleteDirectory(firstParam, currentFolder);
                    case "rmfile" -> fm.deleteFile(firstParam, currentFolder);
                    default -> System.out.println("Такой команды не существует, введите 'help' для просмотра списка команд.");
                }
            }else if(tokens.length == 3){
                firstParam = tokens[1];
                secondParam = tokens[2];
                switch (command){
                    case "cp" -> fm.copyFile(firstParam, secondParam, currentFolder);
                    case "rename" -> fm.renameFile(firstParam, secondParam, currentFolder);
                    case "redir" -> fm.renameDirectory(firstParam, secondParam, currentFolder);
                    case "move" -> fm.moveToDirectory(firstParam, secondParam, currentFolder);
                    default -> System.out.println("Такой команды не существует, введите 'help' для просмотра списка команд.");
                }
            }
            input = scanner.nextLine();
        }
    }
}

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
                    case "help":
                        fm.helpList();
                        break;
                    case "ll":
                        fm.listOfFiles(false);
                        break;
                    case "ls":
                        fm.listOfFiles(true);
                        break;
                }
            }else if(tokens.length == 2){
                firstParam = tokens[1];
                switch (command){
                    case "cd":
                        fm.changeDirectory(firstParam, currentFolder);
                        break;
                    case "cat" :
                        fm.contentFile(firstParam, currentFolder);
                        break;
                    case "touch" :
                        fm.createFile(firstParam, currentFolder);
                        break;
                    case "mkdir" :
                        fm.makeDirectory(firstParam, currentFolder);
                        break;
                    case "rmdir" :
                        fm.deleteDirectory(firstParam, currentFolder);
                        break;
                    case "rmfile" :
                        fm.deleteFile(firstParam, currentFolder);
                        break;
                }
            }else if(tokens.length == 3){
                firstParam = tokens[1];
                secondParam = tokens[2];
                switch (command){
                    case "cp" :
                        fm.copyFile(firstParam, secondParam, currentFolder);
                        break;
                    case "rename" :
                        fm.renameFile(firstParam, secondParam, currentFolder);
                        break;
                    case "redir" :
                        fm.renameDirectory(firstParam, secondParam, currentFolder);
                        break;
                    case "move" :
                        fm.moveToDirectory(firstParam, secondParam, currentFolder);
                        break;
                }
            }

            input = scanner.nextLine();
        }
    }
}

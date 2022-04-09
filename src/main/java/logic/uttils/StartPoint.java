package logic.uttils;



import logic.constants.Commands;

import java.util.Scanner;
import static logic.constants.Commands.*;
import static logic.uttils.FileManager.*;

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
        Scanner scanner = new Scanner(System.in);
        listOfFiles(true);
        String input = scanner.nextLine();

        while(!input.equals(EXIT.getText())) {
            String firstParam;
            String secondParam;
            String[] tokens = input.split(" ");
            String command = tokens[0];
            if(tokens.length == 1){
                switch (command){
                    case "help":
                        helpList();
                        break;
                    case "ll":
                        listOfFiles(false);
                        break;
                    case "ls":
                        listOfFiles(true);
                        break;
                }
            }else if(tokens.length == 2){
                firstParam = tokens[1];
                switch (command){
                    case "cd":
                        changeDirectory(firstParam, currentFolder);
                        break;
                    case "cat" :
                        contentFile(firstParam, currentFolder);
                        break;
                    case "touch" :
                        createFile(firstParam, currentFolder);
                        break;
                    case "mkdir" :
                        makeDirectory(firstParam, currentFolder);
                        break;
                    case "rmdir" :
                        deleteDirectory(firstParam, currentFolder);
                        break;
                    case "rmfile" :
                        deleteFile(firstParam, currentFolder);
                        break;
                }
            }else if(tokens.length == 3){
                firstParam = tokens[1];
                secondParam = tokens[2];
                switch (command){
                    case "cp" :
                        copyFile(firstParam, secondParam, currentFolder);
                        break;
                    case "rename" :
                        renameFile(firstParam, secondParam, currentFolder);
                        break;
                    case "redir" :
                        renameDirectory(firstParam, secondParam, currentFolder);
                        break;
                    case "move" :
                        moveToDirectory(firstParam, secondParam, currentFolder);
                        break;
                }
            }

            input = scanner.nextLine();
        }
    }
}

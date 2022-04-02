package logic.uttils;

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

        while(!input.equals(EXIT.getText())){
            String[] tokens = input.split(" ");
            String command = tokens[0];

            // полная хрень, потом сделаю лучше
            if (command.equals(LIST_OF_FILES.getText())) {
                listOfFiles(false);
            } else if (command.equals(LIST_OF_FILES_WITH_SIZE.getText())) {
                listOfFiles(true);
            } else if (command.equals(COPY_FILE.getText())){
                String sourceFile = tokens[1];
                String destFile = tokens[2];
                copyFile(sourceFile, destFile, currentFolder);
            } else if (command.equals(CHANGE_DIRECTORY.getText())) {
                String folderName = tokens[1];
                changeDirectory(folderName, currentFolder);
            } else if (command.equals(CREATE_NEW_FILE.getText())) {
                String fileName = tokens[1];
                createFile(fileName, currentFolder);
            } else if (command.equals(MAKE_DIRECTORY.getText())) {
                String newFolderName = tokens[1];
                makeDirectory(newFolderName, currentFolder);
            } else if (command.equals(CONTENT_FILE.getText())) {
                String thisFileName = tokens[1];
                contentFile(thisFileName, currentFolder);
            } else if (command.equals(RENAME_FILE.getText())) {
                String fileSource = tokens[1];
                String fileDest = tokens[2];
                renameFile(fileSource, fileDest, currentFolder);
            } else if (command.equals(RENAME_DIRECTORY.getText())) {
                String sourceDirectory = tokens[1];
                String destDirectory = tokens[2];
                renameDirectory(sourceDirectory, destDirectory, currentFolder);
            } else if (command.equals(DELETE_DIRECTORY.getText())) {
                String sourceDirectory = tokens[1];
                deleteDirectory(sourceDirectory, currentFolder);
            } else if (command.equals(DELETE_FILE.getText())) {
                String sourceFile = tokens[1];
                deleteFile(sourceFile, currentFolder);
            } else if (command.equals(MOVE_TO_DIRECTORY.getText())) {
                String srcFile = tokens[1];
                String destDir = tokens[2];
                moveToDirectory(srcFile, destDir, currentFolder);
            } else if (command.equals(HELP.getText())) {
                helpList();
            } else {
                System.out.println("Команда отсутствует в списке");
            }

            input = scanner.nextLine();
        }
    }
}

import logic.uttils.FileManager;

import java.util.Scanner;

import static logic.constants.Commands.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileManager fileManager = new FileManager("src/main/resources/root");
        fileManager.listOfFiles(true);
        String input = scanner.nextLine();

        while(!input.equals(EXIT.getText())){
            String[] tokens = input.split(" ");
            String command = tokens[0];

            // полная хрень, потом сделаю лучше
            if (command.equals(LIST_OF_FILES.getText())) {
                fileManager.listOfFiles(false);
            } else if (command.equals(LIST_OF_FILES_WITH_SIZE.getText())) {
                fileManager.listOfFiles(true);
            } else if (command.equals(COPY_FILE.getText())){
                String sourceFile = tokens[1];
                String destFile = tokens[2];
                fileManager.copyFile(sourceFile, destFile);
            } else if (command.equals(CHANGE_DIRECTORY.getText())) {
                String folderName = tokens[1];
                fileManager.changeDirectory(folderName);
            } else if (command.equals(CREATE_NEW_FILE.getText())) {
                String fileName = tokens[1];
                fileManager.createFile(fileName);
            } else if (command.equals(MAKE_DIRECTORY.getText())) {
                String newFolderName = tokens[1];
                fileManager.makeDirectory(newFolderName);
            } else if (command.equals(CONTENT_FILE.getText())) {
                String thisFileName = tokens[1];
                fileManager.contentFile(thisFileName);
            } else if (command.equals(RENAME_FILE.getText())) {
                String fileSource = tokens[1];
                String fileDest = tokens[2];
                fileManager.renameFile(fileSource, fileDest);
            } else if (command.equals(RENAME_DIRECTORY.getText())) {
                String sourceDirectory = tokens[1];
                String destDirectory = tokens[2];
                fileManager.renameDirectory(sourceDirectory, destDirectory);
            } else if (command.equals(DELETE_DIRECTORY.getText())) {
                String sourceDirectory = tokens[1];
                fileManager.deleteDirectory(sourceDirectory);
            } else if (command.equals(DELETE_FILE.getText())) {
                String sourceFile = tokens[1];
                fileManager.deleteFile(sourceFile);
            } else if (command.equals(MOVE_TO_DIRECTORY.getText())) {
                String srcFile = tokens[1];
                String destDir = tokens[2];
                fileManager.moveToDirectory(srcFile, destDir);
            } else if (command.equals(HELP.getText())) {
                fileManager.helpList();
            } else {
                System.out.println("Команда отсутствует в списке");
            }

            input = scanner.nextLine();
        }
    }
}

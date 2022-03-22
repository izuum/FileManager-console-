import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileManager fileManager = new FileManager("src/main/resources/root");

        String input = scanner.nextLine();

        while(!input.equals(Commands.EXIT)){
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case Commands.LIST_OF_FILES:
                    fileManager.listOfFiles(false);
                    break;
                case Commands.LIST_OF_FILES_WITH_SIZE:
                    fileManager.listOfFiles(true);
                    break;
                case Commands.COPY_FILE:
                    String sourceFile = tokens[1];
                    String destFile = tokens[2];
                    fileManager.copyFile(sourceFile, destFile);
                    break;
                case Commands.CHANGE_DIRECTORY:
                    String folderName = tokens[1];
                    fileManager.changeDirectory(folderName);
                    break;
                case Commands.CREATE_NEW_FILE:
                    String fileName = tokens[1];
                    fileManager.createFile(fileName);
                    break;
                case Commands.MAKE_DIRECTORY:
                    String newFolderName = tokens[1];
                    fileManager.makeDirectory(newFolderName);
                    break;
                case Commands.CONTENT_FILE:
                    String thisFileName = tokens[1];
                    fileManager.contentFile(thisFileName);
                    break;
                case Commands.RENAME_FILE:
                    String fileSource = tokens[1];
                    String fileDest = tokens[2];
                    fileManager.renameFile(fileSource, fileDest);
                    break;
                case Commands.RENAME_DIRECTORY:
                    String sourceDirectory = tokens[1];
                    String destDirectory = tokens[2];
                    fileManager.renameDirectory(sourceDirectory, destDirectory);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}

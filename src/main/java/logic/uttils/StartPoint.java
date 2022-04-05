package logic.uttils;

import logic.constants.Commands;
import logic.function.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static logic.constants.Commands.*;
import static logic.uttils.FileManager.*;

public class StartPoint {
    private static String currentFolder;
    private static String root;
    private Map<String, Object> function = new HashMap<>();


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

        //ChangeDirectory cd = new ChangeDirectory();


    }

    public void startProgram(){
        Scanner scanner = new Scanner(System.in);
        listOfFiles(true);
        String input = scanner.nextLine();

        while(!input.equals(EXIT.getText())) {
            String firstParametr;
            String secondParametr;
            String[] tokens = input.split(" ");
            String command = tokens[0];
            if(tokens.length == 2){
                firstParametr = tokens[1];
            }else if(tokens.length == 3){
                secondParametr = tokens[2];
            }

            ChangeDirectory cd = new ChangeDirectory();
            ContentFile cat = new ContentFile();
            CopyFile cp = new CopyFile();
            CreateNewFile touch = new CreateNewFile();
            DeleteDirectory rmdir = new DeleteDirectory();
            DeleteFile rmfile = new DeleteFile();
            Help help = new Help();
            ListOfFiles ll = new ListOfFiles();
            ListOfFilesWithSize ls = new ListOfFilesWithSize();
            MakeDirectory mkdir = new MakeDirectory();
            MoveToDirectory move = new MoveToDirectory();
            RenameDirectory redir = new RenameDirectory();
            RenameFile rename = new RenameFile();


            function.put(CHANGE_DIRECTORY.getText(), cd.changeDirectory(tokens[1], currentFolder));
            function.put(CONTENT_FILE.getText(), cat.contentFile(tokens[1], currentFolder));
            function.put(COPY_FILE.getText(), cp.copyFile(tokens[1], tokens[2], currentFolder));
            function.put(CREATE_NEW_FILE.getText(), touch.createFile(tokens[1], currentFolder));
            function.put(DELETE_DIRECTORY.getText(), rmdir.deleteDirectory(tokens[1], currentFolder));
            function.put(DELETE_FILE.getText(), rmfile.deleteFile(tokens[1], currentFolder));
            function.put(HELP.getText(), help.helpList());
            function.put(LIST_OF_FILES.getText(), ll.listOfFiles());
            function.put(LIST_OF_FILES_WITH_SIZE.getText(), ls.listOfFiles());
            function.put(MAKE_DIRECTORY.getText(), mkdir.makeDirectory(tokens[1], currentFolder));
            function.put(MOVE_TO_DIRECTORY.getText(), move.moveToDirectory(tokens[1], tokens[2], currentFolder));
            function.put(RENAME_DIRECTORY.getText(), redir.renameDirectory(tokens[1], tokens[2], currentFolder));
            function.put(RENAME_FILE.getText(), rename.renameFile(tokens[1], tokens[2], currentFolder));

            for(Map.Entry entry : function.entrySet()){
                if (tokens[0].equals(entry.getKey())) {
                    function.get(entry.getKey());
                    break;
                }
            }






            // полная хрень, потом сделаю лучше
//            if (command.equals(LIST_OF_FILES.getText())) {
//                listOfFiles(false);
//            } else if (command.equals(LIST_OF_FILES_WITH_SIZE.getText())) {
//                listOfFiles(true);
//            } else if (command.equals(COPY_FILE.getText())){
//                String sourceFile = tokens[1];
//                String destFile = tokens[2];
//                copyFile(sourceFile, destFile, currentFolder);
//            } else if (command.equals(CHANGE_DIRECTORY.getText())) {
//                String folderName = tokens[1];
//                changeDirectory(folderName, currentFolder);
//            } else if (command.equals(CREATE_NEW_FILE.getText())) {
//                String fileName = tokens[1];
//                createFile(fileName, currentFolder);
//            } else if (command.equals(MAKE_DIRECTORY.getText())) {
//                String newFolderName = tokens[1];
//                makeDirectory(newFolderName, currentFolder);
//            } else if (command.equals(CONTENT_FILE.getText())) {
//                String thisFileName = tokens[1];
//                contentFile(thisFileName, currentFolder);
//            } else if (command.equals(RENAME_FILE.getText())) {
//                String fileSource = tokens[1];
//                String fileDest = tokens[2];
//                renameFile(fileSource, fileDest, currentFolder);
//            } else if (command.equals(RENAME_DIRECTORY.getText())) {
//                String sourceDirectory = tokens[1];
//                String destDirectory = tokens[2];
//                renameDirectory(sourceDirectory, destDirectory, currentFolder);
//            } else if (command.equals(DELETE_DIRECTORY.getText())) {
//                String sourceDirectory = tokens[1];
//                deleteDirectory(sourceDirectory, currentFolder);
//            } else if (command.equals(DELETE_FILE.getText())) {
//                String sourceFile = tokens[1];
//                deleteFile(sourceFile, currentFolder);
//            } else if (command.equals(MOVE_TO_DIRECTORY.getText())) {
//                String srcFile = tokens[1];
//                String destDir = tokens[2];
//                moveToDirectory(srcFile, destDir, currentFolder);
//            } else if (command.equals(HELP.getText())) {
//                helpList();
//            } else {
//                System.out.println("Команда отсутствует в списке");
//            }

            input = scanner.nextLine();
        }
    }
}

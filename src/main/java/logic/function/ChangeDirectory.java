package logic.function;

import static logic.function.ListOfFilesWithSize.listOfFiles;
import static logic.uttils.StartPoint.*;

public class ChangeDirectory {

    public ChangeDirectory(/*String firstParametr, String currFol*/) {

    }

    public static Object changeDirectory(String folderName, String currentFolder) { //сменить папку. если "/" - перейти в корень
        try {
            if (folderName.equals("/")) {                 // если ".." - выйти на уровень выше
                setCurrentFolder(getRoot());//) = getRoot();         // иначе перейти в нужную папку
            } else if (folderName.equals("..")) {
                int indexOfLastPosition = getCurrentFolder().lastIndexOf("\\");
                setCurrentFolder(getCurrentFolder().substring(0, indexOfLastPosition));// = getCurrentFolder().substring(0, indexOfLastPosition);
            } else {
                setCurrentFolder(getCurrentFolder() + "\\" + folderName);// = getCurrentFolder() + "\\" + folderName;
            }
            listOfFiles();
        }catch (NullPointerException e){
            System.out.println("Невозможно перейти во вложенный или несуществующий каталог. Вернитесь на уровень выше! (cd ..)");
        }
        return null;
    }
}

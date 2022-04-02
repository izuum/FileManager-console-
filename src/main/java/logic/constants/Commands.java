package logic.constants;

import java.util.HashMap;
import java.util.Map;

public enum Commands {

    LIST_OF_FILES("ll", "Вывод на экран списка файлов и папок в текущем каталоге."),
    LIST_OF_FILES_WITH_SIZE("ls", "Вывод на экран списка файлов и папок в текущем каталоге и их размера."), //Выводится автоматически после каждой команды
    COPY_FILE("cp", "Копирование файла или папки.(cp <объект_копирования> <имя_нового_обьекта>)"), //Например: cp Folder Folder2 -> копирует каталог NewFolder в NewFolder2
    CHANGE_DIRECTORY("cd", "Перемещение по каталогам (cd <нужный_каталог>)"), //Находясь в каталоге root: cd Folder -> перемещается в каталог Folder
    CREATE_NEW_FILE("touch", "Создать новый файл в текущем каталоге. Необходимо указать расширение (touch <имя_файла>)"), //Например: touch pictures.jpeg -> создастся файл pictures.jpeg
    MAKE_DIRECTORY("mkdir", "Создать новую папку(каталог) в текущем каталоге.(mkdir <имя_каталога>)"), //Например: mkdir NewFolder -> создастся новая папка NewFolder
    CONTENT_FILE("cat", "Открыть содержимое файла. Необходимо указать расширение.(cat <имя_файла>)"), //Например: cat Letter.txt -> на экран выведется содержимое файла Letter.txt
    RENAME_FILE("rename", "Переименование файла. Необходимо указать расширение.(rename <имя_файла> <новое_имя_файла>)"), //Например: rename fax.txt nofax.txt -> файл fax.txt переименовывается в nofax.txt
    RENAME_DIRECTORY("redir", "Переименование папки.(redir <имя_папки> <новое_имя_папки>)"), //Например: redir Folder NotFolder -> папка Folder переименовывается в NotFolder
    DELETE_DIRECTORY("rmdir", "Удалить папку(каталог). (rmdir <имя_папки>)"), //Например: rmdir Folder -> удалит папку Folder
    DELETE_FILE("rmfile", "Удалить файл. (rmfile <имя_файла>)"), // Например: rmfile album.mp3 -> удалит файл album.mp3
    MOVE_TO_DIRECTORY("move", "Перемещение папки или файла из текущего каталога.(move <имя_обьекта> <имя_нужного_каталога>)"), // Например: move 1.txt Folder -> переместит файл 1.txt из текущего каталога в каталог Folder
    EXIT("exit", "Выход"), // Заканчивает программу FileManager
    HELP("help", "Список команд доступных пользователю"); //Выводит на экран список доступных для ввода команд

    private String text;
    private String commandDescription;
    private static Map<String, String> map = new HashMap<>();


    Commands(String value, String commandDescription) {
        this.text = value;
        this.commandDescription = commandDescription;

    }

    public String getText() {
        return text;
    }

    public static Map<String, String> getListEnum() {
        for (Commands commands : values()) {
            map.put(commands.text, commands.commandDescription);
        }
        return map;
    }
}
package constants;

import java.util.HashMap;
import java.util.Map;

public enum Commands {

    // Опиши, что умеет делать каждая команда и прикольно было бы как она должна использоваться

    LIST_OF_FILES("ll", "Умеет и так и сяк"),
    LIST_OF_FILES_WITH_SIZE("ls", "Умеет и так и сяк"),
    COPY_FILE("cp", "Умеет и так и сяк"),
    CHANGE_DIRECTORY("cd", "Умеет и так и сяк"),
    CREATE_NEW_FILE("touch", "Умеет и так и сяк"),
    MAKE_DIRECTORY("mkdir", "Умеет и так и сяк"),
    CONTENT_FILE("cat", "Умеет и так и сяк"),
    RENAME_FILE("rename", "Умеет и так и сяк"),
    RENAME_DIRECTORY("redir", "Умеет и так и сяк"),
    DELETE_DIRECTORY("rmdir", "Умеет и так и сяк"),
    DELETE_FILE("rmfile", "Умеет и так и сяк"),
    MOVE_TO_DIRECTORY("move", "Умеет и так и сяк"),
    EXIT("exit", "Умеет и так и сяк"),
    HELP("help", "Умеет и так и сяк");

    private String text;
    private String commandDescription;
    private static Map<String, String> map;


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

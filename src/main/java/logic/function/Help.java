package logic.function;

import logic.constants.Commands;

import java.util.Map;

public class Help {

    public static Object helpList() {
        Map<String, String> listEnum = Commands.getListEnum();
        for (Map.Entry<String, String> entry : listEnum.entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
        return null;
    }
}

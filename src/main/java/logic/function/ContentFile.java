package logic.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContentFile {

    public ContentFile(/*String thisFileName, String currentFolder*/) {
        System.out.println("This content file");
    }

    public Object contentFile(String thisFileName, String currentFolder) { //открыть файл
        File file = new File(currentFolder + "\\" + thisFileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Невозможно открыть файл!");
        }
        System.out.print(">: ");
        return null;
    }
}

import logic.uttils.StartPoint;

import static logic.uttils.FileManager.universalPathFile;

public class Main {
    public static void main(String[] args) {

        StartPoint startPoint = new StartPoint(universalPathFile("src/main/resources/root"));
        startPoint.startProgram();

    }
}

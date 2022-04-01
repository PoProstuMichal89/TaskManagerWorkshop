import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskManager {

    static final String[] menu = {"add", "remove", "list", "exit"};
    static final String filePath = "src/main/resources/tasks.csv";


    public static void main(String[] args) {
        String[][] tasks = null;

        tasks = GetTasksToArray.getTasks(filePath);
        DisplayMenu.displayMenu(menu);



    }


}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class TaskManager {

    static final String[] menu = {"add", "remove", "list", "exit"};
    static final String filePath = "src/main/resources/tasks.csv";


    public static void main(String[] args) {
        //zdefiniowanie tablicy do przechowywania zadań
        String[][] tasks = null;
        tasks = GetTasksToArray.getTasks(filePath);

        //wyświetlanie menu głównego
        DisplayMenu.display(menu);


        //   ---Choose of action logic --- //

        Scanner scan = new Scanner(System.in);
        System.out.print("your's action: ");
        while (scan.hasNextLine()) {
            String choosenAction = scan.nextLine();
            switch (choosenAction) {
                case "exit":
                    break;
                case "add":
                    AddTask.addTask(tasks);
                    System.out.println("Thanks you. Your's task is added");
                    break;
                case "remove":
                    break;

                case "list":
                    System.out.println("List of tasks: ");
                    ListOfTasks.displayListsOfTasks(tasks);

                    break;

                default:
                    System.out.println("Choose a correct action");

            }
            DisplayMenu.display(menu);
            System.out.print("your's action: ");

        }


    }


}
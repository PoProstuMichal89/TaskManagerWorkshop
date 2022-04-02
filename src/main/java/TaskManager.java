import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {

    static final String[] menu = {"add", "remove", "list", "exit"};
    static final String filePath = "src/main/resources/tasks.csv";
    static String[][] tasks;


    public static void main(String[] args) {
        //zdefiniowanie tablicy do przechowywania zadań
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
                    saveTabToFile(filePath,tasks);
                    System.exit(0);
                    break;
                case "add":
                    addTask();
                    System.out.println("Thanks you. Your's task is added");
                    break;
                case "remove":
                    removeTask(tasks, GetNumberToRemove.getNumber());
                    System.out.println("Your's task is removed");
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

    // --Metody prywatne korzystające i modyfikujące tablicę String[][] tasks--

    // dodawanie zadań

    private static void addTask() {

        //zapisywanie inputu użytkownika do zmiennych
        Scanner scan = new Scanner(System.in);
        System.out.println("Please add task description: ");
        String taskDescription = scan.nextLine();
        System.out.println("Please add task due date");
        String taskDate = scan.nextLine();
        System.out.println("Is your task is important: true/false: ");
        String taskProirity = scan.nextLine();

        // zwiększenie rozmiaru tablicy na nowe wiersze
        tasks = Arrays.copyOf(tasks, tasks.length + 1);

        //zapisywanie inputu ze zmiennych do tablicy
        tasks[tasks.length - 1] = new String[3]; //dodanie nowych kolumn do ostatniego wiersza
        tasks[tasks.length - 1][0] = taskDescription;
        tasks[tasks.length - 1][1] = taskDate;
        tasks[tasks.length - 1][2] = taskProirity;

    }

    // usuwanie zadań (pobranie numeru i walidacja numeru - w klasie 'GetNumberToRemove')

    private static void removeTask(String[][] tab, int index) {    //metoda przyjmuje dwa argumenty: tablicę z której usuwa i index który ma usunąć

        try {
            if (index < tab.length) {
                tasks = ArrayUtils.remove(tab, index);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Element not exist in tab");
        }

    }

    public static void saveTabToFile(String fileName, String[][] tab) {
        Path dir = Paths.get(fileName);

        String[] lines = new String[tasks.length];
        for (int i = 0; i < tab.length; i++) {
            lines[i] = String.join(",", tab[i]);
        }

        try {
            Files.write(dir, Arrays.asList(lines));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class AddTask {

    public static void addTask(String[][] tasks){

        //zapisywanie inputu użytkownika do zmiennych
        Scanner scan = new Scanner(System.in);
        System.out.println("Please add task description: ");
        String taskDescription = scan.nextLine();
        System.out.println("Please add task due date");
        String taskDate = scan.nextLine();
        System.out.println("Is your task is important: true/false: ");
        String taskProirity = scan.nextLine();

        // zwiększenie rozmiaru tablicy na nowe wiersze
        tasks=Arrays.copyOf(tasks, tasks.length + 1);

        //zapisywanie inputu ze zmiennych do tablicy
        tasks[tasks.length-1]=new String[3]; //dodanie nowych kolumn do ostatniego wiersza
        tasks[tasks.length-1][0]=taskDescription;
        tasks[tasks.length-1][1]=taskDate;
        tasks[tasks.length-1][2]=taskProirity;

    }

//    public static void main(String[] args) {
//        String[][] task=null;
//        task=GetTasksToArray.getTasks("src/main/resources/tasks.csv");
//        String[][] tasksTest = new String[11][12];
//        tasksTest=addTask(task);
//        tasksTest=addTask(task);
//        for (int i = 0; i < tasksTest.length; i++) {
//            for (int j = 0; j < tasksTest[i].length; j++) {
//                System.out.println(tasksTest[i][j]);
//            }
//        }
//
//
//    }

}

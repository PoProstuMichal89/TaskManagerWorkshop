public class ListOfTasks {
    public static void displayListsOfTasks(String[][] tasks){
        for (int i = 0; i < tasks.length; i++) {
            System.out.print("#");                          //dodanie punktora do każdego wiersza
            for (int j = 0; j < tasks[i].length; j++) {
                System.out.print(tasks[i][j]+" ");
            }
            System.out.println(); //dodanie nowej linii
        }


    }

//    public static void main(String[] args) {
//        String[][] task=null;
//        task=AnotherMethods.GetTasksToArray.getTasks("src/main/resources/tasks.csv");
//        displayListsOfTasks(task);
//    }

}

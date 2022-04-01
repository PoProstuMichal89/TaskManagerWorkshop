import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GetTasksToArray {
    public static String[][] getTasks(String filePath) {

        Path directory = Paths.get(filePath);     // spróbować innego roziwązania z try-catch
        if (!Files.exists(directory)) {
            System.out.println("File don't exist");
            System.exit(0);
        }

        String[][] arr = null;
        try {
            List<String> strings = Files.readAllLines(directory);
            arr = new String[strings.size()][strings.get(0).split(",").length];
            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = split[j];

                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return arr;
    }
}

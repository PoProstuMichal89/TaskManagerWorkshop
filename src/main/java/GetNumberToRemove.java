import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

//pobranie numeru

public class GetNumberToRemove {

    public static int getNumber() {


        //prośba o podanie numeru i zpaisanie numeru
        Scanner scan = new Scanner(System.in);
        System.out.println("Select task's number to remove: ");
        String number = scan.nextLine();
        while (!isGreaterOrEqualeZero(number)) {
            System.out.println("Select right number! It can't be smaller than 0!");
            number = scan.nextLine();
        }
        return Integer.parseInt(number);

    }

    //walidacja czy jest wieksza lub równa zero

    public static boolean isGreaterOrEqualeZero(String choosenNumber) {
        if (NumberUtils.isParsable(choosenNumber)) {
            return Integer.parseInt(choosenNumber) >= 0; //jeśli input choosen number parsowlany do int, to zwróć true tylko w wypadku w którym ten int będzie większy lub równy zero
        }
        return false;  //zwróć false dla ujemnych wartości
    }


}

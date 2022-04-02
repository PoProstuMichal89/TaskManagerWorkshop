public class DisplayMenu {

    public static void display(String[] menu) {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an opion: "+ ConsoleColors.RESET);
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }



    }
}

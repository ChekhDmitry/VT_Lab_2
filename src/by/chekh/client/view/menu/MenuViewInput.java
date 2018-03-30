package by.chekh.client.view.menu;

import java.util.Scanner;

/**
 * Created by dima on 11/6/2017.
 */
public class MenuViewInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String menuActionInput(){
        System.out.print("Ваше действие: ");
        String choice = scanner.nextLine().trim();
        System.out.println("----------------------------------------");
        return choice;
    }

    public static String menuRoleActionInput(){
        while (true) {
            System.out.print("Ваше действие: ");
            String choice = scanner.nextLine().trim();
            System.out.println("----------------------------------------");
            if (choice.equals("1")) {
                return "admin";
            } else if (choice.equals("2")) {
                return "teacher";
            }
        }
    }
}

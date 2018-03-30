import by.chekh.client.controller.ClientController;
import by.chekh.server.controller.MainServerController;

import java.util.Scanner;

/**
 * Created by dima on 11/3/2017.
 */
public class MainApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String... args){

        System.out.println("1-Server");
        System.out.println("2-Client");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();
        if(choice.equals("1")){
            Thread serverThread = new Thread(new MainServerController());
            serverThread.start();

            System.out.print("Enter any key to close server:");
            scanner.nextLine().trim();

            serverThread.interrupt();
            try {
                serverThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Server was closed.");
        }else{
            Thread clientThread = new Thread(new ClientController());
            clientThread.start();
            try {
                clientThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

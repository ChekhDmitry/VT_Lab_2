package by.chekh.client.controller;

import by.chekh.client.view.error.ErrorViewPrinter;
import by.chekh.client.view.menu.MenuViewInput;
import by.chekh.client.view.menu.MenuViewPrinter;
import by.chekh.client.view.student.StudentCardViewInput;
import by.chekh.client.view.student.StudentCardViewPrinter;
import by.chekh.entity.StudentCard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by dima on 11/3/2017.
 */
public class ClientController implements Runnable {

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    private void initConnection(){
        try {
            socket = new Socket("",5678);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendRequest(Object responseObject){
        try {
            outputStream.writeObject(responseObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchStudentCard(){
        String studentName = StudentCardViewInput.studentCardNameInput();
        sendRequest(studentName);
        try {
            Object responsetObject = inputStream.readObject();
            if (responsetObject instanceof StudentCard) {
                StudentCard studentCard = (StudentCard) responsetObject;
                StudentCardViewPrinter.printStudentCard(studentCard);
            }else{
                StudentCardViewPrinter.printReportNoSuchStudentCard();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createStudentCard(){
        StudentCard studentCard = StudentCardViewInput.studentCardCreationInput();
        sendRequest(studentCard);
        try {
            Object responseObject = inputStream.readObject();
            if (responseObject instanceof String) {
                String response = (String) responseObject;
                System.out.println(response);
            } else {
                ErrorViewPrinter.printInvalidResponseDataType();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void editStudentCard(){
        String studentName = StudentCardViewInput.studentCardNameInput();
        sendRequest(studentName);
        try {
            Object responseObject = inputStream.readObject();
            if (responseObject instanceof StudentCard) {
                StudentCard studentCard = (StudentCard) responseObject;
                StudentCardViewPrinter.printStudentCard(studentCard);
                StudentCardViewInput.studentCardEditInput(studentCard);
                sendRequest(studentCard);

                Object responseObject_2 = inputStream.readObject();
                if (responseObject_2 instanceof String) {
                    String response = (String) responseObject_2;
                    System.out.println(response);
                } else {
                    ErrorViewPrinter.printInvalidResponseDataType();
                }

            }else{
                StudentCardViewPrinter.printReportNoSuchStudentCard();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        initConnection();
        boolean closeConnection = false;

        MenuViewPrinter.printRoleMenu();
        String role = MenuViewInput.menuRoleActionInput();

        while (!closeConnection) {

            MenuViewPrinter.printMenu(role);
            String actionChoice = MenuViewInput.menuActionInput();

            switch (actionChoice){
                case "1":{
                    searchStudentCard();
                    break;
                }
                case "2":{
                    if(role.equals("admin")) {
                        createStudentCard();
                    }else {
                        ErrorViewPrinter.printInvalidActionError();
                    }
                    break;
                }
                case "3":{
                    if(role.equals("admin")) {
                        editStudentCard();
                    }else {
                        ErrorViewPrinter.printInvalidActionError();
                    }
                    break;
                }
                case "4":{
                    closeConnection = true;
                    break;
                }
                default:{
                    ErrorViewPrinter.printInvalidActionError();
                }
            }
        }
        sendRequest("CloseConnection");
        closeConnection();
    }
}

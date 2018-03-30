package by.chekh.server.controller;

import by.chekh.entity.StudentCard;
import by.chekh.server.service.ArchiveService;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dima on 11/3/2017.
 */
public class LocalServerController implements Runnable {

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public LocalServerController(Socket socket){
        this.socket = socket;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public LocalServerController(){}

    private void initConnection(){
        try {
            ServerSocket serverSocket = new ServerSocket(5678, 0, InetAddress.getByName("localhost"));
            socket = serverSocket.accept();
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

    private void sendResponse(Object responseObject){
        try {
            outputStream.writeObject(responseObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

       // initConnection();
        ArchiveService archiveService = new ArchiveService();

        while(true) {
            try {
                Object requestObject = inputStream.readObject();
                if (requestObject instanceof StudentCard) {
                    StudentCard studentCard = (StudentCard)requestObject;
                    archiveService.saveStudentCard(studentCard);
                    sendResponse("SERVER: Студент успешно сохранен.");
                } else if (requestObject instanceof String) {
                    String request = (String)requestObject;
                    if(request.equals("CloseConnection")){
                        break;
                    }else{
                        StudentCard studentCard = archiveService.findStudentCardByName(request);
                        sendResponse(studentCard);
                    }
                } else {
                    sendResponse("LocalServerController request obj error.");
                    System.out.println("LocalServerController request obj error!!!");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeConnection();
    }
}

package by.chekh.server.controller;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MainServerController implements Runnable{

    private ServerSocket mainServerSocket;
    private Socket newSocket;

    @Override
    public void run() {
        try {
            mainServerSocket = new ServerSocket(5678);
            mainServerSocket.setSoTimeout(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try {
                while(newSocket==null) {
                    try {
                        newSocket = mainServerSocket.accept();
                    }catch (SocketTimeoutException e){}
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(newSocket!=null) {
                Thread t = new Thread(new LocalServerController(newSocket));
                t.start();
                newSocket = null;
            }else{
                break;
            }
        }
    }
}

package com.latewind.practice.concurrent.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Late Wind on 2017/5/16.
 */
public class Server extends BaseConn {
    static final int THREAD_COUNTS=10;
    Executor executor= Executors.newFixedThreadPool(THREAD_COUNTS);
    ServerSocket serverSocket;
    public Server() throws IOException {
        serverSocket=new ServerSocket(12345);
        serverSocket.setSoTimeout(100000);
    }
    public void conn(){

        while (true) {
            try {
                Socket server=serverSocket.accept();
                handleRequest(server);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleRequest(Socket socket) {
        executor.execute(() -> {
            initConn(socket);
            send("Hello,Client");
            System.out.println(receive());
        });
    }
    public static void  main(String args[]){

        try {
            new Server().conn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

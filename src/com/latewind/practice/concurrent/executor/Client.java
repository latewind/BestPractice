package com.latewind.practice.concurrent.executor;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Late Wind on 2017/5/16.
 */
public class Client extends BaseConn {
    String serverName = "localhost";
    int port = 12345;

    public void conn(){
        try {
            Socket client=new Socket(serverName,port);
            initConn(client);
            System.out.println(receive());
            send("I'm Client,Hello Service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  main(String args[]){

            new Client().conn();

    }
}

package com.latewind.practice.scanner;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Late Wind on 2017/5/21.
 */
public class PortScanner {


    public static void main(String args []){
        String host="111.13.100.91";
        int port =80;
        try {
            Socket socket=new Socket(host,80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

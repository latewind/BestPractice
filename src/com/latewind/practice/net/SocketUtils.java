package com.latewind.practice.net;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.MessageFormat;

public class SocketUtils {


    public static void receive(Socket socket) {
        try {

            InputStream input = socket.getInputStream();
            byte[] data = new byte[256];
            while (input.read(data) > 0) {
                System.out.println("receive:" + new String(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //数据量小，会一直堵塞读不到数据
    public static void receiveUseDataInStream(Socket socket) {
        try {
            DataInputStream in;
            in = new DataInputStream(socket.getInputStream());
            String inData = in.readUTF();
            String receiveData = MessageFormat.format("receive-{0}:{1}", socket.toString(), inData);
            System.out.println(receiveData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send(Socket socket, String msg) {
        try {
            String sendMsg = MessageFormat.format("send-{0}:{1}", socket.toString(), msg);
            System.out.println(sendMsg);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

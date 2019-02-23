package com.latewind.practice.net.bio;

import com.latewind.practice.net.SocketUtils;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BIOSocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 12000);

        //接受线程
        new Thread(() -> SocketUtils.receive(socket)).start();
        while (true) {
            Scanner input = new Scanner(System.in);
            String cmd = input.nextLine();
            if (cmd.equals("q")) {//退出
                socket.close();
                break;
            } else if (cmd.equals("s")) {
                SocketUtils.send(socket, "Hello,i am client");
            }
        }


    }
}

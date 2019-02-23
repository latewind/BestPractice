package com.latewind.practice.net.bio;

import com.latewind.practice.net.SocketUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOSocketServer {
    private ServerSocket serverSocket;

    public BIOSocketServer(int port) throws IOException {
        serverSocket = new ServerSocket();
        try {
            serverSocket.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void start() {

        try {
            while (true) {
                Socket socket = this.serverSocket.accept();
                new Thread(() -> {
                    while (true) {
                        SocketUtils.receive(socket);
                        SocketUtils.send(socket, "server");
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            BIOSocketServer server = new BIOSocketServer(12000);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.latewind.practice.concurrent.executor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread
{
   private ServerSocket serverSocket;
   
   public GreetingServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(100000);
   }
   public void run() {
      while(true)
         try
            {
               System.out.println("s1:Waiting for client on port " +
               serverSocket.getLocalPort() + "...");
               Socket server = serverSocket.accept();

               System.out.println("s2:Just connected to "
                     + server.getRemoteSocketAddress());

               System.out.println("s3:"+receive(server));
              send("s4:Thank you for connecting to "
                 + server.getLocalSocketAddress() + "\nGoodbye!",server);
               server.close();
            }catch(SocketTimeoutException s)
            {
               System.out.println("Socket timed out!");
               break;
            }catch(IOException e)
            {
               e.printStackTrace();
               break;
            }
   }
   public static void send(String msg,Socket socket){
      try{
         DataOutputStream out =
                 new DataOutputStream(socket.getOutputStream());
         out.writeUTF(msg);
      }catch (IOException e){

      }

   }

   public static String receive(Socket socket){
      DataInputStream in=null;
      try {
         in = new DataInputStream(socket.getInputStream());
         return in.readUTF();
      }catch(IOException e){
         return "";
      }
   }
   public static void main(String [] args)
   {
      int port = Integer.parseInt("12345");
      try
      {
         Thread t = new GreetingServer(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}

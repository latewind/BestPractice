package com.latewind.practice.concurrent.executor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GreetingClient
{
   public static void main(String [] args)
   {
      String serverName = "localhost";
      int port = Integer.parseInt("12345");
      try {
         System.out.println("C1:Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);

         System.out.println("C2:Just connected to "
                      + client.getRemoteSocketAddress());
         GreetingServer.send("C3:Hello from "
                      + client.getLocalSocketAddress(),client);

         System.out.println("C4:Server says " + GreetingServer.receive(client));


          client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
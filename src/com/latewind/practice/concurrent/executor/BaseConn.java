package com.latewind.practice.concurrent.executor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Late Wind on 2017/5/16.
 */
public abstract class BaseConn {
   static  ThreadLocal<DataOutputStream> outLocal= new ThreadLocal<DataOutputStream>(){
        @Override
        protected DataOutputStream initialValue() {
            return super.initialValue();
        }
    };
  static   ThreadLocal<DataInputStream>inLocal= new ThreadLocal<DataInputStream>(){
        @Override
        protected DataInputStream initialValue() {
            return super.initialValue();
        }
    };

   public void  initConn(Socket socket){
       try {
           outLocal.set( new DataOutputStream(socket.getOutputStream()));
            inLocal.set(new DataInputStream(socket.getInputStream()));
       } catch (IOException e) {
           e.printStackTrace();
       }

   }

    public  static void send(String msg){
        try{
            DataOutputStream out = outLocal.get();
            out.writeUTF(msg);
        }catch (IOException e){

        }

    }

    public static String receive(){
        try {
            DataInputStream in=inLocal.get();
            return in.readUTF();
        }catch(IOException e){
            return "";
        }
    }

}

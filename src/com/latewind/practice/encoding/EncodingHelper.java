package com.latewind.practice.encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by Late Wind on 2017/6/22.
 */
public class EncodingHelper {

    public static void main(String [] args) throws UnsupportedEncodingException {
        String primaryStr="Hello ??";
        String csn = Charset.defaultCharset().name();
        System.out.println("×Ö·û¼¯£º"+csn);
        EncodingHelper.showArray(primaryStr.toCharArray());
        EncodingHelper.show(primaryStr.getBytes());
        EncodingHelper.show(primaryStr.getBytes("UTF-8"));
        EncodingHelper.show(primaryStr.getBytes("GBK"));
    }
    public static void show(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        for(byte b :bytes){
            builder.append(b).append(" ");
        }
        System.out.println(builder );
    }
    public static void showArray(char[] bytes){
        StringBuilder builder = new StringBuilder();
        for(char b :bytes){
            builder.append(b).append(" ");
        }
        System.out.println(builder );
    }
}

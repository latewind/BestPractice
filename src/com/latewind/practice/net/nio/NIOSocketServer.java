package com.latewind.practice.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_ACCEPT;

public class NIOSocketServer {
    private Selector selector;

    public NIOSocketServer init(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        selector = Selector.open();
        serverSocketChannel.register(selector, OP_ACCEPT);
        return this;
    }

    public void handleEvent() throws IOException {

        while (true) {
            if (selector.select() == 0) {
                continue;
            }
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iter = keys.iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
                    //非堵塞
                    socketChannel.configureBlocking(false);
                    //注册读取事件
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(16));
                }

                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();

                    ByteBuffer buffer = (ByteBuffer) key.attachment();

                    while (socketChannel.read(buffer) > 0) {
                        buffer.flip();
                        byte[] b = new byte[buffer.remaining()];
                        buffer.get(b);
                        System.out.println(new String(b));
                        buffer.clear();
                    }
                    key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                }

                if (key.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.clear();
                    String reply = new String("1234567890123456");
                    buffer.put(reply.getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        socketChannel.write(buffer);
                    }
                    key.interestOps(SelectionKey.OP_READ);

                }
                iter.remove();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        NIOSocketServer nio = new NIOSocketServer();
        nio.init(12000);
        nio.handleEvent();
    }

}

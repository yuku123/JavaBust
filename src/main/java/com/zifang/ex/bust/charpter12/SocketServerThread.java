package com.zifang.ex.bust.charpter12;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerThread {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        ServerSocket server = new ServerSocket(50000);
        // accept方法将会阻塞当前进程，知道连接真的到了
        while(true){
            Socket socket = server.accept();
            new HandlerTread(socket).start();
        }
    }
}

class HandlerTread extends Thread{
    private Socket socket;
    public HandlerTread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream inputStream = socket.getInputStream();
            // 不断打印从客户端获得到的数据
            printMessageFromInputStream(inputStream);
            // 输入流关闭
            inputStream.close();
            // 关闭socket
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void printMessageFromInputStream(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, len,"UTF-8"));
        }
    }
}
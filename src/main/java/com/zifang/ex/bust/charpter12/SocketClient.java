package com.zifang.ex.bust.charpter12;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String args[]) throws Exception {
        // 服务端IP地址和端口，与服务端建立连接
        Socket socket = new Socket("127.0.0.1", 50000);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        // 往输出流内写入数据
        outputStream.write("HelloWorld".getBytes("UTF-8"));
        outputStream.write("HelloWorld".getBytes("UTF-8"));
        // 关闭输出流
        outputStream.close();
        // 关闭连接
        socket.close();
    }
}
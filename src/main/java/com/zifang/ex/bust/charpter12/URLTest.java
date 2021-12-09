package com.zifang.ex.bust.charpter12;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class URLTest {
    @Test
    public void test0() throws URISyntaxException, IOException {
        URL url = new URL("http://aa:123@localhost:8080/search?name=doge#anchor-1");
        print(url);
    }

    private void print(URL url) throws IOException {
        System.out.println("protocol: " + url.getProtocol());
        System.out.println("userInfo: " + url.getUserInfo());
        System.out.println("host: " + url.getHost());
        System.out.println("port: " + url.getPort());
        System.out.println("path: " + url.getPath());
        System.out.println("query: " + url.getQuery());
        System.out.println("ref: " + url.getRef());
        System.out.println("file: " + url.getFile());
        System.out.println("defaultPort: " + url.getDefaultPort());
        System.out.println("authority: " + url.getAuthority());

    }

    @Test
    public void test2() throws IOException {
        URL u = new URL("http://www.baidu.com");
        InputStream inputStream = u.openStream();
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        System.out.println(new String(b));
    }


    @Test
    public void client() throws IOException {
        ServerSocket server = new ServerSocket(50000);
        Socket socket = null;
        while (true ){
            socket = server.accept();
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printMessageFromInputStream(inputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        writeOutStream(outputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        // 关闭监听
        // server.close();

        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    byte[] bytes = new byte[1024];
//                    int len;
//                    while ((len = inputStream.read(bytes)) != -1) {
//                        System.out.print(new String(bytes, 0, len,"UTF-8"));
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();



    }

    public static void printMessageFromInputStream(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, len,"UTF-8"));
        }
    }
    public static void writeOutStream(OutputStream outputStream) throws IOException {
        int i = 0 ;
       while (true){
           outputStream.write(("hello"+i).getBytes());
           outputStream.flush();
       }
    }

    @Test
    public void test3(){
        try {
            URL url = new URL("http://127.0.0.1:50000");
            URLConnection connection = url.openConnection();
            //connection.setDoOutput(true);

            System.out.println("Content-Type: " + connection.getContentType());
            System.out.println("Content-Length: " + connection.getContentLength());
            System.out.println("Content-LengthLong: " + connection.getContentLengthLong());
            System.out.println("Content-encoding: " + connection.getContentEncoding());
            System.out.println("Date: " + connection.getDate());
            System.out.println("Expires: " + connection.getExpiration());
            System.out.println("Last-modified: " + connection.getLastModified());
        } catch (IOException e) {

        }
    }
}

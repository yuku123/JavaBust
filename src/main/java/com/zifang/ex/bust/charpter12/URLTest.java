package com.zifang.ex.bust.charpter12;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
    InputStream inputStream =  u.openStream();
    byte[] b = new byte[inputStream.available()];
    inputStream.read(b);
    System.out.println(new String(b));
}
}

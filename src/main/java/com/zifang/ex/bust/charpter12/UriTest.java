package com.zifang.ex.bust.charpter12;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class UriTest {
    @Test
    public void test0() throws URISyntaxException {
        URI uri = URI.create("foo://username:password@example.com:8042/over/there/index.dtb?type=animal&name=narwhal#nose");
        print(uri);
    }
    private void print(URI uri) {
        System.out.println("scheme: " + uri.getScheme());
        System.out.println("userInfo: " + uri.getUserInfo());
        System.out.println("host: " + uri.getHost());
        System.out.println("port: " + uri.getPort());
        System.out.println("path: " + uri.getPath());
        System.out.println("query: " + uri.getQuery());
        System.out.println("fragment: " + uri.getFragment());
        System.out.println("authority: " + uri.getAuthority());

        System.out.println("RawSchemeSpecificPart: " + uri.getRawSchemeSpecificPart());
        System.out.println("RawUserInfo: " + uri.getRawUserInfo());
        System.out.println("RawAuthority: " + uri.getRawAuthority());
        System.out.println("RawPath: " + uri.getRawPath());
        System.out.println("RawQuery: " + uri.getRawQuery());
        System.out.println("RawFragment: " + uri.getRawFragment());
    }
}

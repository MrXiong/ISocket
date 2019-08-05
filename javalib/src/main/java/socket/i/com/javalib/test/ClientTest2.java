package socket.i.com.javalib.test;

import socket.i.com.javalib.Client;

public class ClientTest2 {
    public static void main(String[] args) {
        //需要服务器的正确的IP地址和端口号
        Client client=new Client("192.168.31.48", 6768);
        client.start();
    }

}

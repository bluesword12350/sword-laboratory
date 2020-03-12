package top.bluesword.java.net;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author 李林峰
 */
public class MulticastSocketTest {

    int port = 1234;

    /**
     * https://www.rfc-editor.org/rfc/rfc5771.txt
     * 组播地址可用范围
     * 224.0.0.0 - 224.0.0.255 (/24) Local Network Control Block（局域网）
     * 224.0.1.0 - 224.0.1.255 (/24) Internetwork Control Block （互联网）
     */
    String host = "224.0.1.1";
    String data = "hello world.";

    @Test
    void receive() throws IOException {
        byte[] data = new byte[256];
        try(MulticastSocket ms = new MulticastSocket(this.port)) {
            ms.joinGroup(InetAddress.getByName(this.host));
            DatagramPacket packet = new DatagramPacket(data, data.length);
            ms.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        }
    }

    @Test
    void send() throws IOException {
        DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(), InetAddress.getByName(host), port);
        try(MulticastSocket ms = new MulticastSocket()) {
            ms.send(packet);
        }
    }

}
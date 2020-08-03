package top.bluesword.java.net;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

/**
 * @author 李林峰
 */
public class MulticastSocketTest {

    private final int port = 1234;

    /**
     * https://www.rfc-editor.org/rfc/rfc5771.txt
     * 组播地址可用范围
     * 224.0.0.0 - 224.0.0.255 (/24) Local Network Control Block（局域网）
     * 224.0.1.0 - 224.0.1.255 (/24) Internetwork Control Block （互联网）
     */
    private final String host = "224.0.1.1";

    private boolean ready = false;

    private String receiveData;
    private final String data = "hello world.";

    @Test
    void sendAndReceive(){
        Thread thread = new Thread(() -> {
            try {
                receive();
            } catch (IOException e) {
                //
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            try {
                send();
            } catch (IOException e) {
                //
            }
        });
        thread2.start();
        await().atMost(1, SECONDS).until(() -> data.equals(receiveData));
    }

    void receive() throws IOException {
        byte[] data = new byte[256];
        try(MulticastSocket ms = new MulticastSocket(this.port)) {
            ms.joinGroup(new InetSocketAddress(this.host, port), NetworkInterface.getByName("bge0"));
            DatagramPacket packet = new DatagramPacket(data, data.length);
            ready = true;
            ms.receive(packet);
            receiveData = new String(packet.getData(), 0, packet.getLength());
            System.out.println(receiveData);
        }
    }

    void send() throws IOException {
        await().atMost(1, SECONDS).until(() -> ready);
        DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(), InetAddress.getByName(host), port);
        try(MulticastSocket ms = new MulticastSocket()) {
            ms.send(packet);
        }
    }

}
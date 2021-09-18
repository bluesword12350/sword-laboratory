package top.bluesword.java.net;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class DatagramSocketTest {

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
        byte[] msgBytes = new byte[1024];
        try(DatagramSocket socket = new DatagramSocket(null)) {
            socket.setReuseAddress(true); // set reuse address before binding
            socket.bind(new InetSocketAddress(this.port)); // bind
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.host, port);
            NetworkInterface bge0 = NetworkInterface.getByName("bge0");
            socket.joinGroup(inetSocketAddress, bge0);
            DatagramPacket packet = new DatagramPacket(msgBytes, msgBytes.length);
            ready = true;
            socket.receive(packet);
            receiveData = new String(packet.getData(), 0, packet.getLength());
            System.out.println(receiveData);
            socket.leaveGroup(inetSocketAddress, bge0);
        }
    }

    void send() throws IOException {
        await().atMost(1, SECONDS).until(() -> ready);
        byte[] msgBytes = data.getBytes();
        DatagramPacket packet = new DatagramPacket(msgBytes, msgBytes.length, InetAddress.getByName(host), port);
        DatagramSocket sender = new DatagramSocket(new InetSocketAddress(0));
        sender.setOption(StandardSocketOptions.IP_MULTICAST_IF, NetworkInterface.getByName("bge0"));
        sender.setOption(StandardSocketOptions.IP_MULTICAST_TTL, 10);
        try(sender) {
            sender.send(packet);
        }
    }

}

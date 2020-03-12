package org.jgroups;

import org.jgroups.protocols.*;
import org.jgroups.protocols.pbcast.GMS;
import org.jgroups.protocols.pbcast.NAKACK2;
import org.jgroups.protocols.pbcast.STABLE;
import org.jgroups.stack.Protocol;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

class JChannelTest {

    @Test
    void buildByXml() throws Exception {
        JChannel channel=new JChannel("udp-test.xml");
        channel.setReceiver(new ReceiverAdapter() {
            @Override
            public void receive(Message msg) {
                System.out.println("received msg from " + msg.getSrc() + ": " + msg.getObject());
            }
        });
        channel.connect("ChatCluster1");
    }

    @Test
    void buildByNone() throws Exception {
        JChannel channel=new JChannel();
        channel.setReceiver(new ReceiverAdapter() {
            @Override
            public void receive(Message msg) {
                System.out.println("received msg from " + msg.getSrc() + ": " + msg.getObject());
            }
        });
        channel.connect("ChatCluster1");
    }

    @Test
    void buildByProtocol() throws Exception {
        Protocol[] protocolStack={
                new UDP().setValue("bind_addr", InetAddress.getByName("127.0.0.1")),
                new PING(),
                new MERGE3(),
                new FD_SOCK(),
                new FD_ALL(),
                new VERIFY_SUSPECT(),
                new BARRIER(),
                new NAKACK2(),
                new UNICAST3(),
                new STABLE(),
                new GMS(),
                new UFC(),
                new MFC(),
                new FRAG2()};
        JChannel ch=new JChannel(protocolStack).name("test");

        ch.setReceiver(new ReceiverAdapter() {
            public void viewAccepted(View new_view) {
                System.out.println("view: " + new_view);
            }

            public void receive(Message msg) {
                System.out.println("<< " + msg.getObject() + " [" + msg.getSrc() + "]");
            }
        });

        ch.connect("ChatCluster");
    }

    @Test
    void service() throws Exception {
        JChannel ch=new JChannel().name("s1");

        ch.setReceiver(new ReceiverAdapter() {
            public void viewAccepted(View new_view) {
                System.out.println("view: " + new_view);
            }

            public void receive(Message msg) {
                System.out.println("<< " + msg.getObject() + " [" + msg.getSrc() + "]");
            }
        });

        ch.connect("ChatCluster");
    }

    @Test
    void send() throws Exception {
        JChannel ch=new JChannel().name("c1");
        ch.connect("ChatCluster");
        ch.send(null, "第5次");
    }
}

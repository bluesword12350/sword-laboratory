package top.bluesword.java.net;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

class InetAddressTest {
    @Test
    void mainTest() throws UnknownHostException, SocketException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("hostName="+localHost.getHostName());
        System.out.println("canonicalHostName="+localHost.getCanonicalHostName());
        System.out.println("ip="+localHost.getHostAddress());

        byte[] mac = NetworkInterface.getByInetAddress(localHost).getHardwareAddress();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<mac.length; i++) {
            if(i!=0) sb.append(":");
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
            if(str.length()==1) sb.append("0").append(str);
            else sb.append(str);
        }
        System.out.println("mac="+sb);
    }
}

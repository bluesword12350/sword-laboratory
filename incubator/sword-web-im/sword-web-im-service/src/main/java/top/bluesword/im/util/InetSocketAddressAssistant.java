package top.bluesword.im.util;

import java.net.InetSocketAddress;

/**
 * @author 李林峰
 */
public class InetSocketAddressAssistant {

    public static String getHostAddress(InetSocketAddress address){
        return address.getAddress().getHostAddress();
    }
}

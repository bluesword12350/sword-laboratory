package top.bluesword.webflux.socket.util;

import org.springframework.web.reactive.socket.WebSocketSession;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class WebSocketSessionAssistant {

    public static InetSocketAddress getRemoteAddress(WebSocketSession session){
        return Objects.requireNonNull(session.getHandshakeInfo().getRemoteAddress());
    }

    public static String getRemoteAddressIp(WebSocketSession session){
        return getRemoteAddress(session).toString();
    }

    public static InetAddress getInetAddress(WebSocketSession session){
        return getRemoteAddress(session).getAddress();
    }

    public static String getHostAddress(WebSocketSession session){
        return getInetAddress(session).getHostAddress();
    }

}

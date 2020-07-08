package top.bluesword.webflux.socket;

import org.springframework.web.reactive.socket.WebSocketSession;

import java.net.InetAddress;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class WebSocketSessionAssistant {

    public static InetAddress getInetAddress(WebSocketSession session){
        return Objects.requireNonNull(session.getHandshakeInfo().getRemoteAddress()).getAddress();
    }

    public static String getHostAddress(WebSocketSession session){
        return getInetAddress(session).getHostAddress();
    }

}

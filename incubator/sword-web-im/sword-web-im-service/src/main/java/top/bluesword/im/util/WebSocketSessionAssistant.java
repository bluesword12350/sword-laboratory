package top.bluesword.im.util;

import org.springframework.web.reactive.socket.WebSocketSession;

import java.net.InetSocketAddress;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class WebSocketSessionAssistant {

    public static InetSocketAddress getRemoteAddress(WebSocketSession session){
        return Objects.requireNonNull(session.getHandshakeInfo().getRemoteAddress());
    }

}

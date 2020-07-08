package top.bluesword.im.api.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.im.domain.MessageQueueManager;
import top.bluesword.im.util.InetSocketAddressAssistant;

import java.net.InetSocketAddress;

/**
 * @author 李林峰
 */
@RestController
@RequestMapping("personal-information")
public class PersonalInformationController {

    @PostMapping("set-name")
    public void setName(String name, ServerHttpRequest httpRequest){
        InetSocketAddress remoteAddress = httpRequest.getRemoteAddress();
        assert remoteAddress != null;
        String ip = InetSocketAddressAssistant.getHostAddress(remoteAddress);
        MessageQueueManager.setName(ip,name);
    }
}

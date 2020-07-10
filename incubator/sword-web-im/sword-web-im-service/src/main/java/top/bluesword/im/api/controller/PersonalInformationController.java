package top.bluesword.im.api.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import top.bluesword.im.domain.AddressInfo;
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
    public void setName(@RequestBody AddressInfo addressInfo, ServerHttpRequest httpRequest){
        InetSocketAddress remoteAddress = httpRequest.getRemoteAddress();
        assert remoteAddress != null;
        String ip = InetSocketAddressAssistant.getHostAddress(remoteAddress);
        MessageQueueManager.setName(ip,addressInfo.getName());
    }
}

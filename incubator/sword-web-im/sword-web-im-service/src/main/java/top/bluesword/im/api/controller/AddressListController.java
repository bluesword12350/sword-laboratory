package top.bluesword.im.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.im.domain.MessageQueueInfo;
import top.bluesword.im.domain.MessageQueueManager;

import java.util.Collection;

/**
 * @author 李林峰
 */
@CrossOrigin
@RestController
@RequestMapping("address-list")
public class AddressListController {

    @GetMapping("all")
    public Collection<MessageQueueInfo> all(){
        return MessageQueueManager.getMessageQueueInfos();
    }
}

package top.bluesword.laboratory.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.bluesword.laboratory.event.TestApplicationEvent;

import java.util.UUID;

/**
 * @author 李林峰
 */
@Slf4j
@RestController
@RequestMapping("application-event")
@AllArgsConstructor
public class ApplicationEventController {

    private ApplicationEventPublisher publisher;

    @ResponseBody
    @GetMapping("start")
    public String asyncTaskStart() {
        publisher.publishEvent(new TestApplicationEvent(UUID.randomUUID().toString()));
        return "开启完成";
    }

}

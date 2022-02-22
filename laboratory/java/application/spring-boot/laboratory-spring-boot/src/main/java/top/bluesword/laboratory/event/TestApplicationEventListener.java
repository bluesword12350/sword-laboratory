package top.bluesword.laboratory.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 李林峰
 */
@Component
@Slf4j
public class TestApplicationEventListener {

    @EventListener
    public void listen0(TestApplicationEvent event) throws InterruptedException {
        Thread.sleep(3000);
        log.info("收听事件{}，任务1",event.getId());
    }

    @EventListener
    public void listen1(TestApplicationEvent event){
        log.info("收听事件{}，任务2",event.getId());
    }

    @EventListener
    @Async
    public void listen2(TestApplicationEvent event) {
        log.info("收听事件{}，任务3",event.getId());
    }

    @EventListener
    @Async
    public void listen3(TestApplicationEvent event){
        log.info("收听事件{}，任务4",event.getId());
    }

}
